package de.dfki.cos.basys.common.aas;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.imps.CuratorFrameworkState;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.utils.CloseableUtils;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.Stat;
import org.bouncycastle.crypto.tls.NewSessionTicket;
import org.eclipse.basyx.aas.registration.api.IAASRegistryService;
import org.eclipse.basyx.submodel.metamodel.api.identifier.IIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Charsets;
import com.google.gson.Gson;

import de.dfki.cos.basys.common.aas.dto.AasDescriptor;
import de.dfki.cos.basys.common.aas.dto.SubmodelDescriptor;


public class ZookeeperAasRegistry implements AasRegistry {
	public final Logger LOGGER;
	public static final String PREFIX = "/basys/aas-registry";

	private Gson gson = new Gson();
	private CuratorFramework client;	
	
	public ZookeeperAasRegistry() {
		LOGGER = LoggerFactory.getLogger(getClass().getName());
	}

	public boolean connect(String connectionString) {
		client = CuratorFrameworkFactory.newClient(connectionString, new ExponentialBackoffRetry(1000, 3));
		client.start();
		return isConnected();
	}
	
	public boolean isConnected() {
		return client.getState() == CuratorFrameworkState.STARTED;
	}
	
	public void disconnect() {
		CloseableUtils.closeQuietly(client);	
	}
	
	@Override
	public Response getRegistry() {
		try {
			if (!isConnected()) {
				// 502: Bad Gateway
				return Response.status(Status.BAD_GATEWAY).build();
			}
			
			String path = getPath();
			if (!exists(path)) {
				// 404: No Asset Administration Shells found  
				return Response.status(Status.OK).entity("[]").build();
			}
			

			List<AasDescriptor> aasDescriptors = null;
			
			String content = new String(client.getData().forPath(path), Charsets.UTF_8);
			AasDescriptor aasDescriptor = gson.fromJson(content, AasDescriptor.class);
			
			List<String> children = client.getChildren().forPath(path);
			List<SubmodelDescriptor> submodels = new ArrayList<SubmodelDescriptor>(children.size());
			for (String smPath : children) {
				content = new String(client.getData().forPath(smPath), Charsets.UTF_8);
				SubmodelDescriptor submodelDescriptor = gson.fromJson(content, SubmodelDescriptor.class);
				submodels.add(submodelDescriptor);	
			}
			aasDescriptor.setSubmodels(submodels);
			
			return Response.ok().entity(aasDescriptor).build();
		
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Override
	public Response registerAas(AasDescriptor aasDescriptor) {
		try {
			if (!isConnected()) {
				// 502: Bad Gateway
				return Response.status(Status.BAD_GATEWAY).build();
			}
			String path = getPath(aasDescriptor);
			if (exists(path)) {
				// 422: The passed Asset Administration Shell conflicts with already registered Asset Administration Shells  
				return Response.status(422).build();
			}
			if (!check(aasDescriptor)) {
				// 400: The syntax of the passed Asset Administration Shell is not valid or malformed request
				return Response.status(Status.BAD_REQUEST).build();
			}		
			List<SubmodelDescriptor> submodels = aasDescriptor.getSubmodels();
			aasDescriptor.setSubmodels(null);;
			
			String content = gson.toJson(aasDescriptor);
		
			client.create()
				.creatingParentsIfNeeded()
				.withMode(CreateMode.PERSISTENT)
				.withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
				.forPath(path, content.getBytes(Charsets.UTF_8));

			for (SubmodelDescriptor submodelDescriptor : submodels) {
				path = getPath(aasDescriptor.getIdShort(), submodelDescriptor);
				content = gson.toJson(submodelDescriptor);
			
				client.create()
					.withMode(CreateMode.PERSISTENT)
					.withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
					.forPath(path, content.getBytes(Charsets.UTF_8));
				
			}

			// 201: The Asset Administration Shell was created successfully
			return Response.status(Status.CREATED).build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Override
	public Response getAas(String aasId) {
		try {
			if (!isConnected()) {
				// 502: Bad Gateway
				return Response.status(Status.BAD_GATEWAY).build();
			}
			String path = getPath(aasId);
			if (!exists(path)) {
				// 404: No Asset Administration Shell with passed id found  
				return Response.status(Status.NOT_FOUND).build();
			}
			
			String content = new String(client.getData().forPath(path), Charsets.UTF_8);
			AasDescriptor aasDescriptor = gson.fromJson(content, AasDescriptor.class);
			
			List<String> children = client.getChildren().forPath(path);
			List<SubmodelDescriptor> submodels = new ArrayList<SubmodelDescriptor>(children.size());
			for (String smPath : children) {
				content = new String(client.getData().forPath(smPath), Charsets.UTF_8);
				SubmodelDescriptor submodelDescriptor = gson.fromJson(content, SubmodelDescriptor.class);
				submodels.add(submodelDescriptor);	
			}
			aasDescriptor.setSubmodels(submodels);
			
			return Response.ok().entity(aasDescriptor).build();
		
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Override
	public Response updateAas(String aasId, AasDescriptor aasDescriptor) {
		return Response.serverError().build();
	}

	@Override
	public Response deleteAas(String aasId) {
		try {
			if (!isConnected()) {
				// 502: Bad Gateway
				return Response.status(Status.BAD_GATEWAY).build();
			}
			String path = getPath(aasId);
			if (!exists(path)) {
				// 404: No Asset Administration Shell with passed id found  
				return Response.status(Status.NOT_FOUND).build();
			}
			
			client.delete()
				.deletingChildrenIfNeeded()
				.forPath(path);
			
			return Response.status(Status.NO_CONTENT).build();
		
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Override
	public Response getAasSubmodels(String aasId) {
		try {
			if (!isConnected()) {
				// 502: Bad Gateway
				return Response.status(Status.BAD_GATEWAY).build();
			}
			String path = getPath(aasId);
			if (!exists(path)) {
				// 404: No Asset Administration Shell with passed id found  
				return Response.status(Status.NOT_FOUND).build();
			}
			
			List<String> children = client.getChildren().forPath(path);
			List<SubmodelDescriptor> submodels = new ArrayList<SubmodelDescriptor>(children.size());
			for (String smPath : children) {
				String content = new String(client.getData().forPath(smPath), Charsets.UTF_8);
				SubmodelDescriptor submodelDescriptor = gson.fromJson(content, SubmodelDescriptor.class);
				submodels.add(submodelDescriptor);	
			}
			
			return Response.ok().entity(submodels).build();
		
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Override
	public Response registerAasSubmodel(String aasId, SubmodelDescriptor submodelDescriptor) {
		try {
			if (!isConnected()) {
				// 502: Bad Gateway
				return Response.status(Status.BAD_GATEWAY).build();
			}
			String path = getPath(aasId);
			if (!exists(path)) {
				// 404: No Asset Administration Shell with passed id found  
				return Response.status(Status.NOT_FOUND).build();
			}
			path = getPath(aasId, submodelDescriptor);
			if (exists(path)) {
				// 422: The passed Asset Administration Shell conflicts with already registered Asset Administration Shells  
				return Response.status(422).build();
			}
			if (!check(submodelDescriptor)) {
				// 400: The syntax of the passed Asset Administration Shell is not valid or malformed request
				return Response.status(Status.BAD_REQUEST).build();
			}		
			String content = gson.toJson(submodelDescriptor);
		
			client.create()
				.withMode(CreateMode.PERSISTENT)
				.withACL(ZooDefs.Ids.OPEN_ACL_UNSAFE)
				.forPath(path, content.getBytes(Charsets.UTF_8));
			
			// 201: The Asset Administration Shell was created successfully
			return Response.status(Status.CREATED).build();
			
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Override
	public Response getAasSubmodel(String aasId, String submodelId) {
		try {
			if (!isConnected()) {
				// 502: Bad Gateway
				return Response.status(Status.BAD_GATEWAY).build();
			}
			String path = getPath(aasId);
			if (!exists(path)) {
				// 404: No Asset Administration Shell with passed id found  
				return Response.status(Status.NOT_FOUND).build();
			}
			path = getPath(aasId, submodelId);
			if (!exists(path)) {
				// 404: No Submodel with passed id found  
				return Response.status(Status.NOT_FOUND).build();
			}
			
			String content = new String(client.getData().forPath(path), Charsets.UTF_8);
			SubmodelDescriptor submodelDescriptor = gson.fromJson(content, SubmodelDescriptor.class);
			
			return Response.ok().entity(submodelDescriptor).build();
		
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

	@Override
	public Response deleteAasSubmodel(String aasId, String submodelId) {
		try {
			if (!isConnected()) {
				// 502: Bad Gateway
				return Response.status(Status.BAD_GATEWAY).build();
			}
			String path = getPath(aasId);
			if (!exists(path)) {
				// 404: No Asset Administration Shell with passed id found  
				return Response.status(Status.NOT_FOUND).build();
			}
			path = getPath(aasId, submodelId);
			if (!exists(path)) {
				// 404: No Submodel with passed id found  
				return Response.status(Status.NOT_FOUND).build();
			}
			
			client.delete()
				.deletingChildrenIfNeeded()
				.forPath(path);
			
			return Response.status(Status.NO_CONTENT).build();
		
		} catch (Exception e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	private String getPath() {
		return PREFIX;
	}
	
	private String getPath(AasDescriptor aas) {
		return PREFIX + "/" + aas.getIdShort();
	}
	
	private String getPath(String aasId) {
		return PREFIX + "/" + aasId;
	}
	
	private String getPath(String aasId, SubmodelDescriptor sm) {
		return PREFIX + "/" + aasId + "/" + sm.getIdShort();
	}
	
	private String getPath(String aasId, String smId) {
		return PREFIX + "/" + aasId + "/" + smId;
	}
	
	private boolean exists(String path) throws Exception {
		Stat stat = client.checkExists().forPath(path);
		return stat!=null;
	}
	
	private boolean check(AasDescriptor aasDescriptor) {
		// TODO Auto-generated method stub
		return true;
	}
	
	private boolean check(SubmodelDescriptor aasDescriptor) {
		// TODO Auto-generated method stub
		return true;
	}
	
	private AasDescriptor getAasDescriptor(String aasId) {
		return null;
	}

	private SubmodelDescriptor getSubmodelDescriptor(String smId) {
		return null;
	}
}

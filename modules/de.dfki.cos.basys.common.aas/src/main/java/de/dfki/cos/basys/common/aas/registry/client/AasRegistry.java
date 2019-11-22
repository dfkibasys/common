package de.dfki.cos.basys.common.aas.registry.client;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.dfki.cos.basys.common.aas.registry.dto.AasDescriptor;
import de.dfki.cos.basys.common.aas.registry.dto.SubmodelDescriptor;

public interface AasRegistry {

	List<AasDescriptor> getRegistry();

	boolean registerAas(AasDescriptor aasDescriptor);

	AasDescriptor getAas(String aasId);

	boolean updateAas(String aasId, AasDescriptor aasDescriptor);

	boolean deleteAas(String aasId);

	List<SubmodelDescriptor> getAasSubmodels(String aasId);

	boolean registerAasSubmodel(String aasId, SubmodelDescriptor submodelDescriptor);

	SubmodelDescriptor getAasSubmodel(String aasId, String submodelId);

	boolean deleteAasSubmodel(String aasId, String submodelId);

}

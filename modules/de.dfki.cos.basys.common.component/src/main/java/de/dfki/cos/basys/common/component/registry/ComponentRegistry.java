package de.dfki.cos.basys.common.component.registry;

import java.util.List;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

import de.dfki.cos.basys.common.component.Component;
import de.dfki.cos.basys.common.component.ComponentInfo;


//@Path("/registry")
public interface ComponentRegistry {

	ComponentRegistration createRegistration(Component instance) throws ComponentRegistrationException;

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/{componentCategory}")
//	List<ComponentInfo> getComponents(@PathParam("componentCategory") String category);
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/{componentCategory}/{componentId}")
//	ComponentInfo getComponentById(@PathParam("componentCategory") String category, @PathParam("componentId") String id);
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/{componentCategory}/name/{componentName}")
//	ComponentInfo getComponentByName(@PathParam("componentCategory") String category, @PathParam("componentName") String name);

	
	List<ComponentInfo> getComponents(String category);
	
	ComponentInfo getComponentById(String category,String id);
	
	ComponentInfo getComponentByName(String category, String name);

}

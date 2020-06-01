package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.ResourceDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(ResourceRepresentation.PATH)
public interface ResourceRepresentation extends RepresentationEntity<ResourceDto> {
	
	String PATH = "resource";
	
}

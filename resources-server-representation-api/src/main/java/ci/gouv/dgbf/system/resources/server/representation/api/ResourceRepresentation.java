package ci.gouv.dgbf.system.resources.server.representation.api;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.cyk.utility.__kernel__.identifier.resource.ProxyGetter;
import org.cyk.utility.server.representation.RepresentationEntity;

import ci.gouv.dgbf.system.resources.server.representation.entities.ResourceDto;
import io.swagger.annotations.ApiOperation;

@Path(ResourceRepresentation.PATH)
public interface ResourceRepresentation extends RepresentationEntity<ResourceDto> {
	
	@POST
	@Path(PATH_SAVE_INITIAL)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	@ApiOperation(value = "saveInitials",tags = {"save"})
	Response saveInitials(Collection<ResourceDto> resourceDtos);
	
	static ResourceRepresentation getProxy() {
		return ProxyGetter.getInstance().get(ResourceRepresentation.class);
	}
	
	String PATH = "resource";
	String PATH_SAVE_INITIAL = "saveInitials";
}
package ci.gouv.dgbf.system.resources.server.representation.api;
import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ci.gouv.dgbf.system.resources.server.representation.entities.ActivityDto;
import io.swagger.annotations.ApiOperation;

import org.cyk.utility.__kernel__.identifier.resource.ProxyGetter;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(ActivityRepresentation.PATH)
public interface ActivityRepresentation extends RepresentationEntity<ActivityDto> {
	
	@POST
	@Path(PATH_SAVE_INITIALS_FROM_COMPUTATION)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	@ApiOperation(value = "saveInitialsFromComputation",tags = {"save"})
	Response saveInitialsFromComputation(Collection<ActivityDto> activitiesDtos);
	
	static ActivityRepresentation getProxy() {
		return ProxyGetter.getInstance().get(ActivityRepresentation.class);
	}
	
	String PATH = "activity";
	String PATH_SAVE_INITIALS_FROM_COMPUTATION = "saveInitialsFromComputation";
}
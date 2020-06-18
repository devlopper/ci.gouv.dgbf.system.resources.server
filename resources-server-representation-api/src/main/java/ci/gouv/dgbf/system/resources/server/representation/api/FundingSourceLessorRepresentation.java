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

import ci.gouv.dgbf.system.resources.server.representation.entities.FundingSourceLessorDto;
import io.swagger.annotations.ApiOperation;

@Path(FundingSourceLessorRepresentation.PATH)
public interface FundingSourceLessorRepresentation extends RepresentationEntity<FundingSourceLessorDto> {

	@POST
	@Path(PATH_SAVE_ECONOMIC_NATURES)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Produces({ MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML })
	@ApiOperation(value = "saveEconomicNatures",tags = {"save"})
	Response saveEconomicNatures(Collection<FundingSourceLessorDto> fundingSourceLessorDtos);
	
	static FundingSourceLessorRepresentation getProxy() {
		return ProxyGetter.getInstance().get(FundingSourceLessorRepresentation.class);
	}
	
	String PATH = "fundingsourcelessor";
	String PATH_SAVE_ECONOMIC_NATURES = "saveEconomicNatures";
}
package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.FundingSourceDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(FundingSourceRepresentation.PATH)
public interface FundingSourceRepresentation extends RepresentationEntity<FundingSourceDto> {
	
	String PATH = "fundingsource";
	
}

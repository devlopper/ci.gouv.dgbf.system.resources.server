package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.FundingSourceLessorDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(FundingSourceLessorRepresentation.PATH)
public interface FundingSourceLessorRepresentation extends RepresentationEntity<FundingSourceLessorDto> {
	
	String PATH = "fundingsourcelessor";
	
}

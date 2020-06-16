package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.FundingDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(FundingRepresentation.PATH)
public interface FundingRepresentation extends RepresentationEntity<FundingDto> {
	
	String PATH = "funding";
	
}

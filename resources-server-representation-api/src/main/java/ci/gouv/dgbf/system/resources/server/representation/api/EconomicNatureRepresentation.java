package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.EconomicNatureDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(EconomicNatureRepresentation.PATH)
public interface EconomicNatureRepresentation extends RepresentationEntity<EconomicNatureDto> {
	
	String PATH = "economicnature";
	
}

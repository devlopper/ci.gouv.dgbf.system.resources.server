package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(BudgetRepresentation.PATH)
public interface BudgetRepresentation extends RepresentationEntity<BudgetDto> {
	
	String PATH = "budget";
	
}

package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetaryActDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(BudgetaryActRepresentation.PATH)
public interface BudgetaryActRepresentation extends RepresentationEntity<BudgetaryActDto> {
	
	String PATH = "budgetaryact";
	
}

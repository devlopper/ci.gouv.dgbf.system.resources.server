package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetaryActVersionDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(BudgetaryActVersionRepresentation.PATH)
public interface BudgetaryActVersionRepresentation extends RepresentationEntity<BudgetaryActVersionDto> {
	
	String PATH = "budgetaryactversion";
	
}

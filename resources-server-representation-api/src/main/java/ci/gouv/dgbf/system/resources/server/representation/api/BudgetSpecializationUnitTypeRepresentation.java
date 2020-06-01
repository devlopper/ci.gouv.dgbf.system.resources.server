package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetSpecializationUnitTypeDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(BudgetSpecializationUnitTypeRepresentation.PATH)
public interface BudgetSpecializationUnitTypeRepresentation extends RepresentationEntity<BudgetSpecializationUnitTypeDto> {
	
	String PATH = "budgetspecializationunittype";
	
}

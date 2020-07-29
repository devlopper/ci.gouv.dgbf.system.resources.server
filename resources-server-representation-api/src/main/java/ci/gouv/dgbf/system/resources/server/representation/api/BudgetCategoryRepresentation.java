package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetCategoryDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(BudgetCategoryRepresentation.PATH)
public interface BudgetCategoryRepresentation extends RepresentationEntity<BudgetCategoryDto> {
	
	String PATH = "budgetcategory";
	
}

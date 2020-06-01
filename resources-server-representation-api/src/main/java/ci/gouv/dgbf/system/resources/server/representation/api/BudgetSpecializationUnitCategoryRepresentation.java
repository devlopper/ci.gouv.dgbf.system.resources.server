package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetSpecializationUnitCategoryDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(BudgetSpecializationUnitCategoryRepresentation.PATH)
public interface BudgetSpecializationUnitCategoryRepresentation extends RepresentationEntity<BudgetSpecializationUnitCategoryDto> {
	
	String PATH = "budgetspecializationunitcategory";
	
}

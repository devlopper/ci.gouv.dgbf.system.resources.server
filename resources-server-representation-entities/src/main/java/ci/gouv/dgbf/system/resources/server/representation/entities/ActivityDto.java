package ci.gouv.dgbf.system.resources.server.representation.entities;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class ActivityDto extends AbstractNamableWithAmountsDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private BudgetSpecializationUnitDto budgetSpecializationUnit;
	private ArrayList<ResourceDto> resources;
}
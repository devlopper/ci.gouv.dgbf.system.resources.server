package ci.gouv.dgbf.system.resources.server.representation.entities;

import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetCategory;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class BudgetCategoryDtoMapper extends AbstractMapperSourceDestinationImpl<BudgetCategoryDto, BudgetCategory> {
	private static final long serialVersionUID = 1L;
     
}
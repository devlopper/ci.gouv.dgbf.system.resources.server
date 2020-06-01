package ci.gouv.dgbf.system.resources.server.representation.entities;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Budget;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class BudgetDtoMapper extends AbstractMapperSourceDestinationImpl<BudgetDto, Budget> {
	private static final long serialVersionUID = 1L;
     
}
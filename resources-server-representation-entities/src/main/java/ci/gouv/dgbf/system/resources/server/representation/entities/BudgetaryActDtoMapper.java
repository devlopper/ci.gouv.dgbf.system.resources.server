package ci.gouv.dgbf.system.resources.server.representation.entities;

import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryAct;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class BudgetaryActDtoMapper extends AbstractMapperSourceDestinationImpl<BudgetaryActDto, BudgetaryAct> {
	private static final long serialVersionUID = 1L;
     
}
package ci.gouv.dgbf.system.resources.server.representation.entities;

import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryActVersion;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class BudgetaryActVersionDtoMapper extends AbstractMapperSourceDestinationImpl<BudgetaryActVersionDto, BudgetaryActVersion> {
	private static final long serialVersionUID = 1L;
     
}
package ci.gouv.dgbf.system.resources.server.representation.entities;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Expenditure;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class ExpenditureDtoMapper extends AbstractMapperSourceDestinationImpl<ExpenditureDto, Expenditure> {
	private static final long serialVersionUID = 1L;
     
}
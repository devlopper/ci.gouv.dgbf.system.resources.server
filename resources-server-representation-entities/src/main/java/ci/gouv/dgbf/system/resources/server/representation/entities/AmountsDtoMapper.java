package ci.gouv.dgbf.system.resources.server.representation.entities;

import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Amounts;

@Mapper
public abstract class AmountsDtoMapper extends AbstractMapperSourceDestinationImpl<AmountsDto, Amounts> {
	private static final long serialVersionUID = 1L;
     
}
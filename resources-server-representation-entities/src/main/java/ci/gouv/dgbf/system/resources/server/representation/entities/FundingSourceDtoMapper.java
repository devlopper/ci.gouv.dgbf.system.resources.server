package ci.gouv.dgbf.system.resources.server.representation.entities;

import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSource;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class FundingSourceDtoMapper extends AbstractMapperSourceDestinationImpl<FundingSourceDto, FundingSource> {
	private static final long serialVersionUID = 1L;
     
}
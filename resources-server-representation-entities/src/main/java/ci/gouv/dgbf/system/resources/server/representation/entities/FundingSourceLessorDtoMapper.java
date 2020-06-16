package ci.gouv.dgbf.system.resources.server.representation.entities;

import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSourceLessor;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class FundingSourceLessorDtoMapper extends AbstractMapperSourceDestinationImpl<FundingSourceLessorDto, FundingSourceLessor> {
	private static final long serialVersionUID = 1L;
     
}
package ci.gouv.dgbf.system.resources.server.representation.entities;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class ActivityDtoMapper extends AbstractMapperSourceDestinationImpl<ActivityDto, Activity> {
	private static final long serialVersionUID = 1L;
     
}
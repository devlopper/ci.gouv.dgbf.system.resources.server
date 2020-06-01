package ci.gouv.dgbf.system.resources.server.representation.entities;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;
import org.cyk.utility.server.representation.AbstractMapperSourceDestinationImpl;
import org.mapstruct.Mapper;

@Mapper
public abstract class ResourceDtoMapper extends AbstractMapperSourceDestinationImpl<ResourceDto, Resource> {
	private static final long serialVersionUID = 1L;
     
}
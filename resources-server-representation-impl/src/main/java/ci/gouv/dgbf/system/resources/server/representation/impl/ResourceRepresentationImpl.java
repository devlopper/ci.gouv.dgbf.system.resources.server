package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.persistence.query.EntityFinder;
import org.cyk.utility.__kernel__.rest.ResponseBuilder;
import org.cyk.utility.__kernel__.runnable.Runner;
import org.cyk.utility.__kernel__.string.StringHelper;
import org.cyk.utility.__kernel__.user.interface_.message.MessageRenderer;
import org.cyk.utility.__kernel__.value.ValueHelper;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

import ci.gouv.dgbf.system.resources.server.business.api.ResourceBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;
import ci.gouv.dgbf.system.resources.server.representation.api.ResourceRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.ResourceDto;

@ApplicationScoped
public class ResourceRepresentationImpl extends AbstractRepresentationEntityImpl<ResourceDto> implements ResourceRepresentation,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public Response saveInitials(Collection<ResourceDto> resourceDtos) {
		if(CollectionHelper.isEmpty(resourceDtos))
			return Response.ok().build();
		final Collection<Resource> resources = new ArrayList<>();
		for(ResourceDto resourceDto : resourceDtos)
			if(StringHelper.isNotBlank(resourceDto.getIdentifier())) {
				Resource resource = EntityFinder.getInstance().find(Resource.class,resourceDto.getIdentifier());
				if(resource != null) {
					resource.getAmounts(Boolean.TRUE).setInitial(ValueHelper.defaultToIfNull(resourceDto.getAmounts(Boolean.TRUE).getInitial(),0l));
					resources.add(resource);
				}
			}
		if(CollectionHelper.isNotEmpty(resources)) {
			Runner.Arguments runnerArguments = new Runner.Arguments().setThrowableMessageArguments(new MessageRenderer.Arguments()).setMessageRenderable(Boolean.FALSE)
					.addRunnables(new Runnable() {				
				@Override
				public void run() {
					__inject__(ResourceBusiness.class).saveInitials(resources);
				}
			});
			Runner.getInstance().run(runnerArguments);
			if(runnerArguments.getThrowable() == null)
				return Response.ok(resources.size()+" has been saved").build();
			return ResponseBuilder.getInstance().build(runnerArguments.getThrowable());
		}
		return Response.ok("Nothing has been saved").build();
	}
	
}
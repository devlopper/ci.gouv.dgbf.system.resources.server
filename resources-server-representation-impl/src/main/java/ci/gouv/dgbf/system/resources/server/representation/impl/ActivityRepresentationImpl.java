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
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

import ci.gouv.dgbf.system.resources.server.business.api.ActivityBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryActVersion;
import ci.gouv.dgbf.system.resources.server.representation.api.ActivityRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.ActivityDto;

@ApplicationScoped
public class ActivityRepresentationImpl extends AbstractRepresentationEntityImpl<ActivityDto> implements ActivityRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Response saveInitialsFromComputation(Collection<ActivityDto> activitiesDtos) {
		if(CollectionHelper.isEmpty(activitiesDtos))
			return Response.ok().build();
		final Collection<Activity> activities = new ArrayList<>();
		for(ActivityDto activityDto : activitiesDtos)
			if(StringHelper.isNotBlank(activityDto.getIdentifier())) {
				Activity activity = EntityFinder.getInstance().find(Activity.class,activityDto.getIdentifier());
				if(activity != null) {
					activities.add(activity);
					if(activityDto.getBudgetaryActVersion() != null)
						activity.setBudgetaryActVersion(EntityFinder.getInstance().find(BudgetaryActVersion.class,activityDto.getBudgetaryActVersion().getIdentifier()));
				}
			}
		if(CollectionHelper.isNotEmpty(activities)) {
			Runner.Arguments runnerArguments = new Runner.Arguments().setThrowableMessageArguments(new MessageRenderer.Arguments()).setMessageRenderable(Boolean.FALSE)
					.addRunnables(new Runnable() {				
				@Override
				public void run() {
					__inject__(ActivityBusiness.class).saveInitialsFromComputation(activities);
				}
			});
			Runner.getInstance().run(runnerArguments);
			if(runnerArguments.getThrowable() == null)
				return Response.ok(activities.size()+" activities has been processed").build();
			return ResponseBuilder.getInstance().build(runnerArguments.getThrowable());
		}
		return Response.ok("Nothing has been processed").build();
	}
}
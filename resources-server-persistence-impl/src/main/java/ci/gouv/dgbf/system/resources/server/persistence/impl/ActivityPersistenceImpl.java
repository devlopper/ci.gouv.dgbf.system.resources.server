package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.ActivityPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class ActivityPersistenceImpl extends AbstractPersistenceEntityImpl<Activity> implements ActivityPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
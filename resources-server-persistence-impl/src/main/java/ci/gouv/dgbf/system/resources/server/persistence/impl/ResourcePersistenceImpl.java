package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.ResourcePersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class ResourcePersistenceImpl extends AbstractPersistenceEntityImpl<Resource> implements ResourcePersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
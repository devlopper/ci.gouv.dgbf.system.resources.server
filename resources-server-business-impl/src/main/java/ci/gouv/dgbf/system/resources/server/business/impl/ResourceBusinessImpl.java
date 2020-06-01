package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.ResourceBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.ResourcePersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class ResourceBusinessImpl extends AbstractBusinessEntityImpl<Resource, ResourcePersistence> implements ResourceBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

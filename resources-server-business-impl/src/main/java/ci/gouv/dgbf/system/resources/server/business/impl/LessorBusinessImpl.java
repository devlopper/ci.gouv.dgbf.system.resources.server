package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

import ci.gouv.dgbf.system.resources.server.business.api.LessorBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.LessorPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Lessor;

@ApplicationScoped
public class LessorBusinessImpl extends AbstractBusinessEntityImpl<Lessor, LessorPersistence> implements LessorBusiness,Serializable {
	private static final long serialVersionUID = 1L;
	
}

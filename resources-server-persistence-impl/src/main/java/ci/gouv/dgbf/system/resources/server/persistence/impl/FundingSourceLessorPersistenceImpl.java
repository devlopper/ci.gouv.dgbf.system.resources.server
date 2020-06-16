package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.FundingSourceLessorPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSourceLessor;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class FundingSourceLessorPersistenceImpl extends AbstractPersistenceEntityImpl<FundingSourceLessor> implements FundingSourceLessorPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
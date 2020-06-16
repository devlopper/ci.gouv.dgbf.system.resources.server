package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.FundingSourceLessorBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.FundingSourceLessorPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSourceLessor;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class FundingSourceLessorBusinessImpl extends AbstractBusinessEntityImpl<FundingSourceLessor, FundingSourceLessorPersistence> implements FundingSourceLessorBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

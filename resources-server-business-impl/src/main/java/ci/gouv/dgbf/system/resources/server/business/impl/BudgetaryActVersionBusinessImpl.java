package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.BudgetaryActVersionBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetaryActVersionPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryActVersion;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class BudgetaryActVersionBusinessImpl extends AbstractBusinessEntityImpl<BudgetaryActVersion, BudgetaryActVersionPersistence> implements BudgetaryActVersionBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

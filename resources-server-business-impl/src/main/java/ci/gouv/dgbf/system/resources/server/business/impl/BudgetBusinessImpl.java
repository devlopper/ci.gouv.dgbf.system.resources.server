package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.BudgetBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Budget;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class BudgetBusinessImpl extends AbstractBusinessEntityImpl<Budget, BudgetPersistence> implements BudgetBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.BudgetCategoryBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetCategoryPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetCategory;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class BudgetCategoryBusinessImpl extends AbstractBusinessEntityImpl<BudgetCategory, BudgetCategoryPersistence> implements BudgetCategoryBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

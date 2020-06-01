package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.BudgetSpecializationUnitCategoryBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetSpecializationUnitCategoryPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitCategory;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class BudgetSpecializationUnitCategoryBusinessImpl extends AbstractBusinessEntityImpl<BudgetSpecializationUnitCategory, BudgetSpecializationUnitCategoryPersistence> implements BudgetSpecializationUnitCategoryBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

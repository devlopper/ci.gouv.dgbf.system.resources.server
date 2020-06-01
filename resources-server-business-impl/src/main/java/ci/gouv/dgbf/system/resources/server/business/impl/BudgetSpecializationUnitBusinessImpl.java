package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.BudgetSpecializationUnitBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetSpecializationUnitPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class BudgetSpecializationUnitBusinessImpl extends AbstractBusinessEntityImpl<BudgetSpecializationUnit, BudgetSpecializationUnitPersistence> implements BudgetSpecializationUnitBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

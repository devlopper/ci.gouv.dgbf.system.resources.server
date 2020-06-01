package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.BudgetSpecializationUnitTypeBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetSpecializationUnitTypePersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitType;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class BudgetSpecializationUnitTypeBusinessImpl extends AbstractBusinessEntityImpl<BudgetSpecializationUnitType, BudgetSpecializationUnitTypePersistence> implements BudgetSpecializationUnitTypeBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

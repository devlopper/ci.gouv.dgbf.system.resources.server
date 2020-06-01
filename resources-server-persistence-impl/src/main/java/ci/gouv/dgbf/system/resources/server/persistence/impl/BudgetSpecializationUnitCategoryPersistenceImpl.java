package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetSpecializationUnitCategoryPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitCategory;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class BudgetSpecializationUnitCategoryPersistenceImpl extends AbstractPersistenceEntityImpl<BudgetSpecializationUnitCategory> implements BudgetSpecializationUnitCategoryPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
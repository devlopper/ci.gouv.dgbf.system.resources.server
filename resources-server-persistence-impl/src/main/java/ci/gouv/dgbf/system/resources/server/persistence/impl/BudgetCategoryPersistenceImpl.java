package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetCategoryPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetCategory;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class BudgetCategoryPersistenceImpl extends AbstractPersistenceEntityImpl<BudgetCategory> implements BudgetCategoryPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
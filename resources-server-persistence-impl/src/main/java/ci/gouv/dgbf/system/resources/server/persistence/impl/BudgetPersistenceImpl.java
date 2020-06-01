package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Budget;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class BudgetPersistenceImpl extends AbstractPersistenceEntityImpl<Budget> implements BudgetPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
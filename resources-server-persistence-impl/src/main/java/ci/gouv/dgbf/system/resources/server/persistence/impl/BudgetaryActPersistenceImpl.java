package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetaryActPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryAct;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class BudgetaryActPersistenceImpl extends AbstractPersistenceEntityImpl<BudgetaryAct> implements BudgetaryActPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
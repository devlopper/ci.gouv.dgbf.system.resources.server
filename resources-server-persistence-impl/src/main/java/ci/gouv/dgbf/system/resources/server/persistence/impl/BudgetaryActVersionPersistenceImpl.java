package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetaryActVersionPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryActVersion;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class BudgetaryActVersionPersistenceImpl extends AbstractPersistenceEntityImpl<BudgetaryActVersion> implements BudgetaryActVersionPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
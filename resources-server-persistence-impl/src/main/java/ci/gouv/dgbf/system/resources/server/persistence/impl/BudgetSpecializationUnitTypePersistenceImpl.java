package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetSpecializationUnitTypePersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitType;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class BudgetSpecializationUnitTypePersistenceImpl extends AbstractPersistenceEntityImpl<BudgetSpecializationUnitType> implements BudgetSpecializationUnitTypePersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
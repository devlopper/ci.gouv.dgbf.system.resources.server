package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.BudgetaryActBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.BudgetaryActPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryAct;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class BudgetaryActBusinessImpl extends AbstractBusinessEntityImpl<BudgetaryAct, BudgetaryActPersistence> implements BudgetaryActBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

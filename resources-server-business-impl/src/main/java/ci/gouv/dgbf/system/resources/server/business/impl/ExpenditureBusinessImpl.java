package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.ExpenditureBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.ExpenditurePersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Expenditure;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class ExpenditureBusinessImpl extends AbstractBusinessEntityImpl<Expenditure, ExpenditurePersistence> implements ExpenditureBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

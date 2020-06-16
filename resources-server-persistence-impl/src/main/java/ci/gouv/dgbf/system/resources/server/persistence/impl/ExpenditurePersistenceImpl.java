package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.ExpenditurePersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Expenditure;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class ExpenditurePersistenceImpl extends AbstractPersistenceEntityImpl<Expenditure> implements ExpenditurePersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
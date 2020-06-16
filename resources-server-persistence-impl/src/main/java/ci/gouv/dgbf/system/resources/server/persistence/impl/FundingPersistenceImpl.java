package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.FundingPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Funding;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class FundingPersistenceImpl extends AbstractPersistenceEntityImpl<Funding> implements FundingPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
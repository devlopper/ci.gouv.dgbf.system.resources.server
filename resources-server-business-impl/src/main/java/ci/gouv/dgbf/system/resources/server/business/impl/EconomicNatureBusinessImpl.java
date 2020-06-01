package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.business.api.EconomicNatureBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.EconomicNaturePersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class EconomicNatureBusinessImpl extends AbstractBusinessEntityImpl<EconomicNature, EconomicNaturePersistence> implements EconomicNatureBusiness,Serializable {
	private static final long serialVersionUID = 1L;
		
}

package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

import ci.gouv.dgbf.system.resources.server.business.api.SectionBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.SectionPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

@ApplicationScoped
public class SectionBusinessImpl extends AbstractBusinessEntityImpl<Section, SectionPersistence> implements SectionBusiness,Serializable {
	private static final long serialVersionUID = 1L;
	
}

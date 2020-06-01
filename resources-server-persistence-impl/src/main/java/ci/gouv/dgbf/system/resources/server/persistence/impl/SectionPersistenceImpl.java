package ci.gouv.dgbf.system.resources.server.persistence.impl;
import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.persistence.api.SectionPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;
import org.cyk.utility.server.persistence.AbstractPersistenceEntityImpl;

@ApplicationScoped
public class SectionPersistenceImpl extends AbstractPersistenceEntityImpl<Section> implements SectionPersistence,Serializable {
	private static final long serialVersionUID = 1L;

	
}
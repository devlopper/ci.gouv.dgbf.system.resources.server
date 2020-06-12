package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

import ci.gouv.dgbf.system.resources.server.representation.api.SectionRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.SectionDto;

@ApplicationScoped
public class SectionRepresentationImpl extends AbstractRepresentationEntityImpl<SectionDto> implements SectionRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}

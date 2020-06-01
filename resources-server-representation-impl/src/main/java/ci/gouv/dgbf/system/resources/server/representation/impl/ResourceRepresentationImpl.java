package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.representation.api.ResourceRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.ResourceDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class ResourceRepresentationImpl extends AbstractRepresentationEntityImpl<ResourceDto> implements ResourceRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}

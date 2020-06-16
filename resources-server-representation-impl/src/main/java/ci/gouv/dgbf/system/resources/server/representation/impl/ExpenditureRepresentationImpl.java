package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.representation.api.ExpenditureRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.ExpenditureDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class ExpenditureRepresentationImpl extends AbstractRepresentationEntityImpl<ExpenditureDto> implements ExpenditureRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}

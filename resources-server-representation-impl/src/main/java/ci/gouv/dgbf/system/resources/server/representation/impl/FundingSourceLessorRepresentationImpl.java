package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.representation.api.FundingSourceLessorRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.FundingSourceLessorDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class FundingSourceLessorRepresentationImpl extends AbstractRepresentationEntityImpl<FundingSourceLessorDto> implements FundingSourceLessorRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}

package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.representation.api.BudgetaryActVersionRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetaryActVersionDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class BudgetaryActVersionRepresentationImpl extends AbstractRepresentationEntityImpl<BudgetaryActVersionDto> implements BudgetaryActVersionRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}

package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.representation.api.BudgetaryActRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetaryActDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class BudgetaryActRepresentationImpl extends AbstractRepresentationEntityImpl<BudgetaryActDto> implements BudgetaryActRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}

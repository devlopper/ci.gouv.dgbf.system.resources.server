package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.representation.api.BudgetRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class BudgetRepresentationImpl extends AbstractRepresentationEntityImpl<BudgetDto> implements BudgetRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}

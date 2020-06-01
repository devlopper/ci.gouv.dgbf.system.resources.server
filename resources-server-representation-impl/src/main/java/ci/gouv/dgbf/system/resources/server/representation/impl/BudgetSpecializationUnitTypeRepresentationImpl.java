package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.representation.api.BudgetSpecializationUnitTypeRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetSpecializationUnitTypeDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class BudgetSpecializationUnitTypeRepresentationImpl extends AbstractRepresentationEntityImpl<BudgetSpecializationUnitTypeDto> implements BudgetSpecializationUnitTypeRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}

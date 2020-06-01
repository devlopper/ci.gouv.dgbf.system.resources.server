package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.representation.api.BudgetSpecializationUnitCategoryRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetSpecializationUnitCategoryDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class BudgetSpecializationUnitCategoryRepresentationImpl extends AbstractRepresentationEntityImpl<BudgetSpecializationUnitCategoryDto> implements BudgetSpecializationUnitCategoryRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}

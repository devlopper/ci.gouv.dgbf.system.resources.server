package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

import ci.gouv.dgbf.system.resources.server.representation.api.BudgetCategoryRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.BudgetCategoryDto;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

@ApplicationScoped
public class BudgetCategoryRepresentationImpl extends AbstractRepresentationEntityImpl<BudgetCategoryDto> implements BudgetCategoryRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
}

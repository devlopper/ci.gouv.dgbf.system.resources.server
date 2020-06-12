package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.cyk.utility.__kernel__.persistence.query.EntityFinder;
import org.cyk.utility.__kernel__.string.StringHelper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Activity.TABLE_NAME)
public class Activity extends AbstractNamableWithTransientAmounts implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_BUDGET_SPECIALIZATION_UNIT) private BudgetSpecializationUnit budgetSpecializationUnit;
	
	@Transient private Collection<Resource> resources;
	@Transient private String budgetSpecializationUnitIdentifier;
	
	@Override
	public Activity setIdentifier(String identifier) {
		return (Activity) super.setIdentifier(identifier);
	}
	
	@Override
	public Activity setCode(String code) {
		return (Activity) super.setCode(code);
	}
	
	@Override
	public Activity setName(String name) {
		return (Activity) super.setName(name);
	}
	
	public Activity setBudgetSpecializationUnitFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setBudgetSpecializationUnit(null);
		setBudgetSpecializationUnit(EntityFinder.getInstance().find(BudgetSpecializationUnit.class, identifier));
		return this;
	}
	
	public static final String FIELD_BUDGET_SPECIALIZATION_UNIT = "budgetSpecializationUnit";
	public static final String FIELD_BUDGET_SPECIALIZATION_UNIT_IDENTIFIER = "budgetSpecializationUnitIdentifier";
	
	public static final String COLUMN_BUDGET_SPECIALIZATION_UNIT = "USB";
	
	public static final String TABLE_NAME = "ACTIVITE";	
}
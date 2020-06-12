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
@Entity @Table(name=BudgetSpecializationUnitCategory.TABLE_NAME)
public class BudgetSpecializationUnitCategory extends AbstractNamableWithTransientAmounts implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_TYPE) private BudgetSpecializationUnitType type;
	
	@Transient private String sectionIdentifier;
	@Transient private Collection<BudgetSpecializationUnit> budgetSpecializationUnits;
	
	@Override
	public BudgetSpecializationUnitCategory setIdentifier(String identifier) {
		return (BudgetSpecializationUnitCategory) super.setIdentifier(identifier);
	}
	
	@Override
	public BudgetSpecializationUnitCategory setCode(String code) {
		return (BudgetSpecializationUnitCategory) super.setCode(code);
	}
	
	@Override
	public BudgetSpecializationUnitCategory setName(String name) {
		return (BudgetSpecializationUnitCategory) super.setName(name);
	}
	
	public BudgetSpecializationUnitCategory setTypeFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setType(null);
		setType(EntityFinder.getInstance().find(BudgetSpecializationUnitType.class, identifier));
		return this;
	}
	
	public static final String FIELD_TYPE = "type";
	public static final String FIELD_SECTION_IDENTIFIER = "sectionIdentifier";
	
	public static final String COLUMN_TYPE = "TYPE";
	
	public static final String TABLE_NAME = "CATEGORIE_USB";	
}
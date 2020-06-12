package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Section.TABLE_NAME)
public class Section extends AbstractNamableWithTransientAmounts implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Transient private Collection<BudgetSpecializationUnitCategory> budgetSpecializationUnitCategories;
	@Transient private Collection<BudgetSpecializationUnit> budgetSpecializationUnits;
	
	@Override
	public Section setIdentifier(String identifier) {
		return (Section) super.setIdentifier(identifier);
	}
	
	@Override
	public Section setCode(String code) {
		return (Section) super.setCode(code);
	}
	
	@Override
	public Section setName(String name) {
		return (Section) super.setName(name);
	}
	
	public static final String TABLE_NAME = "section";	
}
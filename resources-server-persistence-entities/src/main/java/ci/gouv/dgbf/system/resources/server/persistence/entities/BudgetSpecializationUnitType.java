package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=BudgetSpecializationUnitType.TABLE_NAME)
public class BudgetSpecializationUnitType extends AbstractNamableWithTransientAmounts implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public BudgetSpecializationUnitType setIdentifier(String identifier) {
		return (BudgetSpecializationUnitType) super.setIdentifier(identifier);
	}
	
	@Override
	public BudgetSpecializationUnitType setCode(String code) {
		return (BudgetSpecializationUnitType) super.setCode(code);
	}
	
	@Override
	public BudgetSpecializationUnitType setName(String name) {
		return (BudgetSpecializationUnitType) super.setName(name);
	}
	
	public static final String TABLE_NAME = "TYPE_USB";	
}
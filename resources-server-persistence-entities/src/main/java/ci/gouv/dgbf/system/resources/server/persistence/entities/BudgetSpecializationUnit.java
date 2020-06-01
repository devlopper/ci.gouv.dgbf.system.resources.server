package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=BudgetSpecializationUnit.TABLE_NAME)
public class BudgetSpecializationUnit extends AbstractNamableWithTransientAmounts implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_SECTION) private Section section;
	@ManyToOne @JoinColumn(name = COLUMN_CATEGORY) private BudgetSpecializationUnitCategory category;
	
	@Override
	public BudgetSpecializationUnit setIdentifier(String identifier) {
		return (BudgetSpecializationUnit) super.setIdentifier(identifier);
	}
	
	@Override
	public BudgetSpecializationUnit setCode(String code) {
		return (BudgetSpecializationUnit) super.setCode(code);
	}
	
	@Override
	public BudgetSpecializationUnit setName(String name) {
		return (BudgetSpecializationUnit) super.setName(name);
	}
	
	public static final String FIELD_SECTION = "section";
	public static final String FIELD_CATEGORY = "category";
	
	public static final String COLUMN_SECTION = "SECTION";
	public static final String COLUMN_CATEGORY = "CATEGORIE";
	
	public static final String TABLE_NAME = "usb";	
}
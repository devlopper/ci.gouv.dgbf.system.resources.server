package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=BudgetCategory.TABLE_NAME)
public class BudgetCategory extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public BudgetCategory setIdentifier(String identifier) {
		return (BudgetCategory) super.setIdentifier(identifier);
	}
	
	public static final String TABLE_NAME = "CATEGORIE_BUDGET";	
}
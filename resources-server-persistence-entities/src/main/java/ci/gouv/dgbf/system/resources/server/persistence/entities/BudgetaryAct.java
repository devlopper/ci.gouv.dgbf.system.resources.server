package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=BudgetaryAct.TABLE_NAME)
@AttributeOverrides(value= {
		@AttributeOverride(name=BudgetaryAct.FIELD_IDENTIFIER,column = @Column(name="UUID"))
		,@AttributeOverride(name=BudgetaryAct.FIELD_CODE,column = @Column(name="AB_CODE"))
		,@AttributeOverride(name=BudgetaryAct.FIELD_NAME,column = @Column(name="AB_LIBELLE"))
})
public class BudgetaryAct extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public BudgetaryAct setIdentifier(String identifier) {
		return (BudgetaryAct) super.setIdentifier(identifier);
	}
	
	@Override
	public BudgetaryAct setCode(String code) {
		return (BudgetaryAct) super.setCode(code);
	}
	
	@Override
	public BudgetaryAct setName(String name) {
		return (BudgetaryAct) super.setName(name);
	}
	
	public static final String TABLE_NAME = "acte_budgetaire";	
}
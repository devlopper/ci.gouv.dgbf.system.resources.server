package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=BudgetaryActVersion.TABLE_NAME)
@AttributeOverrides(value= {
		@AttributeOverride(name=BudgetaryActVersion.FIELD_IDENTIFIER,column = @Column(name="UUID"))
		,@AttributeOverride(name=BudgetaryActVersion.FIELD_CODE,column = @Column(name="VAB_CODE"))
		,@AttributeOverride(name=BudgetaryActVersion.FIELD_NAME,column = @Column(name="VAB_LIBELLE"))
})
public class BudgetaryActVersion extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_BUDGETARY_ACT) private BudgetaryAct budgetaryAct;
	
	@Override
	public BudgetaryActVersion setIdentifier(String identifier) {
		return (BudgetaryActVersion) super.setIdentifier(identifier);
	}
	
	@Override
	public BudgetaryActVersion setCode(String code) {
		return (BudgetaryActVersion) super.setCode(code);
	}
	
	@Override
	public BudgetaryActVersion setName(String name) {
		return (BudgetaryActVersion) super.setName(name);
	}
	
	public static final String FIELD_BUDGETARY_ACT = "budgetaryAct";
	
	public static final String COLUMN_BUDGETARY_ACT = "VAB_AB_ID";
	
	public static final String TABLE_NAME = "VERS_ACT_BUD";	
}
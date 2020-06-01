package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Budget.TABLE_NAME)
@AttributeOverrides(value= {
		@AttributeOverride(name=Budget.FIELD_IDENTIFIER,column = @Column(name="UUID"))
		,@AttributeOverride(name=Budget.FIELD_CODE,column = @Column(name="BUD_CODE"))
})
public class Budget extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_BUDGETARY_ACT_VERSION) private BudgetaryActVersion budgetaryActVersion;
	
	@Override
	public Budget setIdentifier(String identifier) {
		return (Budget) super.setIdentifier(identifier);
	}
	
	@Override
	public Budget setCode(String code) {
		return (Budget) super.setCode(code);
	}
	
	public static final String FIELD_BUDGETARY_ACT_VERSION = "budgetaryActVersion";
	
	public static final String COLUMN_BUDGETARY_ACT_VERSION = "BUD_VAB_ID";
	
	public static final String TABLE_NAME = "budget";	
}
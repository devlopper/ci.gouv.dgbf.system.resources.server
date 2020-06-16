package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringImpl;
import org.cyk.utility.__kernel__.persistence.query.EntityFinder;
import org.cyk.utility.__kernel__.string.StringHelper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Expenditure.TABLE_NAME)
@AttributeOverrides(value= {
		@AttributeOverride(name=Expenditure.FIELD_IDENTIFIER,column = @Column(name="UUID"))
})
public class Expenditure extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull @ManyToOne @JoinColumn(name = COLUMN_BUDGET) private Budget budget;
	
	@Override
	public Expenditure setIdentifier(String identifier) {
		return (Expenditure) super.setIdentifier(identifier);
	}
	
	public Expenditure setBudgetFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setBudget(null);
		setBudget(EntityFinder.getInstance().find(Budget.class, identifier));
		return this;
	}
	
	public static final String FIELD_BUDGET = "budget";
	
	public static final String COLUMN_BUDGET = "DEP_BUD_ID";
	
	public static final String TABLE_NAME = "LIGNE_DEPENSE";	
}
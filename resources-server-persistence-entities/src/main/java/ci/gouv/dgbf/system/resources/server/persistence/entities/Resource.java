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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Resource.TABLE_NAME)
@AttributeOverrides(value= {
		@AttributeOverride(name=Resource.FIELD_IDENTIFIER,column = @Column(name="UUID"))
})
public class Resource extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotNull @ManyToOne @JoinColumn(name = COLUMN_BUDGET) private Budget budget;
	@NotNull @ManyToOne @JoinColumn(name = COLUMN_ACTIVITY) private Activity activity;
	@NotNull @ManyToOne @JoinColumn(name = COLUMN_ECONOMIC_NATURE) private EconomicNature economicNature;
	
	@AttributeOverrides(value= {
			@AttributeOverride(name=Amounts.FIELD_INITIAL,column = @Column(name=COLUMN_AMOUNT))
	})
	private Amounts amounts = new Amounts();
	
	@Override
	public Resource setIdentifier(String identifier) {
		return (Resource) super.setIdentifier(identifier);
	}
	
	public static final String FIELD_BUDGET = "budget";
	public static final String FIELD_ACTIVITY = "activity";
	public static final String FIELD_ECONOMIC_NATURE = "economicNature";
	public static final String FIELD_AMOUNTS = "amounts";
	
	public static final String COLUMN_BUDGET = "REC_BUD_ID";
	public static final String COLUMN_ACTIVITY = "REC_ACTIVITE_ID";
	public static final String COLUMN_ECONOMIC_NATURE = "REC_NATURE_ECO_ID";
	public static final String COLUMN_AMOUNT = "REC_MONTANT";
	
	public static final String TABLE_NAME = "ligne_recette";	
}
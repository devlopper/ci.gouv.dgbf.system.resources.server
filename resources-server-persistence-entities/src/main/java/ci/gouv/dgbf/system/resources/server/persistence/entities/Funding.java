package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringImpl;
import org.cyk.utility.__kernel__.persistence.query.EntityFinder;
import org.cyk.utility.__kernel__.string.StringHelper;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Funding.TABLE_NAME)
@AttributeOverrides(value = {
		@AttributeOverride(name = Funding.FIELD_IDENTIFIER,column = @Column(name="UUID"))
})
public class Funding extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_FUNDING_SOURCE) private FundingSource fundingSource;
	@ManyToOne @JoinColumn(name = COLUMN_LESSOR) private Lessor lessor;
	@ManyToOne @JoinColumn(name = COLUMN_EXPENDITURE) private Expenditure expenditure;
	@Column(name = COLUMN_AMOUNT) private Long amount;
	
	@Override
	public Funding setIdentifier(String identifier) {
		return (Funding) super.setIdentifier(identifier);
	}
	
	public Funding setFundingSourceFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setFundingSource(null);
		setFundingSource(EntityFinder.getInstance().find(FundingSource.class, identifier));
		return this;
	}
	
	public Funding setLessorFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setLessor(null);
		setLessor(EntityFinder.getInstance().find(Lessor.class, identifier));
		return this;
	}
	
	public Funding setExpenditureFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setExpenditure(null);
		setExpenditure(EntityFinder.getInstance().find(Expenditure.class, identifier));
		return this;
	}
	
	public static final String FIELD_FUNDING_SOURCE = "fundingSource";
	public static final String FIELD_LESSOR = "lessor";
	public static final String FIELD_EXPENDITURE = "expenditure";
	public static final String FIELD_AMOUNT = "amount";
	
	public static final String COLUMN_FUNDING_SOURCE = "FIN_SFIN_ID";
	public static final String COLUMN_LESSOR = "BAILLEUR_ID";
	public static final String COLUMN_EXPENDITURE = "FIN_DEP_ID";
	public static final String COLUMN_AMOUNT = "FIN_MONTANT_CP";
	
	public static final String TABLE_NAME = "FINANCEMENT";	
}
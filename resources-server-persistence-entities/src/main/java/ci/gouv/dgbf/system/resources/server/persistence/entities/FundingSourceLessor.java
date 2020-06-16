package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

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
@Entity @Table(name=FundingSourceLessor.TABLE_NAME)
public class FundingSourceLessor extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ManyToOne @JoinColumn(name = COLUMN_FUNDING_SOURCE) private FundingSource fundingSource;
	@ManyToOne @JoinColumn(name = COLUMN_LESSOR) private Lessor lessor;
	@ManyToOne @JoinColumn(name = COLUMN_ECONOMIC_NATURE) private EconomicNature economicNature;
	
	@Override
	public FundingSourceLessor setIdentifier(String identifier) {
		return (FundingSourceLessor) super.setIdentifier(identifier);
	}
	
	public FundingSourceLessor setFundingSourceFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setFundingSource(null);
		setFundingSource(EntityFinder.getInstance().find(FundingSource.class, identifier));
		return this;
	}
	
	public FundingSourceLessor setLessorFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setLessor(null);
		setLessor(EntityFinder.getInstance().find(Lessor.class, identifier));
		return this;
	}
	
	public FundingSourceLessor setEconomicNatureFromIdentifier(String identifier) {
		if(StringHelper.isBlank(identifier))
			setEconomicNature(null);
		setEconomicNature(EntityFinder.getInstance().find(EconomicNature.class, identifier));
		return this;
	}
	
	public static final String FIELD_FUNDING_SOURCE = "fundingSource";
	public static final String FIELD_LESSOR = "lessor";
	public static final String FIELD_ECONOMIC_NATURE = "economicNature";
	
	public static final String COLUMN_FUNDING_SOURCE = "source_financement";
	public static final String COLUMN_LESSOR = "bailleur";
	public static final String COLUMN_ECONOMIC_NATURE = "nature_economique";
	
	public static final String TABLE_NAME = "SOURCE_FINANCEMENT_BAILLEUR";	
}
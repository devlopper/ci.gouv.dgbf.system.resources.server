package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=Lessor.TABLE_NAME)
public class Lessor extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Transient private Collection<EconomicNature> economicNatures;
	@Transient private Collection<FundingSourceLessor> fundingSourceLessors;
	
	@Override
	public Lessor setIdentifier(String identifier) {
		return (Lessor) super.setIdentifier(identifier);
	}
	
	@Override
	public Lessor setCode(String code) {
		return (Lessor) super.setCode(code);
	}
	
	@Override
	public Lessor setName(String name) {
		return (Lessor) super.setName(name);
	}
	
	public Collection<EconomicNature> getEconomicNatures(Boolean injectIfNull) {
		if(economicNatures == null && Boolean.TRUE.equals(injectIfNull))
			economicNatures = new ArrayList<>();
		return economicNatures;
	}
	
	public Collection<FundingSourceLessor> getFundingSourceLessors(Boolean injectIfNull) {
		if(fundingSourceLessors == null && Boolean.TRUE.equals(injectIfNull))
			fundingSourceLessors = new ArrayList<>();
		return fundingSourceLessors;
	}
	
	public static final String TABLE_NAME = "BAILLEUR";	
}
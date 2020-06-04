package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
@Entity @Table(name=EconomicNature.TABLE_NAME)
public class EconomicNature extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public EconomicNature setIdentifier(String identifier) {
		return (EconomicNature) super.setIdentifier(identifier);
	}
	
	@Override
	public EconomicNature setCode(String code) {
		return (EconomicNature) super.setCode(code);
	}
	
	@Override
	public EconomicNature setName(String name) {
		return (EconomicNature) super.setName(name);
	}
	
	public static final String TABLE_NAME = "NATURE_ECONOMIQUE";	
}
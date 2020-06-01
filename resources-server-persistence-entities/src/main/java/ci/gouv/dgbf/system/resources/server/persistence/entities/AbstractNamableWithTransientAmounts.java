package ci.gouv.dgbf.system.resources.server.persistence.entities;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@MappedSuperclass @Getter @Setter @Accessors(chain=true)
public abstract class AbstractNamableWithTransientAmounts extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl {

	@Transient protected Amounts amounts = new Amounts();
	
	@Override
	public String toString() {
		return code+" "+name;
	}
	
	public static final String FIELD_AMOUNTS = "amounts";
}
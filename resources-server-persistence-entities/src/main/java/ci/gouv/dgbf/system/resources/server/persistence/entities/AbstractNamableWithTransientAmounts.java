package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@MappedSuperclass @Getter @Setter @Accessors(chain=true)
public abstract class AbstractNamableWithTransientAmounts extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable,Amountable {

	@Transient protected Amounts amounts;
	
	@Override
	public String toString() {
		return code+" "+name;
	}
	
	public static final String FIELD_AMOUNTS = "amounts";
}
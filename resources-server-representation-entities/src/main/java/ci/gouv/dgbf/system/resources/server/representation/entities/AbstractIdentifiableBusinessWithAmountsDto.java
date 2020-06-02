package ci.gouv.dgbf.system.resources.server.representation.entities;

import javax.persistence.MappedSuperclass;

import org.cyk.utility.__kernel__.object.__static__.representation.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@MappedSuperclass @Getter @Setter @Accessors(chain=true)
public abstract class AbstractIdentifiableBusinessWithAmountsDto extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringImpl {

	protected AmountsDto amounts;
	
	public AmountsDto getAmounts(Boolean injectIfNull) {
		if(amounts == null && Boolean.TRUE.equals(injectIfNull))
			amounts = new AmountsDto();
		return amounts;
	}
	
	@Override
	public String toString() {
		return code;
	}
	
	public static final String FIELD_AMOUNTS = "amounts";
}
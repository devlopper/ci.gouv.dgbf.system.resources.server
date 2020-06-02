package ci.gouv.dgbf.system.resources.server.representation.entities;

import javax.persistence.MappedSuperclass;

import org.cyk.utility.__kernel__.object.__static__.representation.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@MappedSuperclass @Getter @Setter @Accessors(chain=true)
public abstract class AbstractNamableWithAmountsDto extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl {

	protected AmountsDto amounts;
	
	public AmountsDto getAmounts(Boolean injectIfNull) {
		if(amounts == null && Boolean.TRUE.equals(injectIfNull))
			amounts = new AmountsDto();
		return amounts;
	}
	
	@Override
	public String toString() {
		return code+" "+name;
	}
	
	public static final String FIELD_AMOUNTS = "amounts";
}
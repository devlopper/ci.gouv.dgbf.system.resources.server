package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.cyk.utility.__kernel__.string.StringHelper;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@MappedSuperclass @Getter @Setter @Accessors(chain=true)
public abstract class AbstractNamableWithTransientAmounts extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable,Amountable {

	@Transient protected Amounts amounts;
	
	@Override
	public String toString() {
		if(StringHelper.isBlank(identifier))
			if(StringHelper.isBlank(code))
				return name;
			else
				if(StringHelper.isBlank(name))
					return code;
				else
					return code+" "+name;
		else
			if(StringHelper.isBlank(code))
				if(StringHelper.isBlank(name))
					return identifier;
				else
					return name;
			else
				if(StringHelper.isBlank(name))
					return code;
				else
					return code+" "+name;
	}
	
	public static final String FIELD_AMOUNTS = "amounts";
}
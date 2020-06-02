package ci.gouv.dgbf.system.resources.server.representation.entities;

import java.io.Serializable;

import org.cyk.utility.__kernel__.object.AbstractObject;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true)
public abstract class AbstractAmountsDto extends AbstractObject implements Serializable {

	private Long initial;
	
	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, initial);
	}
	
	public static final String TO_STRING_FORMAT = "I=%s";
	
	public static final String FIELD_INITIAL = "initial";
}
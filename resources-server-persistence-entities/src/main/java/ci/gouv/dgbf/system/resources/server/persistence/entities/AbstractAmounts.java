package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.cyk.utility.__kernel__.object.AbstractObject;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @MappedSuperclass
public abstract class AbstractAmounts extends AbstractObject implements Serializable {

	@Column(name = COLUMN_INITIAL) private Long initial = 0l;
	
	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, initial);
	}
	
	public static final String TO_STRING_FORMAT = "I=%s";
	
	public static final String FIELD_INITIAL = "initial";
	
	public static final String COLUMN_INITIAL = FIELD_INITIAL;
}
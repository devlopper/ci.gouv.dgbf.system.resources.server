package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.cyk.utility.__kernel__.number.NumberHelper;
import org.cyk.utility.__kernel__.object.AbstractObject;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @MappedSuperclass
public abstract class AbstractAmounts extends AbstractObject implements Serializable {

	@Column(name = COLUMN_INITIAL) private Long initial = 0l;
	
	public AbstractAmounts increment(AbstractAmounts amounts) {
		if(amounts == null)
			return this;
		incrementInitial(amounts.getInitial());	
		return this;
	}
	
	public AbstractAmounts decrement(AbstractAmounts amounts) {
		if(amounts == null)
			return this;
		decrementInitial(amounts.getInitial());
		return this;
	}
	
	public AbstractAmounts incrementInitial(Long value) {
		if(value == null)
			return this;
		initial = (Long) NumberHelper.getLong(NumberHelper.add(initial,value));		
		return this;
	}
	
	public AbstractAmounts decrementInitial(Long value) {
		if(value == null)
			return this;
		initial = (Long) NumberHelper.getLong(NumberHelper.subtract(initial,value));		
		return this;
	}
	
	@Override
	public String toString() {
		return String.format(TO_STRING_FORMAT, initial);
	}
	
	public static final String TO_STRING_FORMAT = "I=%s";
	
	public static final String FIELD_INITIAL = "initial";
	
	public static final String COLUMN_INITIAL = FIELD_INITIAL;
}
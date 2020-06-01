package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Amounts extends AbstractAmounts implements Serializable {

	@Override
	public Amounts setInitial(Long initial) {
		return (Amounts) super.setInitial(initial);
	}
	
	private static final String COLUMN_SUFFIX = "REC_";
	
	public static final String COLUMN_INITIAL = AbstractAmounts.COLUMN_INITIAL+COLUMN_SUFFIX;
}
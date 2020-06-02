package ci.gouv.dgbf.system.resources.server.representation.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AmountsDto extends AbstractAmountsDto implements Serializable {

	@Override
	public AmountsDto setInitial(Long initial) {
		return (AmountsDto) super.setInitial(initial);
	}
}
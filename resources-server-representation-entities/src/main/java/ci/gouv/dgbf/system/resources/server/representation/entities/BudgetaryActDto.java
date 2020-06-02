package ci.gouv.dgbf.system.resources.server.representation.entities;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class BudgetaryActDto extends AbstractNamableWithAmountsDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public BudgetaryActDto setIdentifier(String identifier) {
		return (BudgetaryActDto) super.setIdentifier(identifier);
	}

}
package ci.gouv.dgbf.system.resources.server.representation.entities;

import java.io.Serializable;

import org.cyk.utility.__kernel__.object.__static__.representation.AbstractIdentifiableSystemScalarStringImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class FundingSourceLessorDto extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private FundingSourceDto fundingSource;
	//private LessorDto lessor;
	private String lessorIdentifier;
	private EconomicNatureDto economicNature;
	
	private Boolean deletable;

}
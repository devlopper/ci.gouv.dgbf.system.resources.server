package ci.gouv.dgbf.system.resources.server.representation.entities;

import java.io.Serializable;
import java.util.ArrayList;

import org.cyk.utility.__kernel__.object.__static__.representation.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class LessorDto extends AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//private ArrayList<EconomicNatureDto> economicNatures;
	private ArrayList<FundingSourceLessorDto> fundingSourceLessors;
}
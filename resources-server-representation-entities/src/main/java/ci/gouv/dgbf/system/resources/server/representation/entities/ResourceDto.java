package ci.gouv.dgbf.system.resources.server.representation.entities;

import java.io.Serializable;

import org.cyk.utility.__kernel__.object.__static__.representation.AbstractIdentifiableSystemScalarStringImpl;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter @Setter @Accessors(chain=true) @NoArgsConstructor
public class ResourceDto extends AbstractIdentifiableSystemScalarStringImpl implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private BudgetSpecializationUnitDto budgetSpecializationUnit;
	private BudgetaryActVersionDto budgetaryActVersion;
	private BudgetDto budget;
	private ActivityDto activity;
	private EconomicNatureDto economicNature;
	private AmountsDto amounts;
	private String sectionAsString,activityAsString,budgetSpecializationUnitAsString,economicNatureAsString;
	
	public AmountsDto getAmounts(Boolean injectIfNull) {
		if(amounts == null && Boolean.TRUE.equals(injectIfNull))
			amounts = new AmountsDto();
		return amounts;
	}
	
	/**/
	
	public static final String FIELD_BUDGET = "budget";
	public static final String FIELD_ACTIVITY = "activity";
	public static final String FIELD_ECONOMIC_NATURE = "economicNature";
	public static final String FIELD_AMOUNTS = "amounts";
	public static final String FIELD_SECTION_AS_STRING = "sectionAsString";
	public static final String FIELD_ACTIVITY_AS_STRING = "activityAsString";
	public static final String FIELD_BUDGET_SPECIALIZATION_UNIT_AS_STRING = "budgetSpecializationUnitAsString";
	public static final String FIELD_ECONOMIC_NATURE_AS_STRING = "economicNatureAsString";
}
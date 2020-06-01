package ci.gouv.dgbf.system.resources.server.persistence.api.query;
import java.util.Map;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByDimensionOneBusinessIdentifierQuerier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;;

@org.cyk.utility.__kernel__.persistence.query.annotation.Queries(value = {
		@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = Activity.class,name = ActivityByBudgetSpecializationUnitQuerier.QUERY_NAME_READ_BY_BUDGET_SPECIALIZATION_UNITS_CODES,value = "SELECT t FROM Activity t WHERE t.budgetSpecializationUnit.code IN :"+ActivityByBudgetSpecializationUnitQuerier.PARAMETER_NAME_BUDGET_SPECIALIZATION_UNITS_CODES+" ORDER BY t.code ASC")
})
public interface ActivityByBudgetSpecializationUnitQuerier extends ByDimensionOneBusinessIdentifierQuerier<Activity,BudgetSpecializationUnit,String> {

	/**/
	
	static ActivityByBudgetSpecializationUnitQuerier getInstance() {
		return Helper.getInstance(ActivityByBudgetSpecializationUnitQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE = "budgetaryActVersionCode";
	
	String QUERY_NAME_READ_BY_BUDGET_SPECIALIZATION_UNITS_CODES = "readByBudgetSpecializationUnitsCodes";
	String QUERY_IDENTIFIER_READ_BY_BUDGET_SPECIALIZATION_UNITS_CODES = QueryIdentifierBuilder.getInstance().build(Activity.class, QUERY_NAME_READ_BY_BUDGET_SPECIALIZATION_UNITS_CODES);
	String PARAMETER_NAME_BUDGET_SPECIALIZATION_UNITS_CODES = "budgetSpecializationUnitsCodes";
	
	String QUERY_NAME_COUNT_BY_BUDGET_SPECIALIZATION_UNITS_CODES = "countByBudgetSpecializationUnitsCodes";
	
	String QUERY_NAME_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES = "readAggregationByBudgetSpecializationUnitsCodes";
	String QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES = QueryIdentifierBuilder.getInstance().build(Activity.class, QUERY_NAME_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES);
	Map<String,Integer> QUERY_VALUE_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES_INDEXES = ResourceQuerier.deriveSumsTupleFieldsNamesIndexes(
			Activity.FIELD_IDENTIFIER,Activity.FIELD_CODE,Activity.FIELD_NAME);
	String QUERY_VALUE_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES_SELECT_FROM = 
			"SELECT t.identifier,t.code,t.name"
			+","+ResourceQuerier.deriveSums("resource")
			+" FROM Activity t ";
	String QUERY_VALUE_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES = 
			QUERY_VALUE_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES_SELECT_FROM
			+" LEFT JOIN Resource resource ON resource.activity.identifier = t.identifier"
			+" WHERE t.budgetSpecializationUnit.code IN :"+PARAMETER_NAME_BUDGET_SPECIALIZATION_UNITS_CODES
			
			+" AND resource.budget.actVersion.code = :"+PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE+" "
			
			+" GROUP BY t.identifier,t.code,t.name"
			+" ORDER BY t.code ASC";
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES
				,Query.FIELD_TUPLE_CLASS,Activity.class,Query.FIELD_RESULT_CLASS,Activity.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES
				).setTupleFieldsNamesIndexes(QUERY_VALUE_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES_INDEXES)
			);
	}
}
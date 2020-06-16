package ci.gouv.dgbf.system.resources.server.persistence.api.query;
import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByDimensionOneBusinessIdentifierQuerier;
import org.cyk.utility.__kernel__.persistence.query.Language;
import org.cyk.utility.__kernel__.persistence.query.Language.Order;
import org.cyk.utility.__kernel__.persistence.query.Language.Where;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Budget;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryActVersion;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;

public interface ResourceByActivityQuerier extends ByDimensionOneBusinessIdentifierQuerier<Resource,Activity,String> {

	/**/
	
	static ResourceByActivityQuerier getInstance() {
		return Helper.getInstance(ResourceByActivityQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE = "budgetaryActVersionCode";
	String PARAMETER_NAME_ACTIVITIES_CODES = "activitiesCodes";
	String PARAMETER_NAME_ACTIVITY_CODE = "activityCode";
	
	/**/
	
	String QUERY_NAME_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE = "readByActivitiesCodesByBudgetaryActVersionCode";
	String QUERY_IDENTIFIER_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE = QueryIdentifierBuilder.getInstance().build(Resource.class, QUERY_NAME_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE);
	String QUERY_VALUE_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_WHERE = Where.of(Where.and(
			Where.inJoinFieldsNames("t", PARAMETER_NAME_ACTIVITIES_CODES,Resource.FIELD_ACTIVITY,Activity.FIELD_CODE)
			,Where.equalsJoinFieldsNames("t", PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,Resource.FIELD_BUDGET,Budget.FIELD_ACT_VERSION,BudgetaryActVersion.FIELD_CODE)
			));
	String QUERY_VALUE_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE = Language.of(ResourceQuerier.QUERY_VALUE_READ_VIEW_02_SELECT_FROM
			,QUERY_VALUE_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_WHERE
			,Order.of(Order.join(Order.asc("t", "activity.code"),Order.desc("t", "economicNature.code"))));
	
	String QUERY_NAME_COUNT_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE = "countByActivitiesCodesByBudgetaryActVersionCode";
	
	/**/
	
	String QUERY_NAME_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE = "readByActivityCodeByBudgetaryActVersionCode";
	String QUERY_IDENTIFIER_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE = QueryIdentifierBuilder.getInstance().build(Resource.class, QUERY_NAME_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE);
	String QUERY_VALUE_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE_WHERE = Where.of(Where.and(
			Where.equalsJoinFieldsNames("t", PARAMETER_NAME_ACTIVITY_CODE,Resource.FIELD_ACTIVITY,Activity.FIELD_CODE)
			,Where.equalsJoinFieldsNames("t", PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,Resource.FIELD_BUDGET,Budget.FIELD_ACT_VERSION,BudgetaryActVersion.FIELD_CODE)
			));
	String QUERY_VALUE_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE = Language.of(ResourceQuerier.QUERY_VALUE_READ_VIEW_02_SELECT_FROM
			,QUERY_VALUE_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE_WHERE
			,Order.of(Order.join(Order.asc("t", "activity.code"),Order.desc("t", "economicNature.code"))));
	
	String QUERY_NAME_COUNT_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE = "countByActivityCodeByBudgetaryActVersionCode";
	
	String QUERY_NAME_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE___INTERNAL = "readByActivityCodeByBudgetaryActVersionCode___INTERNAL";
	String QUERY_IDENTIFIER_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE___INTERNAL = QueryIdentifierBuilder.getInstance().build(Resource.class, QUERY_NAME_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE___INTERNAL);
	String QUERY_VALUE_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE___INTERNAL = Language.of("Select t From Resource t"
			,Where.of(Where.and(
					Where.equalsJoinFieldsNames("t", PARAMETER_NAME_ACTIVITY_CODE,Resource.FIELD_ACTIVITY,Activity.FIELD_CODE)
					,Where.equalsJoinFieldsNames("t", PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,Resource.FIELD_BUDGET,Budget.FIELD_ACT_VERSION,BudgetaryActVersion.FIELD_CODE)
					))
			,Order.of(Order.join(Order.asc("t", "activity.code"),Order.desc("t", "economicNature.code"))));
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE
				,Query.FIELD_TUPLE_CLASS,Resource.class,Query.FIELD_RESULT_CLASS,Resource.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE
				).setTupleFieldsNamesIndexes(ResourceQuerier.QUERY_VALUE_READ_VIEW_02_TUPLE_FIELDS_NAMES_INDEXES)
			);
		
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE
				,Query.FIELD_TUPLE_CLASS,Resource.class,Query.FIELD_RESULT_CLASS,Resource.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE
				).setTupleFieldsNamesIndexes(ResourceQuerier.QUERY_VALUE_READ_VIEW_02_TUPLE_FIELDS_NAMES_INDEXES)
			);
		
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE___INTERNAL
				,Query.FIELD_TUPLE_CLASS,Resource.class,Query.FIELD_RESULT_CLASS,Resource.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE___INTERNAL)
			);
	}
}
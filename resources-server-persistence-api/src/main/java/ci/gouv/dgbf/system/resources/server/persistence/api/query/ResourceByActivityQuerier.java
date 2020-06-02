package ci.gouv.dgbf.system.resources.server.persistence.api.query;
import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByDimensionOneBusinessIdentifierQuerier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;

public interface ResourceByActivityQuerier extends ByDimensionOneBusinessIdentifierQuerier<Resource,Activity,String> {

	/**/
	
	static ResourceByActivityQuerier getInstance() {
		return Helper.getInstance(ResourceByActivityQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE = "budgetaryActVersionCode";
	String PARAMETER_NAME_ACTIVITIES_CODES = "activitiesCodes";
	
	String QUERY_NAME_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE = "readByActivitiesCodesByBudgetaryActVersionCode";
	String QUERY_IDENTIFIER_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE = QueryIdentifierBuilder.getInstance().build(Resource.class, QUERY_NAME_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE);
	String QUERY_VALUE_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_WHERE = " WHERE t.activity.code IN :"+PARAMETER_NAME_ACTIVITIES_CODES
			+" AND t.budget.actVersion.code = :"+PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE+" "
			;
	String QUERY_VALUE_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE = ResourceQuerier.QUERY_VALUE_READ_VIEW_01_SELECT_FROM+QUERY_VALUE_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_WHERE
			+" ORDER BY t.activity.code ASC,t.economicNature.code ASC";
	
	String QUERY_NAME_COUNT_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE = "countByActivitiesCodesByBudgetaryActVersionCode";
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE
				,Query.FIELD_TUPLE_CLASS,Resource.class,Query.FIELD_RESULT_CLASS,Resource.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_BY_ACTIVITIES_CODES_BY_BUDGETARY_ACT_VERSION_CODE
				).setTupleFieldsNamesIndexes(ResourceQuerier.QUERY_VALUE_READ_VIEW_01_TUPLE_FIELDS_NAMES_INDEXES)
			);
	}
}
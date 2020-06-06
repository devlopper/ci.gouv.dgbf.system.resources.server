package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import java.util.Map;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

@Queries(value = {
		@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = Section.class,name = SectionQuerier.QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING,value = "SELECT t FROM Section t ORDER BY t.code ASC")
})
public interface SectionQuerier extends Querier {

	/**/
	
	static SectionQuerier getInstance() {
		return Helper.getInstance(SectionQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE = "budgetaryActVersionCode";
	
	/* read order by code ascending */
	String QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING = "readOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(Section.class, QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING);
	
	/* read amounts aggregation order by code ascending */
	String QUERY_NAME_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = "readAggregationByBudgetaryActVersionCodeOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(Section.class, QUERY_NAME_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING);
	Map<String,Integer> QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_TUPLE_FIELDS_NAMES_INDEXES = ResourceQuerier
			.deriveSumsTupleFieldsNamesIndexes(Section.FIELD_IDENTIFIER,Section.FIELD_CODE,Section.FIELD_NAME);
	String QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = 
			"SELECT t.identifier,t.code,t.name,"+ResourceQuerier.deriveSums("resource")
			+" FROM Section t "
			+" LEFT JOIN BudgetSpecializationUnit budgetSpecializationUnit ON budgetSpecializationUnit.section.identifier = t.identifier "
			+" LEFT JOIN Activity activity ON activity.budgetSpecializationUnit.identifier = budgetSpecializationUnit.identifier "
			+" LEFT JOIN Resource resource ON resource.activity.identifier = activity.identifier "	
			+" LEFT JOIN Budget budget ON budget.specializationUnit.identifier = budgetSpecializationUnit.identifier "	
			+" LEFT JOIN BudgetaryActVersion budgetaryActVersion ON budgetaryActVersion.identifier = budget.actVersion.identifier AND budgetaryActVersion.code = :"+PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE+" "	
			+" GROUP BY t.identifier,t.code,t.name "
			+" ORDER BY t.code ASC"
			;
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
				,Query.FIELD_TUPLE_CLASS,Section.class,Query.FIELD_RESULT_CLASS,Section.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
				).setTupleFieldsNamesIndexes(QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_TUPLE_FIELDS_NAMES_INDEXES)
			);
	}
}
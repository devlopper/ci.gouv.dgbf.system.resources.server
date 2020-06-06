package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import java.util.Map;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitCategory;

@Queries(value = {
		@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = BudgetSpecializationUnitCategory.class,name = BudgetSpecializationUnitCategoryQuerier.QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING
			,value = "SELECT t FROM BudgetSpecializationUnitCategory t ORDER BY t.code ASC")
		,@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = BudgetSpecializationUnitCategory.class,name = BudgetSpecializationUnitCategoryQuerier.QUERY_NAME_READ_BY_TYPES_CODES_ORDER_BY_CODE_ASCENDING
			,value = "SELECT t FROM BudgetSpecializationUnitCategory t WHERE t.type.code IN :"+BudgetSpecializationUnitCategoryQuerier.PARAMETER_NAME_TYPES_CODES+" ORDER BY t.code ASC")
})
public interface BudgetSpecializationUnitCategoryQuerier extends Querier {

	/**/
	
	static BudgetSpecializationUnitCategoryQuerier getInstance() {
		return Helper.getInstance(BudgetSpecializationUnitCategoryQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_NAME_SECTIONS_CODES = "sectionsCodes";
	String PARAMETER_NAME_TYPES_CODES = "typesCodes";
	String PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE = "budgetaryActVersionCode";
	
	String QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING = "readOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnitCategory.class, QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING);	
	
	String QUERY_NAME_READ_BY_TYPES_CODES_ORDER_BY_CODE_ASCENDING = "readByTypesCodesOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_BY_TYPES_CODES_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnitCategory.class, QUERY_NAME_READ_BY_TYPES_CODES_ORDER_BY_CODE_ASCENDING);	
	
	String QUERY_NAME_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = "readAggregationByBudgetaryActVersionCodeOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnitCategory.class, QUERY_NAME_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING);
	Map<String,Integer> QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_TUPLE_FIELDS_NAMES_INDEXES = ResourceQuerier.deriveSumsTupleFieldsNamesIndexes(
			BudgetSpecializationUnitCategory.FIELD_IDENTIFIER,BudgetSpecializationUnitCategory.FIELD_CODE,BudgetSpecializationUnitCategory.FIELD_NAME);
	String QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_SELECT_FROM = 
			"SELECT t.identifier,t.code,t.name,"+ResourceQuerier.deriveSums("resource")
			+" FROM BudgetSpecializationUnitCategory t"
			+" LEFT JOIN BudgetSpecializationUnit budgetSpecializationUnit ON budgetSpecializationUnit.category.identifier = t.identifier "		
			+" LEFT JOIN Budget budget ON budget.specializationUnit.identifier = budgetSpecializationUnit.identifier "	
			+" LEFT JOIN BudgetaryActVersion budgetaryActVersion ON budgetaryActVersion.identifier = budget.actVersion.identifier AND budgetaryActVersion.code = :"+PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE+" "
			+" LEFT JOIN Activity activity ON activity.budgetSpecializationUnit.identifier = budgetSpecializationUnit.identifier"
			+" LEFT JOIN Resource resource ON resource.activity.identifier = activity.identifier"
			;
	String QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = 
			QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_SELECT_FROM
			+" GROUP BY t.identifier,t.code,t.name "
			+" ORDER BY t.code ASC"
			;
	
	String QUERY_NAME_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_SECTIONS_CODES_ORDER_BY_CODE_ASCENDING = "readAggregationBySectionsCodesByBudgetaryActVersionCodeOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_SECTIONS_CODES_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnitCategory.class, QUERY_NAME_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_SECTIONS_CODES_ORDER_BY_CODE_ASCENDING);
	String QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_SECTIONS_CODES_ORDER_BY_CODE_ASCENDING = 
			QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_SELECT_FROM
			+" WHERE activity.budgetSpecializationUnit.section.code IN :"+PARAMETER_NAME_SECTIONS_CODES			
			+" GROUP BY t.identifier,t.code,t.name "
			+" ORDER BY t.code ASC"
			;
	
	String QUERY_NAME_READ_AGGREGATION_BY_SECTIONS_CODES_BY_TYPES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = "readAggregationOrderAscendingBySectionsCodesByTypesCodesByBudgetaryActVersionCode";
	String QUERY_IDENTIFIER_READ_AGGREGATION_BY_SECTIONS_CODES_BY_TYPES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnitCategory.class, QUERY_NAME_READ_AGGREGATION_BY_SECTIONS_CODES_BY_TYPES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING);
	String QUERY_VALUE_READ_AGGREGATION_BY_SECTIONS_CODES_BY_TYPES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = 
			QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_SELECT_FROM
			+" WHERE activity.budgetSpecializationUnit.section.code IN :"+PARAMETER_NAME_SECTIONS_CODES
			+" AND activity.budgetSpecializationUnit.category.type.code IN :"+PARAMETER_NAME_TYPES_CODES			
			+" GROUP BY t.identifier,t.code,t.name "
			+" ORDER BY t.code ASC"
			;
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,BudgetSpecializationUnitCategoryQuerier.QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
				,Query.FIELD_TUPLE_CLASS,BudgetSpecializationUnitCategory.class,Query.FIELD_RESULT_CLASS,BudgetSpecializationUnitCategory.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
				).setTupleFieldsNamesIndexes(QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_TUPLE_FIELDS_NAMES_INDEXES)
			);
		
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,BudgetSpecializationUnitCategoryQuerier.QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_SECTIONS_CODES_ORDER_BY_CODE_ASCENDING
				,Query.FIELD_TUPLE_CLASS,BudgetSpecializationUnitCategory.class,Query.FIELD_RESULT_CLASS,BudgetSpecializationUnitCategory.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_SECTIONS_CODES_ORDER_BY_CODE_ASCENDING
				).setTupleFieldsNamesIndexes(QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_TUPLE_FIELDS_NAMES_INDEXES)
			);
		
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,BudgetSpecializationUnitCategoryQuerier.QUERY_IDENTIFIER_READ_AGGREGATION_BY_SECTIONS_CODES_BY_TYPES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
				,Query.FIELD_TUPLE_CLASS,BudgetSpecializationUnitCategory.class,Query.FIELD_RESULT_CLASS,BudgetSpecializationUnitCategory.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_AGGREGATION_BY_SECTIONS_CODES_BY_TYPES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
				).setTupleFieldsNamesIndexes(QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_TUPLE_FIELDS_NAMES_INDEXES)
			);
	}
}
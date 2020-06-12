package ci.gouv.dgbf.system.resources.server.persistence.api.query;
import java.util.Map;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByDimensionOneBusinessIdentifierQuerier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

@Queries(value = {
	@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = BudgetSpecializationUnit.class,name = BudgetSpecializationUnitBySectionQuerier.QUERY_NAME_READ_BY_SECTIONS_CODES,value = "SELECT t FROM BudgetSpecializationUnit t WHERE t.section.code IN :"+BudgetSpecializationUnitBySectionQuerier.PARAMETER_NAME_SECTIONS_CODES+" ORDER BY t.code ASC")
	,@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = BudgetSpecializationUnit.class,name = BudgetSpecializationUnitBySectionQuerier.QUERY_NAME_READ_BY_SECTIONS_CODES_BY_TYPES_CODES,value = "SELECT t FROM BudgetSpecializationUnit t WHERE t.section.code IN :"
			+BudgetSpecializationUnitBySectionQuerier.PARAMETER_NAME_SECTIONS_CODES+" AND t.category.type.identifier IN :"+BudgetSpecializationUnitBySectionQuerier.PARAMETER_NAME_TYPES_CODES+" ORDER BY t.code ASC")
})
public interface BudgetSpecializationUnitBySectionQuerier extends ByDimensionOneBusinessIdentifierQuerier<BudgetSpecializationUnit,Section,String> {

	/**/
	
	static BudgetSpecializationUnitBySectionQuerier getInstance() {
		return Helper.getInstance(BudgetSpecializationUnitBySectionQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE = "budgetaryActVersionCode";
	String PARAMETER_NAME_SECTIONS_CODES = "sectionsCodes";
	String PARAMETER_NAME_TYPES_CODES = "typesCodes";
	
	String QUERY_NAME_READ_BY_SECTIONS_CODES = "readBySectionsCodes";
	String QUERY_IDENTIFIER_READ_BY_SECTIONS_CODES = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnit.class, QUERY_NAME_READ_BY_SECTIONS_CODES);
	
	String QUERY_NAME_COUNT_BY_SECTIONS_CODES = "countBySectionsCodes";
	
	String QUERY_NAME_READ_BY_SECTIONS_CODES_BY_TYPES_CODES = "readBySectionsCodesByTypesCodes";
	String QUERY_IDENTIFIER_READ_BY_SECTIONS_CODES_BY_TYPES_CODES = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnit.class, QUERY_NAME_READ_BY_SECTIONS_CODES_BY_TYPES_CODES);

	String QUERY_NAME_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE = "readAggregationBySectionsCodesByBudgetaryActVersionCode";
	String QUERY_IDENTIFIER_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnit.class, QUERY_NAME_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE);
	Map<String,Integer> QUERY_VALUE_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE_INDEXES = ResourceQuerier.deriveSumsTupleFieldsNamesIndexes(
			BudgetSpecializationUnit.FIELD_IDENTIFIER,BudgetSpecializationUnit.FIELD_CODE,BudgetSpecializationUnit.FIELD_NAME,BudgetSpecializationUnit.FIELD_SECTION_IDENTIFIER);
	String QUERY_VALUE_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE_SELECT_FROM = 
			"SELECT t.identifier,t.code,t.name,t.section.identifier"
			+","+ResourceQuerier.deriveSums("resource")	
			+" FROM BudgetSpecializationUnit t "
			+" INNER JOIN Budget budget ON budget.specializationUnit.identifier = t.identifier ";
	String QUERY_VALUE_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE = 
			QUERY_VALUE_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE_SELECT_FROM
			+" INNER JOIN Resource resource ON resource.budget.identifier = budget.identifier"
			+" WHERE budget.actVersion.code = :"+PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE+" AND t.section.code IN :"+PARAMETER_NAME_SECTIONS_CODES			
			+" GROUP BY t.identifier,t.code,t.name,t.section.identifier"
			+" ORDER BY t.code ASC";
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE
				,Query.FIELD_TUPLE_CLASS,BudgetSpecializationUnit.class,Query.FIELD_RESULT_CLASS,BudgetSpecializationUnit.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE
				).setTupleFieldsNamesIndexes(QUERY_VALUE_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE_INDEXES)
			);
	}
}
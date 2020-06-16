package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import java.util.Map;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.map.MapHelper;
import org.cyk.utility.__kernel__.persistence.query.Language;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;

@Queries(value = {
		@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = EconomicNature.class,name = EconomicNatureQuerier.QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING,value = "SELECT t FROM EconomicNature t ORDER BY t.identifier ASC")
		,@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = EconomicNature.class,name = EconomicNatureQuerier.QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING
		,value = "SELECT t FROM EconomicNature t WHERE NOT EXISTS(SELECT t1.identifier FROM Resource t1 WHERE t1.economicNature = t AND t1.activity.identifier IN :"+EconomicNatureQuerier.PARAMETER_NAME_ACTIVITIES_CODES+") ORDER BY t.identifier ASC")
		,@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = EconomicNature.class,name = EconomicNatureQuerier.QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_AND_IDENTIFIER_DOES_START_BY_7_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING
		,value = "SELECT t FROM EconomicNature t WHERE (t.identifier LIKE '1%' OR t.identifier LIKE '7%') AND NOT EXISTS(SELECT t1.identifier FROM Resource t1 WHERE t1.economicNature = t AND t1.activity.identifier IN :"+EconomicNatureQuerier.PARAMETER_NAME_ACTIVITIES_CODES+") ORDER BY t.identifier ASC")
})
public interface EconomicNatureQuerier extends Querier {

	/**/
	
	static EconomicNatureQuerier getInstance() {
		return Helper.getInstance(EconomicNatureQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_NAME_ACTIVITIES_CODES = "activitiesCodes";
	String PARAMETER_NAME_FUNDING_SOURCES_CODES = "fundingSourcesCodes";
	String PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE = "budgetaryActVersionCode";
	
	/* read order by code ascending */
	String QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING = "readOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(EconomicNature.class, QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING);
	
	/* read where activity revenue economic nature does not exist by activities codes order by code ascending */
	String QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING = "readWhereActivityEconomicNatureDoesNotExistByActivitiesCodesOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(EconomicNature.class, QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING);
	
	/* read where activity revenue economic nature does not exist by activities codes order by code ascending */
	String QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_AND_IDENTIFIER_DOES_START_BY_7_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING = "readWhereActivityEconomicNatureDoesNotExistAndIdentifierDoesStartBy7ByActivitiesCodesOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_AND_IDENTIFIER_DOES_START_BY_7_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(EconomicNature.class, QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_AND_IDENTIFIER_DOES_START_BY_7_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING);
	
	/* read aggregation where lessor has funding by funding sources codes */
	String QUERY_NAME_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_FUNDING_SOURCES_CODES_ORDER_BY_CODE_ASCENDING = "readAggregationByBudgetaryActVersionByFundingSourcesCodesOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_FUNDING_SOURCES_CODES_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(EconomicNature.class, QUERY_NAME_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_FUNDING_SOURCES_CODES_ORDER_BY_CODE_ASCENDING);
	Map<String,Integer> QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_FUNDING_SOURCES_CODES_ORDER_BY_CODE_ASCENDING_TUPLE_FIELDS_NAMES_INDEXES = 
			MapHelper.instantiateStringIntegerByStrings(EconomicNature.FIELD_IDENTIFIER,EconomicNature.FIELD_FUNDING_SOURCE_IDENTIFIER,EconomicNature.FIELD_AMOUNT);
	String QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_FUNDING_SOURCES_CODES_ORDER_BY_CODE_ASCENDING = Language.of(
			Language.Select.of("t.identifier,fundingSource.code,sum(funding.amount)")
			,Language.From.of(""
					+ " EconomicNature t "
					+ " JOIN FundingSourceLessor fundingSourceLessor ON fundingSourceLessor.economicNature = t "
					+ " JOIN Funding funding ON funding.lessor = fundingSourceLessor.lessor"
					+ " JOIN Expenditure expenditure ON expenditure = funding.expenditure"
					+ " JOIN Budget budget ON budget = expenditure.budget"
					+ " JOIN BudgetaryActVersion budgetaryActVersion ON budgetaryActVersion = budget.actVersion AND budgetaryActVersion.code = :"+PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE
					+ " JOIN FundingSource fundingSource ON fundingSource = fundingSourceLessor.fundingSource "
					+ "AND fundingSource = funding.fundingSource AND fundingSource.code = :"+PARAMETER_NAME_FUNDING_SOURCES_CODES
					+ " ")
			,Language.Group.of("t.identifier,fundingSource.code")
			,Language.Order.of("t.identifier ASC")
			);
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_FUNDING_SOURCES_CODES_ORDER_BY_CODE_ASCENDING
				,Query.FIELD_TUPLE_CLASS,EconomicNature.class,Query.FIELD_RESULT_CLASS
				,EconomicNature.class,Query.FIELD_VALUE,QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_FUNDING_SOURCES_CODES_ORDER_BY_CODE_ASCENDING)
				.setTupleFieldsNamesIndexes(QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_FUNDING_SOURCES_CODES_ORDER_BY_CODE_ASCENDING_TUPLE_FIELDS_NAMES_INDEXES));
	}
}
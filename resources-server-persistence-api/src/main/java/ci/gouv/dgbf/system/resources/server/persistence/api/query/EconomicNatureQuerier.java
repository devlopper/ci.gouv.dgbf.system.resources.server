package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;

@Queries(value = {
		@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = EconomicNature.class,name = EconomicNatureQuerier.QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING,value = "SELECT t FROM EconomicNature t ORDER BY t.identifier ASC")
		,@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = EconomicNature.class,name = EconomicNatureQuerier.QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING
		,value = "SELECT t FROM EconomicNature t WHERE NOT EXISTS(SELECT t1.identifier FROM Resource t1 WHERE t1.economicNature = t AND t1.activity.identifier IN :"+EconomicNatureQuerier.PARAMETER_ACTIVITIES_CODES+") ORDER BY t.identifier ASC")
		,@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = EconomicNature.class,name = EconomicNatureQuerier.QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_AND_IDENTIFIER_DOES_START_BY_7_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING
		,value = "SELECT t FROM EconomicNature t WHERE (t.identifier LIKE '1%' OR t.identifier LIKE '7%') AND NOT EXISTS(SELECT t1.identifier FROM Resource t1 WHERE t1.economicNature = t AND t1.activity.identifier IN :"+EconomicNatureQuerier.PARAMETER_ACTIVITIES_CODES+") ORDER BY t.identifier ASC")
})
public interface EconomicNatureQuerier extends Querier {

	/**/
	
	static EconomicNatureQuerier getInstance() {
		return Helper.getInstance(EconomicNatureQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_ACTIVITIES_CODES = "activitiesCodes";
	
	/* read order by code ascending */
	String QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING = "readOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(EconomicNature.class, QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING);
	
	/* read where activity revenue economic nature does not exist by activities codes order by code ascending */
	String QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING = "readWhereActivityEconomicNatureDoesNotExistByActivitiesCodesOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(EconomicNature.class, QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING);
	
	/* read where activity revenue economic nature does not exist by activities codes order by code ascending */
	String QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_AND_IDENTIFIER_DOES_START_BY_7_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING = "readWhereActivityEconomicNatureDoesNotExistAndIdentifierDoesStartBy7ByActivitiesCodesOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_AND_IDENTIFIER_DOES_START_BY_7_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(EconomicNature.class, QUERY_NAME_READ_WHERE_ACTIVITY_REVENUE_ECONOMIC_NATURE_DOES_NOT_EXIST_AND_IDENTIFIER_DOES_START_BY_7_BY_ACTIVITIES_CODES_ORDER_BY_CODE_ASCENDING);
	
	
	static void initialize() {
		
	}
}
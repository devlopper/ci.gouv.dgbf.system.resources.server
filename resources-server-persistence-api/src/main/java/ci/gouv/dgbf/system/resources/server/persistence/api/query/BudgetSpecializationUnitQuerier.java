package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.persistence.query.annotation.Query;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;;

@Queries(value = {
		@Query(tupleClass = BudgetSpecializationUnit.class,name = BudgetSpecializationUnitQuerier.QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING,value = "SELECT t FROM BudgetSpecializationUnit t ORDER BY t.code ASC")
})
public interface BudgetSpecializationUnitQuerier extends Querier {

	/**/
	
	static BudgetSpecializationUnitQuerier getInstance() {
		return Helper.getInstance(BudgetSpecializationUnitQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING = "readOrderByCodeAscending";
	
	String QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnit.class, QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING);
}
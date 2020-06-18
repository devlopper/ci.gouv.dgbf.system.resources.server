package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSource;

@Queries(value = {
		@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = FundingSource.class,name = FundingSourceQuerier.QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING
				,value = "SELECT t FROM FundingSource t ORDER BY t.code ASC")
		,@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = FundingSource.class,name = FundingSourceQuerier.QUERY_NAME_READ_BY_CODES_ORDER_BY_CODE_ASCENDING
				,value = "SELECT t FROM FundingSource t WHERE t.code IN :"+FundingSourceQuerier.PARAMETER_CODES+" ORDER BY t.code ASC")
})
public interface FundingSourceQuerier extends Querier {

	/**/
	
	static FundingSourceQuerier getInstance() {
		return Helper.getInstance(FundingSourceQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_CODES = "codes";
	
	/* read order by code ascending */
	String QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING = "readOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(FundingSource.class, QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING);
	Collection<FundingSource> readOrderByCodeAscending();
	
	/* read by codes order by code ascending */
	String QUERY_NAME_READ_BY_CODES_ORDER_BY_CODE_ASCENDING = "readByCodesOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_BY_CODES_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(FundingSource.class, QUERY_NAME_READ_BY_CODES_ORDER_BY_CODE_ASCENDING);
	
	static void initialize() {
		
	}
	
	/**/
	
	public static abstract class AbstractImpl extends AbstractObject implements FundingSourceQuerier,Serializable {
		
		@Override
		public Collection<FundingSource> readOrderByCodeAscending() {
			return EntityReader.getInstance().readMany(FundingSource.class, QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING);
		}
	}
}
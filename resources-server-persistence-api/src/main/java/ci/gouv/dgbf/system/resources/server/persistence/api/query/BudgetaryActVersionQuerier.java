package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import java.io.Serializable;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryActVersion;

public interface BudgetaryActVersionQuerier extends Querier {

	/**/
	
	public static abstract class AbstractImpl extends AbstractObject implements BudgetaryActVersionQuerier,Serializable {
		
	}
	
	/**/
	
	static BudgetaryActVersionQuerier getInstance() {
		return Helper.getInstance(BudgetaryActVersionQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String QUERY_NAME_READ_ALL_01 = "read.all.01";
	String QUERY_IDENTIFIER_READ_ALL_01 = QueryIdentifierBuilder.getInstance().build(BudgetaryActVersion.class, QUERY_NAME_READ_ALL_01);
	
	String QUERY_VALUE_READ_ALL_01 = 
			"SELECT t"
			+" FROM BudgetaryActVersion t ";
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_ALL_01
				,Query.FIELD_TUPLE_CLASS,BudgetaryActVersion.class,Query.FIELD_RESULT_CLASS,BudgetaryActVersion.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_ALL_01
				)
			);
	}
}
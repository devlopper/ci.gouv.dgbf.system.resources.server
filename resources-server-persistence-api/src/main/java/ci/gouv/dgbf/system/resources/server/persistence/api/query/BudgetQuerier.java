package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import java.io.Serializable;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutorArguments;
import org.cyk.utility.__kernel__.persistence.query.QueryGetter;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Budget;

public interface BudgetQuerier extends Querier {

	Budget readBySpecializationUnitCodeByActVersionCode(String specializationUnitCode,String actVersionCode);
	
	/**/
	
	public static abstract class AbstractImpl extends AbstractObject implements BudgetQuerier,Serializable {
		
		public Budget readBySpecializationUnitCodeByActVersionCode(String specializationUnitCode,String actVersionCode) {
			return QueryExecutor.getInstance().executeReadOne(Budget.class, new QueryExecutorArguments().setQuery(QueryGetter.getInstance().get(QUERY_IDENTIFIER_READ_BY_SPECIALIZATION_UNIT_CODE_BY_ACT_VERSION_CODE))
					.addFilterField(PARAMETER_NAME_SPECIALIZATION_UNIT_CODE, specializationUnitCode).addFilterField(PARAMETER_NAME_ACT_VERSION_CODE, actVersionCode));
		}
		
	}
	
	/**/
	
	static BudgetQuerier getInstance() {
		return Helper.getInstance(BudgetQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_NAME_SPECIALIZATION_UNIT_CODE = "specializationUnitCode";
	String PARAMETER_NAME_ACT_VERSION_CODE = "actVersionCode";
	
	String QUERY_NAME_READ_BY_SPECIALIZATION_UNIT_CODE_BY_ACT_VERSION_CODE = "readBySpecializationUnitCodeByActVersionCode";
	String QUERY_IDENTIFIER_READ_BY_SPECIALIZATION_UNIT_CODE_BY_ACT_VERSION_CODE = QueryIdentifierBuilder.getInstance().build(Budget.class, QUERY_NAME_READ_BY_SPECIALIZATION_UNIT_CODE_BY_ACT_VERSION_CODE);
	
	String QUERY_VALUE_READ_BY_SPECIALIZATION_UNIT_CODE_BY_ACT_VERSION_CODE = 
			"SELECT t"
			+" FROM Budget t "
			+ " WHERE t.specializationUnit.code = :"+PARAMETER_NAME_SPECIALIZATION_UNIT_CODE
			+ " AND t.actVersion.code = :"+PARAMETER_NAME_ACT_VERSION_CODE;
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_BY_SPECIALIZATION_UNIT_CODE_BY_ACT_VERSION_CODE
				,Query.FIELD_TUPLE_CLASS,Budget.class,Query.FIELD_RESULT_CLASS,Budget.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_BY_SPECIALIZATION_UNIT_CODE_BY_ACT_VERSION_CODE
				)
			);
	}
}
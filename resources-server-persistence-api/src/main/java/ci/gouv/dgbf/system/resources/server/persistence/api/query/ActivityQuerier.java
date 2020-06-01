package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryArgumentHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutorArguments;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.QueryValueBuilder;
import org.cyk.utility.__kernel__.persistence.query.filter.Filter;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;

public interface ActivityQuerier extends Querier {

	Collection<Activity> readMany(QueryExecutorArguments arguments);
	Long count(QueryExecutorArguments arguments);
	
	/**/
	
	public static abstract class AbstractImpl extends AbstractObject implements ActivityQuerier,Serializable {
		@Override
		public Collection<Activity> readMany(QueryExecutorArguments arguments) {
			if(QUERY_IDENTIFIER_READ_WHERE_CODE_LIKE_AND_NAME_LIKE.equals(arguments.getQuery().getIdentifier()))
				prepare(arguments);	
			return QueryExecutor.getInstance().executeReadMany(Activity.class, arguments);
		}
		
		@Override
		public Long count(QueryExecutorArguments arguments) {
			if(QUERY_IDENTIFIER_COUNT_WHERE_CODE_LIKE_AND_NAME_LIKE.equals(arguments.getQuery().getIdentifier()))
				prepare(arguments);
			return QueryExecutor.getInstance().executeCount(arguments);
		}
		
		private static void prepare(QueryExecutorArguments arguments) {
			Filter filter = new Filter();
			filter.addField(PARAMETER_NAME_CODE, QueryArgumentHelper.getLike(arguments.getFilterFieldValue(PARAMETER_NAME_CODE)));
			filter.addField(PARAMETER_NAME_NAME, QueryArgumentHelper.getLike(arguments.getFilterFieldValue(PARAMETER_NAME_NAME)));
			arguments.setFilter(filter);
		}
	}
	
	/**/
	
	static ActivityQuerier getInstance() {
		return Helper.getInstance(ActivityQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String QUERY_NAME_READ_WHERE_CODE_LIKE_AND_NAME_LIKE = "readWhereCodeLikeAndNameLike";
	String QUERY_NAME_COUNT_WHERE_CODE_LIKE_AND_NAME_LIKE = "countWhereCodeLikeAndNameLike";
	
	String PARAMETER_NAME_CODE = "code";
	String PARAMETER_NAME_NAME = "name";
	
	String QUERY_IDENTIFIER_READ_WHERE_CODE_LIKE_AND_NAME_LIKE = QueryIdentifierBuilder.getInstance().build(Activity.class, QUERY_NAME_READ_WHERE_CODE_LIKE_AND_NAME_LIKE);
	String QUERY_IDENTIFIER_COUNT_WHERE_CODE_LIKE_AND_NAME_LIKE = QueryIdentifierBuilder.getInstance().build(Activity.class, QUERY_NAME_COUNT_WHERE_CODE_LIKE_AND_NAME_LIKE);
	
	String QUERY_VALUE_READ_WHERE_CODE_LIKE_AND_NAME_LIKE_WHERE = " WHERE "+QueryValueBuilder.deriveLike("t", "code","code",null,null,Boolean.TRUE)+" OR "
			+QueryValueBuilder.deriveLike("t", "name","name",null,null);
	String QUERY_VALUE_READ_WHERE_CODE_LIKE_AND_NAME_LIKE = 
			"SELECT t.identifier,t.code,t.name"
			+" FROM Activity t "
			+ QUERY_VALUE_READ_WHERE_CODE_LIKE_AND_NAME_LIKE_WHERE
			+" ORDER BY t.code ASC";
	
	String QUERY_VALUE_COUNT_WHERE_CODE_LIKE_AND_NAME_LIKE = 
			"SELECT COUNT(t.identifier)"
			+" FROM Activity t "
			+ QUERY_VALUE_READ_WHERE_CODE_LIKE_AND_NAME_LIKE_WHERE;
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_WHERE_CODE_LIKE_AND_NAME_LIKE
				,Query.FIELD_TUPLE_CLASS,Activity.class,Query.FIELD_RESULT_CLASS,Activity.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_WHERE_CODE_LIKE_AND_NAME_LIKE
				)
				//.setTupleFieldsNamesIndexes(activityFields)
			);
	}
}
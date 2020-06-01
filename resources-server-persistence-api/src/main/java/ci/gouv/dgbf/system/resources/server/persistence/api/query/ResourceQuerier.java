package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.map.MapHelper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutor;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutorArguments;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.QueryStringHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryValueBuilder;
import org.cyk.utility.__kernel__.persistence.query.filter.Filter;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Amounts;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;

public interface ResourceQuerier extends Querier {

	Collection<Resource> readMany(QueryExecutorArguments arguments);
	Long count(QueryExecutorArguments arguments);
	
	/**/
	
	public static abstract class AbstractImpl extends AbstractObject implements ResourceQuerier,Serializable {
		@Override
		public Collection<Resource> readMany(QueryExecutorArguments arguments) {
			if(arguments != null && arguments.getQuery() != null && QUERY_IDENTIFIER_READ_VIEW_01.equals(arguments.getQuery().getIdentifier()))
				prepare(arguments);	
			return QueryExecutor.getInstance().executeReadMany(Resource.class, arguments);
		}
		
		@Override
		public Long count(QueryExecutorArguments arguments) {
			if(arguments != null && arguments.getQuery() != null && QUERY_IDENTIFIER_COUNT_VIEW_01.equals(arguments.getQuery().getIdentifier()))
				prepare(arguments);
			return QueryExecutor.getInstance().executeCount(arguments);
		}
		
		private static void prepare(QueryExecutorArguments arguments) {
			Filter filter = new Filter();
			filter.addFieldsTransformedToLike(arguments.getFilter(), Resource.FIELD_ACTIVITY,Activity.FIELD_BUDGET_SPECIALIZATION_UNIT,BudgetSpecializationUnit.FIELD_SECTION
					,Resource.FIELD_ECONOMIC_NATURE);	
			arguments.setFilter(filter);
		}
	}
	
	static Map<String,Integer> deriveSumsTupleFieldsNamesIndexes(Collection<String> fieldsNames) {
		if(fieldsNames == null)
			fieldsNames = new ArrayList<>();
		fieldsNames.addAll(deriveSumsTupleFieldsNames());
		return MapHelper.instantiateStringIntegerByStrings(fieldsNames);
	}
	
	static Collection<String> deriveSumsTupleFieldsNames() {
		String prefix = Resource.FIELD_AMOUNTS+".";
		return List.of(prefix+Amounts.FIELD_INITIAL);
	}
	
	static Map<String,Integer> deriveSumsTupleFieldsNamesIndexes(String...fieldsNames) {
		return deriveSumsTupleFieldsNamesIndexes(fieldsNames == null ? null : CollectionHelper.listOf(fieldsNames));
	}

	static String deriveSums(String tupleName) {
		tupleName = tupleName + "." +Resource.FIELD_AMOUNTS;
		return QueryValueBuilder.deriveSum(tupleName, Amounts.FIELD_INITIAL);
	}
	
	static String deriveColumns(String tupleName) {
		tupleName = tupleName + "." +Resource.FIELD_AMOUNTS;
		return QueryValueBuilder.deriveCaseZeroIfNull(tupleName,Amounts.FIELD_INITIAL)
				;
	}
	
	/**/
	/* View 01 */
	String QUERY_NAME_READ_VIEW_01 = "read.view.01";
	String QUERY_IDENTIFIER_READ_VIEW_01 = QueryIdentifierBuilder.getInstance().build(Resource.class, QUERY_NAME_READ_VIEW_01);
	Map<String,Integer> QUERY_VALUE_READ_VIEW_01_TUPLE_FIELDS_NAMES_INDEXES = deriveSumsTupleFieldsNamesIndexes(Resource.FIELD_IDENTIFIER
			,Resource.FIELD_SECTION_AS_STRING,Resource.FIELD_BUDGET_SPECIALIZATION_UNIT_AS_STRING,Resource.FIELD_ACTIVITY_AS_STRING
			,Resource.FIELD_ECONOMIC_NATURE_AS_STRING);
	String QUERY_VALUE_READ_VIEW_01_SELECT_FROM = "SELECT t.identifier,"
			+QueryValueBuilder.deriveConcatsCodeAndNameFromTuplesNames(BudgetSpecializationUnit.FIELD_SECTION,Activity.FIELD_BUDGET_SPECIALIZATION_UNIT,Resource.FIELD_ACTIVITY,Resource.FIELD_ECONOMIC_NATURE)
			+","+deriveColumns("t")
			+ " FROM Resource t "
			+QueryValueBuilder.deriveLeftJoinsFromFieldsNames("t"
					, Resource.FIELD_ACTIVITY
					,Resource.FIELD_ACTIVITY+"."+Activity.FIELD_BUDGET_SPECIALIZATION_UNIT
					,Resource.FIELD_ACTIVITY+"."+Activity.FIELD_BUDGET_SPECIALIZATION_UNIT+"."+BudgetSpecializationUnit.FIELD_SECTION
					,Resource.FIELD_ECONOMIC_NATURE
				);
	String QUERY_VALUE_READ_VIEW_01_WHERE = " WHERE "
			+ "     ("+QueryStringHelper.formatTupleFieldLike("t", "activity.identifier","activity") + " OR " + QueryStringHelper.formatTupleFieldLike("t", "activity.name","activity")+")"
			+ " AND ("+QueryStringHelper.formatTupleFieldLike("t", "activity.budgetSpecializationUnit.code","budgetSpecializationUnit") + " OR " + QueryStringHelper.formatTupleFieldLike("t", "activity.budgetSpecializationUnit.name","budgetSpecializationUnit")+")"
			+ " AND ("+QueryStringHelper.formatTupleFieldLike("t", "activity.budgetSpecializationUnit.section.code","section") + " OR " + QueryStringHelper.formatTupleFieldLike("t", "activity.budgetSpecializationUnit.section.name","section")+")"
			+ " AND ("+QueryStringHelper.formatTupleFieldLike("t", "economicNature.identifier","economicNature") + " OR " + QueryStringHelper.formatTupleFieldLike("t", "economicNature.name","economicNature")+")"
			;
	String QUERY_VALUE_READ_VIEW_01 = QUERY_VALUE_READ_VIEW_01_SELECT_FROM+QUERY_VALUE_READ_VIEW_01_WHERE	+ " ORDER BY t.activity.identifier ASC,t.economicNature.identifier ASC";	
	
	String QUERY_NAME_COUNT_VIEW_01 = "count.view.01";
	String QUERY_IDENTIFIER_COUNT_VIEW_01 = QueryIdentifierBuilder.getInstance().build(Resource.class, QUERY_NAME_COUNT_VIEW_01);
	String QUERY_VALUE_COUNT_VIEW_01 = "SELECT COUNT(t.identifier) FROM Resource t "+ QUERY_VALUE_READ_VIEW_01_WHERE;
	
	/* All 01 */
	String QUERY_NAME_READ_ALL_01 = "read.all.01";
	String QUERY_IDENTIFIER_READ_ALL_01 = QueryIdentifierBuilder.getInstance().build(Resource.class, QUERY_NAME_READ_ALL_01);
	Map<String,Integer> QUERY_VALUE_READ_ALL_01_TUPLE_FIELDS_NAMES_INDEXES = deriveSumsTupleFieldsNamesIndexes(Resource.FIELD_IDENTIFIER
			,Resource.FIELD_SECTION_AS_STRING,Resource.FIELD_BUDGET_SPECIALIZATION_UNIT_AS_STRING,Resource.FIELD_ACTIVITY_AS_STRING
			,Resource.FIELD_ECONOMIC_NATURE_AS_STRING);
	String QUERY_VALUE_READ_ALL_01_SELECT_FROM = "SELECT t.identifier,"
			+QueryValueBuilder.deriveConcatsCodeAndNameFromTuplesNames(BudgetSpecializationUnit.FIELD_SECTION,Activity.FIELD_BUDGET_SPECIALIZATION_UNIT,Resource.FIELD_ACTIVITY,Resource.FIELD_ECONOMIC_NATURE)
			+","+deriveColumns("t")
			+ " FROM Resource t "
			+QueryValueBuilder.deriveLeftJoinsFromFieldsNames("t"
					, Resource.FIELD_ACTIVITY
					,Resource.FIELD_ACTIVITY+"."+Activity.FIELD_BUDGET_SPECIALIZATION_UNIT
					,Resource.FIELD_ACTIVITY+"."+Activity.FIELD_BUDGET_SPECIALIZATION_UNIT+"."+BudgetSpecializationUnit.FIELD_SECTION
					,Resource.FIELD_ECONOMIC_NATURE
				);
	String QUERY_VALUE_READ_ALL_01 = QUERY_VALUE_READ_ALL_01_SELECT_FROM+ " ORDER BY t.activity.code ASC,t.economicNature.code ASC";	
	
	/**/
	
	static ResourceQuerier getInstance() {
		return Helper.getInstance(ResourceQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	/**/
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_VIEW_01,Query.FIELD_TUPLE_CLASS,Resource.class,Query.FIELD_RESULT_CLASS
				,Resource.class,Query.FIELD_VALUE,QUERY_VALUE_READ_VIEW_01).setTupleFieldsNamesIndexes(QUERY_VALUE_READ_VIEW_01_TUPLE_FIELDS_NAMES_INDEXES));
		QueryHelper.addQueries(Query.buildCount(Resource.class,QUERY_NAME_COUNT_VIEW_01,QUERY_VALUE_COUNT_VIEW_01));
	}
}
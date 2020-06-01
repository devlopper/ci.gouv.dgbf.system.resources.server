package ci.gouv.dgbf.system.resources.server.persistence.api;

import java.io.Serializable;

import org.cyk.utility.__kernel__.persistence.query.EntityCounter;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutorArguments;

import ci.gouv.dgbf.system.resources.server.persistence.api.query.ActivityQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.ResourceQuerier;

@ci.gouv.dgbf.system.resources.server.annotation.System
public class EntityCounterImpl extends EntityCounter.AbstractImpl implements Serializable {

	@Override
	public <T> Long count(Class<T> tupleClass, QueryExecutorArguments arguments) {
		if(arguments != null && arguments.getQuery() != null) {
			if(ResourceQuerier.QUERY_IDENTIFIER_COUNT_VIEW_01.equals(arguments.getQuery().getIdentifier()))
				return ResourceQuerier.getInstance().count(arguments);
			if(ActivityQuerier.QUERY_IDENTIFIER_COUNT_WHERE_CODE_LIKE_AND_NAME_LIKE.equals(arguments.getQuery().getIdentifier()))
				return ActivityQuerier.getInstance().count(arguments);
		}
		return super.count(tupleClass, arguments);
	}
}
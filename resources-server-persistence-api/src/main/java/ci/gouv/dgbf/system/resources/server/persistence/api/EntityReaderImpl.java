package ci.gouv.dgbf.system.resources.server.persistence.api;

import java.io.Serializable;
import java.util.Collection;

import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutorArguments;

import ci.gouv.dgbf.system.resources.server.persistence.api.query.ActivityQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.ResourceQuerier;

@ci.gouv.dgbf.system.resources.server.annotation.System
public class EntityReaderImpl extends EntityReader.AbstractImpl implements Serializable {

	@SuppressWarnings("unchecked")
	@Override
	public <T> Collection<T> readMany(Class<T> resultClass, QueryExecutorArguments arguments) {
		if(arguments != null && arguments.getQuery() != null) {
			if(ResourceQuerier.QUERY_IDENTIFIER_READ_VIEW_01.equals(arguments.getQuery().getIdentifier()))
				return (Collection<T>) ResourceQuerier.getInstance().readMany(arguments);
			if(ActivityQuerier.QUERY_IDENTIFIER_READ_WHERE_CODE_LIKE_AND_NAME_LIKE.equals(arguments.getQuery().getIdentifier()))
				return (Collection<T>) ActivityQuerier.getInstance().readMany(arguments);				
		}
		return super.readMany(resultClass, arguments);
	}	
}
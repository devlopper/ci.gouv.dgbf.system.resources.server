package ci.gouv.dgbf.system.resources.server.persistence.api;

import java.io.Serializable;

import org.cyk.utility.__kernel__.persistence.query.QueryResultMapper;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Amountable;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Amounts;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;

@ci.gouv.dgbf.system.resources.server.annotation.System
public class QueryResultMapperImpl extends QueryResultMapper.AbstractImpl implements Serializable {

	@Override
	protected <T> void write(T instance, String fieldName, Object value) {
		if(instance instanceof Amountable) {
			Amountable amountable = (Amountable) instance;
			if(fieldName.equals(Resource.FIELD_AMOUNTS+"."+Amounts.FIELD_INITIAL)) {
				amountable.getAmounts(Boolean.TRUE).setInitial((Long) value);
				return;
			}
			if(fieldName.contains("."+Resource.FIELD_AMOUNTS) && amountable.getAmounts() == null)
				amountable.setAmounts(new Amounts());
		}
		super.write(instance, fieldName, value);
	}
}
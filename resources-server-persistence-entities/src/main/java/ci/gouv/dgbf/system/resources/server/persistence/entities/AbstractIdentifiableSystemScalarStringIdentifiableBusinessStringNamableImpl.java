package ci.gouv.dgbf.system.resources.server.persistence.entities;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@MappedSuperclass @Getter @Setter @Accessors(chain=true)
public abstract class AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl extends org.cyk.utility.__kernel__.object.__static__.persistence.AbstractIdentifiableSystemScalarStringIdentifiableBusinessStringNamableImpl {

	@Override
	public String toString() {
		return code+" "+name;
	}
}
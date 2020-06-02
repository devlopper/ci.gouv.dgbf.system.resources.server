package ci.gouv.dgbf.system.resources.server.business.api;

import java.util.Collection;

import javax.transaction.Transactional;

import org.cyk.utility.__kernel__.number.NumberHelper;
import org.cyk.utility.server.business.BusinessEntity;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;

public interface ResourceBusiness extends BusinessEntity<Resource> {

	@Transactional
	void saveInitials(Collection<Resource> resources);
	
	/* rules */
	
	static Boolean isInitialValid(Long initial) {
		if(initial == null)
			return Boolean.TRUE;
		return NumberHelper.isGreaterThanOrEqualZero(initial);
	}
	
	static void validateInitial(Long initial) {
		if(Boolean.TRUE.equals(isInitialValid(initial)))
			return;
		throw new RuntimeException("Incorrect");
	}
	
	String SAVE_INITIALS = "Resource.saveInitials";
}

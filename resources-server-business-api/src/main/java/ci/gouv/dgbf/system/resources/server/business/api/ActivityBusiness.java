package ci.gouv.dgbf.system.resources.server.business.api;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;

import java.util.Collection;

import javax.transaction.Transactional;

import org.cyk.utility.server.business.BusinessEntity;

public interface ActivityBusiness extends BusinessEntity<Activity> {

	@Transactional
	void saveInitialsFromComputation(Collection<Activity> activities);
	
	static Boolean isComputable(String code) {
		if(Activity.CODE_RECETTES_EXTERIEURES.equals(code))
			return Boolean.TRUE;
		return Boolean.FALSE;
	}
	
	static void validateComputable(String code) {
		if(Boolean.TRUE.equals(isComputable(code)))
			return;
		throw new RuntimeException("Les lignes de recettes de l'activité "+code+" ne peuvent pas être deduit par calcul.");
	}
	
	static void validateComputationImplemented(String code) {
		if(Boolean.TRUE.equals(isComputable(code)))
			return;
		throw new RuntimeException("Le calcul des lignes de recettes de l'activité "+code+" n'est pas encore implémenté.");
	}
	
	/**/
	String SAVE_INITIALS_FROM_COMPUTATION = "Activity.saveInitialsFromComputation";
}
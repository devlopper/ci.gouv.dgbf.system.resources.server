package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import ci.gouv.dgbf.system.resources.server.business.api.ActivityBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.ActivityPersistence;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.BudgetQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.EconomicNatureQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.ResourceByActivityQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;
import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSource;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.persistence.EntitySaver;
import org.cyk.utility.__kernel__.persistence.EntitySaver.Arguments;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.string.StringHelper;
import org.cyk.utility.__kernel__.throwable.ThrowablesMessages;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;

@ApplicationScoped
public class ActivityBusinessImpl extends AbstractBusinessEntityImpl<Activity, ActivityPersistence> implements ActivityBusiness,Serializable {
	private static final long serialVersionUID = 1L;

	@Override @Transactional
	public void saveInitialsFromComputation(Collection<Activity> activities) {
		if(CollectionHelper.isEmpty(activities))
			return;
		ThrowablesMessages throwablesMessages = new ThrowablesMessages();
		for(Activity activity : activities) {
			try {
				ActivityBusiness.validateComputable(activity.getCode());
				ActivityBusiness.validateComputationImplemented(activity.getCode());
			} catch (Exception exception) {
				throwablesMessages.add(exception.getMessage());
			}	
		}
		throwablesMessages.throwIfNotEmpty();
		
		Collection<Resource> resources = null;
		Collection<Resource> creatablesResources = null;
		Collection<Resource> updatablesResources = null;
		for(Activity activity : activities) {
			if(Activity.CODE_RECETTES_EXTERIEURES.equals(activity.getCode())) {
				if(activity.getBudgetaryActVersion() == null)
					throw new RuntimeException("La version ne doit pas être nulle");
				Collection<Resource> __resources__ = computeRecettesExterieures(activity);
				if(CollectionHelper.isEmpty(__resources__))
					continue;
				if(resources == null)
					resources = new ArrayList<>();
				resources.addAll(__resources__);
			}else
				throw new RuntimeException("!!! On ne devrait pas être dans ce cas. Cette activité ne peut pas être traitée. !!!");
		}
		
		if(CollectionHelper.isEmpty(resources))
			return;
		for(Resource resource : resources)
			if(StringHelper.isBlank(resource.getIdentifier())) {
				if(creatablesResources == null)
					creatablesResources = new ArrayList<>();
				creatablesResources.add(resource);
			}else {
				if(updatablesResources == null)
					updatablesResources = new ArrayList<>();
				updatablesResources.add(resource);
			}		
		EntitySaver.getInstance().save(Resource.class, new Arguments<Resource>().setCreatables(creatablesResources).setUpdatables(updatablesResources));	
	}
	
	private Collection<Resource> computeRecettesExterieures(Activity activity) {
		Collection<EconomicNature> economicNatures = EntityReader.getInstance().readMany(EconomicNature.class
				, EconomicNatureQuerier.QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_FUNDING_SOURCES_CODES_ORDER_BY_CODE_ASCENDING
				, ResourceByActivityQuerier.PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,activity.getBudgetaryActVersion().getCode()
				, EconomicNatureQuerier.PARAMETER_NAME_FUNDING_SOURCES_CODES,CollectionHelper.listOf(FundingSource.CODE_DON)
				);
		if(CollectionHelper.isEmpty(economicNatures))
			return null;
		Collection<Resource> resources = EntityReader.getInstance().readMany(Resource.class
				, ResourceByActivityQuerier.QUERY_IDENTIFIER_READ_BY_ACTIVITY_CODE_BY_BUDGETARY_ACT_VERSION_CODE___INTERNAL
				, ResourceByActivityQuerier.PARAMETER_NAME_ACTIVITY_CODE,CollectionHelper.listOf(activity.getCode())
				, ResourceByActivityQuerier.PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,activity.getBudgetaryActVersion().getCode()
				);		
		if(resources == null)
			resources = new ArrayList<>();
		for(EconomicNature economicNature : economicNatures) {
			//find resource
			Resource resource = null;
			for(Resource index : resources) {
				if(index.getEconomicNature().equals(economicNature)) {
					resource = index;
					break;
				}
			}
			if(resource == null) {
				//create new resource
				resource = new Resource()
						.setActivity(activity)
						.setEconomicNature(economicNature)
						.setBudget(BudgetQuerier.getInstance().readBySpecializationUnitCodeByActVersionCode(activity.getBudgetSpecializationUnit().getCode()
								, activity.getBudgetaryActVersion().getCode()));
				resource.getAmounts(Boolean.TRUE).setInitial(economicNature.getAmount());
				resources.add(resource);
			}else {
				//update amount
				resource.getAmounts(Boolean.TRUE).setInitial(economicNature.getAmount());
			}
		}		
		return resources;
	}
}
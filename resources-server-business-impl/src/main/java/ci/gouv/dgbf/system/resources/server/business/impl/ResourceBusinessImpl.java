package ci.gouv.dgbf.system.resources.server.business.impl;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.persistence.EntitySaver;
import org.cyk.utility.__kernel__.persistence.EntitySaver.Arguments;
import org.cyk.utility.__kernel__.properties.Properties;
import org.cyk.utility.__kernel__.throwable.ThrowablesMessages;
import org.cyk.utility.server.business.AbstractBusinessEntityImpl;
import org.cyk.utility.server.business.BusinessFunctionCreator;

import ci.gouv.dgbf.system.resources.server.business.api.ResourceBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.api.ResourcePersistence;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.BudgetQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;

@ApplicationScoped
public class ResourceBusinessImpl extends AbstractBusinessEntityImpl<Resource, ResourcePersistence> implements ResourceBusiness,Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	protected void __listenExecuteCreateBefore__(Resource resource, Properties properties,BusinessFunctionCreator function) {
		super.__listenExecuteCreateBefore__(resource, properties, function);
		if(resource.getBudget() == null && resource.getBudgetSpecializationUnit() != null && resource.getBudgetaryActVersion() != null) {
			resource.setBudget(BudgetQuerier.getInstance().readBySpecializationUnitCodeByActVersionCode(resource.getBudgetSpecializationUnit().getCode()
					, resource.getBudgetaryActVersion().getCode()));
		}
		//resource.setCreationDate(LocalDateTime.now());
	}			
	
	@Override @Transactional
	public void saveInitials(Collection<Resource> resources) {
		if(CollectionHelper.isEmpty(resources))
			return;
		ThrowablesMessages throwablesMessages = new ThrowablesMessages();
		for(Resource resource : resources) {
			try {
				ResourceBusiness.validateInitial(resource.getAmounts() == null ? null : resource.getAmounts().getInitial());
			} catch (Exception exception) {
				throwablesMessages.add(resource.getActivity().getIdentifier()+"-"+resource.getEconomicNature().getIdentifier()+" : "+exception.getMessage());
			}	
		}
		throwablesMessages.throwIfNotEmpty();
		EntitySaver.getInstance().save(Resource.class, new Arguments<Resource>().setUpdatables(resources));	
	}
}
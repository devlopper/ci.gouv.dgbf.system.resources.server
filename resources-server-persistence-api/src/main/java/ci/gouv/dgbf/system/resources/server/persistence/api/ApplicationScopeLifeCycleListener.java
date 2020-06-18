package ci.gouv.dgbf.system.resources.server.persistence.api;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.persistence.query.EntityCounter;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryResultMapper;

import ci.gouv.dgbf.system.resources.server.persistence.api.query.ActivityByBudgetSpecializationUnitQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.BudgetQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.BudgetSpecializationUnitBySectionQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.BudgetSpecializationUnitCategoryQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.BudgetaryActVersionQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.EconomicNatureQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.FundingSourceQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.LessorQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.ResourceByActivityQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.ResourceQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.SectionQuerier;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		__inject__(ci.gouv.dgbf.system.resources.server.persistence.entities.ApplicationScopeLifeCycleListener.class).initialize(null);
	}
	
	@Override
	public void __destroy__(Object object) {}	

	public static void initialize() {
		ci.gouv.dgbf.system.resources.server.persistence.entities.ApplicationScopeLifeCycleListener.initialize();
		DependencyInjection.setQualifierClassTo(ci.gouv.dgbf.system.resources.server.annotation.System.class,QueryResultMapper.class, EntityReader.class,EntityCounter.class);
		
		SectionQuerier.initialize();
		BudgetaryActVersionQuerier.initialize();
		BudgetSpecializationUnitCategoryQuerier.initialize();
		BudgetSpecializationUnitBySectionQuerier.initialize();
		BudgetQuerier.initialize();
		EconomicNatureQuerier.initialize();
		
		ActivityByBudgetSpecializationUnitQuerier.initialize();
		ResourceQuerier.initialize();		
		ResourceByActivityQuerier.initialize();
		
		LessorQuerier.initialize();	
		FundingSourceQuerier.initialize();	
		
		QueryHelper.scan(List.of(ResourceQuerier.class.getPackage()));	
	}
}
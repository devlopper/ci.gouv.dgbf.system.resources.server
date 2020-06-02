package ci.gouv.dgbf.system.resources.server.persistence.api;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.AbstractApplicationScopeLifeCycleListener;
import org.cyk.utility.__kernel__.DependencyInjection;
import org.cyk.utility.__kernel__.klass.PersistableClassesGetter;
import org.cyk.utility.__kernel__.persistence.query.EntityCounter;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryResultMapper;

import ci.gouv.dgbf.system.resources.server.persistence.api.query.ActivityByBudgetSpecializationUnitQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.BudgetQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.BudgetSpecializationUnitCategoryQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.BudgetaryActVersionQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.EconomicNatureQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.ResourceByActivityQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.ResourceQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.SectionQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Budget;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitCategory;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitType;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryAct;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryActVersion;
import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListener implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __initialize__(Object object) {
		
	}
	
	@Override
	public void __destroy__(Object object) {}	

	public static void initialize() {
		DependencyInjection.setQualifierClassTo(ci.gouv.dgbf.system.resources.server.annotation.System.class,QueryResultMapper.class, EntityReader.class,EntityCounter.class);
		PersistableClassesGetter.COLLECTION.set(List.of(Resource.class,Activity.class,Budget.class,EconomicNature.class,BudgetSpecializationUnit.class
				,BudgetSpecializationUnitCategory.class,BudgetSpecializationUnitType.class,Section.class,BudgetaryActVersion.class,BudgetaryAct.class));
		
		SectionQuerier.initialize();
		BudgetaryActVersionQuerier.initialize();
		BudgetSpecializationUnitCategoryQuerier.initialize();
		BudgetQuerier.initialize();
		EconomicNatureQuerier.initialize();
		
		ActivityByBudgetSpecializationUnitQuerier.initialize();
		ResourceQuerier.initialize();		
		ResourceByActivityQuerier.initialize();
		
		QueryHelper.scan(List.of(ResourceQuerier.class.getPackage()));	
	}
}
package ci.gouv.dgbf.system.resources.server.persistence.entities;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.cyk.utility.__kernel__.klass.PersistableClassesGetter;
import org.cyk.utility.server.persistence.AbstractApplicationScopeLifeCycleListenerEntities;

@ApplicationScoped
public class ApplicationScopeLifeCycleListener extends AbstractApplicationScopeLifeCycleListenerEntities implements Serializable {
	private static final long serialVersionUID = 1L;

	@Override
	public void __destroy__(Object object) {}
	
	/**/
	
	public static void initialize() {
		PersistableClassesGetter.COLLECTION.set(List.of(Expenditure.class,Resource.class,Activity.class,Budget.class,EconomicNature.class,BudgetSpecializationUnit.class
				,BudgetSpecializationUnitCategory.class,BudgetSpecializationUnitType.class,Section.class,BudgetaryActVersion.class,BudgetaryAct.class
				,Funding.class,FundingSourceLessor.class,FundingSource.class,Lessor.class));	
	}
}
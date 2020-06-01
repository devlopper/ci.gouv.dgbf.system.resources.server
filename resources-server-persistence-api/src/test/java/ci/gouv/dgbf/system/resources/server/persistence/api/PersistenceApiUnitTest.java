package ci.gouv.dgbf.system.resources.server.persistence.api;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collection;

import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.persistence.query.EntityCreator;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.test.weld.AbstractPersistenceUnitTest;
import org.cyk.utility.__kernel__.variable.VariableHelper;
import org.cyk.utility.__kernel__.variable.VariableName;
import org.junit.jupiter.api.Test;

import ci.gouv.dgbf.system.resources.server.persistence.api.query.ResourceQuerier;
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

public class PersistenceApiUnitTest extends AbstractPersistenceUnitTest {
	private static final long serialVersionUID = 1L;

	@Override
	protected String getPersistenceUnitName() {
		return "default";
	}
	
	@Test
	public void resource_readAmountsAreNotNull(){
		Collection<Resource> resources = EntityReader.getInstance().readMany(Resource.class, ResourceQuerier.QUERY_IDENTIFIER_READ_ALL_01);
		if(CollectionHelper.isEmpty(resources))
			return;
		resources.forEach(resource -> {
			assertThat(resource.getAmounts()).as("amounts are not null").isNotNull();
			assertThat(resource.getAmounts().getInitial()).as("intial is not null").isNotNull();
		});
	}
	
	@Test
	public void section_readAggregationOrderByCodeAscending(){
		
	}
	
	@Override
	protected void initializeEntityManagerFactory(String persistenceUnitName) {
		super.initializeEntityManagerFactory(persistenceUnitName);
		ApplicationScopeLifeCycleListener.initialize();
		ApplicationScopeLifeCycleListener.initialize();//TODO it is not working when removed
		//org.cyk.utility.__kernel__.persistence.query.QueryExecutor.AbstractImpl.LOG_LEVEL = java.util.logging.Level.INFO;
		VariableHelper.write(VariableName.SYSTEM_LOGGING_THROWABLE_PRINT_STACK_TRACE,Boolean.TRUE);
	}
	
	@Override
	protected void createData() {
		EntityCreator.getInstance().createManyInTransaction(new BudgetSpecializationUnitType().setCode("1").setName("1")
				,new Section().setCode("1").setName("1"),new Section().setCode("2").setName("2"),new EconomicNature().setCode("1").setName("1"));
		EntityCreator.getInstance().createManyInTransaction(new BudgetSpecializationUnitCategory().setCode("1").setName("1").setTypeFromIdentifier("1"));
		EntityCreator.getInstance().createManyInTransaction(new BudgetSpecializationUnit().setCode("1").setName("1").setCategoryFromIdentifier("1")
				,new BudgetSpecializationUnit().setCode("2").setName("2").setCategoryFromIdentifier("1")
				,new BudgetSpecializationUnit().setCode("3").setName("3").setCategoryFromIdentifier("1"));
		
		EntityCreator.getInstance().createManyInTransaction(new Activity().setCode("1").setName("1").setBudgetSpecializationUnitFromIdentifier("1")
				,new Activity().setCode("2").setName("2").setBudgetSpecializationUnitFromIdentifier("1"));
		
		EntityCreator.getInstance().createManyInTransaction(new BudgetaryAct().setCode("2020").setName("2020").setYear("2020")
				,new BudgetaryAct().setCode("2021").setName("2021").setYear("2021"));
		
		EntityCreator.getInstance().createManyInTransaction(new BudgetaryActVersion().setCode("2020_1").setName("2020_1").setBudgetaryActFromIdentifier("2020")
				,new BudgetaryActVersion().setCode("2020_2").setName("2020_2").setBudgetaryActFromIdentifier("2020")
				,new BudgetaryActVersion().setCode("2021_1").setName("2021_1").setBudgetaryActFromIdentifier("2021"));
		
		for(BudgetSpecializationUnit budgetSpecializationUnit : EntityReader.getInstance().readMany(BudgetSpecializationUnit.class)) {
			for(BudgetaryActVersion budgetaryActVersion : EntityReader.getInstance().readMany(BudgetaryActVersion.class)) {
				EntityCreator.getInstance().createManyInTransaction(new Budget().setCode(budgetSpecializationUnit.getCode()+"_"+budgetaryActVersion.getCode())
						.setActVersion(budgetaryActVersion).setSpecializationUnit(budgetSpecializationUnit));
			}
		}
		
		EntityCreator.getInstance().createManyInTransaction(new Resource().setIdentifier("1").setActivityFromIdentifier("1").setEconomicNatureFromIdentifier("1")
				.setBudgetFromIdentifier("1_2020_1") );
	}
	
}
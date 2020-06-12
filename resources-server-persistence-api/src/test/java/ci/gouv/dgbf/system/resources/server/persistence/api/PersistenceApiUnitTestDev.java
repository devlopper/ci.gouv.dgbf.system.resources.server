package ci.gouv.dgbf.system.resources.server.persistence.api;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutorArguments;
import org.cyk.utility.__kernel__.test.weld.AbstractPersistenceUnitTest;
import org.junit.jupiter.api.Test;

import ci.gouv.dgbf.system.resources.server.persistence.api.query.SectionQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitCategory;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitType;
import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

public class PersistenceApiUnitTestDev extends AbstractPersistenceUnitTest {
	private static final long serialVersionUID = 1L;

	@Override
	protected void initializeEntityManagerFactory(String persistenceUnitName) {
		super.initializeEntityManagerFactory(persistenceUnitName);
		ApplicationScopeLifeCycleListener.initialize();
		//ApplicationScopeLifeCycleListener.initialize();//TODO it is not working when removed
		//org.cyk.utility.__kernel__.persistence.query.QueryExecutor.AbstractImpl.LOG_LEVEL = java.util.logging.Level.INFO;
	}
	
	@Override
	protected String getPersistenceUnitName() {
		return "dev";
	}
	
	@Test
	public void run(){
		assertCountIsGreaterThanZero(Section.class,BudgetSpecializationUnitType.class,BudgetSpecializationUnitCategory.class
				,BudgetSpecializationUnit.class,Activity.class,EconomicNature.class);
		printSections();
	}
	
	public void printSections(){
		System.out.println(StringUtils.repeat("-", 20)+" All Section list "+StringUtils.repeat("-", 20));
		Collection<Section> sections = SectionQuerier.getInstance().readOrderByCodeAscending();
		if(CollectionHelper.isNotEmpty(sections))
			sections.forEach(section -> {
				System.out.println(section.getCode()+" | "+section.getAmounts());
			});
		
		printSections("0101",Boolean.TRUE,Boolean.TRUE);
	}
	
	public void printSections(String budgetaryActVersionCode,Boolean isGetAll,Boolean isGetTree){
		System.out.println(StringUtils.repeat("-", 20)+" All Section of Version "+budgetaryActVersionCode+" "+StringUtils.repeat("-", 20));
		
		Collection<Section> sections = EntityReader.getInstance().readMany(Section.class,
				new QueryExecutorArguments().setQuery(new Query().setIdentifier(
					SectionQuerier.QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_GET_ALL_BY_GET_TREE_ORDER_BY_CODE_ASCENDING))
				.addFilterFieldsValues(SectionQuerier.PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,budgetaryActVersionCode));
		if(CollectionHelper.isNotEmpty(sections))
			sections.forEach(section -> {
				System.out.println(section.getCode()+" | "+section.getAmounts());
				if(CollectionHelper.isNotEmpty(section.getBudgetSpecializationUnitCategories())) {
					System.out.println("\tBudgetSpecializationUnitCategories");
					System.out.print("\t");
					for(BudgetSpecializationUnitCategory budgetSpecializationUnitCategory : section.getBudgetSpecializationUnitCategories()) {
						System.out.print(" "+budgetSpecializationUnitCategory.getCode()+"-"+budgetSpecializationUnitCategory.getAmounts()+" |");
					}
					System.out.println();
				}
				if(CollectionHelper.isNotEmpty(section.getBudgetSpecializationUnits())) {
					System.out.println("\tBudgetSpecializationUnits");
					for(BudgetSpecializationUnit budgetSpecializationUnit : section.getBudgetSpecializationUnits()) {
						System.out.println("\t"+budgetSpecializationUnit.getCode()+" | "+budgetSpecializationUnit.getAmounts());
						if(CollectionHelper.isNotEmpty(budgetSpecializationUnit.getActivities())) {
							System.out.println("\t\tActivities");
							for(Activity activity : budgetSpecializationUnit.getActivities()) {
								System.out.println("\t\t"+activity.getCode()+" | "+activity.getAmounts());
								if(CollectionHelper.isNotEmpty(activity.getResources())) {
									System.out.println("\t\t\tResources");
									for(Resource resource : activity.getResources()) {
										System.out.println("\t\t\t"+resource.getEconomicNature().getCode()+" | "+resource.getAmounts());
									}
								}
							}
						}
					}
				}
			});
	}
}
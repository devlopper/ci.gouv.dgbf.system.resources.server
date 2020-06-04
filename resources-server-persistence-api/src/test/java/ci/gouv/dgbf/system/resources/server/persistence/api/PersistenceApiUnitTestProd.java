package ci.gouv.dgbf.system.resources.server.persistence.api;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.test.weld.AbstractPersistenceUnitTest;
import org.junit.jupiter.api.Test;

import ci.gouv.dgbf.system.resources.server.persistence.api.query.SectionQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitCategory;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitType;
import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

public class PersistenceApiUnitTestProd extends AbstractPersistenceUnitTest {
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
		return "prod";
	}
	
	@Test
	public void run(){
		assertCountIsGreaterThanZero(Section.class,BudgetSpecializationUnitType.class,BudgetSpecializationUnitCategory.class
				,BudgetSpecializationUnit.class,Activity.class,EconomicNature.class);
		printSections();
	}
	
	public void printSections(){
		System.out.println(StringUtils.repeat("-", 20)+" Section list "+StringUtils.repeat("-", 20));
		Collection<Section> sections = EntityReader.getInstance().readMany(Section.class
				,SectionQuerier.QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
				,SectionQuerier.PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE, "0101"
				);
		if(CollectionHelper.isNotEmpty(sections))
			sections.forEach(section -> {
				System.out.println(section+" : "+section.getAmounts());
			});
	}
}
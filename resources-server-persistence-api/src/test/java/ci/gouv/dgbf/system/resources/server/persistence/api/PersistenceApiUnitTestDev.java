package ci.gouv.dgbf.system.resources.server.persistence.api;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.test.weld.AbstractPersistenceUnitTest;
import org.junit.jupiter.api.Test;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitCategory;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitType;
import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

public class PersistenceApiUnitTestDev extends AbstractPersistenceUnitTest {
	private static final long serialVersionUID = 1L;

	@Override
	protected String getPersistenceUnitName() {
		return "dev";
	}
	
	@Test
	public void run(){
		assertCountIsGreaterThanZero(Section.class,BudgetSpecializationUnitType.class,BudgetSpecializationUnitCategory.class
				,BudgetSpecializationUnit.class,Activity.class,EconomicNature.class);
	}
	
	public void printSections(){
		System.out.println(StringUtils.repeat("-", 20)+" Section list "+StringUtils.repeat("-", 20));
		Collection<Section> sections = EntityReader.getInstance().readMany(Section.class);
		if(CollectionHelper.isNotEmpty(sections))
			sections.forEach(section -> {
				System.out.println(section);
			});
	}
}
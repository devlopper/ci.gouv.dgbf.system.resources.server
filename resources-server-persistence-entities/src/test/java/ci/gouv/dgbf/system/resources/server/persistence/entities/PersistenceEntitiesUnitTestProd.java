package ci.gouv.dgbf.system.resources.server.persistence.entities;

import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.klass.PersistableClassesGetter;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.test.weld.AbstractPersistenceUnitTest;
import org.junit.jupiter.api.Test;

public class PersistenceEntitiesUnitTestProd extends AbstractPersistenceUnitTest {
	private static final long serialVersionUID = 1L;

	@Override
	protected String getPersistenceUnitName() {
		return "prod";
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void run(){
		assertCountIsNotNull((Collection<Class<?>>)PersistableClassesGetter.COLLECTION.get());
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
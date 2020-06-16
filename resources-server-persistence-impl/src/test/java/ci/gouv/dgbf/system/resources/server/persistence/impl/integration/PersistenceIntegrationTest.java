package ci.gouv.dgbf.system.resources.server.persistence.impl.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.server.persistence.test.arquillian.AbstractPersistenceArquillianIntegrationTestWithDefaultDeployment;
import org.junit.Test;

public class PersistenceIntegrationTest extends AbstractPersistenceArquillianIntegrationTestWithDefaultDeployment {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void __listenBefore__() {
		super.__listenBefore__();
		QueryHelper.getQueries().setIsRegisterableToEntityManager(Boolean.TRUE);
	}
	
	@Override
	protected void __listenAfter__() {
		super.__listenAfter__();
		QueryHelper.clear();
	}
	
	@Test
	public void readWhereAdministrativeUnitDoesNotExistBySectionsCodes_() throws Exception{
		userTransaction.begin();
		assertThat("").isEmpty();
	}
}

package ci.gouv.dgbf.system.resources.server.business.impl.integration;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.cyk.utility.__kernel__.business.EntityCreator;
import org.cyk.utility.__kernel__.persistence.query.EntityFinder;
import org.cyk.utility.server.business.test.arquillian.AbstractBusinessArquillianIntegrationTestWithDefaultDeployment;
import org.junit.Test;

import ci.gouv.dgbf.system.resources.server.business.api.ActivityBusiness;
import ci.gouv.dgbf.system.resources.server.business.api.ResourceBusiness;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Budget;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryAct;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetaryActVersion;
import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Expenditure;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Funding;
import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSource;
import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSourceLessor;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Lessor;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

public class BusinessIntegrationTest extends AbstractBusinessArquillianIntegrationTestWithDefaultDeployment {
	private static final long serialVersionUID = 1L;
		
	@Test
	public void resources_saveInitialsFromComputation() {
		EntityCreator.getInstance().createMany(new EconomicNature().setCode("1").setName("1"),new EconomicNature().setCode("2").setName("1")
				,new EconomicNature().setCode("3").setName("1"),new EconomicNature().setCode("4").setName("1"),new EconomicNature().setCode("5").setName("1")
				,new EconomicNature().setCode("6").setName("1"));
		EntityCreator.getInstance().createMany(new FundingSource().setCode(FundingSource.CODE_TRESOR).setName("1"),new FundingSource().setCode(FundingSource.CODE_DON).setName("2")
				,new FundingSource().setCode(FundingSource.CODE_EMPRUNT).setName("3"));
		EntityCreator.getInstance().createMany(new Section().setCode("1").setName("1"));
		EntityCreator.getInstance().createMany(new Lessor().setCode("1").setName("1"),new Lessor().setCode("2").setName("2"),new Lessor().setCode("3").setName("3")
				,new Lessor().setCode("4").setName("4"),new Lessor().setCode("5").setName("5"));
		EntityCreator.getInstance().createMany(new BudgetSpecializationUnit().setCode("1").setName("1").setSectionIdentifier("1"));
		EntityCreator.getInstance().createMany(new Activity().setCode(Activity.CODE_RECETTES_EXTERIEURES).setName("1").setBudgetSpecializationUnitFromIdentifier("1"));
		EntityCreator.getInstance().createMany(new BudgetaryAct().setCode("1").setName("1").setYear("2020"));
		EntityCreator.getInstance().createMany(new BudgetaryActVersion().setCode("1").setName("1").setBudgetaryActFromIdentifier("1"));
		EntityCreator.getInstance().createMany(new Budget().setCode("1").setSpecializationUnitFromIdentifier("1").setActVersionFromIdentifier("1"));
		EntityCreator.getInstance().createMany(new Expenditure().setIdentifier("1").setBudgetFromIdentifier("1"));
		EntityCreator.getInstance().createMany(
				new Funding().setExpenditureFromIdentifier("1").setLessorFromIdentifier("1").setFundingSourceFromIdentifier(FundingSource.CODE_DON).setAmount(100l)
				,new Funding().setExpenditureFromIdentifier("1").setLessorFromIdentifier("1").setFundingSourceFromIdentifier(FundingSource.CODE_EMPRUNT).setAmount(25l)
				,new Funding().setExpenditureFromIdentifier("1").setLessorFromIdentifier("2").setFundingSourceFromIdentifier(FundingSource.CODE_DON).setAmount(200l)
				,new Funding().setExpenditureFromIdentifier("1").setLessorFromIdentifier("3").setFundingSourceFromIdentifier(FundingSource.CODE_EMPRUNT).setAmount(75l)
				);
		
		EntityCreator.getInstance().createMany(
				new FundingSourceLessor().setFundingSourceFromIdentifier(FundingSource.CODE_DON).setLessorFromIdentifier("1").setEconomicNatureFromIdentifier("1")
				,new FundingSourceLessor().setFundingSourceFromIdentifier(FundingSource.CODE_EMPRUNT).setLessorFromIdentifier("1").setEconomicNatureFromIdentifier("2")
				,new FundingSourceLessor().setFundingSourceFromIdentifier(FundingSource.CODE_DON).setLessorFromIdentifier("2").setEconomicNatureFromIdentifier("3")
				,new FundingSourceLessor().setFundingSourceFromIdentifier(FundingSource.CODE_EMPRUNT).setLessorFromIdentifier("2").setEconomicNatureFromIdentifier("4")
				,new FundingSourceLessor().setFundingSourceFromIdentifier(FundingSource.CODE_DON).setLessorFromIdentifier("3").setEconomicNatureFromIdentifier("5")
				,new FundingSourceLessor().setFundingSourceFromIdentifier(FundingSource.CODE_DON).setLessorFromIdentifier("2").setEconomicNatureFromIdentifier("6")
			);
		
		assertThat(__inject__(ResourceBusiness.class).count()).isEqualTo(0l);
		
		Activity activity = EntityFinder.getInstance().find(Activity.class, Activity.CODE_RECETTES_EXTERIEURES);
		activity.setBudgetaryActVersion(EntityFinder.getInstance().find(BudgetaryActVersion.class, "1"));		
		__inject__(ActivityBusiness.class).saveInitialsFromComputation(List.of(activity));
		
		assertThat(__inject__(ResourceBusiness.class).count()).isEqualTo(3l);
	}
}
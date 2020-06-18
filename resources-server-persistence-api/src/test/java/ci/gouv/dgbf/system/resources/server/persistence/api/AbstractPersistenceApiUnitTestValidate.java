package ci.gouv.dgbf.system.resources.server.persistence.api;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.klass.PersistableClassesGetter;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryExecutorArguments;
import org.junit.jupiter.api.Test;

import ci.gouv.dgbf.system.resources.server.persistence.api.query.EconomicNatureQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.LessorQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.api.query.SectionQuerier;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitCategory;
import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;
import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSource;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Lessor;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Resource;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

public abstract class AbstractPersistenceApiUnitTestValidate extends org.cyk.utility.__kernel__.test.weld.AbstractPersistenceUnitTest {
	private static final long serialVersionUID = 1L;

	@Override
	protected void initializeEntityManagerFactory(String persistenceUnitName) {
		super.initializeEntityManagerFactory(persistenceUnitName);
		ApplicationScopeLifeCycleListener.initialize();
		//ApplicationScopeLifeCycleListener.initialize();//TODO it is not working when removed
		//org.cyk.utility.__kernel__.persistence.query.QueryExecutor.AbstractImpl.LOG_LEVEL = java.util.logging.Level.INFO;
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void run(){
		assertCountIsNotNull((Collection<Class<?>>) PersistableClassesGetter.COLLECTION.get());
		printSections();
		printEconomicNatures();
		printLessorReadAllWithAllFundingSourcesOrderByCodeAscending();
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

	public void printEconomicNatures(){
		printReadAggregationByFundingSourcesCodesOrderByCodeAscending("0101",FundingSource.CODE_DON);
		printReadAggregationByFundingSourcesCodesOrderByCodeAscending("0101",FundingSource.CODE_EMPRUNT);
	}
	
	public void printReadAggregationByFundingSourcesCodesOrderByCodeAscending(String budgetaryActVersionCode,String...fundingSourcesCodes) {
		System.out.println(StringUtils.repeat("-", 20)+" Economic nature aggregation : "+Arrays.toString(fundingSourcesCodes)+StringUtils.repeat("-", 20));
		Collection<EconomicNature> economicNatures = EntityReader.getInstance().readMany(EconomicNature.class, EconomicNatureQuerier.QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_FUNDING_SOURCES_CODES_ORDER_BY_CODE_ASCENDING
				, EconomicNatureQuerier.PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,budgetaryActVersionCode
				, EconomicNatureQuerier.PARAMETER_NAME_FUNDING_SOURCES_CODES,CollectionHelper.listOf(fundingSourcesCodes)
			);
		if(CollectionHelper.isNotEmpty(economicNatures))
			for(String fundingSourcesCode : fundingSourcesCodes) {
				System.out.println("\tSource de financement : "+fundingSourcesCode);
				System.out.println("\t\tNatures économiques");
				economicNatures.forEach(economicNature -> {
					System.out.println("\t\t"+economicNature.getIdentifier()+" : "+economicNature.getAmount());
				});
			}
	}
	
	public void printLessorReadAllWithAllFundingSourcesOrderByCodeAscending() {
		System.out.println(StringUtils.repeat("-", 20)+" Lessor with all funding sources : "+StringUtils.repeat("-", 20));
		Collection<Lessor> lessors = EntityReader.getInstance().readMany(Lessor.class, new QueryExecutorArguments().setQuery(new Query().setIdentifier(LessorQuerier.QUERY_IDENTIFIER_READ_ALL_WITH_ALL_FUNDING_SOURCES_ORDER_BY_CODE_ASCENDING)));
		if(CollectionHelper.isNotEmpty(lessors))
			for(Lessor lessor : lessors)
				System.out.println(lessor+" : "+lessor.getFundingSourceLessors().stream().map(x -> x.getFundingSource().getCode()+":"+(x.getEconomicNature() == null ? "?" : x.getEconomicNature().getCode())).collect(Collectors.toList()));		
	}
}
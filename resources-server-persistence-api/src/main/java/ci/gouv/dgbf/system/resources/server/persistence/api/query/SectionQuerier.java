package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.field.FieldHelper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.Query;
import org.cyk.utility.__kernel__.persistence.query.QueryHelper;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.Activity;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitCategory;
import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnitType;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

@Queries(value = {
		@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = Section.class,name = SectionQuerier.QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING,value = "SELECT t FROM Section t ORDER BY t.code ASC")
})
public interface SectionQuerier extends Querier {

	/**/
	
	static SectionQuerier getInstance() {
		return Helper.getInstance(SectionQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE = "budgetaryActVersionCode";
	
	/* read order by code ascending */
	String QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING = "readOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(Section.class, QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING);
	Collection<Section> readOrderByCodeAscending();
	
	/* read amounts aggregation order by code ascending */
	String QUERY_NAME_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = "readAggregationByBudgetaryActVersionCodeOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(Section.class, QUERY_NAME_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING);
	Map<String,Integer> QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_TUPLE_FIELDS_NAMES_INDEXES = ResourceQuerier
			.deriveSumsTupleFieldsNamesIndexes(Section.FIELD_IDENTIFIER,Section.FIELD_CODE,Section.FIELD_NAME);
	String QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING = 
			"SELECT t.identifier,t.code,t.name,"+ResourceQuerier.deriveSums("resource")
			+" FROM Section t "
			+" INNER JOIN BudgetSpecializationUnit budgetSpecializationUnit ON budgetSpecializationUnit.section.identifier = t.identifier "
			+" INNER JOIN Activity activity ON activity.budgetSpecializationUnit.identifier = budgetSpecializationUnit.identifier "
			+" INNER JOIN Resource resource ON resource.activity.identifier = activity.identifier "	
			+" WHERE resource.budget.actVersion.code = :"+PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE+" "
			+" GROUP BY t.identifier,t.code,t.name "
			+" ORDER BY t.code ASC"
			;
	Collection<Section> readAggregationByBudgetaryActVersionCodeOrderByCodeAscending(String budgetaryActVersionCode);
	
	String QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_BY_GET_ALL_BY_GET_TREE_ORDER_BY_CODE_ASCENDING = 
			QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING+".GetAll.GetTree";
	Collection<Section> readAggregationByBudgetaryActVersionCodeOrderByCodeAscending(String budgetaryActVersionCode,Boolean isGetAll,Boolean isGetTree);
	
	static void initialize() {
		QueryHelper.addQueries(Query.build(Query.FIELD_IDENTIFIER,QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
				,Query.FIELD_TUPLE_CLASS,Section.class,Query.FIELD_RESULT_CLASS,Section.class
				,Query.FIELD_VALUE,QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
				).setTupleFieldsNamesIndexes(QUERY_VALUE_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING_TUPLE_FIELDS_NAMES_INDEXES)
			);
	}
	
	/**/
	
	public static abstract class AbstractImpl extends AbstractObject implements SectionQuerier,Serializable {
		
		@Override
		public Collection<Section> readOrderByCodeAscending() {
			return EntityReader.getInstance().readMany(Section.class, QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING);
		}
		
		@Override
		public Collection<Section> readAggregationByBudgetaryActVersionCodeOrderByCodeAscending(String budgetaryActVersionCode) {
			return EntityReader.getInstance().readMany(Section.class, QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
					,PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,budgetaryActVersionCode);
		}
		
		@Override
		public Collection<Section> readAggregationByBudgetaryActVersionCodeOrderByCodeAscending(String budgetaryActVersionCode,Boolean isGetAll,Boolean isGetTree) {
			Collection<Section> sections = readAggregationByBudgetaryActVersionCodeOrderByCodeAscending(budgetaryActVersionCode);
			if(Boolean.TRUE.equals(isGetAll)) {
				Collection<Section> all = readOrderByCodeAscending();
				Integer count = CollectionHelper.getSize(all);
				if(count > 0 && count > CollectionHelper.getSize(sections)) {
					if(sections == null)
						sections = new ArrayList<>();
					all.removeAll(sections);
					sections.addAll(all);
				}
			}
			if(CollectionHelper.isNotEmpty(sections) && Boolean.TRUE.equals(isGetTree)) {
				Collection<String> codes = CollectionHelper.cast(String.class,FieldHelper.readBusinessIdentifiers(sections));
				readBudgetSpecializationUnitCategories(sections,codes, budgetaryActVersionCode,isGetAll);
				readBudgetSpecializationUnits(sections, codes, budgetaryActVersionCode, isGetAll,isGetTree);
			}
			CollectionHelper.sortByBusinessIdentifier((List<Section>) sections);
			return sections;
		}
		
		private void readBudgetSpecializationUnitCategories(Collection<Section> sections,Collection<String> codes,String budgetaryActVersionCode,Boolean isGetAll) {
			Collection<BudgetSpecializationUnitCategory> budgetSpecializationUnitCategories = EntityReader.getInstance().readMany(BudgetSpecializationUnitCategory.class
					, BudgetSpecializationUnitCategoryQuerier.QUERY_IDENTIFIER_READ_AGGREGATION_BY_SECTIONS_CODES_BY_TYPES_CODES_BY_BUDGETARY_ACT_VERSION_CODE_ORDER_BY_CODE_ASCENDING
					, BudgetSpecializationUnitCategoryQuerier.PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,budgetaryActVersionCode
					, BudgetSpecializationUnitCategoryQuerier.PARAMETER_NAME_SECTIONS_CODES,codes
					, BudgetSpecializationUnitCategoryQuerier.PARAMETER_NAME_TYPES_CODES,List.of(BudgetSpecializationUnitType.CODE_RESOURCE));
			if(CollectionHelper.isNotEmpty(budgetSpecializationUnitCategories)) {
				sections.forEach(section -> {
					section.setBudgetSpecializationUnitCategories(budgetSpecializationUnitCategories.stream()
							.filter(category -> section.getIdentifier().equals(category.getSectionIdentifier())).collect(Collectors.toList()));
				});
			}
			if(Boolean.TRUE.equals(isGetAll)) {
				Collection<BudgetSpecializationUnitCategory> all = EntityReader.getInstance().readMany(BudgetSpecializationUnitCategory.class
						,BudgetSpecializationUnitCategoryQuerier.QUERY_IDENTIFIER_READ_BY_TYPES_CODES_ORDER_BY_CODE_ASCENDING
						,BudgetSpecializationUnitCategoryQuerier.PARAMETER_NAME_TYPES_CODES,List.of(BudgetSpecializationUnitType.CODE_RESOURCE));
				if(CollectionHelper.isNotEmpty(all))
					sections.forEach(section -> {
						if(section.getBudgetSpecializationUnitCategories() == null)
							section.setBudgetSpecializationUnitCategories(new ArrayList<>());
						for(BudgetSpecializationUnitCategory index : all)
							if(!section.getBudgetSpecializationUnitCategories().contains(index)) {
								section.getBudgetSpecializationUnitCategories().add(index);
							}
						CollectionHelper.sortByBusinessIdentifier((List<BudgetSpecializationUnitCategory>) section.getBudgetSpecializationUnitCategories());
						BudgetSpecializationUnitCategory total = new BudgetSpecializationUnitCategory();
						total.setCode("Recettes de l'État");
						section.getBudgetSpecializationUnitCategories().forEach(budgetSpecializationUnitCategory -> {
							total.getAmounts(Boolean.TRUE).increment(budgetSpecializationUnitCategory.getAmounts());
						});
						CollectionHelper.addElementAt(section.getBudgetSpecializationUnitCategories(), 4, total);
					});				
			}
		}
		
		private void readBudgetSpecializationUnits(Collection<Section> sections,Collection<String> codes,String budgetaryActVersionCode,Boolean isGetAll,Boolean isGetTree) {
			Collection<BudgetSpecializationUnit> budgetSpecializationUnits = EntityReader.getInstance().readMany(BudgetSpecializationUnit.class
					, BudgetSpecializationUnitBySectionQuerier.QUERY_IDENTIFIER_READ_AGGREGATION_BY_SECTIONS_CODES_BY_BUDGETARY_ACT_VERSION_CODE
					, BudgetSpecializationUnitBySectionQuerier.PARAMETER_NAME_SECTIONS_CODES,codes
					, BudgetSpecializationUnitBySectionQuerier.PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,budgetaryActVersionCode);
			if(CollectionHelper.isNotEmpty(budgetSpecializationUnits)) {
				sections.forEach(section -> {
					section.setBudgetSpecializationUnits(budgetSpecializationUnits.stream()
							.filter(budgetSpecializationUnit -> section.getIdentifier().equals(budgetSpecializationUnit.getSectionIdentifier())).collect(Collectors.toList()));
				});
			}
			
			Collection<BudgetSpecializationUnit> all = null;
			if(Boolean.TRUE.equals(isGetAll)) {
				all = EntityReader.getInstance().readMany(BudgetSpecializationUnit.class
						,BudgetSpecializationUnitBySectionQuerier.QUERY_IDENTIFIER_READ_BY_SECTIONS_CODES_BY_TYPES_CODES
						,BudgetSpecializationUnitBySectionQuerier.PARAMETER_NAME_SECTIONS_CODES,codes
						,BudgetSpecializationUnitBySectionQuerier.PARAMETER_NAME_TYPES_CODES,List.of(BudgetSpecializationUnitType.CODE_RESOURCE)
						);
				if(CollectionHelper.isNotEmpty(all))
					for(Section section : sections) {
						if(section.getBudgetSpecializationUnits() == null)
							section.setBudgetSpecializationUnits(new ArrayList<>());
						for(BudgetSpecializationUnit index : all)
							if(section.equals(index.getSection()) && !section.getBudgetSpecializationUnits().contains(index)) {
								section.getBudgetSpecializationUnits().add(index);
							}
						CollectionHelper.sortByBusinessIdentifier((List<BudgetSpecializationUnit>) section.getBudgetSpecializationUnits());
					}
				all = new ArrayList<>();
				for(Section section : sections)
					all.addAll(section.getBudgetSpecializationUnits());
			}
			if(CollectionHelper.isNotEmpty(all) && Boolean.TRUE.equals(isGetTree)) {
				Collection<String> budgetSpecializationUnitsCodes = CollectionHelper.cast(String.class,FieldHelper.readBusinessIdentifiers(all));
				readActivities(all, budgetSpecializationUnitsCodes, budgetaryActVersionCode, isGetAll);
			}
		}
		
		private void readActivities(Collection<BudgetSpecializationUnit> budgetSpecializationUnits,Collection<String> codes,String budgetaryActVersionCode,Boolean isGetAll) {
			Collection<Activity> activities = EntityReader.getInstance().readMany(Activity.class
					, ActivityByBudgetSpecializationUnitQuerier.QUERY_IDENTIFIER_READ_AGGREGATION_BY_BUDGET_SPECIALIZATION_UNITS_CODES_BY_BUDGETARY_ACT_VERSION_CODE
					, ActivityByBudgetSpecializationUnitQuerier.PARAMETER_NAME_BUDGET_SPECIALIZATION_UNITS_CODES,codes
					, ActivityByBudgetSpecializationUnitQuerier.PARAMETER_NAME_BUDGETARY_ACT_VERSION_CODE,budgetaryActVersionCode);
			if(CollectionHelper.isNotEmpty(activities)) {
				budgetSpecializationUnits.forEach(budgetSpecializationUnit -> {
					budgetSpecializationUnit.setActivities(activities.stream()
							.filter(activity -> budgetSpecializationUnit.getIdentifier().equals(activity.getBudgetSpecializationUnitIdentifier())).collect(Collectors.toList()));
				});
			}
			if(Boolean.TRUE.equals(isGetAll)) {
				Collection<Activity> all = EntityReader.getInstance().readMany(Activity.class
						,ActivityByBudgetSpecializationUnitQuerier.QUERY_IDENTIFIER_READ_BY_BUDGET_SPECIALIZATION_UNITS_CODES
						,ActivityByBudgetSpecializationUnitQuerier.PARAMETER_NAME_BUDGET_SPECIALIZATION_UNITS_CODES,codes
						);
				if(CollectionHelper.isNotEmpty(all))
					budgetSpecializationUnits.forEach(budgetSpecializationUnit -> {
						if(budgetSpecializationUnit.getActivities() == null)
							budgetSpecializationUnit.setActivities(new ArrayList<>());
						for(Activity index : all)
							if(budgetSpecializationUnit.equals(index.getBudgetSpecializationUnit()) && !budgetSpecializationUnit.getActivities().contains(index)) {
								budgetSpecializationUnit.getActivities().add(index);
							}
						CollectionHelper.sortByBusinessIdentifier((List<Activity>) budgetSpecializationUnit.getActivities());
					});
			}
		}
	}
}
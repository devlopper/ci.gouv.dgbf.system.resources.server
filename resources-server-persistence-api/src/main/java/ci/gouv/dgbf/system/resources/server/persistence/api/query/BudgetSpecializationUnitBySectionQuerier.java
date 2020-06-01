package ci.gouv.dgbf.system.resources.server.persistence.api.query;
import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.persistence.query.ByDimensionOneBusinessIdentifierQuerier;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.persistence.query.annotation.Query;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.BudgetSpecializationUnit;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Section;

@Queries(value = {
	@Query(tupleClass = BudgetSpecializationUnit.class,name = BudgetSpecializationUnitBySectionQuerier.QUERY_NAME_READ_BY_SECTIONS_CODES,value = "SELECT t FROM BudgetSpecializationUnit t WHERE t.section.code IN :"+BudgetSpecializationUnitBySectionQuerier.PARAMETER_NAME_CODES+" ORDER BY t.code ASC")
	,@Query(tupleClass = BudgetSpecializationUnit.class,name = BudgetSpecializationUnitBySectionQuerier.QUERY_NAME_READ_BY_SECTIONS_CODES_BY_TYPES_CODES,value = "SELECT t FROM BudgetSpecializationUnit t WHERE t.section.code IN :"
			+BudgetSpecializationUnitBySectionQuerier.PARAMETER_NAME_CODES+" AND t.category.type.identifier IN :"+BudgetSpecializationUnitBySectionQuerier.PARAMETER_NAME_TYPES_CODES+" ORDER BY t.code ASC")
})
public interface BudgetSpecializationUnitBySectionQuerier extends ByDimensionOneBusinessIdentifierQuerier<BudgetSpecializationUnit,Section,String> {

	/**/
	
	static BudgetSpecializationUnitBySectionQuerier getInstance() {
		return Helper.getInstance(BudgetSpecializationUnitBySectionQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PARAMETER_NAME_CODES = "codes";
	String PARAMETER_NAME_TYPES_CODES = "typesCodes";
	
	String QUERY_NAME_READ_BY_SECTIONS_CODES = "readBySectionsCodes";
	String QUERY_IDENTIFIER_READ_BY_SECTIONS_CODES = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnit.class, QUERY_NAME_READ_BY_SECTIONS_CODES);
	
	String QUERY_NAME_COUNT_BY_SECTIONS_CODES = "countBySectionsCodes";
	
	String QUERY_NAME_READ_BY_SECTIONS_CODES_BY_TYPES_CODES = "readBySectionsCodesByTypesCodes";
	String QUERY_IDENTIFIER_READ_BY_SECTIONS_CODES_BY_TYPES_CODES = QueryIdentifierBuilder.getInstance().build(BudgetSpecializationUnit.class, QUERY_NAME_READ_BY_SECTIONS_CODES_BY_TYPES_CODES);
	
}
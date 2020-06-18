package ci.gouv.dgbf.system.resources.server.persistence.api.query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.object.AbstractObject;
import org.cyk.utility.__kernel__.persistence.query.EntityReader;
import org.cyk.utility.__kernel__.persistence.query.Querier;
import org.cyk.utility.__kernel__.persistence.query.QueryIdentifierBuilder;
import org.cyk.utility.__kernel__.persistence.query.annotation.Queries;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSource;
import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSourceLessor;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Lessor;

@Queries(value = {
		@org.cyk.utility.__kernel__.persistence.query.annotation.Query(tupleClass = Lessor.class,name = LessorQuerier.QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING,value = "SELECT t FROM Lessor t ORDER BY t.code ASC")
})
public interface LessorQuerier extends Querier {

	/**/
	
	static LessorQuerier getInstance() {
		return Helper.getInstance(LessorQuerier.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	/* read order by code ascending */
	String QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING = "readOrderByCodeAscending";
	String QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING = QueryIdentifierBuilder.getInstance().build(Lessor.class, QUERY_NAME_READ_ORDER_BY_CODE_ASCENDING);
	Collection<Lessor> readOrderByCodeAscending();
	
	String QUERY_IDENTIFIER_READ_ALL_WITH_ALL_FUNDING_SOURCES_ORDER_BY_CODE_ASCENDING = "readAllWithAllFundingSourcesOrderByCodeAscending";
	Collection<Lessor> readAllWithAllFundingSourcesOrderByCodeAscending();
	
	static void initialize() {
		
	}
	
	/**/
	
	public static abstract class AbstractImpl extends AbstractObject implements LessorQuerier,Serializable {
		
		@Override
		public Collection<Lessor> readOrderByCodeAscending() {
			return EntityReader.getInstance().readMany(Lessor.class, QUERY_IDENTIFIER_READ_ORDER_BY_CODE_ASCENDING);
		}
		
		@Override
		public Collection<Lessor> readAllWithAllFundingSourcesOrderByCodeAscending() {
			Collection<FundingSource> fundingSources = EntityReader.getInstance().readMany(FundingSource.class, FundingSourceQuerier.QUERY_IDENTIFIER_READ_BY_CODES_ORDER_BY_CODE_ASCENDING
					, FundingSourceQuerier.PARAMETER_CODES,FundingSource.CATEGORY_EXTERNAL_CODES);
			Collection<Lessor> lessors = readOrderByCodeAscending();
			Collection<FundingSourceLessor> fundingSourceLessors = EntityReader.getInstance().readMany(FundingSourceLessor.class);
			if(CollectionHelper.isNotEmpty(lessors))
				lessors.forEach(lessor -> {
					if(CollectionHelper.isNotEmpty(fundingSourceLessors))
						lessor.setFundingSourceLessors(fundingSourceLessors.stream().filter(x -> x.getLessor().equals(lessor)).collect(Collectors.toList()));
					if(lessor.getFundingSourceLessors() == null)
						lessor.setFundingSourceLessors(new ArrayList<>());
					for(FundingSource fundingSource : fundingSources) {
						if(lessor.getFundingSourceLessors().stream().filter(x -> x.getFundingSource().equals(fundingSource)).count() == 0)
							lessor.getFundingSourceLessors().add(new FundingSourceLessor().setFundingSource(fundingSource).setLessor(lessor));
					}
				});
			return lessors;
		}
	}
}
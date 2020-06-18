package ci.gouv.dgbf.system.resources.server.representation.api;
import java.io.Serializable;

import javax.ws.rs.Path;

import org.cyk.utility.__kernel__.Helper;
import org.cyk.utility.__kernel__.representation.EntitySaver;
import org.cyk.utility.__kernel__.value.Value;

import ci.gouv.dgbf.system.resources.server.representation.entities.FundingSourceLessorDto;

@Path(FundingSourceLessorSaver.PATH)
public interface FundingSourceLessorSaver extends EntitySaver<FundingSourceLessorDto> {
	
	public static abstract class AbstractImpl extends EntitySaver.AbstractImpl<FundingSourceLessorDto> implements FundingSourceLessorSaver,Serializable {	
		@Override
		protected Class<FundingSourceLessorDto> getRepresentationEntityClass() {
			return FundingSourceLessorDto.class;
		}
	}
	
	/**/
	
	static FundingSourceLessorSaver getInstance() {
		return Helper.getInstance(FundingSourceLessorSaver.class, INSTANCE);
	}
	
	Value INSTANCE = new Value();
	
	String PATH = FundingSourceLessorRepresentation.PATH+"saver";
}
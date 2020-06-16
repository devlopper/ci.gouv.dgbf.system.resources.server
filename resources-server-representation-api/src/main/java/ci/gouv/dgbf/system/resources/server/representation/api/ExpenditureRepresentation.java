package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.ExpenditureDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(ExpenditureRepresentation.PATH)
public interface ExpenditureRepresentation extends RepresentationEntity<ExpenditureDto> {
	
	String PATH = "expenditure";
	
}

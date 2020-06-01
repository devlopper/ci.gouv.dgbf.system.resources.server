package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import ci.gouv.dgbf.system.resources.server.representation.entities.SectionDto;
import org.cyk.utility.server.representation.RepresentationEntity;

@Path(SectionRepresentation.PATH)
public interface SectionRepresentation extends RepresentationEntity<SectionDto> {
	
	String PATH = "section";
	
}

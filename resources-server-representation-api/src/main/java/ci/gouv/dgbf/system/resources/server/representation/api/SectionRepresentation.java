package ci.gouv.dgbf.system.resources.server.representation.api;
import javax.ws.rs.Path;

import org.cyk.utility.server.representation.RepresentationEntity;

import ci.gouv.dgbf.system.resources.server.representation.entities.SectionDto;

@Path(SectionRepresentation.PATH)
public interface SectionRepresentation extends RepresentationEntity<SectionDto> {
	
	String PATH = "section";
	String PARAMETER_BUDGETARY_ACT_VERSION_CODE = "version_code";
	String PARAMETER_IS_GET_ALL = "all";
	String PARAMETER_IS_GET_TREE = "tree";
}

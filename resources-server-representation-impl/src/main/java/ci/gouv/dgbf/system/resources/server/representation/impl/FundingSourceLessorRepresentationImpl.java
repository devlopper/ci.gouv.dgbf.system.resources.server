package ci.gouv.dgbf.system.resources.server.representation.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

import org.cyk.utility.__kernel__.business.EntitySaver;
import org.cyk.utility.__kernel__.business.EntitySaver.Arguments;
import org.cyk.utility.__kernel__.collection.CollectionHelper;
import org.cyk.utility.__kernel__.persistence.query.EntityFinder;
import org.cyk.utility.__kernel__.rest.ResponseBuilder;
import org.cyk.utility.__kernel__.runnable.Runner;
import org.cyk.utility.__kernel__.string.StringHelper;
import org.cyk.utility.__kernel__.user.interface_.message.MessageRenderer;
import org.cyk.utility.server.representation.AbstractRepresentationEntityImpl;

import ci.gouv.dgbf.system.resources.server.persistence.entities.EconomicNature;
import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSource;
import ci.gouv.dgbf.system.resources.server.persistence.entities.FundingSourceLessor;
import ci.gouv.dgbf.system.resources.server.persistence.entities.Lessor;
import ci.gouv.dgbf.system.resources.server.representation.api.FundingSourceLessorRepresentation;
import ci.gouv.dgbf.system.resources.server.representation.entities.FundingSourceLessorDto;

@ApplicationScoped
public class FundingSourceLessorRepresentationImpl extends AbstractRepresentationEntityImpl<FundingSourceLessorDto> implements FundingSourceLessorRepresentation,Serializable {
	private static final long serialVersionUID = 1L;
	
	@Override
	public Response saveEconomicNatures(Collection<FundingSourceLessorDto> fundingSourceLessorDtos) {
		if(CollectionHelper.isEmpty(fundingSourceLessorDtos))
			return Response.ok().build();
		final Collection<FundingSourceLessor> creatables = new ArrayList<>();
		final Collection<FundingSourceLessor> updatables = new ArrayList<>();
		final Collection<FundingSourceLessor> deletables = new ArrayList<>();
		for(FundingSourceLessorDto fundingSourceLessorDto : fundingSourceLessorDtos) {
			FundingSourceLessor fundingSourceLessor;
			if(StringHelper.isBlank(fundingSourceLessorDto.getIdentifier())) {
				fundingSourceLessor = new FundingSourceLessor();
				if(fundingSourceLessorDto.getFundingSource() != null && StringHelper.isNotBlank(fundingSourceLessorDto.getFundingSource().getIdentifier()))
					fundingSourceLessor.setFundingSource(EntityFinder.getInstance().find(FundingSource.class, fundingSourceLessorDto.getFundingSource().getIdentifier()));
				if(StringHelper.isNotBlank(fundingSourceLessorDto.getLessorIdentifier()))
					fundingSourceLessor.setLessor(EntityFinder.getInstance().find(Lessor.class, fundingSourceLessorDto.getLessorIdentifier()));
				if(fundingSourceLessorDto.getEconomicNature() != null && StringHelper.isNotBlank(fundingSourceLessorDto.getEconomicNature().getIdentifier()))
					fundingSourceLessor.setEconomicNature(EntityFinder.getInstance().find(EconomicNature.class, fundingSourceLessorDto.getEconomicNature().getIdentifier()));		
				creatables.add(fundingSourceLessor);
			}else {
				fundingSourceLessor = EntityFinder.getInstance().find(FundingSourceLessor.class,fundingSourceLessorDto.getIdentifier());
				if(fundingSourceLessor != null) {
					if(Boolean.TRUE.equals(fundingSourceLessorDto.getDeletable()))
						deletables.add(fundingSourceLessor);
					else {
						if(fundingSourceLessorDto.getEconomicNature() == null)
							fundingSourceLessor.setEconomicNature(null);
						else if(StringHelper.isNotBlank(fundingSourceLessorDto.getEconomicNature().getIdentifier()))
							fundingSourceLessor.setEconomicNature(EntityFinder.getInstance().find(EconomicNature.class, fundingSourceLessorDto.getEconomicNature().getIdentifier()));
						updatables.add(fundingSourceLessor);	
					}						
				}				
			}
		}
		Runner.Arguments runnerArguments = new Runner.Arguments().setThrowableMessageArguments(new MessageRenderer.Arguments()).setMessageRenderable(Boolean.FALSE)
				.addRunnables(new Runnable() {				
			@Override
			public void run() {
				Arguments<FundingSourceLessor> arguments = new Arguments<FundingSourceLessor>();
				arguments.setPersistenceArguments(new org.cyk.utility.__kernel__.persistence.EntitySaver.Arguments<FundingSourceLessor>().setCreatables(creatables).setUpdatables(updatables).setDeletables(deletables));
				EntitySaver.getInstance().save(FundingSourceLessor.class, arguments);
			}
		});
		Runner.getInstance().run(runnerArguments);
		if(runnerArguments.getThrowable() == null)
			return Response.ok(/*fundingSourceLessors.size()+" funding source lessors has been processed"*/).build();
		return ResponseBuilder.getInstance().build(runnerArguments.getThrowable());
	}	
}
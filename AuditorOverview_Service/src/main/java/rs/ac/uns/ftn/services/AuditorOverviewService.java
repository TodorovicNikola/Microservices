package rs.ac.uns.ftn.services;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.models.AuditorOverview;
import rs.ac.uns.ftn.repositories.AuditorOverviewRepository;

@Service
public class AuditorOverviewService extends AbstractCRUDService<AuditorOverview, String> {

	private AuditorOverviewRepository aORepository;

	public AuditorOverviewService(AuditorOverviewRepository aORepository) {
		super(aORepository);
		this.aORepository = aORepository;
	}
	
	public String addAuditorOverview(AuditorOverview ao){
		if(save(ao) != null){
			return "Success";
			
		}
		return null;
	}
	
}

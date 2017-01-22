package rs.ac.uns.ftn.services;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.models.ProgrIPlanIntProv;
import rs.ac.uns.ftn.repositories.ProgrIPlanIntProvRepository;

@Service
public class ProgrIPlanIntProvService extends AbstractCRUDService<ProgrIPlanIntProv, String> {

	private ProgrIPlanIntProvRepository pipipRepository;

	public ProgrIPlanIntProvService(ProgrIPlanIntProvRepository pipipRepository) {
		super(pipipRepository);
		this.pipipRepository = pipipRepository;
	}
	
	public List<ProgrIPlanIntProv> getAllProgrIPlanIntProv(){
		return pipipRepository.findAll();
	}
	
	public String addProgrIPlanIntProv(ProgrIPlanIntProv progrIPlanIntProv){
		if(save(progrIPlanIntProv) != null){
			return "Success";
		}
		return null;
	}
	
	public String deleteProgrIPlanIntProv(String id){
		pipipRepository.delete(id);
		
		return "Success";
	}
	
	
}

package rs.ac.uns.ftn.services;

import java.util.List;

import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.models.ObavOIntProv;
import rs.ac.uns.ftn.repositories.ObavOIntProvRepository;
import rs.ac.uns.ftn.services.AbstractCRUDService;

@Service
public class ObavOIntProvService  extends AbstractCRUDService<ObavOIntProv, String> {
	
	private ObavOIntProvRepository oIPRepository;

	public ObavOIntProvService(ObavOIntProvRepository oIPRepository) {
		super(oIPRepository);
		this.oIPRepository = oIPRepository;
	}
	
	public List<ObavOIntProv> getAllProgrIPlanIntProv(){
		return oIPRepository.findAll();
	}
	
	public String addProgrIPlanIntProv(ObavOIntProv progrIPlanIntProv){
		if(save(progrIPlanIntProv) != null){
			return "Success";
		}
		return null;
	}
	
	public String deleteProgrIPlanIntProv(String id){
		oIPRepository.delete(id);
		
		return "Success";
	}

}

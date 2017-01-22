package rs.ac.uns.ftn.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.ac.uns.ftn.models.ProgrIPlanIntProv;

public interface ProgrIPlanIntProvRepository extends MongoRepository<ProgrIPlanIntProv, String>{

	ProgrIPlanIntProv findById(String progrIplanIntProvId);
	
}

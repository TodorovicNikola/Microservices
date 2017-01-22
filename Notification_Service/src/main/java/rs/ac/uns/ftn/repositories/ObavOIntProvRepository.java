package rs.ac.uns.ftn.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.ac.uns.ftn.models.ObavOIntProv;


public interface ObavOIntProvRepository  extends MongoRepository<ObavOIntProv, String>{

	ObavOIntProv findById(String id);
	
}
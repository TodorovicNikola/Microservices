package rs.uns.ac.rs.repositories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.uns.ac.rs.models.DocumentQualityEntity;

public interface DocumentRepository extends MongoRepository<DocumentQualityEntity, String>{

	
	
	
	
}
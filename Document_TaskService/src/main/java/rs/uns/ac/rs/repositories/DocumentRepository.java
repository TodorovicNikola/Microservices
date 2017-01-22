package rs.uns.ac.rs.repositories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.uns.ac.rs.models.DocumentEntity;


public interface DocumentRepository extends MongoRepository<DocumentEntity, String>{

	
	List<DocumentEntity> findByTaskCreatedBy(String firstAndLastName);
	List<DocumentEntity> findByStatus(String status);
	
	
}
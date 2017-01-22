package rs.uns.ac.rs.repositories;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.uns.ac.rs.models.User;

public interface UserRepository extends MongoRepository<User, String>{

	
	List<User> findByFirstName(String firstName);
	
	List<User> findByFirstName(String firstName, Sort sort);
	
	Page<User> findByFirstName(String firstName, Pageable pageable);
	
	List<User> findByFirstNameAndLastName(String firsttName, String lastName);
	
	
	List<User> findByFirstNameNotNull();
	
	List<User> findByFirstNameNull();
	
	User findByMail(String mail);

	User findById(String userId);
	
	
	
}
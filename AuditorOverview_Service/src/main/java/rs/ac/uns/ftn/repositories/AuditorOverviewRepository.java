package rs.ac.uns.ftn.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import rs.ac.uns.ftn.models.AuditorOverview;

public interface AuditorOverviewRepository extends MongoRepository<AuditorOverview, String>{

	AuditorOverview findById(String id);
}

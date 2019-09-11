package com.emc.springbootmongodb.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

// No need implementation, just one interface, and you have CRUD, thanks Spring Data
public interface DomainRepository extends MongoRepository<Domain, Long>, DomainRepositoryCustom {

	//other methods



    Domain findFirstByDomain(String domain);

    Domain findByDomainAndDisplayAds(String domain, boolean displayAds);

    //Supports native JSON query string
    @Query("{domain:'?0'}")
    Domain findCustomByDomain(String domain);

    @Query("{domain: { $regex: ?0 } })")
    List<Domain> findCustomByRegExDomain(String domain);

	int updateDomain(String domain, boolean displayAds);

}
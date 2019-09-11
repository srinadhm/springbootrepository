package com.emc.springbootmongodb.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.mongodb.WriteResult;

//Impl postfix of the name on it compared to the core repository interface
public class DomainRepositoryImpl implements DomainRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    
    public int updateDomain(String domain, boolean displayAds) {

        Query query = new Query(Criteria.where("domain").is(domain));
        Update update = new Update();
        update.set("displayAds", displayAds);

        WriteResult result = mongoTemplate.updateFirst(query, update, Domain.class);

        if(result!=null)
            return result.getN();
        else
            return 0;

    }
}
package com.tdgames.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.tdgames.entity.DataBaseSequence;


@Service
public class IDIncrementService {

	@Autowired
	MongoOperations mongoOperations;
	
	public String generateSequence(String seqName) {
		
		DataBaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
                new Update().inc("seq",1), options().returnNew(true).upsert(true),
                DataBaseSequence.class);
		
		if(!Objects.isNull(counter)) {
			return ""+counter.getSeq();
		}
		else {
			return "1";
		}
	}
	
}

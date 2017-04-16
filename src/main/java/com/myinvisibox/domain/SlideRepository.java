package com.myinvisibox.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SlideRepository extends MongoRepository<Slide, String> {
	public Slide findByUuid(String uuid);

}

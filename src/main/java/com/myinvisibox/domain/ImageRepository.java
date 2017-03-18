package com.myinvisibox.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImageRepository extends MongoRepository<Image, String> {
	public Image findByUuid(String uuid);

}

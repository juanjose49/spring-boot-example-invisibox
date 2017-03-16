package com.myinvisibox.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvisiboxRepository extends MongoRepository<Invisibox, String> {
	public Invisibox findByBarcodeId(String barcodeId);

}

package com.myinvisibox.domain;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvisiboxRepository extends MongoRepository<Invisibox, String> {
	public Invisibox findByBarcodeId(String barcodeId);
	public List<Invisibox> findByUserId(String userId);

}

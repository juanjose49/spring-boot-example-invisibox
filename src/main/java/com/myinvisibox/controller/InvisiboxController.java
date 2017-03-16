package com.myinvisibox.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myinvisibox.domain.Invisibox;
import com.myinvisibox.domain.InvisiboxRepository;

@RestController()
@RequestMapping("/invisibox")
@CrossOrigin(origins = "*")
public class InvisiboxController {
	@Autowired
	private InvisiboxRepository invisiboxRepository;


	@RequestMapping(value = "/{barcodeId}", method = RequestMethod.GET)
	public ResponseEntity<Invisibox> getInvisibox(@PathVariable String barcodeId) {
		Invisibox invisibox = invisiboxRepository.findByBarcodeId(barcodeId);
		if(invisibox == null){
			return new ResponseEntity<Invisibox>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Invisibox>(invisibox, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addInvisibox(@RequestBody Invisibox invisibox) {
		if(invisiboxRepository.findByBarcodeId(invisibox.getBarcodeId()) != null){
			return new ResponseEntity<String>(HttpStatus.CONFLICT);
		}
		
		invisiboxRepository.save(invisibox);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}


}
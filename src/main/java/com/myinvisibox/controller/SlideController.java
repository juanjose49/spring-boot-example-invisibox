package com.myinvisibox.controller;

import java.util.UUID;

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

import com.myinvisibox.domain.Slide;
import com.myinvisibox.domain.SlideRepository;

@RestController()
@RequestMapping("/slide")
@CrossOrigin(origins = "*")
public class SlideController {
	@Autowired
	private SlideRepository slideRepository;


	@RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Slide> getSlide(@PathVariable String uuid) {
		Slide img = slideRepository.findByUuid(uuid);
		if(img == null){
			return new ResponseEntity<Slide>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Slide>(img, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addSlide(@RequestBody Slide slide) {
		slideRepository.save(slide);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}


}
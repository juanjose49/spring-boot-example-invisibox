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

import com.myinvisibox.domain.Image;
import com.myinvisibox.domain.ImageRepository;

@RestController()
@RequestMapping("/status")
@CrossOrigin(origins = "*")
public class StatusController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<String> getStatus() {
		return new ResponseEntity<String>("200",HttpStatus.OK);
	}

}
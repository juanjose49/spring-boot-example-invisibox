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
@RequestMapping("/image")
@CrossOrigin(origins = "*")
public class ImageController {
	@Autowired
	private ImageRepository imageRepository;


	@RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Image> getImage(@PathVariable String uuid) {
		Image img = imageRepository.findByUuid(uuid);
		if(img == null){
			return new ResponseEntity<Image>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Image>(img, HttpStatus.OK);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addImage(@RequestBody Image image) {
		imageRepository.save(image);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}


}
package com.myinvisibox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myinvisibox.domain.Invisibox;
import com.myinvisibox.domain.InvisiboxRepository;

@RestController()
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private InvisiboxRepository invisiboxRepository;
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<Invisibox>> getInvisiboxes(@PathVariable String userId) {
		List<Invisibox> invisiboxes = invisiboxRepository.findByUserId(userId);
		if(invisiboxes == null || invisiboxes.isEmpty()){
			return new ResponseEntity<List<Invisibox>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Invisibox>>(invisiboxes, HttpStatus.OK);
	}

}
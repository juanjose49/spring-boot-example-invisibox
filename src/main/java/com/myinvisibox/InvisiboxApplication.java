package com.myinvisibox;

import java.io.IOException;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InvisiboxApplication {
	public static void main(String[] args) {
		SpringApplication.run(InvisiboxApplication.class, args);
//		try {
//			for (int i=0; i<50;i++){
//				String uuid = UUID.randomUUID().toString();
//				Runtime.getRuntime().exec("osascript /Users/emeterio/git/invisibox-service/dymo/invisibox.scpt " + uuid);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}





}

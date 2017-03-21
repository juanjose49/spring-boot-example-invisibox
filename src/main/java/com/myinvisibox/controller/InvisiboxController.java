package com.myinvisibox.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.codec.binary.Base64;
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

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.myinvisibox.domain.Invisibox;
import com.myinvisibox.domain.InvisiboxRepository;
import com.myinvisibox.domain.QrCode;

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
	public ResponseEntity<QrCode> addInvisibox(@RequestBody Invisibox invisibox) {
		if(invisiboxRepository.findByBarcodeId(invisibox.getBarcodeId()) != null){
			return new ResponseEntity<QrCode>(HttpStatus.CONFLICT);
		}
		
		invisiboxRepository.save(invisibox);
		return new ResponseEntity<QrCode>(createQRCode(invisibox.getBarcodeId()), HttpStatus.CREATED);
	}

	public QrCode createQRCode(String qrCodeData){
		String charset = "UTF-8"; // or "ISO-8859-1"
		Map<EncodeHintType, ErrorCorrectionLevel> hintMap 
			= new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		BitMatrix matrix = null;
		try {
			matrix = new MultiFormatWriter().encode(
					new String(qrCodeData.getBytes(charset), charset),
						BarcodeFormat.QR_CODE, 200, 200, hintMap);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (WriterException e) {
			e.printStackTrace();
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			MatrixToImageWriter.writeToStream(matrix, "jpg", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new QrCode("data:image/jpeg;base64,"+ Base64.encodeBase64String(baos.toByteArray()));
	}

}
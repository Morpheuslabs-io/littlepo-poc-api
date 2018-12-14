package com.littlepo.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.common.io.Files;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.littlepo.data.QrData;
import com.littlepo.data.UploadFileResponse;
import com.littlepo.service.FileStorageService;
import com.littlepo.service.QrCodeService;
import com.littlepo.utils.IDGenerator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/qrcode/")

public class QrCodeAPI {

    @Autowired
	QrCodeService qrCodeService;
    @Autowired
    FileStorageService fileStorageService;
    
	@RequestMapping(method = RequestMethod.POST, path = "/generate", produces = MediaType.IMAGE_PNG_VALUE)
	@ApiOperation(value = "generateQrCode",
    notes = "This will generate and return a QR code image.")
	public ResponseEntity<byte[]> generateQRCodeImage(@RequestBody QrData qrData) {
		try {
			String qrString = qrData.getQrString();
			byte[] qrCode = qrCodeService.generateQRcode(qrString);
			
			return ResponseEntity.ok().body(qrCode);
		} catch (Exception ex) {
			throw new InternalServerError("Error while generating bQR code image.", ex);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/download")
	@ApiOperation(value = "downloadQrCode",
    notes = "This will generate and download a QR code image.")
	public ResponseEntity<Resource> downloadQRCodeImage(@RequestBody QrData qrData) {
		try {
			String qrString = qrData.getQrString();
			byte[] qrCode = qrCodeService.generateQRcode(qrString);
			String fileName = qrString;
			File file = new File(fileName);
			Files.write(qrCode, file);
			fileStorageService.storeFile(file);
			Resource resource = fileStorageService.loadFileAsResource(fileName);
	        return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(MediaType.IMAGE_PNG_VALUE))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
	                .body(resource);
			
		} catch (Exception ex) {
			throw new InternalServerError("Error while generating QR code image.", ex);
		}
	}
	
    @PostMapping("read")
	@ApiOperation(value = "readQrCode",
    notes = "This will read a QR code file and return the data encoded in the QR code.")
    public  String readQrCode(@RequestParam("QrCodeFile") MultipartFile qrCodeFile) {
        try {
        	String fileName = qrCodeFile.getOriginalFilename();
        	File qrFile = new File(fileName);
        	FileOutputStream fos = new FileOutputStream(qrFile);
            fos.write(qrCodeFile.getBytes());
            fos.close();
            
            String qrText = qrCodeService.readQRCode(qrFile);
            return qrText;
            

        } catch (Exception ex) {
			throw new InternalServerError("Error while reading QR code image.", ex);
		}
    }
    
    
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public class InternalServerError extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public InternalServerError(final String message, final Throwable cause) {
			super(message);
		}

	}

 
}


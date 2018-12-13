package com.littlepo.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.littlepo.data.QrData;
import com.littlepo.utils.SeqGenerator;
import com.littlepo.utils.IDGenerator;

@Service
public class QrCodeService {
	
	public void generateQRcodeTest(String qrData) throws WriterException, IOException {
		
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		// qrData = "JavaSampleApproach\nJava Technology, Spring Framework";
		BitMatrix bitMatrix = qrCodeWriter.encode(qrData, BarcodeFormat.QR_CODE, 350, 350); // width x height
		Path path = FileSystems.getDefault().getPath("JSA-QRCode.png");
		System.out.println("path: " + path);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}
	
	public byte[] generateQRcode(String qrString) throws WriterException, IOException {
		
		// Gson gson = new Gson();
		// String qrString = gson.toJson(qrData);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		BitMatrix matrix = new MultiFormatWriter().encode(qrString, BarcodeFormat.QR_CODE, 220, 220);
		MatrixToImageWriter.writeToStream(matrix, MediaType.IMAGE_PNG.getSubtype(), baos, new MatrixToImageConfig());
		return baos.toByteArray();
	}
	
	public String readQRCode(File qrFile) throws NotFoundException, IOException {
		BufferedImage bufferedImg = ImageIO.read(qrFile);
		
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImg);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
 
		Result result = new MultiFormatReader().decode(bitmap);
		return result.getText();
	}
	
	public String readQRcodeTest() throws NotFoundException, IOException {
		File QRfile = new File("JSA-QRCode.png");
		 
		BufferedImage bufferedImg = ImageIO.read(QRfile);
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImg);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
 
		Result result = new MultiFormatReader().decode(bitmap);
 
		System.out.println("Barcode Format: " + result.getBarcodeFormat());
		System.out.println("Content: " + result.getText());
		return result.getText();
	}
	
}
	

	





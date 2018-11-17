package com.littlepo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class IDGenerator {
	
	private static AtomicLong dQrCodeIdCounter = new AtomicLong();
	private static AtomicLong bQrCodeIdCounter = new AtomicLong();
	private static AtomicLong dxQrCodeIdCounter = new AtomicLong();
	private static AtomicLong gQrCodeIdCounter = new AtomicLong();
	private static AtomicLong iQrCodeIdCounter = new AtomicLong();
	private static String dBatchNoString = "D-" + getDateString();
	private static String bBatchNoString = "B-" + getDateString();

	
	public static String getUUID() {
		UUID id = UUID.randomUUID();
		String uuid = id.toString();
		return uuid;
		
	}

	public static String createBQrCodeID()
	{
		String prefix = getDateTimeString();
		return String.valueOf("BQ" + prefix + bQrCodeIdCounter.getAndIncrement());
	}
	
	public static String createDQrCodeID()
	{
		String prefix = getDateTimeString();
		return String.valueOf("DQ" + prefix + dQrCodeIdCounter.getAndIncrement());
	}
	
	public static String createDxQrCodeID()
	{
		String prefix = getDateTimeString();
		return String.valueOf("DXQ" + prefix + dxQrCodeIdCounter.getAndIncrement());
	}
	
	public static String createGQrCodeID()
	{
		String prefix = getDateTimeString();
		return String.valueOf("GQ" + prefix + gQrCodeIdCounter.getAndIncrement());
	}
	
	public static String createIQrCodeID()
	{
		String prefix = getDateTimeString();
		return String.valueOf("IQ" + prefix + iQrCodeIdCounter.getAndIncrement());
	}
	
	public static String createDBatchNo(String productID)
	{
		return productID + "-" + dBatchNoString;
	}
	
	public static String createBBatchNo(String productID)
	{

		return productID + "-" + bBatchNoString;
	}
	
	private static String getDateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMdd");
		String date = sdf.format(new Date()); 
		return date;
	}
	private static String getDateTimeString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMddHHmm");
		String date = sdf.format(new Date()); 
		return date;
	}

}

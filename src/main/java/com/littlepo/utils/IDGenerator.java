package com.littlepo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class IDGenerator {
	
	private static AtomicLong dQrCodeIdCounter = new AtomicLong();
	private static AtomicLong bQrCodeIdCounter = new AtomicLong();
	private static AtomicLong dxQrCodeIdCounter = new AtomicLong();
	private static AtomicLong dBatchNoCounter = new AtomicLong();
	private static AtomicLong bBatchNoCounter = new AtomicLong();

	
	public static String getUUID() {
		UUID id = UUID.randomUUID();
		String uuid = id.toString();
		return uuid;
		
	}

	public static String createBQrCodeID()
	{
		String prefix = getDateString();
		return String.valueOf("BQ" + prefix + bQrCodeIdCounter.getAndIncrement());
	}
	
	public static String createdDQrCodeID()
	{
		String prefix = getDateString();
		return String.valueOf("DQ" + prefix + dQrCodeIdCounter.getAndIncrement());
	}
	
	public static String createDxQrCodeID()
	{
		String prefix = getDateString();
		return String.valueOf("DXQ" + prefix + dxQrCodeIdCounter.getAndIncrement());
	}
	
	public static String createDBatchNo()
	{
		String prefix = getDateString();
		return String.valueOf("DB" + prefix + dBatchNoCounter.getAndIncrement());
	}
	
	public static String createBBatchNo()
	{
		String prefix = getDateString();
		return String.valueOf("BB" + prefix + bBatchNoCounter.getAndIncrement());
	}
	
	private static String getDateString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMddHHmm");
		String date = sdf.format(new Date()); 
		return date;
	}

}

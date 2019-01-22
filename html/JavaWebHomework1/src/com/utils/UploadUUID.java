package com.utils;
import java.util.UUID;
public class UploadUUID {

	public static String getUUIDFileName(String filename) {
		String name = filename.substring(filename.indexOf('.'));
		name = UUID.randomUUID().toString() + name;
		name = name.replace("-", "");
		return name;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

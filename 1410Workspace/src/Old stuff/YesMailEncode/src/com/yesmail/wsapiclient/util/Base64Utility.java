package com.yesmail.wsapiclient.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;


/**
 * A helper class that encodes and decodes data using the base64
 * encoding scheme.
 *
 * @author Yesmail
 * @version 1.0
 */
public class Base64Utility {

  /**
     * Encodes a string into base64 format.
     * No blanks or line breaks are inserted.
     *
     * @param data The String to be encoded.
     * @return A String with the base64 encoded data.
     */
    public static String encode(String data) {
        return new String(Base64.encodeBase64(data.getBytes()));
    }

  /**
     * Encodes a byte array into base64 format.
     * No blanks or line breaks are inserted.
     *
     * @param dataBytes The byte array to be encoded.
     * @return A String with the base64 encoded data.
     */
    public static String encode(byte[] dataBytes) {
        return new String(Base64.encodeBase64(dataBytes));
    }

  /**
     * Converts a zip file into a byte array.
     * No blanks or line breaks are inserted.
     *
     * @param filePath The zip file to be encoded.
     * @return A byte array of the zip file.
     */
    public static byte[] fileToByteArray(String filePath) {
    	try {
			return FileUtils.readFileToByteArray(new File(filePath));
		} catch (IOException e) {
			throw new RuntimeException("Problem reading file " + filePath, e);
		}
    }

   /**
     * Decodes a Base64 string.
     *
     * @param data A base64 String to be decoded.
     * @return A String containing the decoded data.
     */
    public static String decode(String data) {
    	return new String(Base64.decodeBase64(data.getBytes()));
    }
    
}


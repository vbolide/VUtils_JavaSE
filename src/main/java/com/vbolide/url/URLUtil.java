package com.vbolide.url;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vbolide.exception.InvalidParameterException;
import com.vbolide.validation.ValidationUtil;

/**
 * Utility class for {@linkplain URL} related requirements.
 * 
 * @author Vamshi Byagari
 */
public class URLUtil {

	/**
	 * regex that remove Protocol and WWW if exists
	 */
	public static final String DOMAIN_REGEX = "^(?:https?:\\/\\/)?(?:[^@\\/\\n]+@)?(?:m\\.)?(?:www[0-9]*?\\.)?([^:\\/\\n]+)";


	private URLUtil() {}


	/**
	 * encodes the url with {@code UTF_8} character encoding
	 * @param url url to be encoded
	 * @throws InvalidParameterException when any of the parameter passed are invalid.
	 * @throws UnsupportedEncodingException if the encoding is not supported.
	 */
	public static String encodeURL(final String url) throws InvalidParameterException, UnsupportedEncodingException{
		if(!ValidationUtil.isValidString(url)) {
			throw new InvalidParameterException("input parameter url is invalid");
		}
		return URLEncoder.encode(url, StandardCharsets.UTF_8);
	}
	
	/**
	 * encodes the url
	 * @param url url to be encoded
	 * @param charset any sub class of {@linkplain Charset}
	 * @return encoded url as {@linkplain String}
	 * @throws InvalidParameterException when any of the parameter passed are invalid.
	 * @throws UnsupportedEncodingException if the encoding is not supported.
	 */
	public static String encodeURL(final String url, final Charset charset) throws InvalidParameterException, UnsupportedEncodingException{
		if(!ValidationUtil.isValidString(url)) {
			throw new InvalidParameterException("input parameter url is invalid");
		}
		if(charset == null) {
			throw new InvalidParameterException("input parameter Charset is null");
		}
		return URLEncoder.encode(url, charset);
	}

	/**
	 * decodes the url with {@code UTF_8} character decoding
	 * @param url url to be decoded
	 * @return decoded url as {@linkplain String}
	 * @throws InvalidParameterException when any of the parameter passed are invalid
	 * @throws UnsupportedEncodingException if the decoding is not supported.
	 */
	public static String decodeURL(final String url) throws InvalidParameterException, UnsupportedEncodingException{
		if(!ValidationUtil.isValidString(url)) {
			throw new InvalidParameterException("input parameter url is invalid");
		}
		return URLDecoder.decode(url, StandardCharsets.UTF_8);
	}

	/**
	 * decodes the url
	 * @param url url to be decoded
	 * @param charset any sub class of {@linkplain Charset}
	 * @return decoded url as {@linkplain String}
	 * @throws InvalidParameterException when any of the parameter passed are invalid
	 * @throws UnsupportedEncodingException if the decoding is not supported.
	 */
	public static String decodeURL(final String url, final Charset charset) throws InvalidParameterException, UnsupportedEncodingException{
		if(!ValidationUtil.isValidString(url)) {
			throw new InvalidParameterException("input parameter url is invalid");
		}
		if(charset == null) {
			throw new InvalidParameterException("input parameter Charset is null");
		}
		return URLDecoder.decode(url, charset);
	}

	/**
	 * This method will return full {@linkplain URL} by excluding {@linkplain java.net.URI} part from the argument.
	 * @param url url to be processed.
	 * @return {@linkplain URL} by excluding {@linkplain java.net.URI} or null if unable to do so.
	 */
	public static String getFullDomain(final String url) throws InvalidParameterException{
		if(!ValidationUtil.isValidString(url)) {
			throw new InvalidParameterException("input parameter url is invalid");
		}
		Pattern pattern = Pattern.compile(DOMAIN_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			return matcher.group(0);
		}else {
			return null;
		}
	}


	/**
	 * This method will return {@linkplain URL} by excluding ({@linkplain java.net.URI}, protocol, and WWW if exists) part from the argument.
	 * @param url url to be processed.
	 * @return {@linkplain URL} by excluding ({@linkplain java.net.URI}, protocol, and WWW if exists) or null if unable to do so.
	 */
	public static String getDomainAndSubDomain(final String url) throws InvalidParameterException{
		if(!ValidationUtil.isValidString(url)) {
			throw new InvalidParameterException("input parameter url is invalid");
		}
		Pattern pattern = Pattern.compile(DOMAIN_REGEX, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			return matcher.group(1);
		}else {
			return null;
		}
	}


	/**
	 * This method will return {@linkplain URL} by excluding (Protocol and WWW if exists) part from the argument.
	 * @param url url to be processed.
	 * @return {@linkplain URL} by excluding (Protocol, and WWW if exists) or null if unable to do so.
	 */
	public static String getDomainAndSubDomainWithURI(final String url) throws InvalidParameterException{
		if(!ValidationUtil.isValidString(url)) {
			throw new InvalidParameterException("input parameter url is invalid");
		}
		String path = "";
		try {
			path = new URL(url.endsWith("/") ? url.substring(0, url.length()-1) : url).getPath();
		} catch (Exception e) {}
		return getDomainAndSubDomain(url)+path;
	}


}
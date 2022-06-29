package com.vbolide.image;

import java.awt.Color;
import java.awt.image.BufferedImage;

import com.vbolide.exception.InvalidParameterException;

/**
 * Utility class for image processing related requirements.
 * 
 * @author Vamshi Byagari
 */
public class ImageUtil {

	private ImageUtil() { }

	/**
	 * Converters the input {@linkplain BufferedImage} to JPEG format {@linkplain BufferedImage}.
	 * 
	 * @param bufferedImage - an instance of {@linkplain BufferedImage}.
	 * @return {@linkplain BufferedImage} which is of type JPEG format.
	 * @throws Exception - when the conversion fails.
	 */
	public static BufferedImage getJPGImage(final BufferedImage bufferedImage) throws InvalidParameterException, Exception{
		if(bufferedImage == null) {
			throw new InvalidParameterException("input parameter BufferedImage instace is null");
		}
		if(BufferedImage.TYPE_INT_RGB == bufferedImage.getType() || BufferedImage.TYPE_3BYTE_BGR == bufferedImage.getType()) {
			return bufferedImage;
		}else {
			System.out.println("Input argument image type: "+bufferedImage.getType());
			BufferedImage resultantBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
			resultantBufferedImage.createGraphics().drawImage(bufferedImage, 0, 0, Color.WHITE, null);
			return resultantBufferedImage;
		}
	}
}
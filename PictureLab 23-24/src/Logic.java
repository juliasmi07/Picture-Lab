
import java.awt.Color;

public class Logic {
	
	/**
	 * Alters the picture so that each pixel's blue channel has been zeroed out.
	 * All other channels remain the same 
	 * @param picture the image to be altered
	 */
	public static void zeroBlue(DigitalPicture picture) {
		
		//obtain the 2d arrayof the picture
		Pixel[][] pixel2D = picture.getPixels2D();
		
		//traverse the pixels and alter their values per filter
		for (int r = 0; r < pixel2D.length; r++) {
			for (int c = 0; c < pixel2D[r].length; c++) {
				pixel2D[r][c].setRed(0);				
			}
		}
		
	}
	public static void blackAndWhite(DigitalPicture p) {
		
	//1 obtain a 2D rect of the pixels that we can travrese
	Pixel[][] pixel2D = p.getPixels2D();
	
	for(int r = 0; r < pixel2D.length; r++) {
		for(int c = 0; c < pixel2D[r].length; c++) {
			int avg = (int) pixel2D[r][c].getAverage();
			pixel2D[r][c].setRed(avg);
			pixel2D[r][c].setBlue(avg);
			pixel2D[r][c].setGreen(avg);
		}
	}
	}
	
	public static void negative(DigitalPicture p) {
	Pixel[][] pixel2D = p.getPixels2D();
	for(int r = 0; r < pixel2D.length; r++) {
		for(int c = 0; c < pixel2D[r].length; c++) {
		pixel2D[r][c].setGreen(225-pixel2D[r][c].getGreen());
		pixel2D[r][c].setBlue(225-pixel2D[r][c].getBlue());
		pixel2D[r][c].setRed(225-pixel2D[r][c].getRed());

		}
	}
	}

	
	public static void mirrorVertical(DigitalPicture p) {
	Pixel[][] pixel2D = p.getPixels2D();
	for(int c = 0; c < pixel2D.length; c++) {
		for(int r = 0; r < pixel2D[c].length; r++) {
		pixel2D[r][c].setBlue(pixel2D[pixel2D.length-r][c].getBlue());
		pixel2D[r][c].setRed(pixel2D[pixel2D.length-r][c].getRed());
		pixel2D[r][c].setGreen(pixel2D[pixel2D.length-r][c].getGreen());

			}
	}
	}	
	

	
	
	public static void mirrorHorizontal(DigitalPicture p) {
	Pixel[][] pixel2D = p.getPixels2D();
	for(int r = 0; r < pixel2D.length; r++) {
		for(int c = 0; c < pixel2D[r].length ; c++) {
		pixel2D[r][c].setBlue  (pixel2D[r][pixel2D[r].length-c].getBlue());
		pixel2D[r][c].setRed(pixel2D[r][pixel2D[r].length-c].getRed());
		pixel2D[r][c].setGreen(pixel2D[r][pixel2D[r].length-c].getGreen());
			}
		}
	}
	
	public static void blur(DigitalPicture p) {
	Pixel[][] pixel2D = p.getPixels2D();

	int radius = 3;
	for(int r = 0; r < pixel2D.length; r++) {
		for(int c = 0; c < pixel2D[r].length ; c++) {	
	pixel2D[r][c].setBlue  (pixel2D[r][pixel2D[r].length-c].getBlue());

		
		}
	}
	}
	
	
	
}
//	/**
//	 * Alters the picture so that is is black and white by setting each pixels color value to be the average
//	 * of the pixels red, green, and blue channel. 
//	 * @param picture,  the image to be altered
//	 */
//	public static void ????(??? ???) {
//		
//		
//		
//	}





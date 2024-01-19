
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
	
	
	public static void makeSunset(DigitalPicture p, double rr, double gb) {
	Pixel[][] pixel2D = p.getPixels2D();
	for(int r = 0; r < pixel2D.length; r++) {
		for(int c = 0; c < pixel2D[r].length; c++) {
	int red = (int)((int)pixel2D[r][c].getRed()*rr);
	int green = (int)((int)pixel2D[r][c].getGreen()*rr);
	int blue = (int)((int)pixel2D[r][c].getBlue()*rr);
	
	pixel2D[r][c].setGreen(green);
	pixel2D[r][c].setBlue(blue);
	pixel2D[r][c].setRed(red);
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

	
	/*
	 * public static void mirrorVertical(DigitalPicture p) {
	 * Pixel[][] pixel2D = p.getPixels2D();
	for(int c = 0; c < pixel2D[0].length /2; c++) {
		for(int r = 0; r < pixel2D.length; r++) {
		pixel2D[r][c].setBlue(pixel2D[pixel2D.length-r][c].getBlue());
		pixel2D[r][c].setRed(pixel2D[pixel2D.length-r][c].getRed());
		pixel2D[r][c].setGreen(pixel2D[pixel2D.length-r][c].getGreen());

			}
	}
	}
	 */
	public static void mirrorVertical(DigitalPicture p) {
		Pixel[][] pixel2D = p.getPixels2D();
		int v = pixel2D.length-1;
		for(int r = 0; r < pixel2D.length/2; r++) {
			for(int c = 0; c < pixel2D[r].length; c++) {
		int red = pixel2D[r][c].getRed();
		int green = pixel2D[r][c].getGreen();
		int blue = pixel2D[r][c].getBlue();

		pixel2D[r][c].setBlue(pixel2D[v][c].getBlue());
		pixel2D[r][c].setRed(pixel2D[v][c].getRed());
		pixel2D[r][c].setGreen(pixel2D[v][c].getGreen());

		
		pixel2D[v][c].setBlue(blue);
		pixel2D[v][c].setRed(red);
		pixel2D[v][c].setGreen(green);


					}	
			v--;

		}

	}
	

	public static void mirrorHorizontal(DigitalPicture p) {
	Pixel[][] pixel2D = p.getPixels2D();
	int t = pixel2D[0].length-1;
	for(int c = 0; c < pixel2D[0].length/2; c++) {
		for(int r = 0; r < pixel2D.length; r++) {
	int red = pixel2D[r][c].getRed();
	int green = pixel2D[r][c].getGreen();
	int blue = pixel2D[r][c].getBlue();
			
	pixel2D[r][c].setBlue(pixel2D[r][t].getBlue());
	pixel2D[r][c].setRed(pixel2D[r][t].getRed());
	pixel2D[r][c].setGreen(pixel2D[r][t].getGreen());
			
	pixel2D[r][t].setBlue(blue);
	pixel2D[r][t].setRed(red);
	pixel2D[r][t].setGreen(green);			
	
		}
		t--;

		}

	}
	
	public static void blur(DigitalPicture p) {
	Pixel[][] pixel2D = p.getPixels2D();
	for(int r = 0; r < pixel2D.length-1; r++) {
		for(int c = 0; c < pixel2D[r].length-1; c++) {
	int red = (pixel2D[r][c].getRed() + pixel2D[r+1][c].getRed() + pixel2D[r+1][c+1].getRed() + pixel2D[r][c+1].getRed())/4;
	int blue = (pixel2D[r][c].getBlue() + pixel2D[r+1][c].getBlue() + pixel2D[r+1][c+1].getBlue() + pixel2D[r][c+1].getBlue())/4;
	int green =( pixel2D[r][c].getGreen()+ pixel2D[r+1][c].getGreen() + pixel2D[r+1][c+1].getGreen() + pixel2D[r+1][c+1].getGreen())/4;
	
	pixel2D[r][c].setRed(red);
	pixel2D[r][c].setGreen(green);
	pixel2D[r][c].setBlue(blue);

	pixel2D[r+1][c].setRed(red);
	pixel2D[r+1][c].setGreen(green);
	pixel2D[r+1][c].setBlue(blue);
	
	pixel2D[r][c+1].setRed(red);
	pixel2D[r][c+1].setGreen(green);
	pixel2D[r][c+1].setBlue(blue);
	
	pixel2D[r+1][c+1].setRed(red);
	pixel2D[r+1][c+1].setGreen(green);
	pixel2D[r+1][c+1].setBlue(blue);
				}	
	}
	}
	public static void sunset(DigitalPicture p) {
	Pixel[][] pixel2D = p.getPixels2D();
	for(int r = 0; r < pixel2D.length-1; r++) {
		for(int c = 0; c < pixel2D[r].length-1; c++) {

		pixel2D[r][c].setBlue(0);
		pixel2D[r][c].setGreen(0);	
		
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





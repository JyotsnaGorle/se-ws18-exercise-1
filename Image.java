
/* Software Engineering 2018/19 WiSe  <Assignment 1 >
  -----------------------------------------------------------------
   Name : YoungmoOh(120205) 
*/
   
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image {
	
	public byte [] data = null; //A public byte array to store raw 24-bit RGB image data
	private int wh, ht;
	BufferedImage img = null;
	File f = null;
	
	
	
	/*
	 * Code taken from the URL below about how the get and set pixel value in java.
	 * https://www.dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
	 */
	 public static void main(String args[])throws IOException{
		    BufferedImage img = null;
		    File f = null;

		    //read image
		    try{
		      f = new File("sample.ppm");
		      img = ImageIO.read(f);
		    }catch(IOException e){
		      System.out.println(e);
		    }

		    //get image width and height
		    int width = img.getWidth();
		    int height = img.getHeight();

		    /**
		     * Since, Sample.jpg is a single pixel image so, we will
		     * not be using the width and height variable in this
		     * project.
		     */

		    //get pixel value
		    int p = img.getRGB(0,0);

		    //get alpha
		    int a = (p>>24) & 0xff;

		    //get red
		    int r = (p>>16) & 0xff;

		    //get green
		    int g = (p>>8) & 0xff;

		    //get blue
		    int b = p & 0xff;

		    /**
		     * to keep the project simple we will set the ARGB
		     * value to 255, 100, 150 and 200 respectively.
		     */
		    a = 255;
		    r = 100;
		    g = 150;
		    b = 200;

		    //set the pixel value
		    p = (a<<24) | (r<<16) | (g<<8) | b;
		    img.setRGB(0, 0, p);

		    //write image
		    try{
		      f = new File("sample.ppm");
		      ImageIO.write(img, "ppm", f);
		    }catch(IOException e){
		      System.out.println(e);
		    }
		  }//main() ends here
	
	public Image(int width, int height){
		
		
		wh=width;
		ht=height;
		
		data =new byte[wh*ht*3];
		
	    
		
	}
	
	
	/*
	 * A method set( int x, int y, int val ) which sets a single pixel at position (x,y) to the RGB value 
	 * represented by val (Note: use zero-based indexing, i.e. the upper left corner pixel has position (0,0). 
	 * Note: only consider the lower 24 bits of val).
	 * https://www.dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
	 */
	
	public void set(int x, int y, int val) {
		
		data[(x*wh*y)*3]=(byte)(val >> 16); //R
        data[(x*wh*y)*3 + 1]=(byte)((val >> 8 ) & 0xff); //G 
        data[(x*wh*y)*3 + 2]=(byte)(val & 0xff); //B 
		

		
	}


	public void write(String filename) {
		
		
	}
	

}

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class Gaussian_Filter_7x7{
	
	public static void Gaussianfilter(BufferedImage img,int kernelwidth,int kernelheight){
		int width=img.getWidth();
		int height=img.getHeight();
		int divideby=kernelheight*kernelwidth;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		
		
		
		for (int i = 0; i < width-kernelwidth; i++) {
			for (int j = 0; j < height-kernelheight; j++) {
				int [] t=new int[kernelheight*kernelwidth];
				double value=0;
				for (int x = 0; x < kernelwidth; x++) {
					for (int y = 0; y < kernelheight; y++) {
						value+=(1.00/divideby)*(new Color(img.getRGB(i+x, j+y)).getRed());
					}
				}
				
				
				
				
				int value1=(int) value;
				
				image.setRGB(i, j, new Color(value1,value1,value1).getRGB());
			}
		}
	
		
		
		File outputfile = new File("gaussian7x7.png");
	    try {
			ImageIO.write(image, "png", outputfile);
			
		} catch (IOException e) {
			
		}
		
	}

	public static void main(String[] args) {
		File f=new File("butterfly_22476.png");
		try {
			BufferedImage img =ImageIO.read(f);
			Gaussianfilter(img,7,7);
		} catch (IOException e) {
			
		}
		
	}
}

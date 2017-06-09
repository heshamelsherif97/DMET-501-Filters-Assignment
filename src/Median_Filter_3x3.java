import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class Median_Filter_3x3 {
	
	public static void medianfilter(BufferedImage img,int kernelwidth,int kernelheight){
		int width=img.getWidth();
		int height=img.getHeight();
		int divideby=kernelheight*kernelwidth;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		
		
		
		for (int i = 0; i < width-kernelwidth; i++) {
			for (int j = 0; j < height-kernelheight; j++) {
				int [] t=new int[kernelheight*kernelwidth];
				int c=0;
				for (int x = 0; x < kernelwidth; x++) {
					for (int y = 0; y < kernelheight; y++) {
						
						t[c++]=new Color(img.getRGB(i+x, j+y)).getRed();
					}
				}
				
				Arrays.sort(t);
				int value=t[t.length/2];
				image.setRGB(i+kernelwidth/2, j+kernelheight/2, new Color(value,value,value).getRGB());
			}
		}
	
		
		
		File outputfile = new File("median3x3.png");
	    try {
			ImageIO.write(image, "png", outputfile);
			
		} catch (IOException e) {
			
		}
		
	}

	public static void main(String[] args) {
		File f=new File("butterfly_22476.png");
		try {
			BufferedImage img =ImageIO.read(f);
			medianfilter(img,3,3);
		} catch (IOException e) {
			
		}
		
	}
}

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class Mean_Filter_7x7 {
	
	public static void meanfilter(BufferedImage img,int kernelwidth,int kernelheight){
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
				
				int average=0;
				for (int k = 0; k < t.length; k++) {
					average+=t[k];
				}
				average/=divideby;
				image.setRGB(i+kernelwidth/2, j+kernelheight/2, new Color(average,average,average).getRGB());
			}
		}
	
		
		
		File outputfile = new File("mean7x7.png");
	    try {
			ImageIO.write(image, "png", outputfile);
			
		} catch (IOException e) {
			
		}
		
	}

	public static void main(String[] args) {
		File f=new File("butterfly_22476.png");
		try {
			BufferedImage img =ImageIO.read(f);
			meanfilter(img,7,7);
		} catch (IOException e) {
			
		}
		
	}
}

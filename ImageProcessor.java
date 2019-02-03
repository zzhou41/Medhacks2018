import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class ImageProcessor {
  public ImageProcessor() { }
  public static void main(String[] args) throws IOException{ 
    int index=1;//Index
    BufferedImage image = null;
    File file = null;
    try{
       file = new File("C:/!Daniel/Yellow3.jpg");//MAKE SURE TO CHANGE THE FILE NAME
       image = ImageIO.read(file);
    }
    catch(IOException e){
      System.out.println(e);
    }
    int w = image.getWidth();
    int h = image.getHeight();
    int rsum = 0; int bsum = 0; int gsum = 0;
    for(int x=0;x<w;x++){
      for(int y=0;y<h;y++){
        int p = image.getRGB(x,y);
        int r = (p>>16) & 0xff;
        int g = (p>>8) & 0xff;
        int b = p & 0xff;
        rsum +=r;
        bsum +=b;
        gsum +=g;
      }}
    int ravg = rsum/(h*w);
    int gavg = gsum/(h*w);
    int bavg = bsum/(h*w);
    int avgavg = (ravg+bavg+gavg)/3;
    if(avgavg<256 && avgavg>233){index = 6;}
    if(avgavg<=233 && avgavg>210){index = 5;}
    if(avgavg<=210 && avgavg>190){index = 4;}
    if(avgavg<=190 && avgavg>170){index = 3;}
    if(avgavg<=170&& avgavg>50){index = 2;}
    if(avgavg<=50){index = 1;}
    System.out.println(index);
  }}

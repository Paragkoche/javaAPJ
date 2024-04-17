
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.*;

public class main {
public static void main(String args[]) throws IOException
{
DataInputStream in=new DataInputStream(System.in);
String s;
int w;
BufferedImage img=ImageIO.read(new File("x1.jpg"));
for(w=0;w<img.getWidth();w++)
{
for(int h=0;h<img.getHeight();h++)
{
Color oc=new Color(img.getRGB(w,h));
int avg=((oc.getRed()+oc.getGreen()+oc.getBlue())/3);
Color cc=new Color(avg,avg,avg);
img.setRGB(w,h,cc.getRGB());
}
}
System.out.println("Enter the Output FileName:");
s=in.readLine();
ImageIO.write(img,".jpg",new File(s+".jpg"));
System.out.println("RGB image x1.jpg was successfully converted to Grayscale
image stored in filename="+s+".jpg");

}
}
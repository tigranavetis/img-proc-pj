public import ij.ImagePlus;
import ij.process.ImageProcessor;
import ij.plugin.filter.PlugInFilter;
import java.awt.Color;

public class Binary_Layer_3 implements PlugInFilter {
 public double bottom(int x) {
  return -0.0013 * x * x + 1.2608 * x + 12.067;
 }
 public double top(int x) {
  return -0.0026 * x * x + 1.5713 * x + 14.8;
 }
 public int setup(String args, ImagePlus im) {
  return DOES_RGB;
 }
 public void run(ImageProcessor ip) {
  int width = ip.getWidth(), height = ip.getHeight(), pixel, r, g, b;
  double rb;
  Color color;
  for (int row = 0; row < height; row++)
   for (int col = 0; col < width; col++) {
    color = new Color(ip.getPixel(col, row));
    r = color.getRed();
    g = color.getGreen();
    b = color.getBlue();
    rb = (r + b) / 2.;
    if (b < g && g < r && rb >= bottom(g) && rb <= top(g))
     ip.putPixel(col, row, 0); //BLACK
    else
     ip.putPixel(col, row, 16777215); //WHITE
   }
 }
}class Binary_Layer_3 {
  
}
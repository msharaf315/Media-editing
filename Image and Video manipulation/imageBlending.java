import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class imageBlending {
	static String sharaf ="src/Assigment 2/sharaf2.png";
	
	
	
	public static BufferedImage changeInt(BufferedImage image,double x) throws IOException{
		int s=0;
		BufferedImage sharaf2= new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
		for(int j=0;j<image.getHeight();j++){
			for(int i=0;i<image.getWidth();i++){
				Color c= new Color(image.getRGB(i, j));
				int red= (int) (c.getRed()*x);
				int green= (int) (c.getGreen()*x);
				int blue= (int) (c.getBlue()*x);
				Color v = new Color(red,green,blue);
				sharaf2.setRGB(i,j,v.getRGB());
				
			}
		}
		
		File outputfile = new File("src/Assignment 2/"+s+ "halfandhaflimage.png");
		ImageIO.write(sharaf2,"png",outputfile);
		s+=1;
		return sharaf2;
	
	}
	
	
	public static BufferedImage resize(BufferedImage image,int targetWidth,int targetHeight){
		Image temp= image.getScaledInstance(targetWidth,targetHeight,Image.SCALE_SMOOTH);
		BufferedImage dImage= new BufferedImage (targetWidth,targetHeight,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d= dImage.createGraphics();
		g2d.drawImage(temp, 0, 0,null);
		g2d.dispose();
		return dImage;
		
	}
	public static void sumOfPixels (BufferedImage image1,BufferedImage image2) throws IOException{
		int s= 0;
		BufferedImage sharaf2= new BufferedImage(image1.getWidth(),image1.getHeight(),BufferedImage.TYPE_INT_RGB);
		for(int j=0;j<image1.getHeight();j++){
			for(int i=0;i<image1.getWidth();i++){
				Color c1= new Color(image1.getRGB(i, j));
				Color c2= new Color(image2.getRGB(i, j));
				int red= c1.getRed()+c2.getRed();
				int green= c1.getGreen()+c2.getGreen();
				int blue= c1.getBlue()+c2.getBlue();
				Color X = new Color(red,green,blue);
				sharaf2.setRGB(i,j,X.getRGB());
				
			}
		}
		File outputfile = new File("src/Assignment 2/" +s+ "0.5Image.png");
		ImageIO.write(sharaf2,"png",outputfile);
		s+=1;
		
	}
	
	public static ArrayList<BufferedImage> loadFrames() throws IOException{
		ArrayList<BufferedImage> x =new ArrayList<BufferedImage>() ;
		for(int i =225;i<257;i++){
			String loc =""+i;
			BufferedImage z = ImageIO.read(new File("src/Assignment 2/imageSeq/RuskaUfer23-"+loc+".jpg"));
			x.add(z);
		}
	
		return x;
		
	}
	
  public static ArrayList<BufferedImage> temporal(ArrayList<BufferedImage> frames) throws IOException{
	  ArrayList<BufferedImage> x = new ArrayList<BufferedImage>();
	  int s=0;
	  for(int m=0;m<frames.size();m+=2){
		  BufferedImage image = frames.get(m);
       x.add(image);
       File outputfile = new File("src/s f 1/temporal/"+Integer.toString(s)+".jpg");
		ImageIO.write(image,"jpg",outputfile);
		s+=1;
       x.add(image);
       File outputfile1 = new File("src/s f 1/temporal/"+Integer.toString(s)+".jpg");
		ImageIO.write(image,"jpg",outputfile1);
		s+=1;
	  }
	  if(frames.size()%2!=0){
		  BufferedImage image = frames.get(frames.size());
		  x.add(image);
		  File outputfile1 = new File("src/s f 1/temporal/"+Integer.toString(s)+".jpg");
			ImageIO.write(image,"jpg",outputfile1);
		  
	  }
	 return x; 
  }
  
  public static ArrayList<BufferedImage> temporal2(ArrayList<BufferedImage> frames) throws IOException{
	  ArrayList<BufferedImage> x = new ArrayList<BufferedImage>();
	  int s=0;
	 
	  if(frames.size()%3==0){
		  for(int m=0;m<frames.size();m+=3){
			  BufferedImage image = frames.get(m);
	       x.add(image);
	       File outputfile = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
			ImageIO.write(image,"jpg",outputfile);
			s+=1;
	       x.add(image);
	       File outputfile1 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
			ImageIO.write(image,"jpg",outputfile1);
			s+=1;
			x.add(image);
		       File outputfile2 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
				ImageIO.write(image,"jpg",outputfile1);
				s+=1;
		  }
	  }
		  else{
			  for(int m=0;m<frames.size();m+=3){
				  
				  if(m+5>frames.size()){
						if(m+4>frames.size()){
							BufferedImage image = frames.get(m);
						       x.add(image);
						       File outputfile = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
								ImageIO.write(image,"jpg",outputfile);
								s+=1;
						       x.add(image);
						       File outputfile1 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
								ImageIO.write(image,"jpg",outputfile1);
								s+=1;
								x.add(image);
							       File outputfile2 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
									ImageIO.write(image,"jpg",outputfile1);
									s+=1;
									BufferedImage image1=frames.get(m+1);
									x.add(image1);
									File outputfile3 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
									ImageIO.write(image,"jpg",outputfile);
									s+=1;	
						}
						else{
							BufferedImage image = frames.get(m);
						       x.add(image);
						       File outputfile = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
								ImageIO.write(image,"jpg",outputfile);
								s+=1;
						       x.add(image);
						       File outputfile1 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
								ImageIO.write(image,"jpg",outputfile1);
								s+=1;
								x.add(image);
							       File outputfile2 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
									ImageIO.write(image,"jpg",outputfile1);
									s+=1;
									BufferedImage image1=frames.get(m+1);
									x.add(image1);
									File outputfile3 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
									ImageIO.write(image,"jpg",outputfile);
									s+=1;	
									x.add(image1);
									File outputfile4 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
									ImageIO.write(image,"jpg",outputfile);
									s+=1;
						}
					  
					}
				  else{
					  BufferedImage image = frames.get(m);
				       x.add(image);
				       File outputfile = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
						ImageIO.write(image,"jpg",outputfile);
						s+=1;
				       x.add(image);
				       File outputfile1 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
						ImageIO.write(image,"jpg",outputfile1);
						s+=1;
						x.add(image);
					       File outputfile2 = new File("src/s f 1/double temporal/"+Integer.toString(s)+".jpg");
							ImageIO.write(image,"jpg",outputfile1);
							s+=1;
							BufferedImage image1=frames.get(m+1);
					  
				  }
				  
				  
			  }
			  
		  }
		  
		  
		  
		  
	  
	 return x; 
  }
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<BufferedImage> downsampleframes(ArrayList<BufferedImage> frames) throws IOException{
	  ArrayList<BufferedImage> x = new ArrayList<BufferedImage>();
	  int s=0;
	  for(int m=0;m<frames.size();m++){
		  BufferedImage image = frames.get(m);
		  for(int i=0;i<image.getHeight();i+=2){
			  
			  
			  for(int j=0;j<image.getHeight();j+=2){
				if(j+1>image.getHeight()&&i+1>image.getWidth()){
					
					
				}
			  else{
				  image.setRGB(i+1, j+1,image.getRGB(i,j)); 
			  }
				  
				  if (j+1>image.getHeight()){  
				  }
				  else{
					  image.setRGB(i, j+1,image.getRGB(i,j));
				  }
				  if(i+1>image.getWidth()){
					   
				  }
				  else{
					  image.setRGB(i+1, j,image.getRGB(i,j));
				  }
			  
			  } 
			  
		  }
		  
		  File outputfile = new File("src/s f 1/"+Integer.toString(s)+".jpg");
			ImageIO.write(image,"jpg",outputfile);
		  x.add(image);
		  s+=1;
	  }
	  return x;
  }
	
	
	
	
	
	
	
	public static void plus50(BufferedImage image) throws IOException{
		BufferedImage sharaf2= new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
		int s =0;
		for(int j=0;j<image.getHeight();j++){
			for(int i=0;i<image.getWidth();i++){
				Color c= new Color(image.getRGB(i, j));
				int red= (int) (c.getRed());
				int green= (int) (c.getGreen());
				int blue= (int) (c.getBlue());
				red+=50;
				green+=50;
				blue+=50;
				if(red>255)
					red=255;
				if(green>255)
					green=255;
				if(blue>255)
					blue=255;
				
				Color v = new Color(red,green,blue);
				sharaf2.setRGB(i,j,v.getRGB());
				
			}
		}
		
		File outputfile = new File("src/Assignment 2/"+Integer.toString(s)+"enchantedimagre.png");
		ImageIO.write(sharaf2,"png",outputfile);
		 s+=1;
	
	}
	
	public static void squareEnchant(BufferedImage image) throws IOException{
		BufferedImage sharaf2= new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
		int s =0;
		for(int j=0;j<image.getHeight();j++){
			for(int i=0;i<image.getWidth();i++){
				Color c= new Color(image.getRGB(i, j));
				int red= (int) (c.getRed());
				int green= (int) (c.getGreen());
				int blue= (int) (c.getBlue());
				red=red*red;
				green=green*green;
				blue=blue*blue;
				if(red>255)
					red=255;
				if(green>255)
					green=255;
				if(blue>255)
					blue=255;
				
				Color v = new Color(red,green,blue);
				sharaf2.setRGB(i,j,v.getRGB());
				
			}
		}
		
		File outputfile = new File("src/Assignment 2/"+Integer.toString(s)+"squareEnchanted.png");
		ImageIO.write(sharaf2,"png",outputfile);
		 s+=1;
	
	}
	
	public static void rootEnchant(BufferedImage image) throws IOException{
		BufferedImage sharaf2= new BufferedImage(image.getWidth(),image.getHeight(),BufferedImage.TYPE_INT_RGB);
		int s =0;
		for(int j=0;j<image.getHeight();j++){
			for(int i=0;i<image.getWidth();i++){
				Color c= new Color(image.getRGB(i, j));
				int red= (int) (c.getRed());
				int green= (int) (c.getGreen());
				int blue= (int) (c.getBlue());
				red=(int) Math.sqrt(red);
				green=(int) Math.sqrt(green);
				blue=(int) Math.sqrt(blue);
				if(red>255)
					red=255;
				if(green>255)
					green=255;
				if(blue>255)
					blue=255;
				
				Color v = new Color(red,green,blue);
				sharaf2.setRGB(i,j,v.getRGB());
				
			}
		}
		
		File outputfile = new File("src/Assignment 2/"+Integer.toString(s)+"squareRooted.png");
		ImageIO.write(sharaf2,"png",outputfile);
		 s+=1;
	
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[]) throws IOException{
		 BufferedImage image1 = ImageIO.read(new File("src/Assignment 2/input.png"));
	      BufferedImage image2 = ImageIO.read(new File("src/Assignment 2/text.png"));
	      BufferedImage bigSample = resize(image2,image1.getWidth(),image1.getHeight());
	      
	      BufferedImage halfImage1 = changeInt(image1,0.5);
	      BufferedImage halfImage2 = changeInt(bigSample,0.5);
	      sumOfPixels(halfImage1,halfImage2);
	      
	      BufferedImage base = changeInt(image1,0.7);
	      BufferedImage watermark = changeInt(bigSample,0.3);
	      sumOfPixels(base,watermark);
	      
	      ArrayList<BufferedImage> frames = loadFrames();
	      System.out.println(frames.size());
	      ArrayList<BufferedImage> Sframes =downsampleframes(frames);
	      ArrayList<BufferedImage> temporalframes =temporal(frames);
	      ArrayList<BufferedImage> temporalframes2 =temporal2(frames);
	      plus50(image1);
	      squareEnchant(image1);
	      rootEnchant(image1);
	      
	      
	      
	      
	  
	      
	      
	      
	      
	}
	
	









}
    
  

	




package OCR;

import MainPage.ChoosePanel;
import com.lizardtech.djview.frame.GetDir;
import com.lizardtech.djvubean.RibbonMenu.DjvuComponents;


import java.awt.Color;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class OCROnTiFImage extends JFrame {
     public static String show;
    JTextArea textArea = new JTextArea("please wait Your Text appear here ");
    JScrollPane scrollPane = new JScrollPane(textArea);
    String line = "";
    String tessarctPath="";
    String path="";
    
    public OCROnTiFImage(){}

    //OCR ON English Text
   public  OCROnTiFImage(int x,int y,int w,int h) 
    {
	   
	  // this.getClass().get
	    try {
			 path=GetDir.getDir();
		    }
	    catch (IOException e1) 
	    {
			e1.printStackTrace();
		} catch (InterruptedException e1)
	    {
			e1.printStackTrace();
		}
        tessarctPath=path; 
	   
	   try 
         {
        	 
            final Process p = Runtime.getRuntime().exec(tessarctPath+"\\tesseract.exe cropImage.png output");
            p.waitFor();
            JFrame f= new JFrame();
            //f.setLocation(x+w,y+h);
            f.setSize(300,150);
            f.setLocationRelativeTo(null);
            f.setTitle("OCR English");
            f.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/DjvuIcon.png")));
            f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            File file = new File("output.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) 
            {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            fileReader.close();
            // JOptionPane.showMessageDialog(null, stringBuffer.toString());
            textArea.setBackground(Color.RED);
            textArea.setForeground(Color.BLACK);
            textArea.setText(stringBuffer.toString());
            textArea.setForeground(Color.WHITE);
            f.add(scrollPane);
            f.setVisible(true);
            show=stringBuffer.toString();
            System.out.println(stringBuffer.toString());
        
         }
	   catch (IOException e)
	    {
            e.printStackTrace();
        }
	   catch (InterruptedException e) 
         {
            e.printStackTrace();
         }
    }
   
   
 //  ##############################################################################
   public   OCROnTiFImage(int x,int y,int w,int h,int i) 
    {
	   
	  // this.getClass().get
	    try {
			 path=GetDir.getDir();
		    }
	    catch (IOException e1) 
	    {
			e1.printStackTrace();
		} catch (InterruptedException e1)
	    {
			e1.printStackTrace();
		}
        tessarctPath=path; 
	   
	   try 
         {
        	 
            final Process p = Runtime.getRuntime().exec(tessarctPath+"\\tesseract.exe cropImage.png output");
            p.waitFor();
          //  JFrame f= new JFrame();
            //f.setLocation(x+w,y+h);
          //  f.setSize(300,150);
          //  f.setLocationRelativeTo(null);
           // f.setTitle("OCR English");
          //  f.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/DjvuIcon.png")));
          //  f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            File file = new File("output.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) 
            {
                stringBuffer.append(line);
                stringBuffer.append("\n");
            }
            fileReader.close();
            // JOptionPane.showMessageDialog(null, stringBuffer.toString());
          //  textArea.setBackground(Color.RED);
         //  textArea.setForeground(Color.BLACK);
          //  textArea.setText(stringBuffer.toString());
           // textArea.setForeground(Color.WHITE);
            //f.add(scrollPane);
           // f.setVisible(true);
            show=stringBuffer.toString();
            System.out.println(show);
        
         }
	   catch (IOException e)
	    {
            e.printStackTrace();
        }
	   catch (InterruptedException e) 
         {
            e.printStackTrace();
         }
         
    }
   
   
   
   
   //############################################################
    
  
  public  OCROnTiFImage(int x,int y,int w,int h,String lang) 
  {
	  // this.getClass().get
	    try {
			 path=GetDir.getDir();
		    }
	    catch (IOException e1) 
	    {
			e1.printStackTrace();
		}
	    catch (InterruptedException e1)
	    {
			e1.printStackTrace();
		}
      tessarctPath=path; 
	   
	   try 
       {
      	 
         // final Process p = Runtime.getRuntime().exec(tessarctPath+"\\tesseract.exe cropImage.png output");
           
          final Process p = Runtime.getRuntime().exec(tessarctPath+"\\tesseract.exe cropImage.png  output -l "+lang);
          p.waitFor();
          JFrame f= new JFrame();
          f.setLocationRelativeTo(null);
          f.setSize(300,150);
          f.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/DjvuIcon.png")));
          f.setTitle(DjvuComponents.Titel);
          f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
          File file = new File("output.txt");
          Reader fileReader = new InputStreamReader(new FileInputStream(file),"UTF8");
          BufferedReader reader = new BufferedReader(fileReader);
          
          StringBuffer stringBuffer = new StringBuffer();
          String line;
          while ((line = reader.readLine()) != null) 
          {
              stringBuffer.append(line);
              stringBuffer.append("\n");
          }
          
          fileReader.close();
          System.out.println(stringBuffer.toString());
          // JOptionPane.showMessageDialog(null, stringBuffer.toString());
          textArea.setBackground(Color.RED);
          textArea.setForeground(Color.BLACK);
          textArea.setText(stringBuffer.toString());
          textArea.setForeground(Color.WHITE);
          f.add(scrollPane);
          f.setVisible(true);
          System.out.println(stringBuffer.toString());
         
      
       }
	   catch (IOException e)
	    {
          e.printStackTrace();
      }
	   catch (InterruptedException e) 
       {
          e.printStackTrace();
       }

  }

  
//public static String getFiles(File file)
//{
// String fileName="Program";
// String path="";
//	
// if(file.isDirectory()) 
// {
//   // All files and subdirectories
//  File[] files=file.listFiles();
//	 for(int i = 0; files != null&& i < files.length; i++)
//	 {
//		if(files[i].toString().contains(fileName))
//		{
//			fileName="igug";
//			path=files[i].getPath();
//			
//		}
//	 }
// }
//	 return path;
//	
//}
//
//    @Override
//    public void paintComponents(Graphics g) {
//        super.paintComponents(g);
//        g.fillRect(200, 300, 80, 70);
//    }
  
  public void OCRForImage(String imagePath,String lan) 
  {
      
	  // this.getClass().get
	    try {
			 path=GetDir.getDir();
		    }
	    catch (IOException e1) 
	    {
			e1.printStackTrace();
		}
	    catch (InterruptedException e1)
	    {
			e1.printStackTrace();
		}
      tessarctPath=path; 
	   
	   try 
       {
      	 
         // final Process p = Runtime.getRuntime().exec(tessarctPath+"\\tesseract.exe cropImage.png output");
           String run=null;
           if(lan.equals("en"))
           {
          
             run=tessarctPath+"\\tesseract.exe "+imagePath+"  output";
           }
           else
           {
             run=tessarctPath+"\\tesseract.exe "+imagePath+"  output -l "+lan;
           }
          
          final Process p = Runtime.getRuntime().exec(run);
          p.waitFor();
          JFrame ff= new JFrame();
          ff.setLocationRelativeTo(null);
          ff.setSize(300,150);
          ff.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/DjvuIcon.png")));
           System.err.println(ChoosePanel.Title);
          ff.setTitle("OCR "+ChoosePanel.Title);
          ff.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
          File file = new File("output.txt");
          Reader fileReader = new InputStreamReader(new FileInputStream(file),"UTF8");
          BufferedReader reader = new BufferedReader(fileReader);
          
          StringBuffer stringBuffer = new StringBuffer();
          String line;
          while ((line = reader.readLine()) != null) 
          {
              stringBuffer.append(line);
              stringBuffer.append("\n");
          }
          
          fileReader.close();
          System.out.println(stringBuffer.toString());
          // JOptionPane.showMessageDialog(null, stringBuffer.toString());
          textArea.setBackground(Color.RED);
          textArea.setForeground(Color.BLACK);
          textArea.setText(stringBuffer.toString());
          textArea.setForeground(Color.WHITE);
          ff.add(scrollPane);
          ff.setVisible(true);
          System.out.println(stringBuffer.toString());
         
      
       }
	   catch (IOException e)
	    {
          e.printStackTrace();
      }
	   catch (InterruptedException e) 
       {
          e.printStackTrace();
       }

  }
}

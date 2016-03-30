
package com.lizardtech.djvubean;
import SnippingTool.DrawLayer;
import com.lizardtech.djvu.DjVuOptions;
import com.lizardtech.djvu.DjVuPage;
import com.lizardtech.djvubean.DjVuImage;
import static com.lizardtech.djvubean.RibbonMenu.DjvuComponents.Notestatus;
import static com.lizardtech.djvubean.RibbonMenu.DjvuComponents.djvubean;
import static com.lizardtech.djvubean.RibbonMenu.RibbonMenuCreation.markup;
import static com.lizardtech.djvubean.RibbonMenu.RibbonMenuCreation.popup_note;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

/**
 * ZoomMode is use mouse listener to implement selection zoom on a DjVuBean.
 */
class Markmode implements MouseListener, MouseMotionListener
{ 
    
    
         // A graphics context for the panel
   
    public static int xx;
    public static int yy;
     
     public static  int destx, desty,a,b;
    public static int  xmin,xmax,ymin,ymax;
      //~ Instance fields --------------------------------------------------------

  /** DjVuBean to select text. */
  protected final DjVuBean djvuBean;

  /** Most recient coordinate. */
  protected final Point last = new Point();

  /** Start point where the user pressed down on the mouse. */
  protected Point start = null;

  /** The area selected. */
  public static Rectangle select = new Rectangle();
  int x=0,y=0,w=0,z=0;
  private int srcx, srcy;

   /**
    *  Latest mouse coordinates during drag operation.
    */

   
  

  //~ Constructors -----------------------------------------------------------

  /**
   * Creates a new ZoomMode object.
   *
   * @param bean DjVuBean object to listen to.
   */
  public Markmode(DjVuBean bean)
  {
   djvuBean = bean;
   
  }
  
 

  //~ Methods ----------------------------------------------------------------

  /**
   * Called when the mouse is clicked.  Performs no operation.
   *
   * @param event describing mouse action.
   */
  public void mouseClicked(MouseEvent event) {
   //  djvuBean.requestFocus();
  
  
  }

  /**
   * Called when the mouse is dragged.  Highlights the rectangle if the start
   * position has been set.
   *
   * @param event describing mouse action.
   */
  
  public void mouseDragged(MouseEvent event)
  { 
   
      destx =a= event.getX ();
      desty =b= event.getY ();
      
      //JOptionPane.showMessageDialog(null,last.x);
      if(start != null)
    {
        
      int i = event.getX();
      int j = event.getY();
       
      if((last.x != i) || (last.y != j))
      {
        int k = (i <= start.x)
          ? i
          : start.x;
        int l = (j <= start.y)
          ? j
          : start.y;
        int i1 = (i <= start.x)
          ? (start.x - i)
          : (i - start.x);
        int j1 = (j <= start.y)
          ? (start.y - j)
          : (j - start.y);
        select.setBounds(k, start.y, i1, j1);
        x=k;
        y=l;
        z=i1;
        w=j1;
      djvubean.setSelect(select);
        last.setLocation(start.x, start.y);
      
     
      }
      
   
    }
    
  }
  
 

  /**
   * Called when the mouse pointer enters the component.  Performs no
   * operation.
   *
   * @param event describing mouse action.
   * 
   * 
   */
  
  
  public void mouseEntered(MouseEvent event) {}

  /**
   * Called when the mouse pointer exits the component.  Performs no
   * operation.
   *
   * @param event describing mouse action.
   */
  public void mouseExited(MouseEvent event) {
      
      
 
  }

  /**
   * Called when the mouse pointer is moved.  Performs no operation.
   *
   * @param event describing mouse action.
   */
  public void mouseMoved(MouseEvent event) {}

  /**
   * Called when the mouse button is pressed.  The start location will be
   * set.
   *
   * @param event describing mouse action.
   */
  public void mousePressed(MouseEvent event)
  {
     
      //JOptionPane.showMessageDialog(null,""+djvubean.getBounds().x);
      try
    {
        destx = srcx = event.getX ();
        desty = srcy = event.getY ();
        
      djvuBean.requestFocus();
      start = new Point(
          event.getX(),
          event.getY());
      last.setLocation(start);
      select.setBounds(start.x, start.y, 0,0);  
      djvuBean.setSelect(select);
    }
    catch(final Throwable exp)
    {
        
      exp.printStackTrace(DjVuOptions.err);
      System.gc();
    }
        xx=event.getX();
        yy=event.getY();
         djvuBean.addMouseMotionListener(this);
       JOptionPane.showMessageDialog(null,start.x);
      
       // JOptionPane.showMessageDialog(null,event.getX()+"   "+ event.getY() );
  }

  /**
   * Called when the mouse button is released. The selected area will be
   * zoomed to.
   *
   * @param event describing mouse action.
   */
  public void mouseReleased(MouseEvent event)
          
 {
     
   
     if (popup_note==1){
      //new PopupDemo(xx,yy);
      
     new CustomTitlebar(yy);
     }
     
     

  }

}
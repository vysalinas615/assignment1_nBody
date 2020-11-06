import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class NBody<T> extends JPanel implements ActionListener
{
	Timer aTimer = new Timer(5, this);
	//waits 5 milliseconds
	int x = 0;
	int velX = 2;
	//x is the position, and velX is the speed that the shape will travel at
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.RED);
		//first is position, then length, width, height
		//to move up and down move the x to the length spot 
		g.drawOval(200,100,100,100);
		g.fillOval(200, 100, 100, 100);
		g.fillOval(480, 480, 10, 10);
		//480 x coord,480 y coord,0.015 x veloc,-0.015 y veloc,10 size 
		aTimer.start();
	}
	
	public int gravity(int veloc1, int veloc2, int distance)
	{
		int f;
		f = ((veloc1*veloc2)/(distance));
		return f;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		x += velX;
		//increases x by 2 each time, moves from 0 to the right by 2 (pixels??) each time
		repaint();
		//this paints the shape (makes it look like it's moved basically) 
	}

	public static void main(String[] args) throws IOException, Exception
	{
		String line;
        BufferedReader in;
        LinkedList<String> newList = new LinkedList<String>();
        ArrayList<String> aList = new ArrayList<String>();

         in = new BufferedReader(new FileReader("nbody_input.txt"));
         line = in.readLine();
         int numOfPlanets = 0;
   
         while(line != null)
         {
        	 //first line is the type (either arraylist or linkedlist), second line is the distance 
        	 
        	 System.out.println("LINE:"+line);
        	 //aList.add(line.split(","));
        	 aList.add(line);
        
        	 line = in.readLine();
         }
         
         String theType = aList.get(0);
         //int distance = Integer.parseInt(aList.get(1));
         String distance = aList.get(1);
         System.out.println();
         System.out.println("TYPE:"+theType);
         System.out.println("DISTANCE: "+distance);
         aList.remove(0);
         //first removes the type
         aList.remove(0);
         //second removes the distance
         
         
         
         if (theType.trim().equals("ArrayList"))
		 {
			 System.out.println("It is an array, new arraylist created. ");
			 ArrayList<String> nbodyList = new ArrayList<String>();
		 }
		 
		 else
		 {
    		 System.out.println("It is a linked list, new linkedlist created. ");
    		 LinkedList<String> nbodyLinked = new LinkedList<String>();
		 }
         
         //prints the array
         System.out.print("{");
         for (int i=0;i<aList.size;i++)
         { 
        		 System.out.print(aList.get(i)+" ");
        		 numOfPlanets++;
         }
         System.out.print("}");
         
		NBody<Object> p0 = new NBody<Object>();
		
      	 
		NBody<Object> p1 = new NBody<Object>();
		//this makes an instance of the planet object
		JFrame jf = new JFrame();

		jf.setTitle("N-Body Problem");
		jf.setSize(768, 768);
		//this setSize function basically sets the total size of the window that the shapes exist in
		//be sure to take the width of the shape into account when moving them
		jf.add(p0);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

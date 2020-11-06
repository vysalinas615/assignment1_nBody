import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tutorial extends JPanel
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawRect(100, 10, 30, 40);
	}

	public static void main(String[] args)
	{
		Tutorial t = new Tutorial();
		JFrame jf = new JFrame();

		jf.setTitle("Tutorial");
		jf.setSize(600, 400);
		jf.setVisible(true);
		jf.setDefaultCloseOpernation(JFrame.EXIT_ON_CLOSE);
		jf.add(t);


	}
}
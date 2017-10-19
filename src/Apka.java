import java.awt.*;
import javax.swing.*;

public class Apka 
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
				{
					public void run()
					{
						ApkaFrame o = new ApkaFrame();
						o.setTitle("Kalkulator Wyciskania");
						o.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						o.setVisible(true);
						o.setResizable(false);

					}
				});
	}
}

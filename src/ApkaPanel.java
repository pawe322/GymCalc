import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ApkaPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton display, p5, p6, p8, p10, p12;
	private JPanel panel;
	private double wynik, temp3;
	private String temp1;
	private Integer temp2;
	private JComboBox<Integer> ile;
	private JTextField tF;
	
	public ApkaPanel()
	{
		setLayout(new BorderLayout());
		
		tF = new JTextField();
        ile = new JComboBox<>();
        for(int i=1; i<=12; i++) ile.addItem(i);
	
		wynik = 0;
		
		ActionListener duzo = new duzoAction();
		
		panel = new JPanel();                     	   //góra okna
		panel.setLayout(new GridLayout(9, 2));
		addLabel("Ciê¿ar (kg):");
		panel.add(tF);
		addLabel("Liczba Powtórzeñ (1-12):");
		panel.add(ile);
		addLabel("                         ");
		//addLabel("            !o!BETA v2!o!");
		addButton("Licz", duzo);
		
		addLabel("1 Powtórzenie: ");					//dó³ okna
		display = new JButton("0");
		display.setEnabled(false);
		panel.add(display);

		addLabel("5 Powtórzeñ: ");
		p5 = new JButton("0");
		p5.setEnabled(false);
		panel.add(p5);

		addLabel("6 Powtórzeñ: ");
		p6 = new JButton("0");
		p6.setEnabled(false);
		panel.add(p6);

		addLabel("8 Powtórzeñ: ");
		p8 = new JButton("0");
		p8.setEnabled(false);
		panel.add(p8);

		addLabel("10 Powtórzeñ: ");
		p10 = new JButton("0");
		p10.setEnabled(false);
		panel.add(p10);

		addLabel("12 Powtórzeñ: ");
		p12 = new JButton("0");
		p12.setEnabled(false);
		panel.add(p12);

		
		add(panel);
		
	}
	
	private void addLabel(String label)
	{
		JLabel lbl = new JLabel(label);
		panel.add(lbl);
	}
	
	
   private void addButton(String label, ActionListener listener)
   {
      JButton button = new JButton(label);
      button.addActionListener(listener);
      panel.add(button);
   }
   	
	
	private class duzoAction implements ActionListener
	{
		double[] dziel = new double[] {1, 0.943, 0.906, 0.881, 0.856, 0.831, 0.807, 0.786, 0.765, 0.744, 0.723, 0.703};
		
		public void actionPerformed(ActionEvent event)
		{
			temp1 = (tF.getText());											//ciezar
			temp2 = ile.getItemAt(ile.getSelectedIndex());					//powtorzenia z comboboxa
			
			if (temp2.equals(1)) 
				{
					wynik = Double.parseDouble(temp1);
					display.setText(temp1 + " kg");
				}
			else
				for (int i=2; i<=12; i++)
				{
					if(temp2.equals(i))
					{
						wynik = Integer.parseInt(temp1);
						wynik = wynik/dziel[i-1];
						wynik *= 100;
						wynik = Math.round(wynik);
						wynik /=100;
						temp1 = String.valueOf(wynik);
						display.setText(temp1 + " kg");
					}
				}
			
			temp3=wynik*dziel[4];
			temp3 *= 100;
			temp3 = Math.round(temp3);
			temp3 /=100;
			temp1 = String.valueOf(temp3);
			p5.setText(temp1 + " kg");
			
			temp3=wynik*dziel[5];
			temp3 *= 100;
			temp3 = Math.round(temp3);
			temp3 /=100;
			temp1 = String.valueOf(temp3);
			p6.setText(temp1 + " kg");

			temp3=wynik*dziel[7];
			temp3 *= 100;
			temp3 = Math.round(temp3);
			temp3 /=100;
			temp1 = String.valueOf(temp3);
			p8.setText(temp1 + " kg");
		
			temp3=wynik*dziel[9];
			temp3 *= 100;
			temp3 = Math.round(temp3);
			temp3 /=100;
			temp1 = String.valueOf(temp3);
			p10.setText(temp1 + " kg");
		
			temp3=wynik*dziel[11];
			temp3 *= 100;
			temp3 = Math.round(temp3);
			temp3 /=100;
			temp1 = String.valueOf(temp3);
			p12.setText(temp1 + " kg");
		}
	}
	
}
package aplicacioGrafica;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import classes.*;

public class MainGrafic extends Frame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JFrame f = new JFrame("Plantacions Forestals");
	JButton bplant1, bplant2, bplant3, bplant4;
	JTextField tf1, tf2, tf3, tf4, tAny;
	JLabel lAny;
	MainGrafic(){
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tAny = new JTextField();
		bplant1 = new JButton("NomFinca;AnyPlantació;TotalSuperficie;NumArbres;NumArbustos.");
		bplant2 = new JButton("NomFinca;AnyPlantació;TotalSuperficie;NumArbres;NumArbustos.");
		bplant3 = new JButton("NomFinca;AnyPlantació;TotalSuperficie;NumArbres;NumArbustos.");
		bplant4 = new JButton("NomFinca;AnyPlantació;TotalSuperficie;NumArbres;NumArbustos.");
		lAny = new JLabel("Introdueix un any:");
		tf1.setBounds(600, 125, 150, 30);
		tf1.setEditable(false);
		tf2.setBounds(600, 200, 150, 30);
		tf2.setEditable(false);
		tf3.setBounds(600, 275, 150, 30);
		tf3.setEditable(false);
		tf4.setBounds(600, 350, 150, 30);
		tf4.setEditable(false);
		tAny.setBounds(50, 50, 150, 30);
		bplant1.setBounds(50, 125, 500, 30);
		bplant2.setBounds(50, 200, 500, 30);
		bplant3.setBounds(50, 275, 500, 30);
		bplant4.setBounds(50, 350, 500, 30);
		lAny.setBounds(50, 25, 150, 30);
		bplant1.addActionListener(this);
		bplant2.addActionListener(this);
		bplant3.addActionListener(this);
		bplant4.addActionListener(this);
		f.add(bplant1);
		f.add(bplant2);
		f.add(bplant3);
		f.add(bplant4);
		f.add(tf1);
		f.add(tf2);
		f.add(tf3);
		f.add(tf4);
		f.add(tAny);
		f.add(lAny);
		f.setSize(1000, 800);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		try {		
		String tfany = tAny.getText();
		int any = Integer.parseInt(tfany);
		int abs1 = 50, abs2 = 200, abs3 = 450, abs4 = 300;
		int absT1 = 0, absT2 = 0, absT3 = 0, absT4 = 0;
		if (e.getSource() == bplant1) {
			absT1 = any + abs1;
			String abso1 = String.valueOf(absT1);
			tf1.setText(abso1);
			int res1 = Integer.parseInt(abso1);
			if (res1 <= 167) {
				bplant1.setBackground(Color.RED);
			}
			else if (res1 <= 334) {
				bplant1.setBackground(Color.YELLOW);
			}
			else if (res1 <= 500) {
				bplant1.setBackground(Color.GREEN);
			}
			else if (res1 > 500) {
				bplant1.setBackground(Color.WHITE);
			}
		}
		else if (e.getSource() == bplant2) {
			absT2 = any + abs2;
			String abso2 = String.valueOf(absT2);
			tf2.setText(abso2);
			int res2 = Integer.parseInt(abso2);
			if (res2 <= 167) {
				bplant2.setBackground(Color.RED);
			}
			else if (res2 <= 334) {
				bplant2.setBackground(Color.YELLOW);
			}
			else if (res2 <= 500) {
				bplant2.setBackground(Color.GREEN);
			}
			else if (res2 > 500) {
				bplant2.setBackground(Color.WHITE);
			}
		}
		else if (e.getSource() == bplant3) {
			absT3 = any + abs3;
			String abso3 = String.valueOf(absT3);
			tf3.setText(abso3);
			int res3 = Integer.parseInt(abso3);
			if (res3 <= 167) {
				bplant3.setBackground(Color.RED);
			}
			else if (res3 <= 334) {
				bplant3.setBackground(Color.YELLOW);
			}
			else if (res3 <= 500) {
				bplant3.setBackground(Color.GREEN);
			}
			else if (res3 > 500) {
				bplant3.setBackground(Color.WHITE);
			}
		}
		else if (e.getSource() == bplant4) {
			absT4 = any + abs4;
			String abso4 = String.valueOf(absT4);
			tf4.setText(abso4);
			int res4 = Integer.parseInt(abso4);
			if (res4 <= 167) {
				bplant4.setBackground(Color.RED);
			}
			else if (res4 <= 334) {
				bplant4.setBackground(Color.YELLOW);
			}
			else if (res4 <= 500) {
				bplant4.setBackground(Color.GREEN);
			}
			else if (res4 > 500) {
				bplant4.setBackground(Color.WHITE);
			}
		}
		}catch(Exception ex) {System.out.println(ex);}
	}
	public static void main(String[]args) {
		new MainGrafic();
	}
}


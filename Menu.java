package Greek_krypto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu {
	JPanel jp2 = new JPanel();

	Menu() {
		View.menubar.setVisible(false);
		jp2.setBounds(00, 00, 800, 700);
		jp2.setLayout(null);
		jp2.setBackground(null);
		jp2.setVisible(false);

		JLabel l = new JLabel("             Kryptorexo Game");
		l.setBounds(110, 20, 500, 50);
		l.setFont(new Font("Comic Sans MS", 00, 36));
		l.setForeground(new Color(1, 87, 155));
		l.setVisible(true);
		jp2.add(l);

		JTextField l1 = new JTextField("	               Main Menu");
		l1.setBounds(0, 100, 800, 50);
		l1.setFont(new Font("Comic Sans MS", 00, 30));
		l1.setBackground(new Color(1, 87, 155));
		l1.setForeground(Color.white);
		l1.setEditable(false);
		l1.setVisible(true);
		jp2.add(l1);

		JButton jb1 = new JButton("5x5");
		JButton jb2 = new JButton("8x8");
		JButton jb3 = new JButton("10x10");
		JButton jb4 = new JButton("Instructions");

		jb1.setBounds(320, 230, 150, 50);
		jb1.setBackground(new Color(1, 87, 155));
		jb1.setVisible(true);
		jb1.setForeground(Color.white);
		jb1.setFont(new Font("Comic Sans MS", 00, 20));
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.goto5x5();
			}
		});
		jp2.add(jb1);

		jb2.setBounds(320, 300, 150, 50);
		jb2.setForeground(Color.WHITE);
		jb2.setBackground(new Color(1, 87, 155));
		jb2.setVisible(true);
		jb2.setFont(new Font("Comic Sans MS", 00, 20));
		jp2.add(jb2);
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.goto8x8();
			}
		});

		jb3.setBounds(320, 370, 150, 50);
		jb3.setBackground(new Color(1, 87, 155));
		jb3.setVisible(true);
		jb3.setForeground(Color.white);
		jb3.setFont(new Font("Comic Sans MS", 00, 20));
		jp2.add(jb3);
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.goto10x10();
			}
		});

		jb4.setBounds(320, 440, 150, 50);
		jb4.setBackground(new Color(1, 87, 155));
		jb4.setVisible(true);
		jb4.setForeground(Color.white);
		jb4.setFont(new Font("Comic Sans MS", 00, 20));
		jp2.add(jb4);
		jb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Controller.gotoinstructions();
			}
		});

	}
}
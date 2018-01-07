package Greek_krypto;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class View extends JFrame implements MenuActivityListener {
	int x = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2);
	int y = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2);
	static JMenuBar menubar = new JMenuBar();
	static String name = "You";

	View() {
		setTitle("Kryptorexo Game");
		setBounds(x - 400, y - 370, 800, 700);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menubar.setBounds(00, 00, 800, 25);
		menubar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menubar.setBackground(new Color(1, 87, 155));

		setJMenuBar(menubar);

		JMenu menubutton = new JMenu("Menu");
		menubutton.setForeground(Color.white);
		JMenu toolbutton = new JMenu("Tools");
		toolbutton.setForeground(Color.white);
		// create menu items
		JMenuItem newgame = new JMenuItem("New Game");
		newgame.setMnemonic(KeyEvent.VK_N);
		newgame.setActionCommand("New Game");
		newgame.addActionListener(this);
		menubutton.add(newgame);
		JMenuItem nameitem = new JMenuItem("Enter Player's Name");
		nameitem.setActionCommand("Enter Player's Name");
		nameitem.addActionListener(this);
		menubutton.add(nameitem);
		JMenuItem helpitem = new JMenuItem("Help");
		helpitem.setActionCommand("Help");
		helpitem.addActionListener(this);
		toolbutton.add(helpitem);
		JMenuItem aboutitem = new JMenuItem("About");
		aboutitem.setActionCommand("About");
		aboutitem.addActionListener(this);
		toolbutton.add(aboutitem);
		JMenuItem exititem = new JMenuItem("Exit");
		exititem.setActionCommand("Exit");
		exititem.addActionListener(this);
		menubutton.add(exititem);
		menubar.add(menubutton);
		menubar.add(toolbutton);

	}

	public void addpanel(JPanel p) {
		super.add(p);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("New Game")) {
			if (Pane.TotalScore > Pane.TargetScore) {
				JOptionPane.showMessageDialog(null, name + " win!");
			} else {
				JOptionPane.showMessageDialog(null, name + " lost!");
			}
			Controller.inGame = false;
			Controller.frame.remove(Controller.board.jp4);
			Pane.currentDel=0;
			Pane.currentRline=0;
			Pane.currentRcolumn=0;
			Pane.currentRtable=0;
			Pane.currentStable=0;
			Pane.TotalScore=0;
			new Controller();
		}
		if (e.getActionCommand().equals("Enter Player's Name")) {
			name = JOptionPane.showInputDialog(null, "Enter/Change your name: ");
		}
		if (e.getActionCommand().equals("Help")) {
			Controller.board.jp4.setVisible(false);
			Controller.frame.addpanel(Controller.inst.jp3);
			Controller.inst.jp3.repaint();
			Controller.inst.jp3.setVisible(true);
		}
		if (e.getActionCommand().equals("About")) {
			JOptionPane.showMessageDialog(null, "This is a greek game, called Kryptorexo!");
		}
		if (e.getActionCommand().equals("Exit")) {
			System.exit(0);
		}
	}

}

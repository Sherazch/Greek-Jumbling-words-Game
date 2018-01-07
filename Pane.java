package Greek_krypto;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Pane implements WordsHandlerInterface {
	JPanel jp4 = new JPanel();
	public static int order;// change for others
	Random rand = new Random();
	String WordsArray[] = DataClass.totalWords.split(DataClass.sperator);
	String WordsUse[];
	char CharsUse[];
	JButton Butt[];
	static boolean selected;
	static JButton selectButt;
	static int TargetScore = 0;
	static int TotalScore = 0;
	int WordScore = 0;
	int WordsFound = 0;
	String WordsFounded = "";
	JTextField f1 = new JTextField();// DelLine
	JTextField f2 = new JTextField();// RearrangeLine
	JTextField f3 = new JTextField();// RearrangeColumn

	JLabel l7 = new JLabel();// del
	JLabel l8 = new JLabel();// Rl
	JLabel l9 = new JLabel();// Rc
	JLabel l10 = new JLabel();// Rt
	JLabel l11 = new JLabel();// St

	static int maxlimitDel = 3;
	static int currentDel = 0;
	static int maxlimitRline = 3;
	static int currentRline = 0;
	static int maxlimitRcolumn = 3;
	static int currentRcolumn = 0;
	static int maxlimitRtable = 5;
	static int currentRtable = 0;
	static int maxlimitStable = 6;
	static int currentStable = 0;

	JLabel l13 = new JLabel();// TotalScore
	JLabel l14 = new JLabel();// WordsScore
	JLabel l15 = new JLabel();// WordsFound
	JTextArea l16 = new JTextArea();// WordsFounded

	public Pane() {
		if (order == 5)
			TargetScore = rand.nextInt(50) + 50;
		if (order == 8)
			TargetScore = rand.nextInt(50) + 80;
		if (order == 10)
			TargetScore = rand.nextInt(50) + 100;
		getRandomWords();
		makeCharArray();
		View.menubar.setVisible(true);
		selected = false;
		Butt = new JButton[order * order];
		jp4.setBounds(00, 00, 800, 700);
		jp4.setLayout(null);
		jp4.setBackground(null);
		jp4.setVisible(false);
		JPanel boxes = new JPanel();
		boxes.setLayout(new GridLayout(order, order, 2, 2));
		boxes.setBounds(30, 30, 450, 450);
		boxes.setVisible(true);
		boxes.setBackground(Color.black);

		RandomHandler.RepeatAfter = CharsUse.length;// used to set characters in
													// pane
		RandomHandler.reset();// used to set characters in pane
		for (int i = 0; i < (order * order); i++) {
			String a = "" + makeChars();
			Butt[i] = new JButton(a);
			if (order == 10)
				Butt[i].setFont(new Font("SansSerif", Font.BOLD, 10));
			if (order == 8)
				Butt[i].setFont(new Font("SansSerif", Font.BOLD, 15));
			if (order == 5)
				Butt[i].setFont(new Font("SansSerif", Font.BOLD, 32));
			Butt[i].setBackground(Color.white);
			Butt[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JButton but = (JButton) arg0.getSource();
					if (Pane.selected) {
						String mid = but.getText();
						Color color = but.getBackground();
						but.setText(selectButt.getText());
						but.setBackground(selectButt.getBackground());
						selectButt.setText(mid);
						selectButt.setBackground(color);

						selectButt.setEnabled(true);
						selected = false;
					} else {
						but.setEnabled(false);
						selectButt = but;
						selected = true;
					}

				}
			});
			// other addition to grid buttons..
			boxes.add(Butt[i]);
		}
		jp4.add(boxes);
		SetScoreColors();

		JButton b1 = new JButton("Delete line"); // Delete line button
		b1.setBounds(510, 50, 160, 25);
		b1.setBackground(new Color(1, 87, 155));
		b1.setForeground(Color.white);
		b1.setFont(new Font("Comic Sans MS", 00, 15));
		b1.setVisible(true);
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (currentDel < maxlimitDel) {
					currentDel++;
					l7.setText(currentDel + "/" + maxlimitDel);
					for (int k = 0; k < Butt.length; k++) {
						if (!f1.getText().equals("")) {

							if (((k + 1) / order) == Integer.parseInt(f1.getText())) {
								for (int j = 0; j < order; j++) {
									Butt[k - j].setText(" ");
									Butt[k - j].setBackground(Color.white);
								}
								break;
							}
						}
					}
				}
			}
		});

		JButton b2 = new JButton("Rearrange Line"); // Rearrange Line button
		b2.setBounds(510, 90, 160, 25);
		b2.setBackground(new Color(1, 87, 155));
		b2.setForeground(Color.white);
		b2.setFont(new Font("Comic Sans MS", 00, 15));
		b2.setVisible(true);
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (currentRline < maxlimitRline) {
					currentRline++;
					l8.setText(currentRline + "/" + maxlimitRline);
					for (int k = 0; k < Butt.length; k++) {
						if (!f2.getText().equals("")) {

							if (((k + 1) / order) == Integer.parseInt(f2.getText())) {
								String[] abc = new String[order];
								Color[] xyz = new Color[order];
								for (int j = 0; j < order; j++) {
									abc[j] = Butt[k - j].getText();
									xyz[j] = Butt[k - j].getBackground();
								}
								RandomHandler.RepeatAfter = abc.length;
								RandomHandler.reset();
								for (int j = 0; j < order; j++) {
									int value = rand.nextInt(order);
									value = RandomHandler.checkRepeating(value);
									Butt[k - j].setText(abc[value]);
									Butt[k - j].setBackground(xyz[value]);
								}
								break;
							}
						}
					}
				}
			}
		});
		JButton b3 = new JButton("Rearrange Column"); // Rearrange Column button
		b3.setBounds(510, 130, 160, 25);
		b3.setBackground(new Color(1, 87, 155));
		b3.setForeground(Color.white);
		b3.setFont(new Font("Comic Sans MS", 00, 15));
		b3.setVisible(true);
		b3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (currentRcolumn < maxlimitRcolumn) {
					currentRcolumn++;
					l9.setText(currentRcolumn + "/" + maxlimitRcolumn);
					for (int k = 0; k < Butt.length; k++) {
						if (!f3.getText().equals("")) {
							if ((k % order) == Integer.parseInt(f3.getText()) - 1) {
								String[] abc = new String[order];
								Color[] xyz = new Color[order];
								int n = 0;
								for (int j = 0; j < order * order; j += order) {
									abc[n] = Butt[k + j].getText();
									xyz[n] = Butt[k + j].getBackground();
									n++;
								}
								RandomHandler.RepeatAfter = abc.length;
								RandomHandler.reset();
								n = 0;
								for (int j = 0; j < order * order; j += order) {
									int value = rand.nextInt(order);
									value = RandomHandler.checkRepeating(value);
									Butt[k + j].setText(abc[value]);
									Butt[k + j].setBackground(xyz[value]);
									n++;
								}
								break;
							}
						}
					}
				}
			}
		});
		JButton b4 = new JButton("Rearrange Table"); // Rearrange Table button
		b4.setBounds(510, 170, 160, 25);
		b4.setBackground(new Color(1, 87, 155));
		b4.setForeground(Color.white);
		b4.setFont(new Font("Comic Sans MS", 00, 15));
		b4.setVisible(true);
		b4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (currentRtable < maxlimitRtable) {
					currentRtable++;
					l10.setText(currentRtable + "/" + maxlimitRtable);
					Controller.frame.remove(jp4);
					if (order == 5)
						Controller.goto5x5();
					if (order == 8)
						Controller.goto8x8();
					if (order == 10)
						Controller.goto10x10();
				}

			}
		});
		JButton b5 = new JButton("Shuffle Letters"); // Shuffle letters button
		b5.setBounds(510, 210, 160, 25);
		b5.setBackground(new Color(1, 87, 155));
		b5.setForeground(Color.white);
		b5.setFont(new Font("Comic Sans MS", 00, 15));
		b5.setVisible(true);
		b5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (currentStable < maxlimitStable) {
					currentStable++;
					l11.setText(currentStable + "/" + maxlimitStable);
					RandomHandler.RepeatAfter = Butt.length;
					RandomHandler.reset();
					String[] abc = new String[order * order];
					Color[] xyz = new Color[order * order];
					for (int k = 0; k < Butt.length; k++) {
						abc[k] = Butt[k].getText();
						xyz[k] = Butt[k].getBackground();
					}

					for (int j = 0; j < Butt.length; j++) {
						int value = rand.nextInt(Butt.length);
						value = RandomHandler.checkRepeating(value);
						Butt[j].setText(abc[value]);
						Butt[j].setBackground(xyz[value]);
					}
				}
			}
		});
		JButton b6 = new JButton("Check Word"); // Check word button
		b6.setBounds(150, 510, 150, 30);
		b6.setBackground(new Color(1, 87, 155));
		b6.setForeground(Color.white);
		b6.setFont(new Font("Comic Sans MS", 00, 15));
		b6.setVisible(true);
		b6.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String a = "";
				int Score = 0;
				boolean Double = false;
				for (int k = 0; k < Butt.length; k++) {
					if (!Butt[k].isEnabled())
						continue;
					a += Butt[k].getText();
					if ((k + 1) % (order) == 0) {
						for (int i = 0; i < WordsUse.length; i++) {
							if (a.equals(WordsUse[i])) {

								for (int j = 0; j < order; j++) {
									// do score computation here
									if (Butt[k - j].getBackground() == Color.CYAN) {
										Double = true;
									}
									Score += getValueofChar(Butt[k - j].getText().charAt(0));
									if (Butt[k - j].getBackground() == Color.RED) {
										Score += getValueofChar(Butt[k - j].getText().charAt(0));
									}
									Butt[k - j].setEnabled(false);
									Butt[k - j].setBackground(Color.yellow);
									Butt[k - j].setForeground(Color.white);
								}
								if (Double)
									Score = Score * 2;
								TotalScore += Score;
								WordScore = Score;
								WordsFound++;
								WordsFounded += a + ", ";
								SetScores();
								a = "";
								Score = 0;
								Double = false;
							}

						}
						a = "";

					}
				}
			}
		});

		// delete line textfield
		f1.setBounds(680, 50, 30, 25);
		// rearrange line textfield
		f2.setBounds(680, 90, 30, 25);
		// rearrange column textfield
		f3.setBounds(680, 130, 30, 25);
		JLabel l1 = new JLabel("Limit"); // right upper written 'Limit' label
		l1.setBounds(740, 15, 60, 20);
		l1.setFont(new Font("Comic Sans MS", 00, 13));
		l1.setVisible(true);
		JLabel l2 = new JLabel("Target :"); // Target label
		l2.setBounds(510, 270, 160, 25);
		l2.setVisible(true);
		l2.setFont(new Font("Comic Sans MS", 00, 17));
		JLabel l3 = new JLabel("Total Score :"); // total score label
		l3.setBounds(510, 310, 160, 25);
		l3.setVisible(true);
		l3.setFont(new Font("Comic Sans MS", 0, 17));
		JLabel l4 = new JLabel("Word Score :"); // word score label
		l4.setBounds(510, 350, 160, 25);
		l4.setVisible(true);
		l4.setFont(new Font("Comic Sans MS", 00, 17));
		JLabel l5 = new JLabel("Words Found :"); // no of words found label
		l5.setBounds(510, 390, 160, 25);
		l5.setVisible(true);
		l5.setFont(new Font("Comic Sans MS", 00, 17));
		JLabel l6 = new JLabel("Founded Words :"); // founded words label
		l6.setBounds(510, 430, 160, 25);
		l6.setVisible(true);
		l6.setFont(new Font("Comic Sans MS", 00, 17));
		// valued labels
		// delete line limit label
		l7.setBounds(745, 50, 30, 25);
		l7.setText(currentDel + "/" + maxlimitDel);
		l7.setVisible(true);
		l7.setFont(new Font("Comic Sans MS", 00, 15));
		// rearrange line limit label
		l8.setBounds(745, 90, 30, 25);
		l8.setText(currentRline + "/" + maxlimitRline);
		l8.setVisible(true);
		l8.setFont(new Font("Comic Sans MS", 00, 15));
		// reearrange column limit label
		l9.setBounds(745, 130, 30, 25);
		l9.setText(currentRcolumn + "/" + maxlimitRcolumn);
		l9.setVisible(true);
		l9.setFont(new Font("Comic Sans MS", 00, 15));
		// rearrange table limit label
		l10.setBounds(745, 170, 30, 25);
		l10.setText(currentRtable + "/" + maxlimitRtable);
		l10.setVisible(true);
		l10.setFont(new Font("Comic Sans MS", 00, 15));
		// Shuffle letters limit label
		l11.setBounds(745, 210, 30, 25);
		l11.setText(currentStable + "/" + maxlimitStable);
		l11.setVisible(true);
		l11.setFont(new Font("Comic Sans MS", 00, 15));
		JLabel l12 = new JLabel(); // target value label
		l12.setBounds(745, 270, 30, 25);
		l12.setText("" + TargetScore);
		l12.setVisible(true);
		l12.setFont(new Font("Comic Sans MS", 00, 15));
		// total score value label
		l13.setBounds(745, 310, 30, 25);
		l13.setText("" + TotalScore);
		l13.setVisible(true);
		l13.setFont(new Font("Comic Sans MS", 00, 15));
		// word score value label
		l14.setBounds(745, 350, 30, 25);
		l14.setText("" + WordScore);
		l14.setVisible(true);
		l14.setFont(new Font("Comic Sans MS", 00, 15));
		// number of words found value label
		l15.setBounds(745, 390, 30, 25);
		l15.setText("" + WordsFound);
		l15.setVisible(true);
		l15.setFont(new Font("Comic Sans MS", 00, 15));
		// founded letters showing label
		l16.setBounds(510, 460, 250, 210);
		l16.setText(WordsFounded);
		l16.setVisible(true);
		l16.setFont(new Font("Comic Sans MS", 00, 15));
		l16.setEditable(false);
		l16.setOpaque(false);
		l16.setLineWrap(true);
		l16.setWrapStyleWord(true);
		JTextArea l17 = new JTextArea(ArrangeValueofChar());
		l17.setBounds(50, 560, 450, 100);
		l17.setVisible(true);
		l17.setFont(new Font("Comic Sans MS", 00, 15));
		l17.setEditable(false);
		l17.setOpaque(false);
		l17.setLineWrap(true);
		l17.setWrapStyleWord(true);

		jp4.add(b1);
		jp4.add(b2);
		jp4.add(b3);
		jp4.add(b4);
		jp4.add(b5);
		jp4.add(b6);
		jp4.add(f1);
		jp4.add(f2);
		jp4.add(f3);
		jp4.add(l1);
		jp4.add(l2);
		jp4.add(l3);
		jp4.add(l4);
		jp4.add(l5);
		jp4.add(l6);
		jp4.add(l7);
		jp4.add(l8);
		jp4.add(l9);
		jp4.add(l10);
		jp4.add(l11);
		jp4.add(l12);
		jp4.add(l13);
		jp4.add(l14);
		jp4.add(l15);
		jp4.add(l16);
		jp4.add(l17);

	}

	public void getRandomWords() {
		WordsUse = new String[order - 1];
		RandomHandler.RepeatAfter = WordsArray.length;
		RandomHandler.reset();
		int i = 0;
		while (i < order - 1) {
			int value = rand.nextInt(WordsArray.length);
			// gets the value which is not used already
			value = RandomHandler.checkRepeating(value);
			if (WordsArray[value].length() != order)
				continue;

			WordsUse[i] = WordsArray[value];
			System.out.println(WordsUse[i]);
			i++;
		}
	}

	public void makeCharArray() {
		CharsUse = new char[order * order];

		int num = 0;
		int j = 0;
		int i = 0;
		while (j < (CharsUse.length - order)) {
			CharsUse[j] = WordsUse[i].charAt(num);
			// System.out.print("" + CharsUse[j] + ".");
			j++;
			num++;
			if (num == WordsUse[i].length()) {
				num = 0;
				i++;
			}
		}
		for (int k = j; k < CharsUse.length; k++) {
			CharsUse[k] = ' ';
			// System.out.print("" + CharsUse[k] + ".");
		}
		// System.out.println();
	}

	public char makeChars() {

		int value = rand.nextInt(CharsUse.length);
		// gets the value which is not used already
		value = RandomHandler.checkRepeating(value);
		// System.out.print("" + CharsUse[value] + ".");
		return CharsUse[value];
	}

	public void SetScoreColors() {// call this after creating buttonsss
		RandomHandler.RepeatAfter = Butt.length;
		RandomHandler.reset();
		for (int i = 0; i < order; i++) {
			int value = rand.nextInt(Butt.length);
			// gets the value which is not used already
			value = RandomHandler.checkRepeating(value);
			if (i > order / 2) {
				if (Butt[value].getText().equals(" "))
					i--;
				else
					Butt[value].setBackground(Color.cyan);
			} else {
				if (Butt[value].getText().equals(" "))
					i--;
				else
					Butt[value].setBackground(Color.RED);
			}
		}

	}

	public void SetScores() {
		l13.setText("" + TotalScore);
		l14.setText("" + WordScore);
		l15.setText("" + WordsFound);
		l16.setText(WordsFounded);
		if (TotalScore > TargetScore) {
			JOptionPane.showMessageDialog(null, View.name + " win!");
		} else if (TotalScore < TargetScore && WordsFound == (order - 1)) {
			JOptionPane.showMessageDialog(null, View.name + " lost!");
		}
	}

	public int getValueofChar(char a) {
		for (int i = 0; i < DataClass.scoreArray.length; i++) {
			if (DataClass.scoreArray[i][0] == a) {
				return DataClass.scoreArray[i][1];
			}
		}

		return 0;
	}

	public String ArrangeValueofChar() {
		String a = "Scores:\n";
		for (int i = 0; i < DataClass.scoreArray.length; i++) {
			int b = DataClass.scoreArray[i][1];
			a += DataClass.scoreArray[i][0] + "-" + b;
			if (i != DataClass.scoreArray.length - 1) {
				a += ", ";
			}
		}
		return a;
	}

}

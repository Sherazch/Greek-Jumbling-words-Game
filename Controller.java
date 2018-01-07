package Greek_krypto;

public class Controller {
	static View frame = new View();
	static Menu menu;
	static Instruction inst = new Instruction();
	static Pane board;
	static boolean inGame=false;

	Controller() {
		menu= new Menu();
		menu.jp2.setVisible(true);
		frame.addpanel(menu.jp2);
		menu.jp2.repaint();
	}

	public static void main(String[] args) {
		new Controller();

	}

	public static void gotoinstructions() {
		menu.jp2.setVisible(false);
		inst.jp3.setVisible(true);
		frame.addpanel(inst.jp3);
		inst.jp3.repaint();
	}

	public static void instructionback() {
		inst.jp3.setVisible(false);

		if (!inGame) {
			menu.jp2.setVisible(true);
			menu.jp2.repaint();
		}
		else{
			board.jp4.setVisible(true);
			board.jp4.repaint();
		}
	}

	public static void goto5x5() {
		Pane.order = 5;
		inGame=true;
		board = new Pane();
		menu.jp2.setVisible(false);
		board.jp4.setVisible(true);
		frame.addpanel(board.jp4);
		board.jp4.repaint();
	}

	public static void goto8x8() {
		Pane.order = 8;
		inGame=true;
		board = new Pane();
		menu.jp2.setVisible(false);
		board.jp4.setVisible(true);
		frame.addpanel(board.jp4);
		board.jp4.repaint();
	}

	public static void goto10x10() {
		Pane.order = 10;
		inGame=true;
		board = new Pane();
		menu.jp2.setVisible(false);
		board.jp4.setVisible(true);
		frame.addpanel(board.jp4);
		board.jp4.repaint();
	}

}

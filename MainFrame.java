package tictactoe;
import javax.swing.*;
import java.awt.event.*;
import java.util.Timer; 
import java.util.TimerTask; 


import java.awt.*;

public class MainFrame extends TimerTask implements ActionListener {
//	the frame will consists of all the elements
	private JFrame frame;
//	labelPlayer is used to change the turn of player
//	labelTimer will display the time
	private JLabel labelTurn, labelPlayer, labelTimer;
//	Dimension will save the width and height of the screen
	private Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	private int sHeight = ss.height;
	private int sWidth = ss.width;
//  9 grids are created using the buttons array
	private JButton btns[];
//	turn will be change after every move
	private int turn = 0;
//	isComputer is used to save the state either computer is playing or not
	private static boolean isComputer;
	private static int size = 9;
	private int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8};
//	Timer timer;
	public MainFrame() {
//		this.isComputer = isComputer;
		frame = new JFrame("TIC TAC TOE");
		btns = new JButton[9];
		int left = 400;
		int top = -70;
		for(int i=0;i<9;i++) {
			if(i%3 == 0) {
				left = 450;
				top += 200;
			}
			btns[i] = new JButton();
			btns[i].setBounds(left, top, 200, 200);
			btns[i].setBackground(Color.WHITE);
			btns[i].addActionListener(this);
			btns[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 80));
			btns[i].setFocusable(false);
			left+=200;
			frame.add(btns[i]);
		}
		labelTurn = new JLabel("Turn of Player - ");
		labelTurn.setBounds(100, 100, 200, 50);
		labelTurn.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
		labelTurn.setForeground(Color.white);
		frame.add(labelTurn);
		
		labelPlayer = new JLabel("1");
		labelPlayer.setBounds(270, 100, 50, 50);
		labelPlayer.setFont(new Font(Font.SERIF, Font.PLAIN, 25));
		labelPlayer.setForeground(Color.white);
		frame.add(labelPlayer);
		
		labelTimer = new JLabel("30 sec");
		labelTimer.setBounds(sWidth-200, 150, 100, 100);
		labelTimer.setBorder(BorderFactory.createLineBorder(Color.cyan, 5, true));
		labelTimer.setHorizontalAlignment(JLabel.CENTER);
		labelTimer.setForeground(Color.WHITE);
		labelTimer.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
		frame.add(labelTimer);
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setSize(sWidth, sHeight);
		frame.getContentPane().setBackground(new Color(100, 200, 250));;
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		before window is closed timer should be canceled
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				i=0;
			}
		});
		
//		keylistner for buttons
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() >= '1' && e.getKeyChar() <= '9'){
					btns[Integer.parseInt(String.valueOf(e.getKeyChar()))-1].doClick();
				}
			}
		});
	}
	
	   public static int i = 30; 
//	   This method will be invoked after every 1 second to change the time written in labelTimer
	   public void run() 
	   { 
		   i--;
		   labelTimer.setText(String.valueOf(i));
		   if(i == 0) {
			   frame.dispose();
			   this.cancel();
			   new ResultFrame((turn%2+1)^3);
		   }else if(i < 0 ) {
			   this.cancel();
		   }
	   } 
//	   This function will play computer's turn
	   private void play() {
//		   // System.out.println(size);
		   int x = (int)(Math.random()*(size-1));
		   // System.out.println(x + " " + size + " " + arr[x]);
		   if(btns[x].getText() != "") {
//			   // System.out.println("wrong ");
//			   // System.out.println(btns[x].getText() + " value "+x);
			   play();
			   return;
		   }else {
			   btns[x].doClick();   
		   }
	   }
//	function called when Button is Clicked  
	public void actionPerformed(ActionEvent ae) {
		for(int j=0;j<9;j++) {	
			if(ae.getSource() == btns[j]) {
				if(btns[j].getText() != "") {
//					// System.out.println("Wrong Move");
					JOptionPane.showMessageDialog(frame, "Don't Cheat");
					break;
				}else if(turn%2 == 0) {
					i=31;
					btns[j].setText("X");
					btns[j].setForeground(Color.GREEN);
				}else {
					i=31;
					btns[j].setText("O");
					btns[j].setForeground(Color.red);
				}
				boolean win = false;
				String x1 = btns[0].getText();
				String x2 = btns[1].getText();
				String x3 = btns[2].getText();
				String x4 = btns[3].getText();
				String x5 = btns[4].getText();
				String x6 = btns[5].getText();
				String x7 = btns[6].getText();
				String x8 = btns[7].getText();
				String x9 = btns[8].getText();
				if(x1 != "" && ((x1 == x2 && x2 == x3) || (x1 == x5 && x5 == x9) || (x1 == x4 && x1 == x7))) {
					win = true;
				}else if(x5 != "" && ((x2 == x5 && x5 == x8) || (x4 == x5 && x5 == x6) || (x3 == x5) && (x5 == x7))) {
					win = true;
				}else if(x9 != "" && ((x3 == x6 && x6 == x9) || (x7 == x8 && x8 == x9))) {
					win = true;
				}
				if(win == true) {
					i = -1;
					frame.dispose();
					new ResultFrame(turn%2 + 1);	
					return;
				}
				turn++;
				labelPlayer.setText(String.valueOf(turn%2 + 1));
//				// System.out.println(isComputer);
				int index = 0;
				for(int k=0;k<9;k++) {
					if(arr[k] == j) {
						index = j;
						break;
					}
				}
//				// System.out.println("Index "+index);
				
				for(int var=index; var<9-1; var++) {
					arr[var] = arr[var+1];
					// System.out.print(arr[var] + " ");
				}
				// System.out.println();
//				size--;
				if(isComputer == true && turn%2 == 1 && turn < 8) {
					play();
				}else if(isComputer == true && turn%2 == 1) {
					i=0;
//					turn = 0;
					frame.dispose();
					new ResultFrame(turn%2 + 12);
				}
			}
		}
	}
	
	
	public static void main(String args[]) {
		if(args.length > 0)
			isComputer = true;
	    TimerTask task = new MainFrame();
	    Timer timer = new Timer(); 
	    timer.schedule(task, 1000, 1000);  // 2000 - delay (can set to 0 for immediate execution), 5000 is a frequency.
	      
	}
}

package tictactoe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.border.*;

public class MenuFrame implements ActionListener{
	private JFrame frame;
//	btnSinglePlayer is the single player (computer as an opponent)
//	btnDualPlayer is for dual players
	private JButton btnSinglePlayer, btnDualPlayer, btnInfo;
	private Dimension ss = Toolkit.getDefaultToolkit().getScreenSize();
	private int sWidth = ss.width;
//	private int sHeight = ss.height;
//	arrowLabel is the arrow on the screen
//	title is tictactoe
//	popupLabel1 is the label when i button is pressed
	private JLabel title, arrowLabel, popupLabel1;
	
	public MenuFrame(){
		frame = new JFrame("Tic Tac Toe");
		
		Font font = new Font(Font.SERIF, Font.BOLD, 55);
		title = new JLabel("Tic Tac Toe");
		title.setBounds(sWidth/2 - 150, 50, 400, 130);
		title.setFont(font);
		
		btnInfo = new JButton("i");
		btnInfo.setBounds(sWidth -100, 100, 40, 40);
		btnInfo.addActionListener(this);
		btnInfo.setFocusable(false);
		btnInfo.setBorder(new RoundedBorder(10));
		btnInfo.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		frame.add(btnInfo);
		
		int btnW = 250;
		
		arrowLabel = new JLabel(">");
		arrowLabel.setForeground(new Color(220, 150, 230));
//		arrowLabel.setBackground(new Color(120, 150, 130));
		arrowLabel.setBounds(sWidth/2 - btnW/2 - 50, 200+100, 50, 50);
		arrowLabel.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		
		btnSinglePlayer = new JButton("Single Player");
		btnSinglePlayer.setBounds(sWidth/2 - btnW/2, 200+75, 250, 100);
//		btnSinglePlayer.setFocusable(false);
		btnSinglePlayer.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN) {
					btnDualPlayer.requestFocus();
					arrowLabel.setBounds(sWidth/2 - btnW/2 - 50, 400+75, 50, 50);
				}else if(e.getKeyCode() == 10) {
//					// System.out.println(" single ");
					String x[] = {"raj"};
					MainFrame.main(x);
					frame.dispose();	
				}
			}
		});
		btnDualPlayer = new JButton("Dual Player");
		btnDualPlayer.setBounds(sWidth/2 - btnW/2, 400+50, 250, 100);
//		btnDualPlayer.setFocusable(false);
		btnDualPlayer.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_UP) {
						btnSinglePlayer.requestFocus();
						arrowLabel.setBounds(sWidth/2 - btnW/2 - 50, 200+100, 50, 50);
					}else if(e.getKeyCode() == 10) {
//						// System.out.println(" dual ");
						String arr[] = new String[0];
						MainFrame.main(arr);
						frame.dispose();
					}
				}
		});
		btnSinglePlayer.addActionListener(this);
		btnDualPlayer.addActionListener(this);
		frame.add(arrowLabel);
		frame.add(title);
		frame.add(btnSinglePlayer);
		frame.add(btnDualPlayer);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setSize(ss.width, ss.height);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == btnSinglePlayer) {
			String x[] = {"raj"};
			MainFrame.main(x);
			frame.dispose();	
		}else if(ae.getSource() == btnDualPlayer) {
			String arr[] = new String[0];
			MainFrame.main(arr);
			frame.dispose();
		}else if(ae.getSource() == btnInfo) {
			JOptionPane.showMessageDialog(frame, "1. Choose to play as a single player or multiplayer\n"
					+ "2. You can use arrow keys also\n"
					+ "3. As single player first move will be play by you and computer will play as second player\n"
					+ "4. you can select a grid using mouse or by numbers\n"
					+ "5. In multi player two players can play at same time");
		}
	}
	public static void main(String args[]) {
		new MenuFrame();
	}
	
}

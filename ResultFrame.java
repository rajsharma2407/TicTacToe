package tictactoe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ResultFrame implements ActionListener{
	/* result frame */
	private JFrame frame;
	/* this label will show the result of the game */
	private JLabel resultLabel;
	/* Button to start a new game */
	private JButton btn;
	/* this string will consist the result which we put in the resultLabel */
	private String result;
//	it will give the dimension of screen
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	public ResultFrame(int x) {
//		System.out.println(4);
		frame = new JFrame("TIC TAC TOE");
		if(x == 1) {
			result = "Player 1 wins the match";
		}else if (x == 2) {
			result = "Player 2 wins the match";
		}else {
			result = "Both players played well";
		}
		resultLabel = new JLabel(result);
		resultLabel.setBounds(90, 30, 250, 40);
		resultLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		resultLabel.setForeground(Color.BLUE);
		
		btn = new JButton("New Match");
		btn.setBounds(150, 100, 100, 40);
		btn.addActionListener(this);
		btn.setFocusable(false);
		
		frame.add(btn);
		frame.setResizable(false);
		frame.add(resultLabel);
		frame.setLayout(null);
		frame.setSize(400, 250);
		frame.setVisible(true);
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.getContentPane().setBackground(new Color(100, 250, 200));
	}
	public void actionPerformed(ActionEvent ae) {
		frame.dispose();
		new MenuFrame();
	}
	public static void main(String[] args) {
		new MenuFrame();
	}
}

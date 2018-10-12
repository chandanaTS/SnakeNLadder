package snake;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class SnakeandLadders {

	private JFrame frame;
	int Player1x=777;
	int Player1y=484;
	int Player1Move=70;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SnakeandLadders window = new SnakeandLadders();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SnakeandLadders() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chandana\\Desktop\\SnakeNLadder\\gui.jpg"));
		frame.setBounds(20, 20, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlayer = new JLabel();
		ImageIcon player1=new ImageIcon(new ImageIcon(SnakeandLadders.class.getResource("/images/player-1.png")).getImage().getScaledInstance(40, 100, Image.SCALE_DEFAULT));
		lblPlayer.setIcon(player1);
		lblPlayer.setBounds(Player1x, Player1y, 40, 100);
		frame.getContentPane().add(lblPlayer);
		
		JLabel lblPlayer2 = new JLabel();
		ImageIcon player2=new ImageIcon(new ImageIcon(SnakeandLadders.class.getResource("/images/player-2.png")).getImage().getScaledInstance(40, 100, Image.SCALE_DEFAULT));
		lblPlayer2.setIcon(player2);
		lblPlayer2.setBounds(888, 484, 40, 100);
		frame.getContentPane().add(lblPlayer2);
		
		JLabel lblBoard = new JLabel();
		ImageIcon board=new ImageIcon(new ImageIcon(SnakeandLadders.class.getResource("/images/gui.jpg")).getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT));
		lblBoard.setIcon(board);
		lblBoard.setBounds(0, 0, 700, 700);
		frame.getContentPane().add(lblBoard);
		
		JLabel lblDice = new JLabel();
		ImageIcon dice=new ImageIcon(new ImageIcon(SnakeandLadders.class.getResource("/images/dice-1.png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		lblDice.setIcon(dice);
		lblDice.setBounds(807, 117, 100, 100);
		frame.getContentPane().add(lblDice);
		
		JButton btnNewButton = new JButton("Roll Dice");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Random ran = new Random();
				int ranNum=ran.nextInt(6)+1;
				ImageIcon dice=new ImageIcon(new ImageIcon(SnakeandLadders.class.getResource("/images/dice-"+ranNum+".png")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
				lblDice.setIcon(dice);
				
				if(Player1x==777) {
					Player1x=0;
					Player1y=550;
				}
				else {
					if(Player1Move==70&&Player1x+Player1Move>=700) {
						Player1y-=70;
						Player1Move=-70;
					}
					else if(Player1Move==-70&&Player1x+Player1Move<0) {
						Player1y-=70;
						Player1Move=70;
					}
					else {
						Player1x+=Player1Move;//Player1x=Player1x+Player1Move; 
					}
					
				}
				lblPlayer.setBounds(Player1x, Player1y, 40, 100);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(752, 257, 205, 50);
		frame.getContentPane().add(btnNewButton);
		
		
		
}
}
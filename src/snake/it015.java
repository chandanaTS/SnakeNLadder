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
	int Player1Pos=-1;
	int Player2Pos=-1;
	int turn=1;
	int[] boardOrder[]= {{0, 630}, {70, 630}, {140, 630}, {210, 630}, {280, 630}, {350, 630}, {420, 630}, {490, 630}, {560, 630}, {630, 630},
						{630, 560}, {560, 560}, {490, 560}, {420, 560}, {350, 560}, {280, 560}, {210, 560}, {140, 560}, {70, 560}, {0, 560},
						{0, 490}, {70, 490}, {140, 490}, {210, 490}, {280, 490}, {350, 490}, {420, 490}, {490, 490}, {560, 490}, {630, 490},
						{630, 420}, {560, 420}, {490, 420}, {420, 420}, {350, 420}, {280, 420}, {210, 420}, {140, 420}, {70, 420}, {0, 420},
						{0, 350}, {70, 350}, {140, 350}, {210, 350}, {280, 350}, {350, 350}, {420, 350}, {490, 350}, {560, 350}, {630, 350},
						{630, 280}, {560, 280}, {490, 280}, {420, 280}, {350, 280}, {280, 280}, {210, 280}, {140, 280}, {70, 280}, {0, 280},
						{0, 210}, {70, 210}, {140, 210}, {210, 210}, {280, 210}, {350, 210}, {420, 210}, {490, 210}, {560, 210}, {630, 210},
						{630, 140}, {560, 140}, {490, 140}, {420, 140}, {350, 140}, {280, 140}, {210, 140}, {140, 140}, {70, 140}, {0, 140},
						{0, 70}, {70, 70}, {140, 70}, {210, 70}, {280, 70}, {350, 70}, {420, 70}, {490, 70}, {560, 70}, {630, 70},
						{630, 0}, {560, 0}, {490, 0}, {420, 0}, {350, 0}, {280, 0}, {210, 0}, {140, 0}, {70, 0}, {0, 0}};
	int[] snakes[]= {{17,7},{54,34},{62,19},{64,60},{93,73},{95,75},{98,79}};
	int[] ladders[]={{1,38},{4,14},{9,31},{21,42},{28,84},{51,67},{72,91},{80,99}};
	

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
		ImageIcon player1=new ImageIcon(new ImageIcon(SnakeandLadders.class.getResource("/images/player-1.png")).getImage().getScaledInstance(30, 70, Image.SCALE_DEFAULT));
		lblPlayer.setIcon(player1);
		lblPlayer.setBounds(777, 484, 30, 70);
		frame.getContentPane().add(lblPlayer);
		
		JLabel lblPlayer2 = new JLabel();
		ImageIcon player2=new ImageIcon(new ImageIcon(SnakeandLadders.class.getResource("/images/player-2.png")).getImage().getScaledInstance(30, 70, Image.SCALE_DEFAULT));
		lblPlayer2.setIcon(player2);
		lblPlayer2.setBounds(888, 484, 30, 70);
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
				
				if(turn==1) {
					turn=2;
					if(Player1Pos+ranNum<100) {
						Player1Pos+=ranNum;
					}
					if(Player1Pos==99) {
						System.out.println("Player 1 Won the game");
					}
				}
				else {
					turn=1;
					if(Player2Pos+ranNum<100) {
						Player2Pos+=ranNum;
					}
					if(Player2Pos==99) {
						System.out.println("Player 2 Won the game");
					}
				}
				for(int x=0;x<snakes.length;x++){
					if(snakes[x][0]==(Player1Pos+1)){
						Player1Pos=snakes[x][1]-1;
					}
					if(snakes[x][0]==(Player2Pos+1)){
						Player2Pos=snakes[x][1]-1;
					}
				}
				for(int y=0;y<ladders.length;y++){
					if(ladders[y][0]==(Player1Pos+1)){
						Player1Pos=ladders[y][1]-1;
					}
					if(ladders[y][0]==(Player2Pos+1)){
						Player2Pos=ladders[y][1]-1;
					}
				}
				lblPlayer.setBounds(boardOrder[Player1Pos][0],boardOrder[Player1Pos][1]-40,30,70);
				lblPlayer2.setBounds(boardOrder[Player2Pos][0],boardOrder[Player2Pos][1]-40,30,70);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(752, 257, 205, 50);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\chandana\\Desktop\\SnakeNLadder\\player-2.png"));
		lblNewLabel.setBounds(355, 205, 121, 73);
		frame.getContentPane().add(lblNewLabel);
		
		
		
}
}
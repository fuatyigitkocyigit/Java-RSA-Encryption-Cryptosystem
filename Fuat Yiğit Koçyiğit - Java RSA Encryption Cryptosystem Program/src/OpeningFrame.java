//-----------------------------------------------------
// Title: Opening Frame Class
// Authors: Fuat Yiðit Koçyiðit
// ID: 16429085948
// Section: 1
// Assignment: 4
//-----------------------------------------------------

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class OpeningFrame extends JFrame {
	
	ImageIcon tedu1 = new ImageIcon("1582184352751.jpg");

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpeningFrame frame = new OpeningFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OpeningFrame() {
		setTitle("Welcome!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setForeground(Color.GREEN);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		panel.setBounds(4, 10, 618, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel OpeningMessage1 = new JLabel("Welcome to the RSA Public-Key Cryptosystem!");
		OpeningMessage1.setBounds(6, 10, 606, 51);
		panel.add(OpeningMessage1);
		OpeningMessage1.setHorizontalAlignment(SwingConstants.CENTER);
		OpeningMessage1.setBackground(Color.WHITE);
		OpeningMessage1.setForeground(Color.CYAN);
		OpeningMessage1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		
		JLabel OpeningMessage2 = new JLabel("Please Select which operation you want to do (you can open both windows in one time).");
		OpeningMessage2.setHorizontalAlignment(SwingConstants.LEFT);
		OpeningMessage2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		OpeningMessage2.setBounds(10, 85, 606, 35);
		contentPane.add(OpeningMessage2);
		
		JLabel PreparedbyMessage = new JLabel("Prepared by Fuat Yi\u011Fit Ko\u00E7yi\u011Fit");
		PreparedbyMessage.setBounds(417, 250, 199, 13);
		contentPane.add(PreparedbyMessage);
		
		JButton OpeningEncryptButton = new JButton("Encrypt");
		OpeningEncryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EncryptFrame frame1 = new EncryptFrame();
				frame1.setVisible(true);
				
			}
		});
		OpeningEncryptButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		OpeningEncryptButton.setBounds(90, 168, 208, 65);
		contentPane.add(OpeningEncryptButton);
		
		JButton OpeningDecryptButton = new JButton("Decrypt");
		OpeningDecryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DecryptFrame frame2 = new DecryptFrame();
				frame2.setVisible(true);
				
			}
		});
		OpeningDecryptButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		OpeningDecryptButton.setBounds(343, 168, 208, 65);
		contentPane.add(OpeningDecryptButton);
		
		/*
		BufferedImage myPicture = ImageIO.read(new File("/Image/1582184352751.jpg"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		add(picLabel);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon img = new ImageIcon(getClass().getResource("1582184352751.jpg"));
		lblNewLabel.setIcon(img);
		lblNewLabel.setBounds(260, 96, 89, 79);
		contentPane.add(lblNewLabel);
		*/
	}
}

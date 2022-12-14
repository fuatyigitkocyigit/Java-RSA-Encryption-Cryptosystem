//-----------------------------------------------------
// Title: Encrypt Frame Class
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
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class EncryptFrame extends JFrame {

	static String plaintext = "";
	private JPanel contentPane;
	private JTextField inputP;
	private JTextField inputQ;
	private JTextField inputE;
	JTextField inputMessage;
	
    JLabel labelP;
    JLabel labelQ;
    JLabel labelTotient;
    JLabel labelE;
    JLabel labelN;
    JLabel labelN2;
    JLabel labelD;
    JLabel encryptedMessage;
    JLabel inputPLabel;
    JLabel inputQLabel;
    JLabel inputELabel;
    JButton encryptButton;
	
	
	int p = 0;
	int q = 0;
	int n = 0;
	int totient = 0;
	int ee = 0;
	int d = 0;

	JTextField textField;
	private JLabel lblNewLabel_1;
	private JButton decryptButton;
	private JLabel decryptedMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EncryptFrame frame = new EncryptFrame();
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
	public EncryptFrame() {
		
		ValueActionListener valueListener = new ValueActionListener();
        MessageActionListener messageListener = new MessageActionListener();
        ButtonActionListener buttonListener = new ButtonActionListener();
		
		setTitle("RSA Encryption");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please select the key values to use or select a key pair. (Please select only 1 Check-box and click more than 2 times)");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 10, 1066, 13);
		contentPane.add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Key pair 1 => P= 29 , Q= 47, E= 83");
		chckbxNewCheckBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					p = 29;
					q = 47;
					ee = 83;
					
					useSelectedKeys(29,47,83);
				}		
	        };
		});
		chckbxNewCheckBox.setBounds(10, 29, 441, 21);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxKeyPair = new JCheckBox("Key pair 2 => P= 11 , Q= 29, E= 83");
		chckbxKeyPair.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					p = 11;
					q = 29;
					ee = 83;
					
					useSelectedKeys(11,29,83);
				}
			};
		});
		chckbxKeyPair.setBounds(10, 52, 441, 21);
		contentPane.add(chckbxKeyPair);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Key pair 3 => P= 19, Q= 47, E= 97");
		chckbxNewCheckBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					p = 19;
					q = 47;
					ee = 97;
					
					useSelectedKeys(19,47,97);
				}
	        };
		});
		chckbxNewCheckBox_1.setBounds(10, 75, 441, 21);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Create new key:");
		chckbxNewCheckBox_2.setBounds(10, 98, 152, 21);
		contentPane.add(chckbxNewCheckBox_2);
		
		inputPLabel = new JLabel("P= ");
		inputPLabel.setBounds(168, 102, 25, 13);
		contentPane.add(inputPLabel);
		
		inputP = new JTextField();
		inputP.setBounds(187, 102, 96, 19);
		contentPane.add(inputP);
		inputP.setColumns(10);
		
		inputP.addActionListener(valueListener);
		
		inputQLabel = new JLabel("Q=");
		inputQLabel.setBounds(293, 102, 45, 13);
		contentPane.add(inputQLabel);
		
		inputQ = new JTextField();
		inputQ.setBounds(312, 102, 96, 19);
		contentPane.add(inputQ);
		inputQ.setColumns(10);
		
		inputQ.addActionListener(valueListener);
		
		inputELabel = new JLabel("E=");
		inputELabel.setBounds(418, 102, 290, 13);
		contentPane.add(inputELabel);
		
		inputE = new JTextField();
		inputE.setBounds(715, 99, 96, 19);
		contentPane.add(inputE);
		inputE.setColumns(10);
		
		inputE.addActionListener(valueListener);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "RSA Values", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(4, 135, 1042, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		labelP = new JLabel("P = " +p);
		labelP.setBounds(6, 15, 236, 21);
		panel.add(labelP);
		
		labelQ = new JLabel("Q = " +q);
		labelQ.setBounds(252, 19, 227, 13);
		panel.add(labelQ);
		
		labelTotient = new JLabel("Totient = " +totient);
		labelTotient.setBounds(6, 38, 227, 13);
		panel.add(labelTotient);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Public Keys:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(6, 62, 1026, 35);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		labelE = new JLabel("E = " +ee);
		labelE.setBounds(10, 11, 466, 13);
		panel_2.add(labelE);
		
		labelN = new JLabel("N = " +n);
		labelN.setBounds(486, 11, 530, 13);
		panel_2.add(labelN);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 107, 1026, 30);
		panel.add(panel_1);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Private Key:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		labelD = new JLabel("D = " +d);
		labelD.setBounds(10, 10, 227, 14);
		panel_1.add(labelD);
		
		labelN2 = new JLabel("N = " +n);
		labelN2.setBounds(485, 11, 531, 13);
		panel_1.add(labelN2);
		
		JLabel lblNewLabel_7 = new JLabel("Please enter the message you want to encrypt here:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(10, 292, 477, 31);
		contentPane.add(lblNewLabel_7);
		
		inputMessage = new JTextField();
		inputMessage.setBounds(10, 324, 477, 52);
		contentPane.add(inputMessage);
		inputMessage.setColumns(10);
		
		inputMessage.addActionListener(messageListener);
		
		encryptButton = new JButton("Encrypt the Message");
		encryptButton.addActionListener(buttonListener);
		
		encryptButton.setBackground(Color.CYAN);
		encryptButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		encryptButton.setBounds(92, 386, 323, 47);
		contentPane.add(encryptButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.RED);
		panel_3.setForeground(Color.RED);
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_3.setBounds(491, 292, 555, 107);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		encryptedMessage = new JLabel("Encrypted Message = ");
		encryptedMessage.setBounds(10, 21, 543, 67);
		panel_3.add(encryptedMessage);
		encryptedMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		textField = new JTextField();
		textField.setBounds(654, 414, 109, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("<html>You can copy the ciphertext from <br> here or directly decrypt it.");
		lblNewLabel_1.setBounds(474, 402, 189, 41);
		contentPane.add(lblNewLabel_1);
		
		decryptButton = new JButton("Decrypt Ciphertext");
		decryptButton.setBounds(773, 412, 127, 21);
		contentPane.add(decryptButton);
		
		decryptButton.addActionListener(buttonListener);
		
		decryptedMessage = new JLabel("= ");
		decryptedMessage.setBounds(910, 409, 136, 24);
		contentPane.add(decryptedMessage);
	}
    
    public class ValueActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int temp;
            if (event.getSource() == inputP) {
                temp = Integer.parseInt(inputP.getText());
                if (isPrime(temp,3)) {
                    p = temp;
                    labelP.setText("P = " + p);
                }
                inputP.setText(null);

            }
            else if (event.getSource() == inputQ) {
                temp = Integer.parseInt(inputQ.getText());
                if (isPrime(temp,3)) {
                    q = temp;
                    labelQ.setText("Q = " + q);
                }
                inputQ.setText(null);

            }
            else {
                temp = Integer.parseInt(inputE.getText());
                if (!isPrime(temp,3)) {
                    temp = 0;
                }
                if (gcd(temp, totient) != 1) {
                    JOptionPane.showMessageDialog(null, "The number was a divisor of " + totient, "Error",
                            JOptionPane.PLAIN_MESSAGE);
                    temp = 0;
                }
                if (temp != 0) {
                    ee = temp;
                    labelE.setText("E = " + ee);
                }
                inputE.setText(null);
                calcD();
            }
            if (p != 0 && q != 0) {
            	inputE.setEnabled(true);
                n = p * q;
                labelN.setText("N = " + n);
                labelN2.setText("N = " + n);
                totient = (p - 1) * (q - 1);
                labelTotient.setText("Totient = " + totient);
                inputELabel.setText("Enter a prime number that is not a divisor of " + totient);
            }
        }
    }

	public class MessageActionListener implements ActionListener {
	
	    @Override
	    public void actionPerformed(ActionEvent event) {
	        plaintext = inputMessage.getText();
	        encryptButton.setEnabled(true);
	    }
	}
	
	public class ButtonActionListener implements ActionListener {
        int[] c;
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == encryptButton) {
                int[] m = new int[plaintext.length()];
                for (int i = 0; i < plaintext.length(); i++) {
                    m[i] = plaintext.charAt(i);
                }
                c = new int[plaintext.length()];
                BigInteger nBig = new BigInteger(n + "");

                StringBuilder ciphertext = new StringBuilder();
                for (int i = 0; i < m.length; i++) {
                    BigInteger a = new BigInteger(m[i] + "");
                    BigInteger b = a.pow(ee);
                    b = b.mod(nBig);
                    c[i] = b.intValue();
                    ciphertext.append(c[i]);
                }
                encryptedMessage.setText("Encrypted Message : " + ciphertext);
                textField.setText("" + ciphertext);
                decryptButton.setEnabled(true);
            }
            else {
                BigInteger nBig = new BigInteger(n + "");
                StringBuilder decryptedC = new StringBuilder();

                for (int j : c) {
                    BigInteger a = new BigInteger(j + "");
                    BigInteger b = a.pow(d);
                    b = b.mod(nBig);
                    decryptedC.append((char) b.intValue());
                }
                decryptedMessage.setText("= " + decryptedC);
            }
        }
    }
	
    public void useSelectedKeys(int inP, int inQ, int inE) {
			p = inP;
			q = inQ;
			ee = inE;
			
			int temp;
           	temp = p;
            p = temp;
            labelP.setText("P = " + p);
            inputP.setText(null);

            temp = q;
            q = temp;
            labelQ.setText("Q = " + q);
            inputQ.setText(null);

            temp = ee;
            
            /*
            if (!isPrime(temp,3)) {
                temp = 0;
            }
            if (gcd(temp, totient) != 1) {
                JOptionPane.showMessageDialog(null, "The number was a divisor of " + totient, "Error",
                        JOptionPane.PLAIN_MESSAGE);
                temp = 0;
            }
            */

            ee = temp;
            labelE.setText("E = " + ee);
            inputE.setText(null);
            calcD();
            
            if (p != 0 && q != 0) {
            	inputE.setEnabled(true);
                n = p * q;
                labelN.setText("N = " + n);
                labelN2.setText("N = " + n);
                totient = (p - 1) * (q - 1);
                labelTotient.setText("Totient =    " + totient);
                inputELabel.setText("Enter a prime below 100. Not a divisor of " + totient);
            }
    }
	
	static int power(int a,int n, int p) {
        int res = 1;

        a = a % p;
     
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * a) % p;
            }
            n = n >> 1;
            a = (a * a) % p;
        }
        return res;
    }
     
    static boolean isPrime(int n, int k) {
	    if (n <= 1 || n == 4) return false;
	    if (n <= 3) return true;
	
	    while (k > 0) {
	        int a = 2 + (int)(Math.random() % (n - 4));
	        if (power(a, n - 1, n) != 1) {
	            return false;
	        }
	        k--;
	    }
        return true;
    }
       
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public void calcD() {
        int s = 0;
        int t = 1;
        int xs = 1;
        int xt = 0;
        int r = ee;
        int xr = totient;
        int quotient = xr / r;
        
        while (r != 1 && r!=0) {
        	System.out.println(r);
        	quotient = xr / r;
            int temp = r;
            r = xr % r;
            xr = temp;
            temp = s;
            s = xs - quotient * s;
            xs = temp;

            temp = t;
            t = xt - quotient * t;
            xt = temp;
        }

        if (t < 0) {
            d = totient + t;
        } 
        else {
            d = t;
        }
        labelD.setText("D = " + d);
    }
}

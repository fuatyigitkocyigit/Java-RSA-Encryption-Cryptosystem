//-----------------------------------------------------
// Title: Decrypt Frame Class
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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;

public class DecryptFrame extends JFrame {

	private JPanel contentPane;
	private JTextField inputMessageD;
	private JTextField inputED;
	private JTextField inputND;
	private JTextField inputDD;
	
	static String plaintext = "";
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
    JLabel decryptedMessage;
    JLabel inputPLabel;
    JLabel inputQLabel;
    JLabel inputELabel;
    JButton decryptButton;
    JButton decryptButton2;
	
	
	int p = 0;
	int q = 0;
	int n = 0;
	int totient = 0;
	int ee = 0;
	int d = 0;
	
	int[] c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DecryptFrame frame = new DecryptFrame();
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
	public DecryptFrame() {
			
		ValueActionListener valueListener = new ValueActionListener();
        MessageActionListener messageListener = new MessageActionListener();
        ButtonActionListener buttonListener = new ButtonActionListener();
		
		setTitle("RSA Decryption");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1070, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter the message you want to decrypt here:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 10, 1036, 21);
		contentPane.add(lblNewLabel);
		
		inputMessageD = new JTextField();
		inputMessageD.setBounds(10, 41, 1036, 61);
		contentPane.add(inputMessageD);
		inputMessageD.setColumns(10);
		
		inputMessageD.addActionListener(messageListener);
		
		JLabel lblNewLabel_1 = new JLabel("Please enter the keys here:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 122, 1036, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("E= ");
		lblNewLabel_2.setBounds(10, 145, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		inputED = new JTextField();
		inputED.setBounds(30, 145, 96, 19);
		contentPane.add(inputED);
		inputED.setColumns(10);
		
		inputED.addActionListener(valueListener);
		
		JLabel lblNewLabel_3 = new JLabel("N=");
		lblNewLabel_3.setBounds(156, 145, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		inputND = new JTextField();
		inputND.setBounds(176, 145, 96, 19);
		contentPane.add(inputND);
		inputND.setColumns(10);
		
		inputND.addActionListener(valueListener);
		
		JLabel lblNewLabel_4 = new JLabel("D=");
		lblNewLabel_4.setBounds(305, 145, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		inputDD = new JTextField();
		inputDD.setBounds(325, 145, 96, 19);
		contentPane.add(inputDD);
		inputDD.setColumns(10);
		
		inputDD.addActionListener(valueListener);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, Color.CYAN));
		panel.setBounds(24, 264, 997, 159);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel decryptedMessage = new JLabel("Decrypted Message = ");
		decryptedMessage.setBounds(6, 10, 985, 143);
		panel.add(decryptedMessage);
		decryptedMessage.setFont(new Font("Tahoma", Font.BOLD, 16));
			
		decryptButton2 = new JButton("Decrypt the Message");
		decryptButton2.setBackground(Color.CYAN);
		decryptButton2.setFont(new Font("Tahoma", Font.BOLD, 16));
		decryptButton2.setBounds(70, 176, 305, 61);
		contentPane.add(decryptButton2);
		
		decryptButton2.addActionListener(buttonListener);
		
	}
        

    	
    public class ValueActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            int temp;
            if (event.getSource() == inputED) {
                temp = Integer.parseInt(inputED.getText());
                ee = temp;
                System.out.println(ee);
                inputED.setText(null);
            }
            else if (event.getSource() == inputND) {
                temp = Integer.parseInt(inputND.getText());
                n = temp;
                System.out.println(n);
                inputND.setText(null);
            }
            else if (event.getSource() == inputDD) {
                temp = Integer.parseInt(inputDD.getText());
                d = temp;
                System.out.println(d);
                inputDD.setText(null);
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
	    	plaintext = inputMessageD.getText();
	    	System.out.println(plaintext);
	    	c = new int[plaintext.length()];
            for (int i = 0; i < plaintext.length(); i++) {
            	String x = String.valueOf(plaintext.charAt(i));
                c[i] = Integer.parseInt(x);
            }
	        //System.out.println(plaintext);
	        decryptButton2.setEnabled(true);
	    }
	}
	
	public class ButtonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
        	
            if (event.getSource() != decryptButton2) {
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
                decryptedMessage.setText("Encrypted Message : " + ciphertext);
                inputMessageD.setText("" + ciphertext);
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
                decryptedMessage.setText("Decrypted Message: " + decryptedC);
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
        //labelD.setText("D = " + d);
    }
}

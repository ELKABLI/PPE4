package maquettes;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class FenetreConnexion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreConnexion frame = new FenetreConnexion();
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
	public FenetreConnexion() {
		setTitle("Connexion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Connexion");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		int x = (this.getWidth()/2)- 100;
		lblNewLabel.setBounds(x, 13, 200, 28);
		contentPane.add(lblNewLabel);
		
		JLabel identifiant = new JLabel("Identifiant");
		identifiant.setFont(new Font("Tahoma",Font.LAYOUT_LEFT_TO_RIGHT,25));
		identifiant.setLayout(null);
		identifiant.setBounds(100,200, 147, 30);
		identifiant.setForeground(Color.BLUE);
		contentPane.add(identifiant);
		
		JLabel mot_de_passe = new JLabel("Mot de passe");
		mot_de_passe.setFont(new Font("Tahoma",Font.LAYOUT_LEFT_TO_RIGHT,25));
		mot_de_passe.setForeground(Color.BLUE);
		mot_de_passe.setBounds(100, 250, 200, 30);
		contentPane.add(mot_de_passe);
		

		textField = new JTextField();		
		textField.setBounds(400, 200, 300, 30);
		contentPane.add(textField);

		
		textField_1 = new JTextField();
		textField_1.setBounds(400, 250, 300, 30);
		contentPane.add(textField_1);
		
		JButton btnValider = new JButton("valider");
		btnValider.setBounds(50, 410, 200, 100);
		contentPane.add(btnValider);
		
		JButton btnAnnul = new JButton("annul\u00E9");
		int XbtnAnnul = this.getWidth()*3/4 - 50;
		btnAnnul.setBounds(XbtnAnnul, 410, 200, 100);
		contentPane.add(btnAnnul);
		
		
		
		
		
	
	}
}

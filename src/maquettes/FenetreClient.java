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

public class FenetreClient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JFormattedTextField jtf = new JFormattedTextField(NumberFormat.getIntegerInstance());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreClient frame = new FenetreClient();
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
	public FenetreClient() {
		setTitle("Fiche client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fiche Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		int x = this.getWidth()/2-53;
		lblNewLabel.setBounds(x, 13, 106, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setLayout(null);
		lblNewLabel_1.setBounds(100,100, 147, 33);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.WHITE);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setForeground(Color.BLUE);
		lblPrenom.setBounds(100, 150, 114, 16);
		contentPane.add(lblPrenom);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setForeground(Color.BLUE);
		lblAdresse.setBounds(100, 200, 114, 16);
		contentPane.add(lblAdresse);
		textField = new JTextField();
		
		textField.setLocation(60, 60);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(400, 100, 300, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(400, 150, 300, 30);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(400, 200, 300, 30);
		contentPane.add(textField_2);
		
		JLabel lblCodePostale = new JLabel("Code Postale");
		lblCodePostale.setForeground(Color.BLUE);
		lblCodePostale.setBounds(100, 250, 114, 16);
		contentPane.add(lblCodePostale);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setForeground(Color.BLUE);
		lblVille.setBounds(100, 300, 114, 16);
		contentPane.add(lblVille);
		
		JLabel lblTel = new JLabel("Date de naissance");
		lblTel.setForeground(Color.BLUE);
		lblTel.setBounds(100, 400, 114, 16);
		contentPane.add(lblTel);
		
		JLabel label = new JLabel("T\u00E9l\u00E9phone");
		label.setForeground(Color.BLUE);
		label.setBounds(100, 350, 114, 16);
		contentPane.add(label);
		
		JLabel lab = new JLabel("\uf0c0");
		lab.setForeground(Color.red);
		contentPane.add(lab);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(400, 250, 300, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(400, 300, 300, 30);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(400, 350, 300, 30);
		contentPane.add(textField_5);
		
		DateFormat Y = new SimpleDateFormat("Y");
		JFormattedTextField textField_6 = new JFormattedTextField(Y);
		
		textField_6.setColumns(10);
		textField_6.setBounds(400, 400, 300, 30);
		contentPane.add(textField_6);
		
		JButton btnValider = new JButton("Valider");
		int XbtnValider = this.getWidth()*3/4-50;
		int YbtnValider = this.getHeight()/4-25;
		btnValider.setBounds(339, 584, 100, 50);
		contentPane.add(btnValider);
	}
}

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

public class FenetreArticle extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JFormattedTextField jtf = new JFormattedTextField(NumberFormat.getIntegerInstance());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetreArticle frame = new FenetreArticle();
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
	public FenetreArticle() {
		setTitle("Fiche Article");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fiche Article");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		int x = this.getWidth()/2-75;
		lblNewLabel.setBounds(x, 13, 150, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom Article");
		lblNewLabel_1.setLayout(null);
		lblNewLabel_1.setBounds(100,100, 147, 33);
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.WHITE);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPrenom = new JLabel("Catégortie");
		lblPrenom.setForeground(Color.BLUE);
		lblPrenom.setBounds(100, 150, 114, 16);
		contentPane.add(lblPrenom);
		
		JLabel lblAdresse = new JLabel("Code Article");
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
		
		JLabel lblCodePostale = new JLabel("Prix");
		lblCodePostale.setForeground(Color.BLUE);
		lblCodePostale.setBounds(100, 250, 114, 16);
		contentPane.add(lblCodePostale);
			
		JLabel lblTel = new JLabel("Quantité");
		lblTel.setForeground(Color.BLUE);
		lblTel.setBounds(100, 300, 114, 16);
		contentPane.add(lblTel);
		
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(400, 250, 300, 30);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(400, 300, 300, 30);
		contentPane.add(textField_4);
		
		JButton btnValider = new JButton("Valider");
		int XbtnValider = this.getWidth()*3/4-50;
		int YbtnValider = this.getHeight()/4-25;
		btnValider.setBounds(339, 584, 100, 50);
		contentPane.add(btnValider);
	}
}

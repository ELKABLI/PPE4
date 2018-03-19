package maquettes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Quitter extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quitter frame = new Quitter();
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
	public Quitter() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBackground(Color.WHITE);
		setType(Type.UTILITY);
		setTitle("ATTENTION");
		setBounds(600, 300, 450, 201);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEtesVousSur = new JLabel("ETES VOUS SUR DE VOULOIR");
		lblEtesVousSur.setHorizontalAlignment(SwingConstants.CENTER);
		lblEtesVousSur.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEtesVousSur.setBounds(12, 13, 408, 38);
		contentPane.add(lblEtesVousSur);
		
		JButton btnNewButton = new JButton("OUI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int code = 0;
				System.exit(code);
				dispose();
				Loguer frame = new Loguer();
				frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(68, 111, 100, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("NON");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBounds(272, 111, 100, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblVousDeconnectez = new JLabel("VOUS DECONNECTER ?");
		lblVousDeconnectez.setHorizontalAlignment(SwingConstants.CENTER);
		lblVousDeconnectez.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVousDeconnectez.setBounds(12, 50, 408, 38);
		contentPane.add(lblVousDeconnectez);
	}
}

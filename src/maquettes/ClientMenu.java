package maquettes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

public class ClientMenu extends JFrame {

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
					String var = null;
					ClientMenu frame = new ClientMenu(var);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param string 
	 */
	public ClientMenu(final String str) {

		setUndecorated(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 600, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnCClients = new JButton("Votre Compte");
		btnCClients.setForeground(Color.BLUE);
		btnCClients.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//String str = null;
					ClientClients frame = new ClientClients(str);
					frame.setVisible(true);
					
					//ajouter du code pour afficher la fiche client du client
					
					
					
					}
		});
		btnCClients.setBounds(10, 11, 162, 70);
		panel.add(btnCClients);
		
		JButton btnCArticles = new JButton("Nos Articles");
		btnCArticles.setForeground(Color.BLUE);
		btnCArticles.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientArticles frame = new ClientArticles();
				frame.setVisible(true);
			}
		});
		btnCArticles.setBounds(418, 11, 162, 70);
		panel.add(btnCArticles);
		
		JButton btnCCommandes = new JButton("Vos Commandes");
		btnCCommandes.setForeground(Color.BLUE);
		btnCCommandes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientCommandes frame = new ClientCommandes(str);
				frame.setVisible(true);
				
				//chargement de la table à l'ouverture de la fenetre
				
				
			}
		});
		btnCCommandes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCCommandes.setBounds(10, 379, 162, 70);
		panel.add(btnCCommandes);
		
		
		JButton btnExit = new JButton("Se Deconnecter");
		btnExit.setForeground(Color.BLUE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Quitter frame = new Quitter();
					frame.setVisible(true);
					
		
				
			}
		});
		
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnExit.setBounds(418, 379, 162, 70);
		panel.add(btnExit);
		
		/*
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ClientMenu.class.getResource("/ressource/img/logo.PNG")));
		lblNewLabel.setBounds(71, 69, 456, 463);
		panel.add(lblNewLabel);*/
	}
}

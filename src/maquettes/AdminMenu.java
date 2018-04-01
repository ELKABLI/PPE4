package maquettes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
//import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class AdminMenu extends JFrame {

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
					AdminMenu frame = new AdminMenu();
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
	public AdminMenu() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 600, 470);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(Color.BLUE, 5, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnACommandes = new JButton("Gestion des Commandes");
		btnACommandes.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnACommandes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminCommandes frame = new AdminCommandes();
				frame.setVisible(true);
			
			}
		});
		btnACommandes.setForeground(Color.BLUE);
		btnACommandes.setBounds(10, 389, 162, 70);
		contentPane.add(btnACommandes);
		
		JButton btnNewButton_3 = new JButton("Gestion des Clients");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminClients frame = new AdminClients();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setBounds(10, 11, 162, 70);
		contentPane.add(btnNewButton_3);
		
		JButton btnExit = new JButton("Deconnection");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quitter frame = new Quitter();
				frame.setVisible(true);
				
			}
		});
		btnExit.setForeground(Color.BLUE);
		btnExit.setBounds(412, 389, 162, 70);
		contentPane.add(btnExit);
		
		JButton btnStatisc = new JButton("Statistique");
		btnStatisc.setForeground(Color.BLUE);
		btnStatisc.setBounds(412, 11, 162, 70);
		contentPane.add(btnStatisc);
		
		/* piste d'amélioration de l'application
		JButton btnGraph = new JButton("Graphique");
		btnGraph.setForeground(Color.BLUE);
		btnGraph.setBounds(412, 205, 162, 70);
		contentPane.add(btnGraph);*/
		
		JButton btnGestionDesArticles = new JButton("Gestion des Articles");
		btnGestionDesArticles.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnGestionDesArticles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminArticles frame = new AdminArticles();
				frame.setVisible(true);
			}
		});
		btnGestionDesArticles.setForeground(Color.BLUE);
		btnGestionDesArticles.setBounds(10, 205, 162, 70);
		contentPane.add(btnGestionDesArticles);
		
		JLabel label = new JLabel("");
		//label.setIcon(new ImageIcon(AdminMenu.class.getResource("/ressource/img/logo.PNG")));
		label.setBounds(77, 48, 456, 463);
		contentPane.add(label);
	}
}

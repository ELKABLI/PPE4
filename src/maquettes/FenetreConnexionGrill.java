package maquettes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class FenetreConnexionGrill extends JFrame {
	private JTextField txtIdentifiant;
	private JTextField txtMotdepasse;
	private JPanel contentPane;
	public FenetreConnexionGrill() {
		this.setTitle("Connexion grille");
		
		
		
		
		this.setSize(900, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
	    //On définit le layout à utiliser sur le content pane
	    contentPane.setLayout(new BorderLayout());
	    contentPane.setBackground(Color.CYAN);
	    setContentPane(contentPane);
	    this.setVisible(true);
	    
	    JPanel panel_centre = new JPanel();
	    //ajout du jPanel au centre du contentPane
	    contentPane.add(panel_centre, BorderLayout.CENTER);
	    //On défini le layout du panel_centre
	    panel_centre.setLayout(new BorderLayout(0, 0));
	    
	    //création de la grille au centre
	    JPanel panel_connexion = new JPanel();
	    panel_connexion.setBorder(new EmptyBorder(50, 50, 50, 50));
	 
	    panel_centre.add(panel_connexion);
	    //On défini le layout du panel_connexion en gbl
	    GridBagLayout gbl_panel_connexion = new GridBagLayout();
	    gbl_panel_connexion.rowHeights = new int[] {50, 50};
	    gbl_panel_connexion.columnWidths = new int[] {200, 200};
	    gbl_panel_connexion.columnWeights = new double[]{0.0, 1.0};
		gbl_panel_connexion.rowWeights = new double[]{0.0, 0.0};
	    panel_connexion.setLayout(gbl_panel_connexion);
	    
	    JLabel lblIdentifiant = new JLabel("Identifiant");
	    GridBagConstraints gbc_lblIdentifiant = new GridBagConstraints();
	    gbc_lblIdentifiant.anchor = GridBagConstraints.EAST;
	    gbc_lblIdentifiant.insets = new Insets(0, 0, 5, 5);
	    gbc_lblIdentifiant.gridx = 0;
	    gbc_lblIdentifiant.gridy = 0;
	    panel_connexion.add(lblIdentifiant, gbc_lblIdentifiant);
	    
	    txtIdentifiant = new JTextField();
	    txtIdentifiant.setText("identifiant");
	    GridBagConstraints gbc_txtIdentifiant = new GridBagConstraints();
	    gbc_txtIdentifiant.insets = new Insets(0, 0, 5, 0);
	    gbc_txtIdentifiant.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtIdentifiant.gridx = 1;
	    gbc_txtIdentifiant.gridy = 0;
	    panel_connexion.add(txtIdentifiant, gbc_txtIdentifiant);
	    txtIdentifiant.setColumns(10);
	    
	    JLabel lblMotDePasse = new JLabel("Mot de passe");
	    GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
	    gbc_lblMotDePasse.anchor = GridBagConstraints.EAST;
	    gbc_lblMotDePasse.insets = new Insets(0, 0, 0, 5);
	    gbc_lblMotDePasse.gridx = 0;
	    gbc_lblMotDePasse.gridy = 1;
	    panel_connexion.add(lblMotDePasse, gbc_lblMotDePasse);
	    
	    txtMotdepasse = new JTextField();
	    txtMotdepasse.setText("Mot_de_passe");
	    GridBagConstraints gbc_txtMotdepasse = new GridBagConstraints();
	    gbc_txtMotdepasse.fill = GridBagConstraints.HORIZONTAL;
	    gbc_txtMotdepasse.gridx = 1;
	    gbc_txtMotdepasse.gridy = 1;
	    panel_connexion.add(txtMotdepasse, gbc_txtMotdepasse);
	    txtMotdepasse.setColumns(10);
	    
	    
	    
	    JPanel panel_bas = new JPanel();
	    contentPane.add(panel_bas, BorderLayout.SOUTH);
	    panel_bas.setLayout(new BorderLayout(0, 0));
	    
	    JPanel panel_actions = new JPanel();
	    panel_bas.add(panel_actions, BorderLayout.CENTER);
	    GridBagLayout gbl_panel_actions = new GridBagLayout();
	    gbl_panel_actions.columnWidths = new int[] {200, 100, 200};
	    gbl_panel_actions.rowHeights = new int[] {70, 0};
	    gbl_panel_actions.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_actions.rowWeights = new double[]{0.0};
	    panel_actions.setLayout(gbl_panel_actions);
	    
	    JButton btnConnextion = new JButton("Connextion");
	    GridBagConstraints gbc_btnConnextion = new GridBagConstraints();
	    gbc_btnConnextion.insets = new Insets(0, 0, 5, 5);
	    gbc_btnConnextion.gridx = 0;
	    gbc_btnConnextion.gridy = 0;
	    panel_actions.add(btnConnextion, gbc_btnConnextion);
	    
	    JButton btnQuitter = new JButton("Quitter");
	    GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
	    gbc_btnQuitter.insets = new Insets(0, 0, 5, 0);
	    gbc_btnQuitter.gridx = 2;
	    gbc_btnQuitter.gridy = 0;
	    panel_actions.add(btnQuitter, gbc_btnQuitter);
	  //On défini le layout du panel_connexion en gbl
	    
	    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FenetreConnexionGrill conectGrille = new FenetreConnexionGrill();

	}

}

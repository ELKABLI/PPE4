package maquettes;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminCommandes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTable table;
	
	public Connection conn = null ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminCommandes frame = new AdminCommandes();
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
	public AdminCommandes() {
		setType(Type.UTILITY);
		setTitle("GESTION DES COMMANDES");
		setResizable(false);
		setBounds(10, 600, 600, 470);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(114, 19, 109, 23);
		textField.setColumns(10);
		
		JLabel lblListe = new JLabel("Liste :");
		lblListe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblListe.setBounds(11, 135, 80, 15);
		
		JButton btnValider = new JButton("Recherche");
		btnValider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnValider.setForeground(Color.BLUE);
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String varIDcommandes = textField.getText();
				String vardatecommandes = textField_2.getText();
				
				try {

				Class.forName("com.mysql.jdbc.Driver");	
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
				String query = "SELECT * FROM commandes WHERE IDcommandes = '"+varIDcommandes+"' OR Datecommandes = '"+vardatecommandes+"' ";
				java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
				ResultSet rs = pstm.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Pas de connexion à la base de données "  + ex.getMessage());
				ex.printStackTrace(); 
			}
			}
		});
		btnValider.setBounds(241, 92, 108, 23);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAnnuler.setForeground(Color.BLUE);
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");textField_2.setText("");
			}
		});
		btnAnnuler.setBounds(442, 92, 90, 23);
		
		JLabel lblRfrence = new JLabel("R\u00E9f\u00E9rence");
		lblRfrence.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRfrence.setBounds(11, 21, 90, 15);
		
		textField_2 = new JTextField();
		textField_2.setBounds(392, 19, 140, 23);
		textField_2.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblListe);
		contentPane.add(btnValider);
		contentPane.add(lblRfrence);
		contentPane.add(textField);
		contentPane.add(btnAnnuler);
		contentPane.add(textField_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 161, 573, 222);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel modele = (DefaultTableModel) table.getModel();
				int selectedRowIndex = table.getSelectedRow();
				textField.setText(modele.getValueAt(selectedRowIndex, 0).toString());
				textField_2.setText(modele.getValueAt(selectedRowIndex, 1).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnModifier.setForeground(Color.BLUE);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String varIDcommandes = textField.getText();
				String vardatecommandes = textField_2.getText();
				try {
					
					Class.forName("com.mysql.jdbc.Driver");	
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
					String query = "UPDATE commandes SET Datecommandes = '" +vardatecommandes+"' WHERE IDcommandes = '" +varIDcommandes+"'  ";
					java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
					int i = pstm.executeUpdate();
					if (i != 0) {
						JOptionPane.showMessageDialog(null, "Commande Modifiée");
					}
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Pas de connexion à la base de données " + ex.getMessage());
					ex.printStackTrace();
			}
				
			}
		});
		btnModifier.setBounds(11, 401, 103, 23);
		contentPane.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSupprimer.setForeground(Color.BLUE);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String varSaisie = textField.getText();
				int n = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir supprimmer ce client ?");
				try {
					if (n == JOptionPane.YES_OPTION) {
					Class.forName("com.mysql.jdbc.Driver");	
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
					String query = "DELETE FROM commandes WHERE IDcommandes = '" +varSaisie+"' ";
					java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
					int i = pstm.executeUpdate();
					if (i != 0) {
						JOptionPane.showMessageDialog(null, "Commande supprimée");
					}
                        
					}
					
				} catch(Exception ex){
					JOptionPane.showMessageDialog(null, "Pas de connexion à la base de données " + ex.getMessage());
					ex.printStackTrace();
			}
			}
		});
		btnSupprimer.setBounds(126, 401, 103, 23);
		contentPane.add(btnSupprimer);
		
		JButton btnImprimer = new JButton("Imprimer");
		btnImprimer.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnImprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MessageFormat header = new MessageFormat ("titre");
                MessageFormat footer = new MessageFormat ("Page {0,number,integer}");
                
                try{table.print(JTable.PrintMode.FIT_WIDTH, header, footer);}
                
                catch (Exception eP){JOptionPane.showMessageDialog(null, eP.getMessage());}
			}
		});
		btnImprimer.setForeground(Color.BLUE);
		btnImprimer.setBounds(241, 401, 103, 23);
		contentPane.add(btnImprimer);
		
		JLabel lblDateCommande = new JLabel("Date Commande");
		lblDateCommande.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateCommande.setBounds(257, 21, 125, 15);
		contentPane.add(lblDateCommande);
		
		JButton btnChargeTable = new JButton("Charge Table");
		btnChargeTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnChargeTable.setForeground(Color.BLUE);
		btnChargeTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {

				Class.forName("com.mysql.jdbc.Driver");	
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppe4","root",""); 
				String query = "SELECT * FROM commandes ";
				java.sql.PreparedStatement pstm = ((Connection) conn).prepareStatement(query);
				ResultSet rs = pstm.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				} catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Pas de connexion à la base de données "  + ex.getMessage());
				ex.printStackTrace();
			}
			} 
		});
		btnChargeTable.setBounds(11, 85, 132, 37);
		contentPane.add(btnChargeTable);
		
		JButton btnNewButton = new JButton("Retour");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(495, 400, 89, 23);
		contentPane.add(btnNewButton);
	}
}

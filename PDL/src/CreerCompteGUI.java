import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

/**
 * Cette classe représente l'interface permettant de créer des comptes utilisateur
 * @author Equipe PDL Groupe 6 Equipe 1
 *
 */
public class CreerCompteGUI {
	
	private int selectedIndex;

	private JFrame frame;
	private Scolarite scolarite;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldIdentifiant;
	private JTextField textFieldMotDePasse;
	private JTextField textFieldAnnee;
	private JTextField textFieldMatiere;
	private JTextField textFieldNumero;
	
	private JCheckBox chckbxCaseEtudiant;
	private JCheckBox chckbxCaseEnseignant;
	private JCheckBox chckbxCaseScolarite;
	private JCheckBox chckbxCaseGestionnaire;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args, Scolarite scolarite) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreerCompteGUI window = new CreerCompteGUI(scolarite);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreerCompteGUI(Scolarite scolarite) {
		this.scolarite = scolarite;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnBoutonRetour = new JButton("Retour");
		btnBoutonRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBoutonRetour.setBounds(530, 259, 186, 45);
		frame.getContentPane().add(btnBoutonRetour);
		
		JLabel lblInfosGenerales = new JLabel("Informations générales");
		lblInfosGenerales.setBounds(37, 10, 174, 45);
		frame.getContentPane().add(lblInfosGenerales);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(20, 68, 68, 13);
		frame.getContentPane().add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(98, 65, 96, 19);
		frame.getContentPane().add(textFieldNom);
		textFieldNom.setColumns(10);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(20, 94, 68, 13);
		frame.getContentPane().add(lblPrenom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(98, 91, 96, 19);
		frame.getContentPane().add(textFieldPrenom);
		
		JLabel lblIdentifiant = new JLabel("Identifiant :");
		lblIdentifiant.setBounds(20, 123, 65, 13);
		frame.getContentPane().add(lblIdentifiant);
		
		textFieldIdentifiant = new JTextField();
		textFieldIdentifiant.setColumns(10);
		textFieldIdentifiant.setBounds(98, 120, 96, 19);
		frame.getContentPane().add(textFieldIdentifiant);
		
		JLabel lblMotDePasse = new JLabel("Mdp :");
		lblMotDePasse.setBounds(20, 152, 68, 13);
		frame.getContentPane().add(lblMotDePasse);
		
		textFieldMotDePasse = new JTextField();
		textFieldMotDePasse.setColumns(10);
		textFieldMotDePasse.setBounds(98, 149, 96, 19);
		frame.getContentPane().add(textFieldMotDePasse);
		
		JLabel lblInformationsEtudiant = new JLabel("Compte étudiant");
		lblInformationsEtudiant.setBounds(284, 26, 104, 13);
		frame.getContentPane().add(lblInformationsEtudiant);
		
		chckbxCaseEtudiant = new JCheckBox("Je crée un compte étudiant");
		chckbxCaseEtudiant.setBounds(269, 64, 179, 21);
		frame.getContentPane().add(chckbxCaseEtudiant);
		
		JLabel lblFiliere = new JLabel("Filière :");
		lblFiliere.setBounds(262, 94, 42, 13);
		frame.getContentPane().add(lblFiliere);
		
		String[] choices = { "Classique", "Alternance",};
		
		JComboBox comboBoxFiliere = new JComboBox(choices);
		comboBoxFiliere.addActionListener(e -> {
	         // Obtention de l'indice du choix sélectionné dans le menu déroulant
	         selectedIndex = comboBoxFiliere.getSelectedIndex();
	      });
		comboBoxFiliere.setBounds(314, 90, 104, 21);
		frame.getContentPane().add(comboBoxFiliere);
		
		JLabel lblAnnee = new JLabel("Année :");
		lblAnnee.setBounds(262, 123, 52, 13);
		frame.getContentPane().add(lblAnnee);
		
		textFieldAnnee = new JTextField();
		textFieldAnnee.setBounds(314, 120, 104, 19);
		frame.getContentPane().add(textFieldAnnee);
		textFieldAnnee.setColumns(10);
		
		JLabel lblInformationsEnseignant = new JLabel("Compte enseignant");
		lblInformationsEnseignant.setBounds(503, 26, 128, 13);
		frame.getContentPane().add(lblInformationsEnseignant);
		
		chckbxCaseEnseignant = new JCheckBox("Je crée un compte enseignant");
		chckbxCaseEnseignant.setBounds(481, 64, 198, 21);
		frame.getContentPane().add(chckbxCaseEnseignant);
		
		JLabel lblMatiere = new JLabel("Matière :");
		lblMatiere.setBounds(467, 94, 59, 13);
		frame.getContentPane().add(lblMatiere);
		
		textFieldMatiere = new JTextField();
		textFieldMatiere.setBounds(530, 91, 114, 19);
		frame.getContentPane().add(textFieldMatiere);
		textFieldMatiere.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numéro :");
		lblNumero.setBounds(467, 123, 59, 13);
		frame.getContentPane().add(lblNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(530, 120, 114, 19);
		frame.getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		JLabel lblInformationsScolarite = new JLabel("Compte scolarité");
		lblInformationsScolarite.setBounds(64, 241, 130, 13);
		frame.getContentPane().add(lblInformationsScolarite);
		
		chckbxCaseScolarite = new JCheckBox("Je crée un compte scolarité");
		chckbxCaseScolarite.setBounds(37, 271, 186, 21);
		frame.getContentPane().add(chckbxCaseScolarite);
		
		chckbxCaseGestionnaire = new JCheckBox("Est un gestionnaire");
		chckbxCaseGestionnaire.setBounds(37, 303, 163, 21);
		frame.getContentPane().add(chckbxCaseGestionnaire);
		
		JButton btnBoutonCreer = new JButton("Créer le compte");
		btnBoutonCreer.setBounds(262, 259, 186, 45);
		frame.getContentPane().add(btnBoutonCreer);
		
		/**
		 * Creation des listener pour faire fonctionner les boutons
		 */
		chckbxCaseEtudiant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chckbxCaseEnseignant.setSelected(false);
				chckbxCaseGestionnaire.setSelected(false);
				chckbxCaseScolarite.setSelected(false);
			}
		});
		chckbxCaseEnseignant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chckbxCaseEtudiant.setSelected(false);
				chckbxCaseGestionnaire.setSelected(false);
				chckbxCaseScolarite.setSelected(false);
			}
		});
		chckbxCaseScolarite.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				chckbxCaseEnseignant.setSelected(false);
				chckbxCaseGestionnaire.setSelected(false);
				chckbxCaseEtudiant.setSelected(false);
			}
		});
		btnBoutonRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceScolarite("EsigServices", 800, 800, scolarite);
				frame.dispose();
			}
		});
		
		btnBoutonCreer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int typeCompte;
				if(chckbxCaseEtudiant.isSelected())
				{
					InteractionBDD moduleBDD = new InteractionBDD();
					if(!moduleBDD.idExist(0, Integer.parseInt(textFieldIdentifiant.getText())))
					{
						int identifiant = Integer.parseInt(textFieldIdentifiant.getText());
						String nom = textFieldNom.getText().toUpperCase();
						String prenom = textFieldPrenom.getText().toLowerCase();
						System.out.println("Prenom : "+prenom);
						String mail = prenom + "."+ nom + "@groupe-esigelec.org";
						mail = mail.toLowerCase();
						mail = mail.replace(" ", "");
						String mdp = textFieldMotDePasse.getText();
						String filiere = "";
						if(selectedIndex == 0)
						{
							filiere = "FISE";
						}
						if(selectedIndex == 1)
						{
							filiere = "FISA";
						}
						int annee = Integer.parseInt(textFieldAnnee.getText());
						Etudiant etudiant = new Etudiant(identifiant, nom, prenom, mail, mdp, filiere, annee);
						moduleBDD.insertAccount(0, etudiant, null, null);
						JOptionPane.showMessageDialog(null, "Le compte a ete cree", "Information", JOptionPane.INFORMATION_MESSAGE);
						clearAll();
					}
				}
				else if(chckbxCaseEnseignant.isSelected())
				{
					InteractionBDD moduleBDD = new InteractionBDD();
					if(!moduleBDD.idExist(0, Integer.parseInt(textFieldIdentifiant.getText())))
					{
						int identifiant = Integer.parseInt(textFieldIdentifiant.getText());
						System.out.println("Here 1");
						String nom = textFieldNom.getText().toUpperCase();
						System.out.println("Here 2");
						String prenom = textFieldPrenom.getText().toLowerCase();
						System.out.println("Here 3");
						String mail = prenom + "."+ nom + "@esigelec.fr";
						System.out.println("Here 4");
						mail = mail.toLowerCase();
						System.out.println("Here 5");
						mail = mail.replace(" ", "");
						System.out.println("Here 6");
						String mdp = textFieldMotDePasse.getText();
						System.out.println("Here 7");
						String numero = textFieldNumero.getText();
						System.out.println("Here 8");
						String matiere = textFieldMatiere.getText();
						System.out.println("Here 9");
						Matiere obj = new Matiere(matiere, 1, 1, 1);
						System.out.println("Here 10");
						System.out.println(obj.getNom());
						Enseignant enseignant = new Enseignant(identifiant, nom, prenom, mail, mdp, numero, obj);
						System.out.println("Here 11");
						moduleBDD.insertAccount(1, null, enseignant, null);
						System.out.println("Here 12");
						JOptionPane.showMessageDialog(null, "Le compte a ete cree", "Information", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("Here 13");
						clearAll();
					}
				}
				else if(chckbxCaseScolarite.isSelected()){
					InteractionBDD moduleBDD = new InteractionBDD();
					if(!moduleBDD.idExist(2, Integer.parseInt(textFieldIdentifiant.getText())))
					{
						int identifiant = Integer.parseInt(textFieldIdentifiant.getText());
						System.out.println("Here 1");
						String nom = textFieldNom.getText().toUpperCase();
						System.out.println("Here 2");
						String prenom = textFieldPrenom.getText().toLowerCase();
						System.out.println("Here 3");
						String mail = prenom + "."+ nom + "@scolarite.esigelec.fr";
						System.out.println("Here 4");
						mail = mail.toLowerCase();
						System.out.println("Here 5");
						mail = mail.replace(" ", "");
						System.out.println("Here 6");
						String mdp = textFieldMotDePasse.getText();
						System.out.println("Here 7");
						boolean estGest = false;
						if(chckbxCaseGestionnaire.isSelected())
						{
							estGest = true;
						}
						Scolarite scolarite = new Scolarite(identifiant, nom, prenom, mail, mdp, estGest);
						System.out.println("Here 11");
						moduleBDD.insertAccount(2, null, null, scolarite);
						System.out.println("Here 12");
						JOptionPane.showMessageDialog(null, "Le compte a ete cree", "Information", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("Here 13");
						clearAll();
					}
				}
				
				
			}
		});
	}
	
	private void clearAll()
	{
		textFieldNom.setText("");
		textFieldPrenom.setText("");
		textFieldIdentifiant.setText("");
		textFieldMotDePasse.setText("");
		textFieldAnnee.setText("");
		textFieldMatiere.setText("");
		textFieldNumero.setText("");
		
		chckbxCaseEtudiant.setSelected(false);
		chckbxCaseEnseignant.setSelected(false);
		chckbxCaseGestionnaire.setSelected(false);
		chckbxCaseScolarite.setSelected(false);
	}
	
	
}

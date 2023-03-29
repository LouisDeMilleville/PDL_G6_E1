import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InterfaceEleve extends JFrame {
	
	private JPanel jpContainer;
	private JLabel jlMessageBienvenue;
	private JLabel jlMessageFermeture;
	private JPanel jpSousContainer;
	private JButton jbPlanning;
	private JButton jbNotes;
	private JButton jbAbsencesNormales;
	private JButton jbAbsencesDistanciel;
	private JButton jbDeconnexion;
	
	private Etudiant etudiant;
	
	private InteractionBDD moduleBDD;
	
	public InterfaceEleve(String titre, int width, int height, Etudiant etudiant) {
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.moduleBDD = moduleBDD;
		this.etudiant = etudiant;
		
		jpContainer = new JPanel();
		jpContainer.setLayout(new GridLayout(4, 1));//L1 : msg bienvenue, L2 : Message affichant ou non une période de fermeture, L3 : grille 2x2 fonctions eleve L4 : Deconnexion
		
		jlMessageBienvenue = new JLabel();
		jlMessageBienvenue.setText("Bonjour, "+ etudiant.getPrenom()+" "+etudiant.getNom());
		jlMessageBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jlMessageBienvenue);
		
		jlMessageFermeture = new JLabel();
		jlMessageFermeture.setText("Pas de fermeture de prevue");
		jlMessageFermeture.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jlMessageFermeture);
		
		jpSousContainer = new JPanel();
		jpSousContainer.setLayout(new GridLayout(2, 2));
		
		jbPlanning = new JButton();
		jbPlanning.setText("Mon planning");
		jbPlanning.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbPlanning);
		
		jbNotes = new JButton();
		jbNotes.setText("Mes notes");
		jbNotes.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbNotes);
		
		jbAbsencesNormales = new JButton();
		jbAbsencesNormales.setText("Mes absences normales");
		jbAbsencesNormales.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbAbsencesNormales);
		
		jbAbsencesDistanciel = new JButton();
		jbAbsencesDistanciel.setText("Mes absences en distanciel");
		jbAbsencesDistanciel.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbAbsencesDistanciel);
		
		jpContainer.add(jpSousContainer);
		
		jbDeconnexion = new JButton();
		jbDeconnexion.setText("Deconnexion");
		jbDeconnexion.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jbDeconnexion);
		
		//Ajouter verification dans table fermeture
		
		this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}	

}

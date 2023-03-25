import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InterfaceEleve extends JFrame {
	
	private JPanel jlContainer;
	private JLabel jlMessageBienvenue;
	
	InteractionBDD moduleBDD;
	
	public InterfaceEleve(String titre, int width, int height, InteractionBDD moduleBDD) {
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.moduleBDD = moduleBDD;
		
		jlContainer = new JPanel();
		jlContainer.setLayout(new GridLayout(4, 1));//L1 : msg bienvenue, L2 : Message affichant ou non une période de fermeture, L3 : grille 2x2 fonctions eleve L4 : Deconnexion
		
		jlMessageBienvenue = new JLabel();
		jlMessageBienvenue.setText("Bonjour, prenom + nom");
		jlMessageBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		jlContainer.add(jlMessageBienvenue);
		
		//Ajouter verification dans table fermeture
	}	

}

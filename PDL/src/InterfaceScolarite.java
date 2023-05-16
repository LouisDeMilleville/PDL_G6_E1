import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Cette classe est l'interface scolarite
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */
public class InterfaceScolarite extends JFrame {
	
	private Scolarite scolarite;
	
	private JPanel jpContainer;
	private JLabel jlMessageBienvenue;
	private JLabel jlMessageFermeture;
	private JPanel jpSousContainer;
	private JButton jbGestionCours;
	private JButton jbGestionEleve;
	private JButton jbGestionEnseignant;
	private JButton jbGestionGroupe;
	private JButton jbGestionNote;
	private JButton jbGestionAbsence;
	private JButton jbGestionStatutEcole;
	private JButton jbCreationCompte;
	private JButton jbDeconnexion;
	
	public InterfaceScolarite(String titre, int width, int height, Scolarite scolarite)
	{
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.scolarite = scolarite;
		
		jpContainer = new JPanel();
		jpContainer.setLayout(new GridLayout(3, 1));
		
		jlMessageBienvenue = new JLabel();
		jlMessageBienvenue.setText("Bonjour, "+ scolarite.getPrenom()+" "+scolarite.getNom());
		jlMessageBienvenue.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jlMessageBienvenue);
		
		jlMessageFermeture = new JLabel();
		jlMessageFermeture.setText("Pas de fermeture de prevue");
		jlMessageFermeture.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jlMessageFermeture);
		
		jpSousContainer = new JPanel();
		if (scolarite.getGestionnaire())
		{
			jpSousContainer.setLayout(new GridLayout(5, 2));
		}
		else
		{
			jpSousContainer.setLayout(new GridLayout(4, 2));
		}
		
		
		jbGestionCours = new JButton();
		jbGestionCours.setText("Gestion des cours");
		jbGestionCours.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbGestionCours);
		
		jbGestionEleve = new JButton();
		jbGestionEleve.setText("Gestion des eleves");
		jbGestionEleve.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbGestionEleve);
		
		jbGestionEnseignant = new JButton();
		jbGestionEnseignant.setText("Gestion des enseigants");
		jbGestionEnseignant.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbGestionEnseignant);
		
		jbGestionGroupe = new JButton();
		jbGestionGroupe.setText("Gestion des groupes");
		jbGestionGroupe.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbGestionGroupe);
		
		jbGestionAbsence = new JButton();
		jbGestionAbsence.setText("Gestion des absences");
		jbGestionAbsence.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbGestionAbsence);
		
		jbGestionNote = new JButton();
		jbGestionNote.setText("Gestion des notes");
		jbGestionNote.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbGestionNote);
		
		if(scolarite.getGestionnaire())
		{
			jbGestionStatutEcole = new JButton();
			jbGestionStatutEcole.setText("Gestion du statut de l'ecole");
			jbGestionStatutEcole.setHorizontalAlignment(SwingConstants.CENTER);
			jpSousContainer.add(jbGestionStatutEcole);
			
			jbCreationCompte = new JButton();
			jbCreationCompte.setText("Creer des comptes");
			jbCreationCompte.setHorizontalAlignment(SwingConstants.CENTER);
			jpSousContainer.add(jbCreationCompte);
		}
		
		jbDeconnexion = new JButton();
		jbDeconnexion.setText("Deconnexion");
		jbDeconnexion.setHorizontalAlignment(SwingConstants.CENTER);
		jpSousContainer.add(jbDeconnexion);
		
		jpContainer.add(jpSousContainer);
		
	//Ajouter verification dans table fermeture
		
		this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		jbDeconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new InterfaceLogin("EsigServices").main(null);
				
			}
		});
        jbGestionCours.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceGestiondeCours("EsigServices", 800, 800, scolarite);
				dispose();
			}
		});
        
        jbGestionAbsence.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceChoixValidationAbsence("EsigServices", 800, 800, scolarite);
				dispose();
			}
		});
        
        if(scolarite.getGestionnaire())
        {
        	jbCreationCompte.addActionListener(new ActionListener() {
    			
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				// TODO Auto-generated method stub
    				new CreerCompteGUI(scolarite).main(null, scolarite);
    				dispose();
    			}
    		});
        }
        
		
		
	}
		
	

}

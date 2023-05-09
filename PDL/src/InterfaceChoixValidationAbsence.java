import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Cette classe est l'interface qui permet a la scolarite de choisir quel type d'absence traiter
 * @author Equipe 1 groupe 6
 * 
 * @version 1.0
 *
 */
public class InterfaceChoixValidationAbsence extends JFrame{
	
	private Scolarite scolarite;
	
	private JPanel jpContainer;
	private JButton jbAbsencesNormales;
	private JButton jbAbsencesDistanciel;
	private JButton jbAbsencesEnseignant;
	private JButton jbDeconnexion;

	
	/**
	 * Constructeur de la fenetre
	 * @param titre
	 * @param width
	 * @param height
	 * @param scolarite
	 */
	public InterfaceChoixValidationAbsence(String titre, int width, int height, Scolarite scolarite)
	{
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.scolarite = scolarite;
		
		jpContainer = new JPanel();
		jpContainer.setLayout(new GridLayout(4, 1));
		
		jbAbsencesNormales = new JButton();
		jbAbsencesNormales.setText("Verifier les absences des eleves");
		jbAbsencesNormales.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jbAbsencesNormales);
		
		jbAbsencesDistanciel = new JButton();
		jbAbsencesDistanciel.setText("Verifier les demandes de distanciel");
		jbAbsencesDistanciel.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jbAbsencesDistanciel);
		
		jbAbsencesEnseignant = new JButton();
		jbAbsencesEnseignant.setText("Verifier les absences des enseignants");
		jbAbsencesEnseignant.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jbAbsencesEnseignant);
		
		jbDeconnexion = new JButton();
		jbDeconnexion.setText("Retour");
		jbDeconnexion.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jbDeconnexion);
		
		this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		//Ajout des listener sur les differents boutons
		jbDeconnexion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new InterfaceScolarite("EsigServices", 800, 800, scolarite);
				dispose();
			}
		});
		
		jbAbsencesNormales.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		jbAbsencesDistanciel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				InteractionBDD moduleBDD = new InteractionBDD();
				ArrayList<AbsenceDistanciel> listAbs = moduleBDD.getListAbsenceDistanciel();
				new InterfaceTraitementAbsences("EsigServices", 1200, 800, scolarite, 2, listAbs, null);
				dispose();
				
			}
		});
		
		jbAbsencesEnseignant.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}

}

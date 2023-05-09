import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class InterfaceTraitementAbsences extends JFrame{
	
	private Scolarite scolarite;
	private int type;
	private ArrayList<AbsenceDistanciel> listAbsDist;
	private ArrayList<AbsenceEnseignant> listAbsEns;
	private int width;
	private int listSize;
	
	private JPanel jpContainer;
	
	
	//Type 1 : AbsenceNormaleEleves ; Type 2 : AbsencesDistancielEleves ; Type 3 : AbsenceEnseignant
	public InterfaceTraitementAbsences(String titre, int width, int height, Scolarite scolarite, int type, ArrayList<AbsenceDistanciel> listAbsDist, ArrayList<AbsenceEnseignant> listAbsEns)
	{
		this.setTitle(titre);
		this.setSize(width, (listAbsDist.size() + 2) * 80);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.scolarite = scolarite;
		this.type = type;
		this.listAbsDist = listAbsDist;
		this.listAbsEns = listAbsEns;
		listSize = listAbsDist.size();
		this.width = width;
		
		jpContainer = new JPanel();
		
		//Creation de la fenetre si affichage des absences distanciel
		if(type == 2)
		{
			jpContainer.setLayout(new GridLayout(listAbsDist.size() + 2, 1));
			JPanel SousContainer = new JPanel();
			SousContainer.setLayout(new GridLayout(1, 7));
			JLabel jlNom = new JLabel("Nom");
			jlNom.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlNom);
			JLabel jlPrenom = new JLabel("Prenom");
			jlPrenom.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlPrenom);
			JLabel jlMatiere = new JLabel("Matiere");
			jlMatiere.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlMatiere);
			JLabel jlDuree = new JLabel("Duree");
			jlDuree.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlDuree);
			JLabel jlRaison = new JLabel("Raison");
			jlRaison.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlRaison);
			JLabel jlValider = new JLabel("Valider");
			jlValider.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlValider);
			JLabel jlRefuser = new JLabel("Refuser");
			jlRefuser.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlRefuser);
			jpContainer.add(SousContainer);
			for(int i = 0 ; i < listAbsDist.size() ; i++)
			{
				JPanel jpDetails = new JPanel();
				jpDetails.setLayout(new GridLayout(1, 7));
				jlNom = new JLabel(listAbsDist.get(i).getNom());
				jlNom.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jlNom);
				jlPrenom = new JLabel(listAbsDist.get(i).getPrenom());
				jlPrenom.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jlPrenom);
				jlMatiere = new JLabel(listAbsDist.get(i).getMatiere());
				jlMatiere.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jlMatiere);
				jlDuree = new JLabel(""+listAbsDist.get(i).getDuree());
				jlDuree.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jlDuree);
				jlRaison = new JLabel(listAbsDist.get(i).getJustificatif());
				jlRaison.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jlRaison);
				JButton jbValider = new JButton("Valider");
				jbValider.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jbValider);
				final int j = i;
				JButton jbRefuser = new JButton("Refuser");
				jbRefuser.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jbRefuser);
				jbValider.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// Ajouter requete pour valider l'absence en prenant en compte l'id de l'absence
						InteractionBDD moduleBDD = new InteractionBDD();
						int id = listAbsDist.get(j).getId();
						//listAbsDist.remove(j);
						listSize--;
						System.out.println("Id abs = "+ id);
						moduleBDD.validerAbsenceDist(id);
						jbValider.setVisible(false);
						jbRefuser.setVisible(false);
						jpContainer.remove(jpDetails);
						jpContainer.setLayout(new GridLayout(listSize + 2, 1));
						refreshWindow();
					}
				});
				jbRefuser.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// Ajouter requete pour refuser l'absence en prenant en compte l'id de l'absence
						InteractionBDD moduleBDD = new InteractionBDD();
						int id = listAbsDist.get(j).getId();
						//listAbsDist.remove(j);
						listSize--;
						System.out.println("Id abs = "+ id);
						moduleBDD.refuserAbsenceDist(id);
						jbValider.setVisible(false);
						jbRefuser.setVisible(false);
						jpContainer.remove(jpDetails);
						jpContainer.setLayout(new GridLayout(listSize + 2, 1));
						refreshWindow();
						
					}
				});
				
				jpContainer.add(jpDetails);
			}
			JButton jbRetour = new JButton("Retour");
			jbRetour.setHorizontalAlignment(SwingConstants.CENTER);
			jpContainer.add(jbRetour);
			jbRetour.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new InterfaceChoixValidationAbsence("EsigServices", 800, 800, scolarite);
					dispose();
					
				}
			});
			
		}
		
		//Traitement des absences d'enseignants
		if(type == 3)
		{
			jpContainer.setLayout(new GridLayout(listAbsDist.size() + 2, 1));
			JPanel SousContainer = new JPanel();
			SousContainer.setLayout(new GridLayout(1, 6));
			JLabel jlNom = new JLabel("Nom");
			jlNom.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlNom);
			JLabel jlPrenom = new JLabel("Prenom");
			jlPrenom.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlPrenom);
			JLabel jlMatiere = new JLabel("Matiere");
			jlMatiere.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlMatiere);
			JLabel jlDuree = new JLabel("Duree");
			jlDuree.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlDuree);
			JLabel jlRaison = new JLabel("Raison");
			jlRaison.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlRaison);
			JLabel jlValider = new JLabel("Valider");
			jlValider.setHorizontalAlignment(SwingConstants.CENTER);
			SousContainer.add(jlValider);
			jpContainer.add(SousContainer);
			for(int i = 0 ; i < listAbsDist.size() ; i++)
			{
				JPanel jpDetails = new JPanel();
				jpDetails.setLayout(new GridLayout(1, 7));
				jlNom = new JLabel(listAbsDist.get(i).getNom());
				jlNom.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jlNom);
				jlPrenom = new JLabel(listAbsDist.get(i).getPrenom());
				jlPrenom.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jlPrenom);
				jlMatiere = new JLabel(listAbsDist.get(i).getMatiere());
				jlMatiere.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jlMatiere);
				jlDuree = new JLabel(""+listAbsDist.get(i).getDuree());
				jlDuree.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jlDuree);
				jlRaison = new JLabel(listAbsDist.get(i).getJustificatif());
				jlRaison.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jlRaison);
				JButton jbValider = new JButton("Valider");
				jbValider.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jbValider);
				final int j = i;
				JButton jbRefuser = new JButton("Refuser");
				jbRefuser.setHorizontalAlignment(SwingConstants.CENTER);
				jpDetails.add(jbRefuser);
				jbValider.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// Ajouter requete pour valider l'absence en prenant en compte l'id de l'absence
						InteractionBDD moduleBDD = new InteractionBDD();
						int id = listAbsDist.get(j).getId();
						//listAbsDist.remove(j);
						listSize--;
						System.out.println("Id abs = "+ id);
						moduleBDD.validerAbsenceDist(id);
						jbValider.setVisible(false);
						jbRefuser.setVisible(false);
						jpContainer.remove(jpDetails);
						jpContainer.setLayout(new GridLayout(listSize + 2, 1));
						refreshWindow();
					}
				});
				jbRefuser.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// Ajouter requete pour refuser l'absence en prenant en compte l'id de l'absence
						InteractionBDD moduleBDD = new InteractionBDD();
						int id = listAbsDist.get(j).getId();
						//listAbsDist.remove(j);
						listSize--;
						System.out.println("Id abs = "+ id);
						moduleBDD.refuserAbsenceDist(id);
						jbValider.setVisible(false);
						jbRefuser.setVisible(false);
						jpContainer.remove(jpDetails);
						jpContainer.setLayout(new GridLayout(listSize + 2, 1));
						refreshWindow();
						
					}
				});
				
				jpContainer.add(jpDetails);
			}
			JButton jbRetour = new JButton("Retour");
			jbRetour.setHorizontalAlignment(SwingConstants.CENTER);
			jpContainer.add(jbRetour);
			jbRetour.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					new InterfaceChoixValidationAbsence("EsigServices", 800, 800, scolarite);
					dispose();
					
				}
			});
			
		}
		
		
		this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	
		
		
	}
	
	public void refreshWindow()
	{
		this.setSize(width, (listSize + 2) * 80);
		this.setContentPane(jpContainer);
		this.setVisible(true);
	}

}

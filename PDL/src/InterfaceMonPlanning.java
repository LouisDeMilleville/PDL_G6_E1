import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


	public class InterfaceMonPlanning extends JFrame{
		
		private Enseignant enseignant;
		private JPanel jpContainer;
		private JLabel jlMessageInformation;
		private JPanel jpContainerDateduCours;
		private JLabel jlDateduCours;
		private JPanel jpContainerHeure;
		private JLabel jlHeure;
		private JPanel jpContainerCours;
		private JLabel jlCours;
		private JPanel jpContainerGroupe;
		private JLabel jlGroupe;
		private JPanel jpContainerBoutons;
		private JButton jbRetour;
		
		public InterfaceMonPlanning(String titre, int width, int height, Enseignant enseignant)
		{
			this.setTitle(titre);
			this.setSize(485, 204);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			jpContainer = new JPanel();
			jpContainer.setLayout(new GridLayout(8, 1));
			
			jlMessageInformation = new JLabel();
			jlMessageInformation.setText("Votre planning du jour");
			jlMessageInformation.setHorizontalAlignment(SwingConstants.CENTER);
			jpContainer.add(jlMessageInformation);
			
			jpContainerDateduCours = new JPanel();
			jpContainerDateduCours.setLayout(new GridLayout(1,2));
			
			jlDateduCours = new JLabel();
			jlDateduCours.setText("Date du cours");
			jlDateduCours.setHorizontalAlignment(SwingConstants.CENTER);
			jpContainerDateduCours.add(jlDateduCours);
	        
	        jpContainer.add(jpContainerDateduCours);
	        			
			 jpContainerHeure = new JPanel();
				jpContainerHeure.setLayout(new GridLayout(1,2));
				
				jlHeure = new JLabel();
				jlHeure.setText("Heure du cours");
				jlHeure.setHorizontalAlignment(SwingConstants.CENTER);
				jpContainerHeure.add(jlHeure);
				
				jpContainer.add(jpContainerHeure);
				
				 jpContainerCours = new JPanel();
					jpContainerCours.setLayout(new BorderLayout(1,2));
					
					jlCours = new JLabel();
					jlCours.setText("Cours");
					jlCours.setHorizontalAlignment(SwingConstants.CENTER);
					jpContainerCours.add(jlCours);
					
					jpContainer.add(jpContainerCours);
					
					 jpContainerGroupe = new JPanel();
						jpContainerGroupe.setLayout(new BorderLayout(1,2));
						
						jlGroupe = new JLabel();
						jlGroupe.setText("Groupe");
						jlGroupe.setHorizontalAlignment(SwingConstants.CENTER);
						jpContainerGroupe.add(jlGroupe);
						jpContainer.add(jpContainerGroupe);

						  jpContainerBoutons = new JPanel();
					        jpContainerBoutons.setLayout(new BorderLayout(1,2));
					        
					        jbRetour = new JButton();
							jbRetour.setText("Retour");
							jbRetour.setHorizontalAlignment(SwingConstants.CENTER);
							jpContainerBoutons.add(jbRetour);
							
			jpContainer.add(jpContainerBoutons);
		
			jbRetour.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
					new InterfaceEnseignant("EsigServices", 800, 800, enseignant);
					
				}
			});
	        
	        
	        
	        this.setContentPane(jpContainer);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
	        
		}

	}

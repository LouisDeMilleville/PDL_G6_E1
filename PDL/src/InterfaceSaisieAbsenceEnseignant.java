import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class InterfaceSaisieAbsenceEnseignant extends JFrame{
	
	private Enseignant enseignant;
	private JPanel jpContainer;
	private JLabel jlMessageInformation;
	private JPanel jpContainerDebut;
	private JLabel jlMessageDebut;
	private JFormattedTextField jfSaisieDebut;
	private JPanel jpContainerFin;
	private JLabel jlMessageFin;
	private JFormattedTextField jfSaisieFin;
	private JPanel jpContainerRaison;
	private JLabel jlMessageRaison;
	private JTextField jtSaisieRaison;
	private JPanel jpContainerBoutons;
	private JButton jbRetour;
	private JButton jbInsertionAbsence;
	private AbsenceEnseignant absEns;
	private String identifiant;
	private DateEtHeure dateDebutAbs;
	private DateEtHeure dateFinAbs;
	private InteractionBDD moduleBDD;
	
	
	
	public InterfaceSaisieAbsenceEnseignant(String titre, int width, int height, Enseignant enseignant)
	{
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		moduleBDD = new InteractionBDD();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		jpContainer = new JPanel();
		jpContainer.setLayout(new GridLayout(5, 1));
		
		jlMessageInformation = new JLabel();
		jlMessageInformation.setText("Veuillez saisir les dates de debut et de fin de votre absence");
		jlMessageInformation.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainer.add(jlMessageInformation);
		
		jpContainerDebut = new JPanel();
		jpContainerDebut.setLayout(new GridLayout(1, 2));
		
		jlMessageDebut = new JLabel();
		jlMessageDebut.setText("Date debut :");
		jlMessageDebut.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerDebut.add(jlMessageDebut);
		
		jfSaisieDebut = new JFormattedTextField(dateFormat);
        jfSaisieDebut.setValue(new Date());
        jfSaisieDebut.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerDebut.add(jfSaisieDebut);
        jpContainer.add(jpContainerDebut);
        /*DateEtHeure date1=new DateEtHeure (0,0,0);
        DateEtHeure date2=new DateEtHeure (0,0,0);
        int id=enseignant.getId();
        AbsenceEnseignant absEns = new AbsenceEnseignant (id,0,date1,date2,"Raison");
        String dateDebut = jfSaisieDebut.getText();
        String dateDebutSplit[]=dateDebut.split("/");
        int j,m,a;
        String jour,mois,annee;
        jour=dateDebutSplit[0]; 
        mois=dateDebutSplit[1]; 
        annee=dateDebutSplit[2];
        absEns.setIdAbs(Integer.parseInt(jour+mois+annee+enseignant.getId()));
        j=Integer.parseInt(dateDebutSplit[0]); 
        m=Integer.parseInt(dateDebutSplit[1]); 
        a=Integer.parseInt(dateDebutSplit[2]); 
        DateEtHeure dateDebutAbs = new DateEtHeure (j,m,a);
        absEns.setDebut(dateDebutAbs);*/
       
        
       
        
        jpContainerFin = new JPanel();
		jpContainerFin.setLayout(new GridLayout(1, 2));
		
		jlMessageFin = new JLabel();
		jlMessageFin.setText("Date fin :");
		jlMessageFin.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerFin.add(jlMessageFin);
		
		jfSaisieFin = new JFormattedTextField(dateFormat);
        jfSaisieFin.setValue(new Date());
        jfSaisieFin.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerFin.add(jfSaisieFin);
        jpContainer.add(jpContainerFin);
        
        /*String dateFin = jfSaisieFin.getText();
        String dateFinSplit[]=dateFin.split("/");
        int j1,m1,a1;
        j1=Integer.parseInt(dateDebutSplit[0]); 
        m1=Integer.parseInt(dateDebutSplit[1]); 
        a1=Integer.parseInt(dateDebutSplit[2]); 
        DateEtHeure dateFinAbs = new DateEtHeure (j1,m1,a1);
        absEns.setFin(dateFinAbs);*/
        
        jpContainerRaison = new JPanel();
		jpContainerRaison.setLayout(new GridLayout(1, 2));
		
		jlMessageRaison = new JLabel();
		jlMessageRaison.setText("Raison de l'absence :");
		jlMessageRaison.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerRaison.add(jlMessageRaison);
		
		jtSaisieRaison = new JTextField();
		jtSaisieRaison.setText("Saisissez la raison de votre absence");
		jtSaisieRaison.setHorizontalAlignment(SwingConstants.CENTER);
		//absEns.setRaison(jtSaisieRaison.getText());
		jpContainerRaison.add(jtSaisieRaison);
        
        jpContainer.add(jpContainerRaison);
        

        
        jpContainerBoutons = new JPanel();
        jpContainerBoutons.setLayout(new GridLayout(1, 2));
        
        jbRetour = new JButton();
		jbRetour.setText("Retour");
		jbRetour.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerBoutons.add(jbRetour);
		//
		
		
		jbInsertionAbsence = new JButton();
		jbInsertionAbsence.setText("Inserer l'absence");
		jbInsertionAbsence.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerBoutons.add(jbInsertionAbsence);
		
		
		jpContainer.add(jpContainerBoutons);
		
		jbRetour.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new InterfaceEnseignant("EsigServices", 800, 800, enseignant);
				
			}
			
		});
jbInsertionAbsence.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				
				new InterfaceEnseignant("EsigServices", 800, 800, enseignant);
		        DateEtHeure date1=new DateEtHeure (0,0,0);
		        DateEtHeure date2=new DateEtHeure (0,0,0);
		        DateEtHeure dateDebutAbs = new DateEtHeure (0,0,0);
		        
		        AbsenceEnseignant absEns = new AbsenceEnseignant (0,0,date1,date2,"Raison");
		        absEns.setIdEns(enseignant.getId());
		        String dateDebut = jfSaisieDebut.getText();
		        String dateDebutSplit[]=dateDebut.split("/");
		        int j,m,a;
		        String jour,mois,annee;
		        jour=dateDebutSplit[0]; 
		        mois=dateDebutSplit[1]; 
		        annee=dateDebutSplit[2];
		        absEns.setIdAbs(Integer.parseInt(jour+mois+annee+enseignant.getId()));
		        j=Integer.parseInt(dateDebutSplit[0]); 
		        m=Integer.parseInt(dateDebutSplit[1]); 
		        a=Integer.parseInt(dateDebutSplit[2]);
		        dateDebutAbs.setAnnee(a);
		        dateDebutAbs.setJour(j);
		        dateDebutAbs.setMois(m);
		        
		        absEns.setDebut(dateDebutAbs);
		        System.out.println(dateDebutAbs);
		        DateEtHeure dateFinAbs = new DateEtHeure (0,0,0);
		        String dateFin = jfSaisieFin.getText();
		        String dateFinSplit[]=dateFin.split("/");
		        int j1,m1,a1;
		        j1=Integer.parseInt(dateDebutSplit[0]); 
		        m1=Integer.parseInt(dateDebutSplit[1]); 
		        a1=Integer.parseInt(dateDebutSplit[2]); 
		        dateDebutAbs.setAnnee(a1);
		        dateDebutAbs.setJour(j1);
		        dateDebutAbs.setMois(m1);
		      
		        absEns.setFin(dateFinAbs);
		        
		       
		        absEns.setRaison(jtSaisieRaison.getText());
		        
		        
				absEns.display();
				
				moduleBDD.addAbsenceEnseignant(absEns);
			}
			
		});
        
        
		
        this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
        
	}

}

import java.awt.GridLayout;
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
	private JButton jbDepotJustif;
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
		String DateduJour;
		
		jpContainer = new JPanel();
		jpContainer.setLayout(new GridLayout(6, 1));
		
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
        DateduJour=jfSaisieDebut.getText();
        jfSaisieDebut.setHorizontalAlignment(SwingConstants.CENTER);
        jpContainerDebut.add(jfSaisieDebut);
        jpContainer.add(jpContainerDebut);
        
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
        
        
        jpContainerRaison = new JPanel();
		jpContainerRaison.setLayout(new GridLayout(1, 2));
		
		jlMessageRaison = new JLabel();
		jlMessageRaison.setText("Raison de l'absence :");
		jlMessageRaison.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerRaison.add(jlMessageRaison);
		
		jtSaisieRaison = new JTextField();
		jtSaisieRaison.setText("Saisissez la raison de votre absence");
		jtSaisieRaison.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerRaison.add(jtSaisieRaison);
        
        jpContainer.add(jpContainerRaison);
        

        
        jpContainerBoutons = new JPanel();
        jpContainerBoutons.setLayout(new GridLayout(1, 2));
        
        jbRetour = new JButton();
		jbRetour.setText("Retour");
		jbRetour.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerBoutons.add(jbRetour);
	
		jbInsertionAbsence = new JButton();
		jbInsertionAbsence.setText("Inserer l'absence");
		jbInsertionAbsence.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerBoutons.add(jbInsertionAbsence);
		
		jbDepotJustif = new JButton();
		jbDepotJustif.setText("Inserer le justif");
		jbDepotJustif.setHorizontalAlignment(SwingConstants.CENTER);
		jpContainerBoutons.add(jbDepotJustif);
			
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
		        j1=Integer.parseInt(dateFinSplit[0]); 
		        m1=Integer.parseInt(dateFinSplit[1]); 
		        a1=Integer.parseInt(dateFinSplit[2]); 
		        dateFinAbs.setAnnee(a1);
		        dateFinAbs.setJour(j1);
		        dateFinAbs.setMois(m1);
		      
		        absEns.setFin(dateFinAbs);
		        
		       
		        absEns.setRaison(jtSaisieRaison.getText());
		        
		        
				absEns.display();
				
				moduleBDD.addAbsenceEnseignant(absEns);
			}
			
		});
jbDepotJustif.addActionListener(new ActionListener() {
	
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	dispose();
	DateEtHeure date3= new DateEtHeure (0,0,0);
	String nom=enseignant.getNom();
	String prenom=enseignant.getPrenom();
	String State="NON JUSTIFIÉ";
	String dateman = DateduJour;
    String datemanSplit[]=dateman.split("/");
	int j2,m2,a2;
	   String jour,mois,annee;
	    jour=datemanSplit[0]; 
	    mois=datemanSplit[1]; 
	    annee=datemanSplit[2];
	j2=Integer.parseInt(jour); 
    m2=Integer.parseInt(mois); 
    a2=Integer.parseInt(annee); 
    date3.setAnnee(a2);
    date3.setJour(j2);
    date3.setMois(m2);
	Justificatifabsence JustifProf= new Justificatifabsence (0,State,date3,"Raison",nom,prenom); 
    //ATTENTION CONTRAINTE D UNICITE
	JustifProf.setIdJustif(Integer.parseInt(jour+mois+annee+enseignant.getId()+7));
    JustifProf.setRaison(jtSaisieRaison.getText());
    
    JustifProf.display();
    moduleBDD.addJustificatifProf(JustifProf);
    
	
	new InterfaceEnseignant("EsigServices", 800, 800, enseignant);
	
}

});
        
        
		
        this.setContentPane(jpContainer);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
        
	}

}

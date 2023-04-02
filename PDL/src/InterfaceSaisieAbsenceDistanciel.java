import javax.swing.JFrame;

public class InterfaceSaisieAbsenceDistanciel extends JFrame{
	
	private Etudiant etudiant;
	
	public InterfaceSaisieAbsenceDistanciel(String titre, int width, int height, Etudiant etudiant)
	{
		this.setTitle(titre);
		this.setSize(width, height);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.etudiant = etudiant;
	}

}



public class Justificatif extends DateEtHeure{
		private String typeJustificatif;
		private DateEtHeure a = new DateEtHeure (1900,1,1,7,0);

		public Justificatif(String typeJustif, int annee, int mois, int jour, int heure, int minute) {
			super(annee, mois, jour, heure, minute);
			// TODO Auto-generated constructor stub
			this.typeJustificatif = typeJustif;
		}
		
		public String getTypeJustificatif() {
			return typeJustificatif;
		
		}
		
		public void getDateEtHeure() {
		
			System.out.print("Date: " +a.getJour()+"/"+a.getMois()+"/"+a.getAnnee());
			System.out.print("Heure: "+ a.getHeure()+"H"+ a.getMinute());
		}
		
		

	}



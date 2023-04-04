
	public class Compte {
		
		private int identifiant; 
		
		private String nom;
		
		private String prenom;
		
		private String mail;
		
		private String mot_de_passe;
		
		protected Compte(int identifiant, String nom, String prenom, String mail, String mdp) {
			this.identifiant = identifiant;
			this.nom = nom;
			this.prenom = prenom;
			this.mail = mail;
			this.mot_de_passe = mdp;
			
		}
		
		public int getId() {
			return identifiant;
		}
		
		public String getNom() {
			return nom;
		}
		
		public String getPrenom() {
			return prenom;
		}
		
		public String getMail() {
			return mail;
		}
		
		public String getMotDePasse() {
			return mot_de_passe;
		}
		
		public void setMotDePasse(String nouveau_mdp) {
			this.mot_de_passe = nouveau_mdp;
		}
		
		
		
		
}

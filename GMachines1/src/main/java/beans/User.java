package beans;

public class User {
	private int id;
	private String nom;
	private String email;
	private String mdp;
	private String sexe;
	private boolean type = false;
	
	public User(int id, String nom, String email, String mdp, String sexe, boolean type) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.sexe = sexe;
		this.type = type;
	}

	public User(String nom, String email, String mdp, String sexe,boolean type) {
		super();
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.sexe = sexe;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "" +  nom;
	}
	
	
}
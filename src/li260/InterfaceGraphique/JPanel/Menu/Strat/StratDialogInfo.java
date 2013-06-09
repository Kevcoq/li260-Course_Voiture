package li260.InterfaceGraphique.JPanel.Menu.Strat;

public class StratDialogInfo {
	private String strategie, selecteur;
	private boolean observeur;

	public StratDialogInfo() {
		super();
	}

	public StratDialogInfo(String strategie, String selecteur, boolean observeur) {
		super();
		this.strategie = strategie;
		this.selecteur = selecteur;
		this.observeur = observeur;
	}

	public String getSelecteur() {
		return selecteur;
	}

	public String getStrategie() {
		return strategie;
	}

	public boolean isObserveur() {
		return observeur;
	}

	public void setObserveur(boolean observeur) {
		this.observeur = observeur;
	}

	public void setSelecteur(String selecteur) {
		this.selecteur = selecteur;
	}

	public void setStrategie(String strategie) {
		this.strategie = strategie;
	}

	@Override
	public String toString() {
		String str;
		if (this.strategie != null && this.selecteur != null) {
			str = "Description de l'objet InfoStratDialog\n";
			str += "Strategie : " + this.strategie + "\n";
			str += "Selecteur : " + this.selecteur + "\n";
			if (this.observeur)
				str += "Observeur : oui\n";
			str += "Observeur : non\n";
		} else {
			str = "Aucune information !";
		}
		return str;
	}

}

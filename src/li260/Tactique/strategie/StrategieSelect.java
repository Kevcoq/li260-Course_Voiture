package li260.Tactique.strategie;

import li260.Tactique.selecteur.Selecteur;

public interface StrategieSelect extends Strategie {

	void add(Strategie s, Selecteur select);

}

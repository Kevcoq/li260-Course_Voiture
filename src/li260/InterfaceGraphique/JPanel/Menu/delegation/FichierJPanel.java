package li260.InterfaceGraphique.JPanel.Menu.delegation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.CircuitExtends;
import li260.Plateau.circuit.Difcolexception;
import li260.Plateau.circuit.cheat.CheatCircuit;
import li260.Plateau.circuit.fact.CircuitFactoryImpl;
import li260.Plateau.circuit.impl.CircuitDeco;
import li260.Plateau.circuit.impl.CircuitZone;
import li260.Plateau.voiture.Voiture;
import li260.Plateau.voiture.fact.FerrariFactory;
import li260.Tactique.Radar.impl.RadarDijkstra;
import li260.Tactique.strategie.impl.StratDecorateur;
import li260.Tactique.strategie.impl.StrategieRadar;
import li260.mains.TestFile;
import li260.mains.tools.Jeu;
import li260.simulation.Simulation;

public class FichierJPanel {
	public CircuitExtends creerCircuit(File fichier) {
		if (fichier == null)
			return null;
		// Creation circuit
		CircuitExtends c = null;
		CircuitFactoryImpl cf1 = new CircuitFactoryImpl(fichier);
		try {
			c = new CircuitZone(cf1.build());
		} catch (Difcolexception e) {
			e.printStackTrace();
		}
		return c;
	}

	public CircuitExtends creerCircuitCheat(File fichier) {
		if (fichier == null)
			return null;
		// Creation circuit
		Circuit c = null;
		CircuitFactoryImpl cf1 = new CircuitFactoryImpl(fichier);
		try {
			c = cf1.build();
		} catch (Difcolexception e) {
			e.printStackTrace();
		}
		CircuitDeco cd = new CircuitDeco(c);
		CheatCircuit.modifCircuit(cd);

		CircuitExtends cz = new CircuitZone(cd);
		return cz;
	}

	public Simulation creerSimu(Jeu jeu) {
		Simulation simu;
		// Creation simu
		simu = new Simulation(jeu.getV(), jeu.getC(), new StratDecorateur(
				new StrategieRadar(TestFile.cmd, new RadarDijkstra(
						TestFile.thetas, jeu.getV(), jeu.getC(), jeu.getC()
								.getDijk())), jeu.getV(), jeu.getC()));
		return simu;
	}

	public Voiture creerVoiture(Circuit c) {
		Voiture v;
		// Creation voiture
		FerrariFactory f1 = new FerrariFactory(c.getPointDepart(),
				c.getDirectionDepart());
		v = f1.build();
		return v;
	}

	public void notice() {
		// TODO Auto-generated method stub
		BufferedReader lect ;
		String tmp = "";
		try
		{
			lect = new BufferedReader(new FileReader("notice")) ;
			while (lect.ready()==true) 
			{
				tmp += lect.readLine() ; 
			}
			
			JFrame frame = new JFrame("Notice");
			JLabel jl = new JLabel(tmp);
			frame.add(jl);
			frame.setVisible(true);
			frame.pack();
			
		}
		catch (NullPointerException a)
		{
			System.out.println("Erreur : pointeur null");
		}
		catch (IOException a) 
		{
			System.out.println("Probl�me d'IO");
		}
	}
}
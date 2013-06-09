package li260.Plateau.circuit.fact;

import java.io.IOException;

import li260.Plateau.circuit.Circuit;
import li260.Plateau.circuit.Difcolexception;

public interface CircuitFactory {
	public Circuit build() throws IOException, Difcolexception;
}

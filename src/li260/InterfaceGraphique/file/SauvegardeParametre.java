package li260.InterfaceGraphique.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import li260.Plateau.voiture.commande.Commande;
import li260.mains.TestFile;

public class SauvegardeParametre {

	public static void chargCmd(File fic) {

		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(fic)));
			TestFile.cmd = (Commande[]) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void chargThetas(File fic) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(fic)));
			TestFile.thetas = (double[]) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void svCmd(String name) {
		try {
			File file = new File(name);
			ObjectOutputStream oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(file)));
			oos.writeObject(TestFile.cmd);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void svThetas(String name) {
		File file = new File(name);
		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream(file)));
			oos.writeObject(TestFile.thetas);
			oos.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
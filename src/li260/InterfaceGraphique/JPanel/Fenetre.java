package li260.InterfaceGraphique.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSlider;

import li260.InterfaceGraphique.JPanel.Menu.Menu;
import li260.InterfaceGraphique.action.listener.Controleur;
import li260.InterfaceGraphique.action.listener.GereControleur;

public class Fenetre {
	private Controleur cjp;
	private ArrayList<JLabel> jLab;

	private JPanel jp;
	private JFrame jFra;

	public Fenetre() {
		jLab = new ArrayList<JLabel>();
		cjp = new GereControleur(this);
		((GereControleur) cjp).init();
	}

	public void fenetre() throws InterruptedException, IOException {
		jFra = new JFrame("Simu LI260");
		Menu menu = new Menu(cjp);
		jFra.setJMenuBar(menu.jMenuBar());

		jp = new JPanel();
		jp.setPreferredSize(new Dimension(1024, 1096));
		jp.setLayout(new BorderLayout());

		JLabel image = new JLabel(new ImageIcon("autre/f1_accueil.png"));
		JPanel panel = new JPanel();
		JButton notice = new JButton("Notice");
		notice.addActionListener(cjp);
		panel.add(notice);

		jp.add(panel, BorderLayout.BEFORE_FIRST_LINE);
		jp.add(image);

		JScrollPane jsp = new JScrollPane(jp);
		jFra.setContentPane(jsp);
		jFra.setVisible(true);
		jFra.pack();
		// jFra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void fini(final String name) {
		class Fermer implements ActionListener {
			private JFrame jf;

			public Fermer(JFrame jf) {
				this.jf = jf;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.dispose();
			}
		}
		final JFrame fini = new JFrame("Finir");
		JButton finir = new JButton(name);
		JButton prec = new JButton("Precedant");
		prec.setActionCommand("prec "+name);

		finir.addActionListener(cjp);
		finir.addActionListener(new Fermer(fini));
		prec.addActionListener(cjp);
		
		fini.add(finir, BorderLayout.CENTER);
		fini.add(prec, BorderLayout.WEST);

		fini.setAlwaysOnTop(true);
		fini.setVisible(true);
		fini.pack();
		
		Thread t = new Thread() {
			public void run() {
				while(fini.isVisible()) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				cjp.actionPerformed(new ActionEvent(name, NORM_PRIORITY, name));
			}
		};
		t.start();
	}

	public void finiZone() {
		class Fermer implements ActionListener {
			private JFrame jf;

			public Fermer(JFrame jf) {
				this.jf = jf;
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jf.dispose();
			}
		}
		final JFrame fini = new JFrame("Finir");
		JButton finir = new JButton("Zone");
		JButton prec = new JButton("Precedant");
		prec.setActionCommand("prec Zone");

		finir.addActionListener(cjp);
		finir.addActionListener(new Fermer(fini));
		prec.addActionListener(cjp);

		final JComboBox box = new JComboBox();
		box.addItem("Lent");
		box.addItem("Normal");
		box.addItem("Rapide");

		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				((GereControleur) cjp).setZone((String) box.getSelectedItem());
			}
		});

		fini.add(finir, BorderLayout.NORTH);
		fini.add(box, BorderLayout.CENTER);
		fini.add(ok, BorderLayout.SOUTH);
		fini.add(prec, BorderLayout.WEST);
		
		fini.setAlwaysOnTop(true);
		fini.setVisible(true);
		fini.pack();
		
		Thread t = new Thread() {
			public void run() {
				while(fini.isVisible()) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				cjp.actionPerformed(new ActionEvent("Zone", NORM_PRIORITY, "Zone"));
			}
		};
		t.start();
	}

	public JFrame getJFra() {
		return jFra;
	}

	public ArrayList<JLabel> getJlab() {
		return jLab;
	}

	public JPanel getJp() {
		return jp;
	}

	public Box hbox() {
		Box hbox = Box.createHorizontalBox();
		JLabel reussi = new JLabel(" | Etat : en attente");
		reussi.setName("reussi");
		jLab.add(reussi);
		JLabel nbC = new JLabel("Nb coup = 0");
		nbC.setName("nbC");
		jLab.add(nbC);
		hbox.add(nbC);
		hbox.add(reussi);
		return hbox;
	}

	public Box instant(int max) {
		Box instantBox = Box.createVerticalBox();
		instantBox.add(new JSeparator());

		JLabel inst = new JLabel("Valeur actuelle : 0");
		inst.setName("inst");
		jLab.add(inst);

		JPanel jp = new JPanel(new BorderLayout());
		JSlider slid = new JSlider(0, max, 0);
		slid.setName("Instant t = ");
		slid.addChangeListener(cjp);

		JButton jb = new JButton("Ok");
		jb.addActionListener(cjp);

		jp.add(slid, BorderLayout.CENTER);
		jp.add(jb, BorderLayout.EAST);

		instantBox.add(jp);
		instantBox.add(inst);
		return instantBox;
	}
}
package li260.InterfaceGraphique.JPanel.Menu.Strat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

import li260.InterfaceGraphique.JPanel.Menu.delegation.StratJPanel;
import li260.InterfaceGraphique.file.SauvegardeStrategie;

@SuppressWarnings("serial")
public class StratDialog extends JDialog {
	private SsoCrea sso;
	private StratDialogInfo sInfo = new StratDialogInfo();
	private JLabel icon, stratLabel, selectLabel;
	private JComboBox strat, select;
	private JRadioButton choixVrai, choixFaux;

	public StratDialog(JFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.setSize(550, 270);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.initComponent();
	}

	/*
	 * Méthode appelée pour utiliser la boîte
	 * 
	 * @return sInfo
	 */

	/*
	 * Initialise le contenu de la boîte
	 */
	private void initComponent() {
		// Icone
		icon = new JLabel(new ImageIcon("autre/formule_1.png"));
		JPanel panIcon = new JPanel();
		panIcon.setBackground(Color.white);
		panIcon.setLayout(new BorderLayout());
		panIcon.add(icon);

		// La strategie
		JPanel panStrat = new JPanel();
		panStrat.setBackground(Color.white);
		panStrat.setPreferredSize(new Dimension(220, 60));
		panStrat.setBorder(BorderFactory.createTitledBorder("Strategie"));
		strat = new JComboBox();
		for (int i = 0; i < StratJPanel.getStringStrat().length; i++)
			strat.addItem(StratJPanel.getStringStrat()[i]);
		stratLabel = new JLabel("Strategie : ");
		panStrat.add(stratLabel);
		panStrat.add(strat);

		// Le selecteur
		JPanel panSelect = new JPanel();
		panSelect.setBackground(Color.white);
		panSelect.setPreferredSize(new Dimension(300, 60));
		panSelect.setBorder(BorderFactory
				.createTitledBorder("Selecteur (pour strat selection)"));
		select = new JComboBox();
		for (int i = 0; i < StratJPanel.getStringSelect().length; i++)
			select.addItem(StratJPanel.getStringSelect()[i]);
		selectLabel = new JLabel("Selecteur : ");
		panSelect.add(selectLabel);
		panSelect.add(select);

		// L'observeur
		JPanel panObs = new JPanel();
		panObs.setBackground(Color.white);
		panObs.setBorder(BorderFactory
				.createTitledBorder("Voulez vous un observeur"));
		panObs.setPreferredSize(new Dimension(200, 60));
		choixVrai = new JRadioButton("vrai");
		choixFaux = new JRadioButton("faux");
		choixFaux.setSelected(true);
		ButtonGroup bg = new ButtonGroup();
		bg.add(choixVrai);
		bg.add(choixFaux);
		panObs.add(choixVrai);
		panObs.add(choixFaux);

		// Le chargement
		JPanel panCharg = new JPanel();
		panCharg.setBackground(Color.white);
		panCharg.setBorder(BorderFactory
				.createTitledBorder("Chargez une strat�gie"));
		panCharg.setPreferredSize(new Dimension(200, 60));
		JButton charg = new JButton("Charger");
		charg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sso.setStrat(SauvegardeStrategie.chargStrategie(sso.getJeu().getC(), sso.getJeu().getV()));
				setVisible(false);
			}
		});
		panCharg.add(charg);

		JPanel content = new JPanel();
		content.setBackground(Color.white);
		content.add(panIcon);
		content.add(panStrat);
		content.add(panSelect);
		content.add(panObs);
		content.add(panCharg);

		JPanel control = new JPanel();
		JButton okBouton = new JButton("OK");

		okBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sInfo = new StratDialogInfo((String) strat.getSelectedItem(),
						(String) select.getSelectedItem(), getObs());
				setVisible(false);
			}

			public boolean getObs() {
				if (choixVrai.isSelected())
					return true;
				return false;
			}
		});

		JButton cancelBouton = new JButton("Annuler");
		cancelBouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});

		control.add(okBouton);
		control.add(cancelBouton);

		this.getContentPane().add(content, BorderLayout.CENTER);
		this.getContentPane().add(control, BorderLayout.SOUTH);
	}

	public void setSSO(SsoCrea sso) {
		this.sso = sso;
	}

	public StratDialogInfo showSDialog() {
		this.setVisible(true);
		return this.sInfo;
	}

}

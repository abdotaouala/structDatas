package com.structurededonnees.main;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.ArbreRougeEtNoirCorrect.com.ArbreRougeNoir;
import com.ArbreRougeEtNoirCorrect.com.Data;
import com.ArbreRougeEtNoirCorrect.com.Noeud;

import com.TableDeHachage.com.TableHachage;
import com.TableDeHachage.com.ElementListeChaineeHachage;
import com.TableDeHachage.com.ListeChaineeHachage;

import liste.chainee.com.ElementListeChainee;
import liste.chainee.com.ListeChainee;

public class StructuresMain{

	private JPanel panelContentPane;
	private ListeChainee liste = new ListeChainee();
	private ArbreRougeNoir arbreRougeNoir = new ArbreRougeNoir();
	private JPanel panelListeChaineeCenter = new JPanel();
	private TableHachage tableHachage = new TableHachage();
	private JFrame frame = new JFrame();
	
	
	
	
	//private JScrollPane scrollPane = new JScrollPane(panelListeChaineeCenter);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StructuresMain frame = new StructuresMain();
					frame.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StructuresMain() {
		
		String[] tousLesPanels = {"panelListeChainee", "panelTableDeHachage", "panelAVL", "panelRougeEtNoir", "panelBArbre", "panelDebut"};
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 538, 430);
		panelContentPane = new JPanel();
		panelContentPane.setBorder(BorderFactory.createTitledBorder("Menu Principale"));
		//panelContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(panelContentPane);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayout cardLayoutPrincipale = new CardLayout();
		
		panelContentPane.setLayout(cardLayoutPrincipale);
		JButton btnCreerDiscothequeRN = new JButton("Creer Discotheque");
		JPanel panelDebut = new JPanel();
		panelContentPane.add(panelDebut, tousLesPanels[5]);
		
		panelDebut.setLayout(new GridLayout(0, 1));
		
		JLabel lblTypesDeStructures = new JLabel("Types de Structures de Donn\u00E9es");
		lblTypesDeStructures.setHorizontalAlignment(SwingConstants.CENTER);
		panelDebut.add(lblTypesDeStructures);
		
		JButton btnListeChain = new JButton("Liste Chain\u00E9e");
		
		panelDebut.add(btnListeChain);
		
		// Declaration des boutons Rouge et Noir
		JButton btnInsererRN = new JButton("Inserer");
		JButton btnRechercherRN = new JButton("Rechercher");
		JTextField textFieldRNTitre = new JTextField();
		JTextArea textAreaRN = new JTextArea();
		
		btnRechercherRN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textAreaRN.setText("");
				String titre = textFieldRNTitre.getText().trim();
				
				Noeud element = arbreRougeNoir.rechercher(titre);
				
				if(element != null)
				{
					textAreaRN.setText("");
					textAreaRN.setText(textAreaRN.getText() + "Titre = '" + element.getInfo().getTitre() + "' \n");
					textAreaRN.setText(textAreaRN.getText() + "Interprete = '" + element.getInfo().getInterprete() + "' \n");
					textAreaRN.setText(textAreaRN.getText() + "Label = '" + element.getInfo().getLabel() + "' \n");
					textAreaRN.setText(textAreaRN.getText() + "Date = '" + element.getInfo().getDate() + "' \n");
					textAreaRN.setText(textAreaRN.getText() + "Style Musicale = '" + element.getInfo().getStyleMusicale() + "' \n");
					textAreaRN.setText(textAreaRN.getText() + "------------------------------------------------------------\n");
				}
			}
		});
		
		// Declaration
		
		JTextField textFieldAVLTitre = new JTextField();
		JTextField textFieldAVLInterprete = new JTextField();
		JTextField textFieldAVLLabel = new JTextField();
		JTextField textFieldAVLDate = new JTextField();
		JTextField textFieldAVLStyleMusicale = new JTextField();
		JTextField textFieldBArbreTitre = new JTextField();
		JTextField textFieldBArbreInterprete = new JTextField();
		JTextField textFieldBArbreLabel = new JTextField();
		JTextField textFieldBArbreDate = new JTextField();
		JTextField textFieldBArbreStyleMusicale = new JTextField();
		JTextField textFieldHachTitre = new JTextField();
		JTextField textFieldHachInterprete = new JTextField();
		JTextField textFieldHachLabel = new JTextField();
		JTextField textFieldHachDate = new JTextField();
		JTextField textFieldHachStyleMusicale = new JTextField();
		JButton btnInsererHach = new JButton("Inserer");
		JButton btnRechercherHach = new JButton("Rechercher");
		JButton btnAfficherHach = new JButton("Afficher");
		JButton btnSupprimerHach = new JButton("Supprimer");
		
		
		btnSupprimerHach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String titre = textFieldHachTitre.getText().trim();
				
				if(titre.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Ce Champs est Obligatoire !!", null, JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					tableHachage.supprimer(titre);
					btnAfficherHach.doClick();
				}
			}
		});
		
		JButton btnDetruireDiscothequeHach = new JButton("Detruire Discotheque");
		JTextArea textAreaHach = new JTextArea();
		btnRechercherHach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String titre = textFieldHachTitre.getText().trim();
				if(titre.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Remplir le Champs Titre !!", null, JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Object retour = tableHachage.rechercher(titre, textAreaHach);
				}
				
			}
		});
		
		
		btnDetruireDiscothequeHach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cardLayoutPrincipale.show(panelContentPane, tousLesPanels[5]);
			}
		});
		
		JButton btnCreerDiscothequeHach = new JButton("Creer Discotheque");
		btnCreerDiscothequeHach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textFieldHachTitre.grabFocus();
				if(tableHachage == null)
				{
					tableHachage = new TableHachage();
				}
				
				btnCreerDiscothequeHach.setEnabled(false);
				btnInsererHach.setEnabled(true);
				btnRechercherHach.setEnabled(true);
				btnSupprimerHach.setEnabled(true);
				btnAfficherHach.setEnabled(true);
				btnDetruireDiscothequeHach.setEnabled(true);
				
				
				
			}
		});
		
		btnInsererHach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String titre = textFieldHachTitre.getText().trim();
				String interprete = textFieldHachInterprete.getText().trim();
				String label = textFieldHachLabel.getText().trim();
				String date = textFieldHachDate.getText().trim();
				String styleMusicale = textFieldHachStyleMusicale.getText().trim();
				if(titre.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Champs Titre est Obligatoire !!", null, JOptionPane.WARNING_MESSAGE);
					textFieldHachTitre.grabFocus();
				}
				else
				{
					ElementListeChaineeHachage element = new ElementListeChaineeHachage(titre, interprete, label, date, styleMusicale);
					//int hachCode = tableHachage.fonctionHachage(titre);
					
					tableHachage.ajouterALaTableDeHachage(element);
					btnAfficherHach.doClick();
				}
				
				
				
				
			}
		});
		
		
		
		btnAfficherHach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				tableHachage.afficherDiscotheque(textAreaHach);
			}
		});
		
		
		JButton btnAfficherRN = new JButton("Afficher l'Arbre");
		
		JButton btnDetruireLeDiscothequeRN = new JButton("Detruire le Discotheque");
		
		JButton btnSupprimerRN = new JButton("Supprimer");
		btnSupprimerRN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String titre = textFieldRNTitre.getText().trim();
				arbreRougeNoir.supprimer(new Data(titre, null, null, null, null));
				//textAreaRN.setText("");
				btnAfficherRN.doClick();
			}
		});
		
		
		
		
		JButton btnTableDeHachage = new JButton("Table de Hachage");
		btnTableDeHachage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutPrincipale.show(panelContentPane, tousLesPanels[1]);
				btnCreerDiscothequeHach.setEnabled(true);
				btnInsererHach.setEnabled(false);
				btnRechercherHach.setEnabled(false);
				btnSupprimerHach.setEnabled(false);
				btnAfficherHach.setEnabled(false);
				btnDetruireDiscothequeHach.setEnabled(false);
				textAreaHach.setText("");
				
				tableHachage = null;
			}
		});
		
		panelDebut.add(btnTableDeHachage);
		
		JButton btnArbreAvl = new JButton("Arbre AVL");
		btnArbreAvl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutPrincipale.show(panelContentPane, tousLesPanels[2]);
				btnCreerDiscothequeHach.setEnabled(true);
				btnInsererHach.setEnabled(false);
				btnRechercherHach.setEnabled(false);
				btnSupprimerHach.setEnabled(false);
				btnAfficherHach.setEnabled(false);
				btnDetruireDiscothequeHach.setEnabled(false);
				textAreaHach.setText("");
				
				tableHachage = null;
				AVLTree();
			}
		});
		panelDebut.add(btnArbreAvl);
		
		JButton btnArbreRougeEt = new JButton("Arbre Rouge et Noir");
		btnArbreRougeEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnDetruireLeDiscothequeRN.setEnabled(false);
				btnAfficherRN.setEnabled(false);
				btnInsererRN.setEnabled(false);
				btnRechercherRN.setEnabled(false);
				btnCreerDiscothequeRN.setEnabled(true);
				btnSupprimerRN.setEnabled(false);
				
				cardLayoutPrincipale.show(panelContentPane, tousLesPanels[3]);
			}
		});
		panelDebut.add(btnArbreRougeEt);
		
		JButton btnBarbre = new JButton("B-Arbre");
		btnBarbre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayoutPrincipale.show(panelContentPane, tousLesPanels[4]);
			}
		});
		panelDebut.add(btnBarbre);
		
		JPanel panelListeChainee = new JPanel();
		panelListeChainee.setBackground(new Color(240, 240, 240));
		panelContentPane.add(panelListeChainee, tousLesPanels[0]);
		panelListeChainee.setLayout(new BorderLayout(0, 0));
		
		JPanel panelListeChaineeNorth = new JPanel();
		panelListeChaineeNorth.setBorder(new TitledBorder(null, "Liste Chain\u00E9e Informations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListeChainee.add(panelListeChaineeNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelListeChaineeNorth = new GridBagLayout();
		gbl_panelListeChaineeNorth.columnWidths = new int[]{0, 0};
		gbl_panelListeChaineeNorth.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelListeChaineeNorth.columnWeights = new double[]{1.0, 1.0};
		gbl_panelListeChaineeNorth.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE, 1.0};
		panelListeChaineeNorth.setLayout(gbl_panelListeChaineeNorth);
		
		JLabel lblTitreListeChainee = new JLabel("Titre : ");
		lblTitreListeChainee.setHorizontalTextPosition(SwingConstants.RIGHT);
		lblTitreListeChainee.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblTitreListeChainee = new GridBagConstraints();
		gbc_lblTitreListeChainee.anchor = GridBagConstraints.WEST;
		gbc_lblTitreListeChainee.fill = GridBagConstraints.VERTICAL;
		gbc_lblTitreListeChainee.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitreListeChainee.gridx = 0;
		gbc_lblTitreListeChainee.gridy = 0;
		panelListeChaineeNorth.add(lblTitreListeChainee, gbc_lblTitreListeChainee);
		
		JTextField textFieldTitreListeChainee = new JTextField();
		textFieldTitreListeChainee.setEnabled(false);
		JTextField textFieldInterpreteListeChainee = new JTextField();
		textFieldInterpreteListeChainee.setEnabled(false);
		JTextField textFieldLabelListeChainee = new JTextField();
		textFieldLabelListeChainee.setEnabled(false);
		JTextField textFieldDateListeChainee = new JTextField();
		textFieldDateListeChainee.setEnabled(false);
		JTextField textFieldStyleListeChainee = new JTextField();
		textFieldStyleListeChainee.setEnabled(false);
		
		JTextArea textArea = new JTextArea();
		JScrollPane sp = new JScrollPane(textArea);
		panelListeChaineeCenter.setLayout(new GridLayout(1, 0));
		panelListeChaineeCenter.add(sp);
		
		JComboBox comboBoxListeChainee = new JComboBox();
		comboBoxListeChainee.addItem(0);
		
		GridBagConstraints gbc_textFieldTitreListeChainee = new GridBagConstraints();
		gbc_textFieldTitreListeChainee.gridwidth = 2;
		gbc_textFieldTitreListeChainee.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldTitreListeChainee.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldTitreListeChainee.gridx = 1;
		gbc_textFieldTitreListeChainee.gridy = 0;
		panelListeChaineeNorth.add(textFieldTitreListeChainee, gbc_textFieldTitreListeChainee);
		textFieldTitreListeChainee.setColumns(30);
		
		JLabel lblInterprte = new JLabel("Interpr\u00E8te : ");
		lblInterprte.setHorizontalTextPosition(SwingConstants.CENTER);
		lblInterprte.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblInterprte = new GridBagConstraints();
		gbc_lblInterprte.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterprte.anchor = GridBagConstraints.WEST;
		gbc_lblInterprte.gridx = 0;
		gbc_lblInterprte.gridy = 1;
		panelListeChaineeNorth.add(lblInterprte, gbc_lblInterprte);
		
		GridBagConstraints gbc_textFieldInterpreteListeChainee = new GridBagConstraints();
		gbc_textFieldInterpreteListeChainee.gridwidth = 2;
		gbc_textFieldInterpreteListeChainee.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldInterpreteListeChainee.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldInterpreteListeChainee.gridx = 1;
		gbc_textFieldInterpreteListeChainee.gridy = 1;
		panelListeChaineeNorth.add(textFieldInterpreteListeChainee, gbc_textFieldInterpreteListeChainee);
		textFieldInterpreteListeChainee.setColumns(10);
		
		JLabel lblLabel = new JLabel("Label : ");
		GridBagConstraints gbc_lblLabel = new GridBagConstraints();
		gbc_lblLabel.anchor = GridBagConstraints.WEST;
		gbc_lblLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel.gridx = 0;
		gbc_lblLabel.gridy = 2;
		panelListeChaineeNorth.add(lblLabel, gbc_lblLabel);
		
		
		GridBagConstraints gbc_textFieldLabelListeChainee = new GridBagConstraints();
		gbc_textFieldLabelListeChainee.gridwidth = 2;
		gbc_textFieldLabelListeChainee.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldLabelListeChainee.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldLabelListeChainee.gridx = 1;
		gbc_textFieldLabelListeChainee.gridy = 2;
		panelListeChaineeNorth.add(textFieldLabelListeChainee, gbc_textFieldLabelListeChainee);
		textFieldLabelListeChainee.setColumns(10);
		
		JLabel lblDate = new JLabel("Date : ");
		GridBagConstraints gbc_lblDate = new GridBagConstraints();
		gbc_lblDate.anchor = GridBagConstraints.WEST;
		gbc_lblDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate.gridx = 0;
		gbc_lblDate.gridy = 3;
		panelListeChaineeNorth.add(lblDate, gbc_lblDate);
		
		GridBagConstraints gbc_textFieldDateListeChainee = new GridBagConstraints();
		gbc_textFieldDateListeChainee.gridwidth = 2;
		gbc_textFieldDateListeChainee.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDateListeChainee.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDateListeChainee.gridx = 1;
		gbc_textFieldDateListeChainee.gridy = 3;
		panelListeChaineeNorth.add(textFieldDateListeChainee, gbc_textFieldDateListeChainee);
		textFieldDateListeChainee.setColumns(10);
		
		JLabel lblStyleMusical = new JLabel("Style Musical :");
		lblStyleMusical.setHorizontalAlignment(SwingConstants.CENTER);
		lblStyleMusical.setHorizontalTextPosition(SwingConstants.CENTER);
		GridBagConstraints gbc_lblStyleMusical = new GridBagConstraints();
		gbc_lblStyleMusical.anchor = GridBagConstraints.WEST;
		gbc_lblStyleMusical.insets = new Insets(0, 0, 5, 5);
		gbc_lblStyleMusical.gridx = 0;
		gbc_lblStyleMusical.gridy = 4;
		panelListeChaineeNorth.add(lblStyleMusical, gbc_lblStyleMusical);
		
		GridBagConstraints gbc_textFieldStyleListeChainee = new GridBagConstraints();
		gbc_textFieldStyleListeChainee.gridwidth = 2;
		gbc_textFieldStyleListeChainee.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldStyleListeChainee.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldStyleListeChainee.gridx = 1;
		gbc_textFieldStyleListeChainee.gridy = 4;
		panelListeChaineeNorth.add(textFieldStyleListeChainee, gbc_textFieldStyleListeChainee);
		textFieldStyleListeChainee.setColumns(10);
		
		JButton btnInsrerListeChainee = new JButton("Ins\u00E8rer");
		JButton btnAfficherLaListeListeChainee = new JButton("Afficher la Liste");
		btnInsrerListeChainee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String titre = textFieldTitreListeChainee.getText().trim();
				String interprete = textFieldInterpreteListeChainee.getText().trim();
				String label = textFieldLabelListeChainee.getText().trim();
				String date = textFieldDateListeChainee.getText().trim();
				String style_musicale = textFieldStyleListeChainee.getText().trim();
				if(!titre.equals("") && !interprete.equals("") && !label.equals("") && !date.equals("") && !style_musicale.equals(""))
				{
					ElementListeChainee element = new ElementListeChainee(titre, interprete, label, date, style_musicale);
					boolean b = liste.insererElement(Integer.parseInt(comboBoxListeChainee.getSelectedItem().toString()), element);
					if(b)
					{
						comboBoxListeChainee.addItem(liste.getLongueur());
						btnAfficherLaListeListeChainee.doClick();
					}
						
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Remplir tous les Chapms SVP !!", null, JOptionPane.ERROR_MESSAGE);
				}
				
				
				
			}
		});
		
		JButton btnCrerDiscothqueListeChainee = new JButton("Cr\u00E9er Discoth\u00E8que");
		JButton btnRechercherListeChainee = new JButton("Rechercher");
		btnRechercherListeChainee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String titre = textFieldTitreListeChainee.getText().trim();
				
				if(titre.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Remplir le Champs Titre !!", null, JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					Object retour = liste.rechercher(titre, textArea);
				}
				
				
			}
		});
		JButton btnSupprimerListeChainee = new JButton("Supprimer");
		
		btnSupprimerListeChainee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String titre = textFieldTitreListeChainee.getText().trim();
				if(titre.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Remplir le Champs Titre !!", null, JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					//comboBoxListeChainee.removeItemAt(liste.getLongueur());
					liste.supprimer(titre, comboBoxListeChainee);
					btnAfficherLaListeListeChainee.doClick();
				}
				
				
			}
		});
		
		JButton btnDtruireLeDiscothque = new JButton("D\u00E9truire le Discoth\u00E8que");
		
		btnDtruireLeDiscothque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				btnAfficherLaListeListeChainee.setEnabled(false);
				btnCrerDiscothqueListeChainee.setEnabled(true);
				btnDtruireLeDiscothque.setEnabled(false);
				btnInsrerListeChainee.setEnabled(false);
				btnRechercherListeChainee.setEnabled(false);
				btnSupprimerListeChainee.setEnabled(false);
				comboBoxListeChainee.removeAllItems();
				comboBoxListeChainee.addItem(0);
				
				textFieldDateListeChainee.setEnabled(false);
				textFieldInterpreteListeChainee.setEnabled(false);
				textFieldLabelListeChainee.setEnabled(false);
				textFieldStyleListeChainee.setEnabled(false);
				textFieldTitreListeChainee.setEnabled(false);
				
				cardLayoutPrincipale.show(panelContentPane, tousLesPanels[5]);
				
			}
		});
		
		
		btnAfficherLaListeListeChainee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				liste.afficherDiscotheque(textArea);
				
				
				
			}
		});
		
		btnCrerDiscothqueListeChainee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				liste = new ListeChainee();
				btnCrerDiscothqueListeChainee.setEnabled(true);
				btnInsrerListeChainee.setEnabled(true);
				btnRechercherListeChainee.setEnabled(true);
				btnSupprimerListeChainee.setEnabled(true);
				btnAfficherLaListeListeChainee.setEnabled(true);
				btnDtruireLeDiscothque.setEnabled(true);
				btnCrerDiscothqueListeChainee.setEnabled(false);
				
				textFieldDateListeChainee.setEnabled(true);
				textFieldInterpreteListeChainee.setEnabled(true);
				textFieldLabelListeChainee.setEnabled(true);
				textFieldStyleListeChainee.setEnabled(true);
				textFieldTitreListeChainee.setEnabled(true);
				
				
			}
		});
		
		JLabel lblPosition = new JLabel("Position : ");
		GridBagConstraints gbc_lblPosition = new GridBagConstraints();
		gbc_lblPosition.anchor = GridBagConstraints.WEST;
		gbc_lblPosition.insets = new Insets(0, 0, 5, 5);
		gbc_lblPosition.gridx = 0;
		gbc_lblPosition.gridy = 5;
		panelListeChaineeNorth.add(lblPosition, gbc_lblPosition);
		
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		panelListeChaineeNorth.add(comboBoxListeChainee, gbc_comboBox);
		GridBagConstraints gbc_btnCrerDiscothqueListeChainee = new GridBagConstraints();
		gbc_btnCrerDiscothqueListeChainee.insets = new Insets(0, 0, 5, 0);
		gbc_btnCrerDiscothqueListeChainee.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCrerDiscothqueListeChainee.gridwidth = 3;
		gbc_btnCrerDiscothqueListeChainee.gridx = 0;
		gbc_btnCrerDiscothqueListeChainee.gridy = 6;
		panelListeChaineeNorth.add(btnCrerDiscothqueListeChainee, gbc_btnCrerDiscothqueListeChainee);
		
		
		btnInsrerListeChainee.setEnabled(false);
		GridBagConstraints gbc_btnInsrerListeChainee = new GridBagConstraints();
		gbc_btnInsrerListeChainee.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsrerListeChainee.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsrerListeChainee.gridx = 0;
		gbc_btnInsrerListeChainee.gridy = 7;
		panelListeChaineeNorth.add(btnInsrerListeChainee, gbc_btnInsrerListeChainee);
		
		
		btnRechercherListeChainee.setEnabled(false);
		GridBagConstraints gbc_btnRechercherListeChainee = new GridBagConstraints();
		gbc_btnRechercherListeChainee.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercherListeChainee.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRechercherListeChainee.gridx = 1;
		gbc_btnRechercherListeChainee.gridy = 7;
		panelListeChaineeNorth.add(btnRechercherListeChainee, gbc_btnRechercherListeChainee);
		
		
		btnSupprimerListeChainee.setEnabled(false);
		GridBagConstraints gbc_btnSupprimerListeChainee = new GridBagConstraints();
		gbc_btnSupprimerListeChainee.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimerListeChainee.gridx = 2;
		gbc_btnSupprimerListeChainee.gridy = 7;
		panelListeChaineeNorth.add(btnSupprimerListeChainee, gbc_btnSupprimerListeChainee);
		
		
		btnAfficherLaListeListeChainee.setEnabled(false);
		GridBagConstraints gbc_btnAfficherLaListeListeChainee = new GridBagConstraints();
		gbc_btnAfficherLaListeListeChainee.insets = new Insets(0, 0, 5, 0);
		gbc_btnAfficherLaListeListeChainee.gridwidth = 3;
		gbc_btnAfficherLaListeListeChainee.fill = GridBagConstraints.BOTH;
		gbc_btnAfficherLaListeListeChainee.gridx = 0;
		gbc_btnAfficherLaListeListeChainee.gridy = 8;
		panelListeChaineeNorth.add(btnAfficherLaListeListeChainee, gbc_btnAfficherLaListeListeChainee);
		
		
		btnDtruireLeDiscothque.setEnabled(false);
		GridBagConstraints gbc_btnDtruireLeDiscothque = new GridBagConstraints();
		gbc_btnDtruireLeDiscothque.gridwidth = 3;
		gbc_btnDtruireLeDiscothque.fill = GridBagConstraints.BOTH;
		gbc_btnDtruireLeDiscothque.gridx = 0;
		gbc_btnDtruireLeDiscothque.gridy = 10;
		panelListeChaineeNorth.add(btnDtruireLeDiscothque, gbc_btnDtruireLeDiscothque);
		
		
		panelListeChaineeCenter.setBorder(new TitledBorder(null, "Zone d'Afficchage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListeChainee.add(panelListeChaineeCenter, BorderLayout.CENTER);
		
		JPanel panelTableDeHachage = new JPanel();
		panelTableDeHachage.setBackground(UIManager.getColor("Button.background"));
		panelContentPane.add(panelTableDeHachage, tousLesPanels[1]);
		panelTableDeHachage.setLayout(new BorderLayout(0, 0));
		
		JPanel panelHachNorth = new JPanel();
		panelHachNorth.setBorder(new TitledBorder(null, "Table de Hachage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTableDeHachage.add(panelHachNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelHachNorth = new GridBagLayout();
		gbl_panelHachNorth.columnWidths = new int[]{0, 0, 0};
		gbl_panelHachNorth.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelHachNorth.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelHachNorth.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelHachNorth.setLayout(gbl_panelHachNorth);
		
		JLabel lblTitre_2 = new JLabel("Titre : ");
		GridBagConstraints gbc_lblTitre_2 = new GridBagConstraints();
		gbc_lblTitre_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre_2.anchor = GridBagConstraints.EAST;
		gbc_lblTitre_2.gridx = 0;
		gbc_lblTitre_2.gridy = 0;
		panelHachNorth.add(lblTitre_2, gbc_lblTitre_2);
		
		
		GridBagConstraints gbc_textFieldHachTitre = new GridBagConstraints();
		gbc_textFieldHachTitre.gridwidth = 2;
		gbc_textFieldHachTitre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHachTitre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHachTitre.gridx = 1;
		gbc_textFieldHachTitre.gridy = 0;
		panelHachNorth.add(textFieldHachTitre, gbc_textFieldHachTitre);
		textFieldHachTitre.setColumns(10);
		
		JLabel lblInterprete_3 = new JLabel("Interprete : ");
		GridBagConstraints gbc_lblInterprete_3 = new GridBagConstraints();
		gbc_lblInterprete_3.anchor = GridBagConstraints.EAST;
		gbc_lblInterprete_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterprete_3.gridx = 0;
		gbc_lblInterprete_3.gridy = 1;
		panelHachNorth.add(lblInterprete_3, gbc_lblInterprete_3);
		
		
		GridBagConstraints gbc_textFieldHachInterprete = new GridBagConstraints();
		gbc_textFieldHachInterprete.gridwidth = 2;
		gbc_textFieldHachInterprete.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHachInterprete.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHachInterprete.gridx = 1;
		gbc_textFieldHachInterprete.gridy = 1;
		panelHachNorth.add(textFieldHachInterprete, gbc_textFieldHachInterprete);
		textFieldHachInterprete.setColumns(10);
		
		JLabel lblLabel_4 = new JLabel("Label : ");
		GridBagConstraints gbc_lblLabel_4 = new GridBagConstraints();
		gbc_lblLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel_4.gridx = 0;
		gbc_lblLabel_4.gridy = 2;
		panelHachNorth.add(lblLabel_4, gbc_lblLabel_4);
		
		 
		GridBagConstraints gbc_textFieldHachLabel = new GridBagConstraints();
		gbc_textFieldHachLabel.gridwidth = 2;
		gbc_textFieldHachLabel.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHachLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHachLabel.gridx = 1;
		gbc_textFieldHachLabel.gridy = 2;
		panelHachNorth.add(textFieldHachLabel, gbc_textFieldHachLabel);
		textFieldHachLabel.setColumns(10);
		
		JLabel lblDate_4 = new JLabel("Date : ");
		GridBagConstraints gbc_lblDate_4 = new GridBagConstraints();
		gbc_lblDate_4.anchor = GridBagConstraints.EAST;
		gbc_lblDate_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate_4.gridx = 0;
		gbc_lblDate_4.gridy = 3;
		panelHachNorth.add(lblDate_4, gbc_lblDate_4);
		
		
		GridBagConstraints gbc_textFieldHachDate = new GridBagConstraints();
		gbc_textFieldHachDate.gridwidth = 2;
		gbc_textFieldHachDate.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHachDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHachDate.gridx = 1;
		gbc_textFieldHachDate.gridy = 3;
		panelHachNorth.add(textFieldHachDate, gbc_textFieldHachDate);
		textFieldHachDate.setColumns(10);
		
		JLabel lblStyleMusicale_3 = new JLabel("Style Musicale : ");
		GridBagConstraints gbc_lblStyleMusicale_3 = new GridBagConstraints();
		gbc_lblStyleMusicale_3.anchor = GridBagConstraints.EAST;
		gbc_lblStyleMusicale_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblStyleMusicale_3.gridx = 0;
		gbc_lblStyleMusicale_3.gridy = 4;
		panelHachNorth.add(lblStyleMusicale_3, gbc_lblStyleMusicale_3);
		
		
		GridBagConstraints gbc_textFieldHachStyleMusicale = new GridBagConstraints();
		gbc_textFieldHachStyleMusicale.gridwidth = 2;
		gbc_textFieldHachStyleMusicale.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldHachStyleMusicale.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldHachStyleMusicale.gridx = 1;
		gbc_textFieldHachStyleMusicale.gridy = 4;
		panelHachNorth.add(textFieldHachStyleMusicale, gbc_textFieldHachStyleMusicale);
		textFieldHachStyleMusicale.setColumns(10);
		
		
		GridBagConstraints gbc_btnCreerDiscothequeHach = new GridBagConstraints();
		gbc_btnCreerDiscothequeHach.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreerDiscothequeHach.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreerDiscothequeHach.gridwidth = 3;
		gbc_btnCreerDiscothequeHach.gridx = 0;
		gbc_btnCreerDiscothequeHach.gridy = 5;
		panelHachNorth.add(btnCreerDiscothequeHach, gbc_btnCreerDiscothequeHach);
		
		
		GridBagConstraints gbc_btnInsererHach = new GridBagConstraints();
		gbc_btnInsererHach.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsererHach.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsererHach.gridx = 0;
		gbc_btnInsererHach.gridy = 6;
		panelHachNorth.add(btnInsererHach, gbc_btnInsererHach);
		
		
		GridBagConstraints gbc_btnRechercherHach = new GridBagConstraints();
		gbc_btnRechercherHach.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRechercherHach.insets = new Insets(0, 0, 5, 0);
		gbc_btnRechercherHach.gridx = 1;
		gbc_btnRechercherHach.gridy = 6;
		panelHachNorth.add(btnRechercherHach, gbc_btnRechercherHach);
		
		
		GridBagConstraints gbc_btnSupprimerHach = new GridBagConstraints();
		gbc_btnSupprimerHach.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimerHach.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimerHach.gridx = 2;
		gbc_btnSupprimerHach.gridy = 6;
		panelHachNorth.add(btnSupprimerHach, gbc_btnSupprimerHach);
		
		
		GridBagConstraints gbc_btnAfficherHach = new GridBagConstraints();
		gbc_btnAfficherHach.gridwidth = 3;
		gbc_btnAfficherHach.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAfficherHach.insets = new Insets(0, 0, 5, 0);
		gbc_btnAfficherHach.gridx = 0;
		gbc_btnAfficherHach.gridy = 7;
		panelHachNorth.add(btnAfficherHach, gbc_btnAfficherHach);
		
		
		GridBagConstraints gbc_btnDetruireDiscotheque = new GridBagConstraints();
		gbc_btnDetruireDiscotheque.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDetruireDiscotheque.gridwidth = 3;
		gbc_btnDetruireDiscotheque.insets = new Insets(0, 0, 0, 5);
		gbc_btnDetruireDiscotheque.gridx = 0;
		gbc_btnDetruireDiscotheque.gridy = 8;
		panelHachNorth.add(btnDetruireDiscothequeHach, gbc_btnDetruireDiscotheque);
		
		JPanel panelHachCenter = new JPanel();
		JScrollPane scrollPaneHAch = new JScrollPane(panelHachCenter);
		
		panelHachCenter.setBorder(new TitledBorder(null, "Zone d'Affichage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTableDeHachage.add(scrollPaneHAch, BorderLayout.CENTER);
		panelHachCenter.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		panelHachCenter.add(textAreaHach);
		
		JPanel panelAVL = new JPanel();
		panelAVL.setBackground(UIManager.getColor("Button.background"));
		panelContentPane.add(panelAVL, tousLesPanels[2]);
		panelAVL.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAVLNorth = new JPanel();
		panelAVLNorth.setBorder(new TitledBorder(null, "Arbre AVL", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAVL.add(panelAVLNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelAVLNorth = new GridBagLayout();
		gbl_panelAVLNorth.columnWidths = new int[]{0, 0, 0};
		gbl_panelAVLNorth.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelAVLNorth.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelAVLNorth.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelAVLNorth.setLayout(gbl_panelAVLNorth);
		
		JLabel lblTtitre = new JLabel("Ttitre : ");
		GridBagConstraints gbc_lblTtitre = new GridBagConstraints();
		gbc_lblTtitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblTtitre.anchor = GridBagConstraints.WEST;
		gbc_lblTtitre.gridx = 0;
		gbc_lblTtitre.gridy = 0;
		panelAVLNorth.add(lblTtitre, gbc_lblTtitre);
		
		textFieldAVLTitre = new JTextField();
		GridBagConstraints gbc_textFieldAVLTitre = new GridBagConstraints();
		gbc_textFieldAVLTitre.gridwidth = 2;
		gbc_textFieldAVLTitre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAVLTitre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAVLTitre.gridx = 1;
		gbc_textFieldAVLTitre.gridy = 0;
		panelAVLNorth.add(textFieldAVLTitre, gbc_textFieldAVLTitre);
		textFieldAVLTitre.setColumns(10);
		
		JLabel lblInterprete_1 = new JLabel("Interprete : ");
		GridBagConstraints gbc_lblInterprete_1 = new GridBagConstraints();
		gbc_lblInterprete_1.anchor = GridBagConstraints.WEST;
		gbc_lblInterprete_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterprete_1.gridx = 0;
		gbc_lblInterprete_1.gridy = 1;
		panelAVLNorth.add(lblInterprete_1, gbc_lblInterprete_1);
		
		textFieldAVLInterprete = new JTextField();
		GridBagConstraints gbc_textFieldAVLInterprete = new GridBagConstraints();
		gbc_textFieldAVLInterprete.gridwidth = 2;
		gbc_textFieldAVLInterprete.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAVLInterprete.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAVLInterprete.gridx = 1;
		gbc_textFieldAVLInterprete.gridy = 1;
		panelAVLNorth.add(textFieldAVLInterprete, gbc_textFieldAVLInterprete);
		textFieldAVLInterprete.setColumns(10);
		
		JLabel lblLabel_2 = new JLabel("Label : ");
		GridBagConstraints gbc_lblLabel_2 = new GridBagConstraints();
		gbc_lblLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel_2.gridx = 0;
		gbc_lblLabel_2.gridy = 2;
		panelAVLNorth.add(lblLabel_2, gbc_lblLabel_2);
		
		textFieldAVLLabel = new JTextField();
		GridBagConstraints gbc_textFieldAVLLabel = new GridBagConstraints();
		gbc_textFieldAVLLabel.gridwidth = 2;
		gbc_textFieldAVLLabel.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAVLLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAVLLabel.gridx = 1;
		gbc_textFieldAVLLabel.gridy = 2;
		panelAVLNorth.add(textFieldAVLLabel, gbc_textFieldAVLLabel);
		textFieldAVLLabel.setColumns(10);
		
		JLabel lblDate_2 = new JLabel("Date : ");
		GridBagConstraints gbc_lblDate_2 = new GridBagConstraints();
		gbc_lblDate_2.anchor = GridBagConstraints.WEST;
		gbc_lblDate_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate_2.gridx = 0;
		gbc_lblDate_2.gridy = 3;
		panelAVLNorth.add(lblDate_2, gbc_lblDate_2);
		
		textFieldAVLDate = new JTextField();
		GridBagConstraints gbc_textFieldAVLDate = new GridBagConstraints();
		gbc_textFieldAVLDate.gridwidth = 2;
		gbc_textFieldAVLDate.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAVLDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAVLDate.gridx = 1;
		gbc_textFieldAVLDate.gridy = 3;
		panelAVLNorth.add(textFieldAVLDate, gbc_textFieldAVLDate);
		textFieldAVLDate.setColumns(10);
		
		JLabel lblStyleMusicale_1 = new JLabel("Style Musicale : ");
		GridBagConstraints gbc_lblStyleMusicale_1 = new GridBagConstraints();
		gbc_lblStyleMusicale_1.anchor = GridBagConstraints.WEST;
		gbc_lblStyleMusicale_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblStyleMusicale_1.gridx = 0;
		gbc_lblStyleMusicale_1.gridy = 4;
		panelAVLNorth.add(lblStyleMusicale_1, gbc_lblStyleMusicale_1);
		
		textFieldAVLStyleMusicale = new JTextField();
		GridBagConstraints gbc_textFieldAVLStyleMusicale = new GridBagConstraints();
		gbc_textFieldAVLStyleMusicale.gridwidth = 2;
		gbc_textFieldAVLStyleMusicale.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldAVLStyleMusicale.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldAVLStyleMusicale.gridx = 1;
		gbc_textFieldAVLStyleMusicale.gridy = 4;
		panelAVLNorth.add(textFieldAVLStyleMusicale, gbc_textFieldAVLStyleMusicale);
		textFieldAVLStyleMusicale.setColumns(10);
		
		JButton btnCreerDiscothequeAVL = new JButton("Creer Discotheque");
		GridBagConstraints gbc_btnCreerDiscothequeAVL = new GridBagConstraints();
		gbc_btnCreerDiscothequeAVL.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreerDiscothequeAVL.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreerDiscothequeAVL.gridwidth = 3;
		gbc_btnCreerDiscothequeAVL.gridx = 0;
		gbc_btnCreerDiscothequeAVL.gridy = 5;
		panelAVLNorth.add(btnCreerDiscothequeAVL, gbc_btnCreerDiscothequeAVL);
		
		JButton btnInsererAVL = new JButton("Inserer");
		GridBagConstraints gbc_btnInsererAVL = new GridBagConstraints();
		gbc_btnInsererAVL.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsererAVL.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsererAVL.gridx = 0;
		gbc_btnInsererAVL.gridy = 6;
		panelAVLNorth.add(btnInsererAVL, gbc_btnInsererAVL);
		
		JButton btnRechercherAVL = new JButton("Rechercher");
		GridBagConstraints gbc_btnRechercherAVL = new GridBagConstraints();
		gbc_btnRechercherAVL.insets = new Insets(0, 0, 5, 0);
		gbc_btnRechercherAVL.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRechercherAVL.gridx = 1;
		gbc_btnRechercherAVL.gridy = 6;
		panelAVLNorth.add(btnRechercherAVL, gbc_btnRechercherAVL);
		
		JButton btnSupprimerAVL = new JButton("Supprimer");
		GridBagConstraints gbc_btnSupprimerAVL = new GridBagConstraints();
		gbc_btnSupprimerAVL.insets = new Insets(0, 0, 5, 5);
		gbc_btnSupprimerAVL.gridx = 2;
		gbc_btnSupprimerAVL.gridy = 6;
		panelAVLNorth.add(btnSupprimerAVL, gbc_btnSupprimerAVL);
		
		JButton btnAfficherAVL = new JButton("Afficher");
		btnAfficherAVL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnAfficherAVL = new GridBagConstraints();
		gbc_btnAfficherAVL.gridwidth = 3;
		gbc_btnAfficherAVL.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAfficherAVL.insets = new Insets(0, 0, 5, 0);
		gbc_btnAfficherAVL.gridx = 0;
		gbc_btnAfficherAVL.gridy = 7;
		panelAVLNorth.add(btnAfficherAVL, gbc_btnAfficherAVL);
		
		JButton btnDetruireDiscothequeAVL = new JButton("Detruire Discotheque");
		GridBagConstraints gbc_btnDetruireDiscothequeAVL = new GridBagConstraints();
		gbc_btnDetruireDiscothequeAVL.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDetruireDiscothequeAVL.gridwidth = 3;
		gbc_btnDetruireDiscothequeAVL.insets = new Insets(0, 0, 0, 5);
		gbc_btnDetruireDiscothequeAVL.gridx = 0;
		gbc_btnDetruireDiscothequeAVL.gridy = 8;
		panelAVLNorth.add(btnDetruireDiscothequeAVL, gbc_btnDetruireDiscothequeAVL);
		
		JPanel panelAVLCenter = new JPanel();
		panelAVLCenter.setBorder(new TitledBorder(null, "Zone d'Affichage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAVL.add(panelAVLCenter, BorderLayout.CENTER);
		panelAVLCenter.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea textAreaAVL = new JTextArea();
		panelAVLCenter.add(textAreaAVL);
		
		JPanel panelRougeEtNoir = new JPanel();
		panelRougeEtNoir.setBackground(UIManager.getColor("Button.background"));
		panelContentPane.add(panelRougeEtNoir, tousLesPanels[3]);
		panelRougeEtNoir.setLayout(new BorderLayout(0, 0));
		
		JPanel panelRNNorth = new JPanel();
		panelRNNorth.setBorder(new TitledBorder(null, "Arbre Rouge et Noir", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRougeEtNoir.add(panelRNNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelRNNorth = new GridBagLayout();
		gbl_panelRNNorth.columnWidths = new int[]{0, 0, 0};
		gbl_panelRNNorth.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelRNNorth.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelRNNorth.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelRNNorth.setLayout(gbl_panelRNNorth);
		
		JLabel lblTitre = new JLabel("Titre : ");
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre.anchor = GridBagConstraints.WEST;
		gbc_lblTitre.gridx = 0;
		gbc_lblTitre.gridy = 0;
		panelRNNorth.add(lblTitre, gbc_lblTitre);
		
		
		textFieldRNTitre.setEnabled(false);
		JTextField textFieldRNInterprete = new JTextField();
		textFieldRNInterprete.setEnabled(false);
		JTextField textFieldRNLabel = new JTextField();
		textFieldRNLabel.setEnabled(false);
		JTextField textFieldRNDate = new JTextField();
		textFieldRNDate.setEnabled(false);
		JTextField textFieldRNStyleMusicale = new JTextField();
		textFieldRNStyleMusicale.setEnabled(false);
		
		
		GridBagConstraints gbc_textFieldRNTitre = new GridBagConstraints();
		gbc_textFieldRNTitre.gridwidth = 2;
		gbc_textFieldRNTitre.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRNTitre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRNTitre.gridx = 1;
		gbc_textFieldRNTitre.gridy = 0;
		panelRNNorth.add(textFieldRNTitre, gbc_textFieldRNTitre);
		textFieldRNTitre.setColumns(10);
		
		JLabel lblInterprete = new JLabel("Interprete : ");
		GridBagConstraints gbc_lblInterprete = new GridBagConstraints();
		gbc_lblInterprete.anchor = GridBagConstraints.WEST;
		gbc_lblInterprete.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterprete.gridx = 0;
		gbc_lblInterprete.gridy = 1;
		panelRNNorth.add(lblInterprete, gbc_lblInterprete);
		
		
		GridBagConstraints gbc_textFieldRNInterprete = new GridBagConstraints();
		gbc_textFieldRNInterprete.gridwidth = 2;
		gbc_textFieldRNInterprete.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRNInterprete.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRNInterprete.gridx = 1;
		gbc_textFieldRNInterprete.gridy = 1;
		panelRNNorth.add(textFieldRNInterprete, gbc_textFieldRNInterprete);
		textFieldRNInterprete.setColumns(10);
		
		JLabel lblLabel_1 = new JLabel("Label : ");
		GridBagConstraints gbc_lblLabel_1 = new GridBagConstraints();
		gbc_lblLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel_1.gridx = 0;
		gbc_lblLabel_1.gridy = 2;
		panelRNNorth.add(lblLabel_1, gbc_lblLabel_1);
		
		
		GridBagConstraints gbc_textFieldRNLabel = new GridBagConstraints();
		gbc_textFieldRNLabel.gridwidth = 2;
		gbc_textFieldRNLabel.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRNLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRNLabel.gridx = 1;
		gbc_textFieldRNLabel.gridy = 2;
		panelRNNorth.add(textFieldRNLabel, gbc_textFieldRNLabel);
		textFieldRNLabel.setColumns(10);
		
		JLabel lblDate_1 = new JLabel("Date : ");
		GridBagConstraints gbc_lblDate_1 = new GridBagConstraints();
		gbc_lblDate_1.anchor = GridBagConstraints.WEST;
		gbc_lblDate_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate_1.gridx = 0;
		gbc_lblDate_1.gridy = 3;
		panelRNNorth.add(lblDate_1, gbc_lblDate_1);
		
		
		GridBagConstraints gbc_textFieldRNDate = new GridBagConstraints();
		gbc_textFieldRNDate.gridwidth = 2;
		gbc_textFieldRNDate.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRNDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRNDate.gridx = 1;
		gbc_textFieldRNDate.gridy = 3;
		panelRNNorth.add(textFieldRNDate, gbc_textFieldRNDate);
		textFieldRNDate.setColumns(10);
		
		JLabel lblStyleMusicale = new JLabel("Style Musicale : ");
		GridBagConstraints gbc_lblStyleMusicale = new GridBagConstraints();
		gbc_lblStyleMusicale.anchor = GridBagConstraints.WEST;
		gbc_lblStyleMusicale.insets = new Insets(0, 0, 5, 5);
		gbc_lblStyleMusicale.gridx = 0;
		gbc_lblStyleMusicale.gridy = 4;
		panelRNNorth.add(lblStyleMusicale, gbc_lblStyleMusicale);
		
		
		GridBagConstraints gbc_textFieldRNStyleMusicale = new GridBagConstraints();
		gbc_textFieldRNStyleMusicale.gridwidth = 2;
		gbc_textFieldRNStyleMusicale.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldRNStyleMusicale.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldRNStyleMusicale.gridx = 1;
		gbc_textFieldRNStyleMusicale.gridy = 4;
		panelRNNorth.add(textFieldRNStyleMusicale, gbc_textFieldRNStyleMusicale);
		textFieldRNStyleMusicale.setColumns(10);
		
		
		btnCreerDiscothequeRN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arbreRougeNoir == null)
				{
					arbreRougeNoir = new ArbreRougeNoir();
				}
				
				textFieldRNDate.setEnabled(true);
				textFieldRNInterprete.setEnabled(true);
				textFieldRNLabel.setEnabled(true);
				textFieldRNStyleMusicale.setEnabled(true);
				textFieldRNTitre.setEnabled(true);
				
				btnInsererRN.setEnabled(true);
				btnRechercherRN.setEnabled(true);
				btnSupprimerRN.setEnabled(true);
				btnAfficherRN.setEnabled(true);
				btnDetruireLeDiscothequeRN.setEnabled(true);
				
				
				btnCreerDiscothequeRN.setEnabled(false);
				
				textAreaRN.setText("");
			}
		});
		GridBagConstraints gbc_btnCreerDiscothequeRN = new GridBagConstraints();
		gbc_btnCreerDiscothequeRN.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreerDiscothequeRN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreerDiscothequeRN.gridwidth = 3;
		gbc_btnCreerDiscothequeRN.gridx = 0;
		gbc_btnCreerDiscothequeRN.gridy = 5;
		panelRNNorth.add(btnCreerDiscothequeRN, gbc_btnCreerDiscothequeRN);
		
		
		btnInsererRN.setEnabled(false);
		btnInsererRN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String titre = textFieldRNTitre.getText().trim();
				String interprete = textFieldRNInterprete.getText().trim();
				String label = textFieldRNLabel.getText().trim();
				String date = textFieldRNDate.getText().trim();
				String styleMusicale = textFieldRNStyleMusicale.getText().trim();
				if(titre.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Ce Champs est Obligatoire !!", null, JOptionPane.WARNING_MESSAGE);
					textFieldRNTitre.grabFocus();
				}
				else
				{
					Data album = new Data(titre, interprete, label, date, styleMusicale);
					arbreRougeNoir.ajout(album);
					textFieldRNTitre.setText("");
					textFieldRNTitre.grabFocus();
				}
				
				
		
				
				
				btnAfficherRN.doClick();
				
				//Noeud element = arbreRougeNoir.rechercher(album.getTitre());
				
				
				
			}
		});
		GridBagConstraints gbc_btnInsererRN = new GridBagConstraints();
		gbc_btnInsererRN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsererRN.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsererRN.gridx = 0;
		gbc_btnInsererRN.gridy = 6;
		panelRNNorth.add(btnInsererRN, gbc_btnInsererRN);
		
		
		btnRechercherRN.setEnabled(false);
		GridBagConstraints gbc_btnRechercherRN = new GridBagConstraints();
		gbc_btnRechercherRN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRechercherRN.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercherRN.gridx = 1;
		gbc_btnRechercherRN.gridy = 6;
		panelRNNorth.add(btnRechercherRN, gbc_btnRechercherRN);
		
		
		btnSupprimerRN.setEnabled(false);
		GridBagConstraints gbc_btnSupprimerRN = new GridBagConstraints();
		gbc_btnSupprimerRN.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimerRN.gridx = 2;
		gbc_btnSupprimerRN.gridy = 6;
		panelRNNorth.add(btnSupprimerRN, gbc_btnSupprimerRN);
		
		
		btnAfficherRN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textAreaRN.setText("");
				arbreRougeNoir.afficherPrefixe(arbreRougeNoir.getRacine(), textAreaRN);
			}
		});
		btnAfficherRN.setEnabled(false);
		GridBagConstraints gbc_btnAfficherRN = new GridBagConstraints();
		gbc_btnAfficherRN.insets = new Insets(0, 0, 5, 0);
		gbc_btnAfficherRN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAfficherRN.gridwidth = 3;
		gbc_btnAfficherRN.gridx = 0;
		gbc_btnAfficherRN.gridy = 7;
		panelRNNorth.add(btnAfficherRN, gbc_btnAfficherRN);
		
		
		btnDetruireLeDiscothequeRN.setEnabled(false);
		btnDetruireLeDiscothequeRN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				arbreRougeNoir = null;
				cardLayoutPrincipale.show(panelContentPane, tousLesPanels[5]);
				textAreaRN.setText("");
			}
		});
		GridBagConstraints gbc_btnDetruireLeDiscothequeRN = new GridBagConstraints();
		gbc_btnDetruireLeDiscothequeRN.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDetruireLeDiscothequeRN.gridwidth = 3;
		gbc_btnDetruireLeDiscothequeRN.insets = new Insets(0, 0, 0, 5);
		gbc_btnDetruireLeDiscothequeRN.gridx = 0;
		gbc_btnDetruireLeDiscothequeRN.gridy = 8;
		panelRNNorth.add(btnDetruireLeDiscothequeRN, gbc_btnDetruireLeDiscothequeRN);
		
		
		JPanel panelRNCenter = new JPanel();
		JScrollPane scrollPaneRN = new JScrollPane(panelRNCenter);
		panelRNCenter.setBorder(new TitledBorder(null, "Zone d'Affichage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRougeEtNoir.add(scrollPaneRN, BorderLayout.CENTER);
		panelRNCenter.setLayout(new GridLayout(0, 1));
		
		
		panelRNCenter.add(textAreaRN);
		
		JPanel panelBArbre = new JPanel();
		panelBArbre.setBackground(UIManager.getColor("Button.background"));
		panelContentPane.add(panelBArbre, tousLesPanels[4]);
		panelBArbre.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBNorth = new JPanel();
		panelBNorth.setBorder(new TitledBorder(null, "B Arbre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBArbre.add(panelBNorth, BorderLayout.NORTH);
		GridBagLayout gbl_panelBNorth = new GridBagLayout();
		gbl_panelBNorth.columnWidths = new int[]{0, 0, 0};
		gbl_panelBNorth.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBNorth.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelBNorth.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBNorth.setLayout(gbl_panelBNorth);
		
		JLabel lblTitre_1 = new JLabel("Titre : ");
		GridBagConstraints gbc_lblTitre_1 = new GridBagConstraints();
		gbc_lblTitre_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitre_1.anchor = GridBagConstraints.EAST;
		gbc_lblTitre_1.gridx = 0;
		gbc_lblTitre_1.gridy = 0;
		panelBNorth.add(lblTitre_1, gbc_lblTitre_1);
		
		textFieldBArbreTitre = new JTextField();
		GridBagConstraints gbc_textFieldBArbreTitre = new GridBagConstraints();
		gbc_textFieldBArbreTitre.gridwidth = 2;
		gbc_textFieldBArbreTitre.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBArbreTitre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBArbreTitre.gridx = 1;
		gbc_textFieldBArbreTitre.gridy = 0;
		panelBNorth.add(textFieldBArbreTitre, gbc_textFieldBArbreTitre);
		textFieldBArbreTitre.setColumns(10);
		
		JLabel lblInterprete_2 = new JLabel("Interprete : ");
		GridBagConstraints gbc_lblInterprete_2 = new GridBagConstraints();
		gbc_lblInterprete_2.anchor = GridBagConstraints.EAST;
		gbc_lblInterprete_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblInterprete_2.gridx = 0;
		gbc_lblInterprete_2.gridy = 1;
		panelBNorth.add(lblInterprete_2, gbc_lblInterprete_2);
		
		textFieldBArbreInterprete = new JTextField();
		GridBagConstraints gbc_textFieldBArbreInterprete = new GridBagConstraints();
		gbc_textFieldBArbreInterprete.gridwidth = 2;
		gbc_textFieldBArbreInterprete.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBArbreInterprete.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBArbreInterprete.gridx = 1;
		gbc_textFieldBArbreInterprete.gridy = 1;
		panelBNorth.add(textFieldBArbreInterprete, gbc_textFieldBArbreInterprete);
		textFieldBArbreInterprete.setColumns(10);
		
		JLabel lblLabel_3 = new JLabel("Label : ");
		GridBagConstraints gbc_lblLabel_3 = new GridBagConstraints();
		gbc_lblLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblLabel_3.gridx = 0;
		gbc_lblLabel_3.gridy = 2;
		panelBNorth.add(lblLabel_3, gbc_lblLabel_3);
		
		textFieldBArbreLabel = new JTextField();
		GridBagConstraints gbc_textFieldBArbreLabel = new GridBagConstraints();
		gbc_textFieldBArbreLabel.gridwidth = 2;
		gbc_textFieldBArbreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBArbreLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBArbreLabel.gridx = 1;
		gbc_textFieldBArbreLabel.gridy = 2;
		panelBNorth.add(textFieldBArbreLabel, gbc_textFieldBArbreLabel);
		textFieldBArbreLabel.setColumns(10);
		
		JLabel lblDate_3 = new JLabel("Date : ");
		GridBagConstraints gbc_lblDate_3 = new GridBagConstraints();
		gbc_lblDate_3.anchor = GridBagConstraints.EAST;
		gbc_lblDate_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblDate_3.gridx = 0;
		gbc_lblDate_3.gridy = 3;
		panelBNorth.add(lblDate_3, gbc_lblDate_3);
		
		textFieldBArbreDate = new JTextField();
		GridBagConstraints gbc_textFieldBArbreDate = new GridBagConstraints();
		gbc_textFieldBArbreDate.gridwidth = 2;
		gbc_textFieldBArbreDate.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBArbreDate.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBArbreDate.gridx = 1;
		gbc_textFieldBArbreDate.gridy = 3;
		panelBNorth.add(textFieldBArbreDate, gbc_textFieldBArbreDate);
		textFieldBArbreDate.setColumns(10);
		
		JLabel lblStyleMusicale_2 = new JLabel("Style Musicale : ");
		GridBagConstraints gbc_lblStyleMusicale_2 = new GridBagConstraints();
		gbc_lblStyleMusicale_2.anchor = GridBagConstraints.EAST;
		gbc_lblStyleMusicale_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblStyleMusicale_2.gridx = 0;
		gbc_lblStyleMusicale_2.gridy = 4;
		panelBNorth.add(lblStyleMusicale_2, gbc_lblStyleMusicale_2);
		
		textFieldBArbreStyleMusicale = new JTextField();
		GridBagConstraints gbc_textFieldBArbreStyleMusicale = new GridBagConstraints();
		gbc_textFieldBArbreStyleMusicale.gridwidth = 2;
		gbc_textFieldBArbreStyleMusicale.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldBArbreStyleMusicale.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBArbreStyleMusicale.gridx = 1;
		gbc_textFieldBArbreStyleMusicale.gridy = 4;
		panelBNorth.add(textFieldBArbreStyleMusicale, gbc_textFieldBArbreStyleMusicale);
		textFieldBArbreStyleMusicale.setColumns(10);
		
		JButton btnCreerDiscothequeBArbre = new JButton("Creer Discotheque");
		GridBagConstraints gbc_btnCreerDiscothequeBArbre = new GridBagConstraints();
		gbc_btnCreerDiscothequeBArbre.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreerDiscothequeBArbre.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreerDiscothequeBArbre.gridwidth = 3;
		gbc_btnCreerDiscothequeBArbre.gridx = 0;
		gbc_btnCreerDiscothequeBArbre.gridy = 5;
		panelBNorth.add(btnCreerDiscothequeBArbre, gbc_btnCreerDiscothequeBArbre);
		
		JButton btnInsererBArbre = new JButton("Inserer");
		GridBagConstraints gbc_btnInsererBArbre = new GridBagConstraints();
		gbc_btnInsererBArbre.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsererBArbre.insets = new Insets(0, 0, 5, 5);
		gbc_btnInsererBArbre.gridx = 0;
		gbc_btnInsererBArbre.gridy = 6;
		panelBNorth.add(btnInsererBArbre, gbc_btnInsererBArbre);
		
		JButton btnRechercherBArbre = new JButton("Rechercher");
		GridBagConstraints gbc_btnRechercherBArbre = new GridBagConstraints();
		gbc_btnRechercherBArbre.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRechercherBArbre.insets = new Insets(0, 0, 5, 5);
		gbc_btnRechercherBArbre.gridx = 1;
		gbc_btnRechercherBArbre.gridy = 6;
		panelBNorth.add(btnRechercherBArbre, gbc_btnRechercherBArbre);
		
		JButton btnSupprimerBArbre = new JButton("Supprimer");
		GridBagConstraints gbc_btnSupprimerBArbre = new GridBagConstraints();
		gbc_btnSupprimerBArbre.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimerBArbre.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimerBArbre.gridx = 2;
		gbc_btnSupprimerBArbre.gridy = 6;
		panelBNorth.add(btnSupprimerBArbre, gbc_btnSupprimerBArbre);
		
		JButton btnAfficherBArbre = new JButton("Afficher");
		GridBagConstraints gbc_btnAfficherBArbre = new GridBagConstraints();
		gbc_btnAfficherBArbre.gridwidth = 3;
		gbc_btnAfficherBArbre.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAfficherBArbre.insets = new Insets(0, 0, 0, 5);
		gbc_btnAfficherBArbre.gridx = 0;
		gbc_btnAfficherBArbre.gridy = 7;
		panelBNorth.add(btnAfficherBArbre, gbc_btnAfficherBArbre);
		
		JButton btnDetruireDiscothequeBArbre = new JButton("Detruire Discotheque");
		btnDetruireDiscothequeBArbre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnDetruireDiscothequeBArbre = new GridBagConstraints();
		gbc_btnDetruireDiscothequeBArbre.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDetruireDiscothequeBArbre.gridwidth = 3;
		gbc_btnDetruireDiscothequeBArbre.insets = new Insets(0, 0, 0, 5);
		gbc_btnDetruireDiscothequeBArbre.gridx = 0;
		gbc_btnDetruireDiscothequeBArbre.gridy = 8;
		panelBNorth.add(btnDetruireDiscothequeBArbre, gbc_btnDetruireDiscothequeBArbre);
		
		JPanel panelBCenter = new JPanel();
		panelBCenter.setBorder(new TitledBorder(null, "Zone d'Affichage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelBArbre.add(panelBCenter, BorderLayout.CENTER);
		panelBCenter.setLayout(new GridLayout(1, 0, 0, 0));
		
		JTextArea textAreaBArbre = new JTextArea();
		panelBCenter.add(textAreaBArbre);
		
		btnListeChain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				cardLayoutPrincipale.show(panelContentPane, tousLesPanels[0]);
				
			}
		});
		
		
		
		
		
	}
	
	// AVL Tree 
	
	void AVLTree(){
		JOptionPane.showMessageDialog(null, "rf");
	}
	


}

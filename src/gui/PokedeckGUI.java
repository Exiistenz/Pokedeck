package gui;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;

import controller.EventListener;
import controller.PokeUpdateListener;
import model.Card;
import model.Energy;
import model.Pokemon;

public class PokedeckGUI extends JFrame {
	private static final long serialVersionUID = 1L;

	JFrame window = new JFrame("PokeDeck");
	private CardLayout cardLayout = new CardLayout();
	private JPanel content = new JPanel();
	private JPanel home;
	private JPanel addPage;
	private JPanel deletePage;
	private JPanel modifyPage;
	
	private JTextField txfName;
	private JTextField txfType;
	private JTextField txfLevel;
	private JTextField txbHealth;
	private JTextField txbResistance;
	private JTextField txbWickness;
	private JTextField txbRetirCost;
	private JTextField txfAttackName;
	private JTextField txfDamage;
	private JTextPane txpDesc;
	//private JTextField txfNumber;
	private JTextPane txpPower;
	private JTextPane txpInfo;
	
	JComboBox<Card> cbxNamePoke;
	JComboBox<Energy> cbxEnergy;
	JComboBox<Card> cbxPokemonChoice;
	JComboBox<Energy> cbxEnergyModif;

	private JTextField txfModifType;
	private JTextField txfModifAttackName;
	private JTextField txfModifDamage;
	private JTextField txfModifLevel;
	private JTextPane txpModifDesc;
	private JTextField txbModifHealth;
	private JTextField txbModifWickness;
	private JTextField txbModifResistance;
	private JTextPane txpModifPower;
	private JTextPane txpModifInfo;
	private JTextField txbModifRetirCost;
	
	public void ConstructGUI() {
		window.setTitle("Pokedeck");
		window.setSize(1000, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);

		home = this.homePanel();
	    addPage = this.addPanel();
	    modifyPage = this.modifyPanel();
	    deletePage = this.deletePanel();
	    
	    content.setLayout(cardLayout);
	    content.add(home);
	    content.add(addPage);
	    content.add(modifyPage);
	    content.add(deletePage);
	    
	    this.setContentPane(content);
	    this.setVisible(true);
	}
	
	public PokedeckGUI() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem itmAdd = new JMenuItem("Ajouter");
		itmAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				home.setVisible(false);
				addPage.setVisible(true);
				modifyPage.setVisible(false);
				deletePage.setVisible(false);
			}
		});
		menuBar.add(itmAdd);
		
		JMenuItem itmModify = new JMenuItem("Modifier");
		itmModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				home.setVisible(false);
				modifyPage.setVisible(true);
				addPage.setVisible(false);
				deletePage.setVisible(false);
				
				cbxPokemonChoice.removeAllItems();
				ArrayList<Pokemon> listPoke = Pokemon.getPokemons();
				
				for (Card aPokemon : listPoke) 
					cbxPokemonChoice.addItem(aPokemon);
			}
		});
		menuBar.add(itmModify);
		
		JMenuItem itmDelete = new JMenuItem("Supprimer");
		itmDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				home.setVisible(false);
				addPage.setVisible(false);
				modifyPage.setVisible(false);
				deletePage.setVisible(true);
				
				cbxNamePoke.removeAllItems();
				ArrayList<Pokemon> listPoke = Pokemon.getPokemons();
				
				for (Card aPokemon : listPoke) 
					cbxNamePoke.addItem(aPokemon);
				
			}
		});
		menuBar.add(itmDelete);
		
		JMenuItem itmSelect = new JMenuItem("Selectionner");
		menuBar.add(itmSelect);
		
		JMenuItem itmDisplay = new JMenuItem("Afficher");
		menuBar.add(itmDisplay);
	}
	
	/**
	 * Create Home page
	 * @return JPanel
	 */
	public JPanel homePanel() {
		JPanel homePanel = new JPanel();
		homePanel.setBackground(new Color(51, 204, 51));
		Font titleFont = new Font(Font.SANS_SERIF, Font.BOLD, 50);
		homePanel.setPreferredSize(new Dimension(900, 450));
		GridBagLayout gbl_homePanel = new GridBagLayout();
		gbl_homePanel.columnWidths = new int[]{900, 0};
		gbl_homePanel.rowHeights = new int[]{225, 0};
		gbl_homePanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_homePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		homePanel.setLayout(gbl_homePanel);
		
		JLabel title = new JLabel("Pokedeck");
		GridBagConstraints gbc_title = new GridBagConstraints();
		gbc_title.fill = GridBagConstraints.VERTICAL;
		gbc_title.gridx = 0;
		gbc_title.gridy = 0;
		homePanel.add(title, gbc_title);
		title.setFont(titleFont);
		
		return homePanel;
	}
	
	
	/**
	 * Create Add card panel
	 * @return JPanel
	 */
	public JPanel addPanel() {
		JPanel firstPanel = new JPanel();
		firstPanel.setVisible(false);
		firstPanel.setBackground(new Color(0, 204, 102));
		getContentPane().add(firstPanel, BorderLayout.CENTER);
		GridBagLayout gbl_firstPanel = new GridBagLayout();
		gbl_firstPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_firstPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_firstPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_firstPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		firstPanel.setLayout(gbl_firstPanel);
		
		JLabel lblAddCard = new JLabel("Ajouter une carte");
		lblAddCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblAddCard = new GridBagConstraints();
		gbc_lblAddCard.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddCard.gridx = 6;
		gbc_lblAddCard.gridy = 1;
		firstPanel.add(lblAddCard, gbc_lblAddCard);
		
		JLabel lblPokemon = new JLabel("Pokemon");
		lblPokemon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPokemon = new GridBagConstraints();
		gbc_lblPokemon.insets = new Insets(0, 0, 5, 5);
		gbc_lblPokemon.gridx = 1;
		gbc_lblPokemon.gridy = 3;
		firstPanel.add(lblPokemon, gbc_lblPokemon);
		
		JLabel lblAttack = new JLabel("Attaque");
		lblAttack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAttack = new GridBagConstraints();
		gbc_lblAttack.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttack.gridx = 7;
		gbc_lblAttack.gridy = 3;
		firstPanel.add(lblAttack, gbc_lblAttack);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 5;
		firstPanel.add(lblName, gbc_lblName);
		
		txfName = new JTextField();
		GridBagConstraints gbc_txfName = new GridBagConstraints();
		gbc_txfName.gridwidth = 4;
		gbc_txfName.insets = new Insets(0, 0, 5, 5);
		gbc_txfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfName.gridx = 2;
		gbc_txfName.gridy = 5;
		firstPanel.add(txfName, gbc_txfName);
		txfName.setColumns(10);
		
		JLabel lblAttckName = new JLabel("Nom");
		GridBagConstraints gbc_lblAttckName = new GridBagConstraints();
		gbc_lblAttckName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttckName.gridx = 7;
		gbc_lblAttckName.gridy = 5;
		firstPanel.add(lblAttckName, gbc_lblAttckName);
		
		txfAttackName = new JTextField();
		GridBagConstraints gbc_txfAttackName = new GridBagConstraints();
		gbc_txfAttackName.gridwidth = 4;
		gbc_txfAttackName.insets = new Insets(0, 0, 5, 5);
		gbc_txfAttackName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfAttackName.gridx = 8;
		gbc_txfAttackName.gridy = 5;
		firstPanel.add(txfAttackName, gbc_txfAttackName);
		txfAttackName.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 1;
		gbc_lblType.gridy = 6;
		firstPanel.add(lblType, gbc_lblType);
		
		txfType = new JTextField();
		GridBagConstraints gbc_txfType = new GridBagConstraints();
		gbc_txfType.gridwidth = 4;
		gbc_txfType.insets = new Insets(0, 0, 5, 5);
		gbc_txfType.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfType.gridx = 2;
		gbc_txfType.gridy = 6;
		firstPanel.add(txfType, gbc_txfType);
		txfType.setColumns(10);
		
		JLabel lblDamage = new JLabel("Dommage");
		GridBagConstraints gbc_lblDamage = new GridBagConstraints();
		gbc_lblDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage.gridx = 7;
		gbc_lblDamage.gridy = 6;
		firstPanel.add(lblDamage, gbc_lblDamage);
		
		txfDamage = new JTextField();
		GridBagConstraints gbc_txfDamage = new GridBagConstraints();
		gbc_txfDamage.gridwidth = 4;
		gbc_txfDamage.insets = new Insets(0, 0, 5, 5);
		gbc_txfDamage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfDamage.gridx = 8;
		gbc_txfDamage.gridy = 6;
		firstPanel.add(txfDamage, gbc_txfDamage);
		txfDamage.setColumns(10);
		
		JLabel lblLevel = new JLabel("Level");
		GridBagConstraints gbc_lblLevel = new GridBagConstraints();
		gbc_lblLevel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevel.gridx = 1;
		gbc_lblLevel.gridy = 7;
		firstPanel.add(lblLevel, gbc_lblLevel);
		
		txfLevel = new JTextField();
		GridBagConstraints gbc_txfLevel = new GridBagConstraints();
		gbc_txfLevel.gridwidth = 4;
		gbc_txfLevel.insets = new Insets(0, 0, 5, 5);
		gbc_txfLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfLevel.gridx = 2;
		gbc_txfLevel.gridy = 7;
		firstPanel.add(txfLevel, gbc_txfLevel);
		txfLevel.setColumns(10);
		
		JLabel lblAttackDesc = new JLabel("Description");
		GridBagConstraints gbc_lblAttackDesc = new GridBagConstraints();
		gbc_lblAttackDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttackDesc.gridx = 7;
		gbc_lblAttackDesc.gridy = 7;
		firstPanel.add(lblAttackDesc, gbc_lblAttackDesc);
		
		txpDesc = new JTextPane();
		GridBagConstraints gbc_txpDesc = new GridBagConstraints();
		gbc_txpDesc.gridheight = 2;
		gbc_txpDesc.gridwidth = 4;
		gbc_txpDesc.insets = new Insets(0, 0, 5, 5);
		gbc_txpDesc.fill = GridBagConstraints.BOTH;
		gbc_txpDesc.gridx = 8;
		gbc_txpDesc.gridy = 7;
		firstPanel.add(txpDesc, gbc_txpDesc);
		
		JLabel lblHealth = new JLabel("Vie");
		GridBagConstraints gbc_lblHealth = new GridBagConstraints();
		gbc_lblHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth.gridx = 1;
		gbc_lblHealth.gridy = 8;
		firstPanel.add(lblHealth, gbc_lblHealth);
		
		txbHealth = new JTextField();
		GridBagConstraints gbc_txbHealth = new GridBagConstraints();
		gbc_txbHealth.gridwidth = 4;
		gbc_txbHealth.insets = new Insets(0, 0, 5, 5);
		gbc_txbHealth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txbHealth.gridx = 2;
		gbc_txbHealth.gridy = 8;
		firstPanel.add(txbHealth, gbc_txbHealth);
		txbHealth.setColumns(10);
		
		JLabel lblWickness = new JLabel("Faiblesse");
		GridBagConstraints gbc_lblWickness = new GridBagConstraints();
		gbc_lblWickness.insets = new Insets(0, 0, 5, 5);
		gbc_lblWickness.gridx = 1;
		gbc_lblWickness.gridy = 9;
		firstPanel.add(lblWickness, gbc_lblWickness);
		
		txbWickness = new JTextField();
		GridBagConstraints gbc_txbWickness = new GridBagConstraints();
		gbc_txbWickness.gridwidth = 4;
		gbc_txbWickness.insets = new Insets(0, 0, 5, 5);
		gbc_txbWickness.fill = GridBagConstraints.HORIZONTAL;
		gbc_txbWickness.gridx = 2;
		gbc_txbWickness.gridy = 9;
		firstPanel.add(txbWickness, gbc_txbWickness);
		txbWickness.setColumns(10);
		
		JLabel lblResistance = new JLabel("R\u00E9sistance");
		GridBagConstraints gbc_lblResistance = new GridBagConstraints();
		gbc_lblResistance.insets = new Insets(0, 0, 5, 5);
		gbc_lblResistance.gridx = 1;
		gbc_lblResistance.gridy = 10;
		firstPanel.add(lblResistance, gbc_lblResistance);
		
		txbResistance = new JTextField();
		GridBagConstraints gbc_txbResistance = new GridBagConstraints();
		gbc_txbResistance.gridwidth = 4;
		gbc_txbResistance.insets = new Insets(0, 0, 5, 5);
		gbc_txbResistance.fill = GridBagConstraints.HORIZONTAL;
		gbc_txbResistance.gridx = 2;
		gbc_txbResistance.gridy = 10;
		firstPanel.add(txbResistance, gbc_txbResistance);
		txbResistance.setColumns(10);
		
		JLabel lblAttackCost = new JLabel("Co\u00FBt de \r\nl'attaque");
		GridBagConstraints gbc_lblAttackCost = new GridBagConstraints();
		gbc_lblAttackCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttackCost.gridx = 7;
		gbc_lblAttackCost.gridy = 10;
		firstPanel.add(lblAttackCost, gbc_lblAttackCost);
		
		JLabel lblPower = new JLabel("Pouvoir");
		GridBagConstraints gbc_lblPower = new GridBagConstraints();
		gbc_lblPower.insets = new Insets(0, 0, 5, 5);
		gbc_lblPower.gridx = 1;
		gbc_lblPower.gridy = 11;
		firstPanel.add(lblPower, gbc_lblPower);
		
		txpPower = new JTextPane();
		GridBagConstraints gbc_txpPower = new GridBagConstraints();
		gbc_txpPower.gridheight = 2;
		gbc_txpPower.gridwidth = 4;
		gbc_txpPower.insets = new Insets(0, 0, 5, 5);
		gbc_txpPower.fill = GridBagConstraints.BOTH;
		gbc_txpPower.gridx = 2;
		gbc_txpPower.gridy = 11;
		firstPanel.add(txpPower, gbc_txpPower);
		
		JLabel lblEnergy = new JLabel("Energie");
		GridBagConstraints gbc_lblEnergy = new GridBagConstraints();
		gbc_lblEnergy.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnergy.gridx = 7;
		gbc_lblEnergy.gridy = 11;
		firstPanel.add(lblEnergy, gbc_lblEnergy);
		
		cbxEnergy = new JComboBox<Energy>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 8;
		gbc_comboBox.gridy = 11;
		firstPanel.add(cbxEnergy, gbc_comboBox);
		
		/*JLabel lblEnergyNumber = new JLabel("Nombre");
		GridBagConstraints gbc_lblEnergyNumber = new GridBagConstraints();
		gbc_lblEnergyNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnergyNumber.gridx = 7;
		gbc_lblEnergyNumber.gridy = 12;
		firstPanel.add(lblEnergyNumber, gbc_lblEnergyNumber);
		
		txfNumber = new JTextField();
		GridBagConstraints gbc_txfNumber = new GridBagConstraints();
		gbc_txfNumber.gridwidth = 2;
		gbc_txfNumber.insets = new Insets(0, 0, 5, 5);
		gbc_txfNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNumber.gridx = 8;
		gbc_txfNumber.gridy = 12;
		firstPanel.add(txfNumber, gbc_txfNumber);
		txfNumber.setColumns(10);*/
		
		JLabel lblInfo = new JLabel("Information");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 1;
		gbc_lblInfo.gridy = 13;
		firstPanel.add(lblInfo, gbc_lblInfo);
		
		txpInfo = new JTextPane();
		GridBagConstraints gbc_txpInfo = new GridBagConstraints();
		gbc_txpInfo.gridheight = 2;
		gbc_txpInfo.gridwidth = 4;
		gbc_txpInfo.insets = new Insets(0, 0, 5, 5);
		gbc_txpInfo.fill = GridBagConstraints.BOTH;
		gbc_txpInfo.gridx = 2;
		gbc_txpInfo.gridy = 13;
		firstPanel.add(txpInfo, gbc_txpInfo);
		
		JLabel lblRetirCost = new JLabel("Co\u00FBt de \r\nretrait");
		GridBagConstraints gbc_lblRetirCost = new GridBagConstraints();
		gbc_lblRetirCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblRetirCost.gridx = 1;
		gbc_lblRetirCost.gridy = 15;
		firstPanel.add(lblRetirCost, gbc_lblRetirCost);
		
		txbRetirCost = new JTextField();
		GridBagConstraints gbc_txbRetirCost = new GridBagConstraints();
		gbc_txbRetirCost.gridwidth = 2;
		gbc_txbRetirCost.insets = new Insets(0, 0, 5, 5);
		gbc_txbRetirCost.fill = GridBagConstraints.HORIZONTAL;
		gbc_txbRetirCost.gridx = 2;
		gbc_txbRetirCost.gridy = 15;
		firstPanel.add(txbRetirCost, gbc_txbRetirCost);
		txbRetirCost.setColumns(10);
		
		JButton butAdd = new JButton("Ajouter");
		butAdd.addActionListener(new EventListener(this));
		GridBagConstraints gbc_butAdd = new GridBagConstraints();
		gbc_butAdd.insets = new Insets(0, 0, 0, 5);
		gbc_butAdd.gridx = 6;
		gbc_butAdd.gridy = 16;
		firstPanel.add(butAdd, gbc_butAdd);
		
		ArrayList<Energy> listEnergy = Energy.getEnergies();
		
		for (Energy anEnergy : listEnergy) 
			cbxEnergy.addItem(anEnergy);
		
		return firstPanel;
	}
	
	public String getPokeName() {
		return txfName.getText();
	}
	
	public void setPokeName(String name) {
		txfName.setText(name);
	}
	
	public String getPokeType() {
		return txfType.getText();
	}
	
	public void setPokeType(String type) {
		txfType.setText(type);
	}
	
	public int getPokeLevel() {
		return Integer.parseInt(txfLevel.getText());
	}
	
	public void setPokeLevel(int lvl) {
		txfLevel.setText(Integer.toString(lvl));
	}
	
	public int getPokeHealth() {
		return Integer.parseInt(txbHealth.getText());
	}
	
	public void setPokeHealth(int hp) {
		txbHealth.setText(Integer.toString(hp));
	}
	
	public String getPokeWickness() {
		return txbWickness.getText();
	}
	
	public void setPokeWickness(String wick) {
		txbWickness.setText(wick);
	}
	
	public String getPokeResistance() {
		return txbResistance.getText();
	}
	
	public void setPokeResistance(String resi) {
		txbResistance.setText(resi);
	}
	
	public int getPokeRetirement() {
		return Integer.parseInt(txbRetirCost.getText());
	}
	
	public void setPokeRetirement(int retir) {
		txbRetirCost.setText(Integer.toString(retir));
	}
	
	public String getPokePower() {
		return txpPower.getText();
	}
	
	public void setPokePower(String power) {
		txpPower.setText(power);
	}
	
	public String getPokeInfo() {
		return txpInfo.getText();
	}
	
	public void setPokeInfo(String info) {
		txpInfo.setText(info);
	}
	
	public String getAttackName() {
		return txfAttackName.getText();
	}
	
	public void setAttackName(String attckName) {
		txfAttackName.setText(attckName);
	}
	
	public String getAttackDesc() {
		return txpDesc.getText();
	}
	
	public void setAttackDesc(String attckDesc) {
		txpDesc.setText(attckDesc);
	}
	
	public int getAttackDamage() {
		return Integer.parseInt(txfDamage.getText());
	}
	
	public void setAttackDamage(int dmg) {
		txfDamage.setText(Integer.toString(dmg));
	}
	
	public Energy getAttackCost() {
		return (Energy) cbxEnergy.getSelectedItem();
	}
	
	public void setAttackCost(Energy eng) {
		cbxEnergy.addItem(eng);
	}
	
	/**
	 * Create Modify card panel
	 * @return JPanel
	 */
	public JPanel modifyPanel() {
		JPanel secondPanel = new JPanel();
		secondPanel.setVisible(true);
		secondPanel.setBackground(new Color(0, 204, 102));
		getContentPane().add(secondPanel, BorderLayout.CENTER);
		GridBagLayout gbl_firstPanel = new GridBagLayout();
		gbl_firstPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_firstPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_firstPanel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_firstPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		secondPanel.setLayout(gbl_firstPanel);
		
		JLabel lblAddCard = new JLabel("Modifier une carte");
		lblAddCard.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblAddCard = new GridBagConstraints();
		gbc_lblAddCard.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddCard.gridx = 6;
		gbc_lblAddCard.gridy = 1;
		secondPanel.add(lblAddCard, gbc_lblAddCard);
		
		JLabel lblPokemon = new JLabel("Pokemon");
		lblPokemon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblPokemon = new GridBagConstraints();
		gbc_lblPokemon.insets = new Insets(0, 0, 5, 5);
		gbc_lblPokemon.gridx = 1;
		gbc_lblPokemon.gridy = 3;
		secondPanel.add(lblPokemon, gbc_lblPokemon);
		
		JLabel lblAttack = new JLabel("Attaque");
		lblAttack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblAttack = new GridBagConstraints();
		gbc_lblAttack.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttack.gridx = 7;
		gbc_lblAttack.gridy = 3;
		secondPanel.add(lblAttack, gbc_lblAttack);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 5;
		secondPanel.add(lblName, gbc_lblName);
		
		cbxPokemonChoice = new JComboBox<Card>();
		cbxPokemonChoice.addItemListener(new PokeUpdateListener(this));
		
		GridBagConstraints gbc_cbxPokemonChoice = new GridBagConstraints();
		gbc_cbxPokemonChoice = new GridBagConstraints();
		gbc_cbxPokemonChoice.gridwidth = 4;
		gbc_cbxPokemonChoice.insets = new Insets(0, 0, 5, 5);
		gbc_cbxPokemonChoice.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxPokemonChoice.gridx = 2;
		gbc_cbxPokemonChoice.gridy = 5;
		secondPanel.add(cbxPokemonChoice, gbc_cbxPokemonChoice);
		
		JLabel lblAttckName = new JLabel("Nom");
		GridBagConstraints gbc_lblAttckName = new GridBagConstraints();
		gbc_lblAttckName.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttckName.gridx = 7;
		gbc_lblAttckName.gridy = 5;
		secondPanel.add(lblAttckName, gbc_lblAttckName);
		
		txfModifAttackName = new JTextField();
		GridBagConstraints gbc_txfAttackName = new GridBagConstraints();
		gbc_txfAttackName.gridwidth = 4;
		gbc_txfAttackName.insets = new Insets(0, 0, 5, 5);
		gbc_txfAttackName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfAttackName.gridx = 8;
		gbc_txfAttackName.gridy = 5;
		secondPanel.add(txfModifAttackName, gbc_txfAttackName);
		txfModifAttackName.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 1;
		gbc_lblType.gridy = 6;
		secondPanel.add(lblType, gbc_lblType);
		
		txfModifType = new JTextField();
		GridBagConstraints gbc_txfType = new GridBagConstraints();
		gbc_txfType.gridwidth = 4;
		gbc_txfType.insets = new Insets(0, 0, 5, 5);
		gbc_txfType.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfType.gridx = 2;
		gbc_txfType.gridy = 6;
		secondPanel.add(txfModifType, gbc_txfType);
		txfModifType.setColumns(10);
		
		JLabel lblDamage = new JLabel("Dommage");
		GridBagConstraints gbc_lblDamage = new GridBagConstraints();
		gbc_lblDamage.insets = new Insets(0, 0, 5, 5);
		gbc_lblDamage.gridx = 7;
		gbc_lblDamage.gridy = 6;
		secondPanel.add(lblDamage, gbc_lblDamage);
		
		txfModifDamage = new JTextField();
		GridBagConstraints gbc_txfDamage = new GridBagConstraints();
		gbc_txfDamage.gridwidth = 4;
		gbc_txfDamage.insets = new Insets(0, 0, 5, 5);
		gbc_txfDamage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfDamage.gridx = 8;
		gbc_txfDamage.gridy = 6;
		secondPanel.add(txfModifDamage, gbc_txfDamage);
		txfModifDamage.setColumns(10);
		
		JLabel lblLevel = new JLabel("Level");
		GridBagConstraints gbc_lblLevel = new GridBagConstraints();
		gbc_lblLevel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevel.gridx = 1;
		gbc_lblLevel.gridy = 7;
		secondPanel.add(lblLevel, gbc_lblLevel);
		
		txfModifLevel = new JTextField();
		GridBagConstraints gbc_txfLevel = new GridBagConstraints();
		gbc_txfLevel.gridwidth = 4;
		gbc_txfLevel.insets = new Insets(0, 0, 5, 5);
		gbc_txfLevel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfLevel.gridx = 2;
		gbc_txfLevel.gridy = 7;
		secondPanel.add(txfModifLevel, gbc_txfLevel);
		txfModifLevel.setColumns(10);
		
		JLabel lblAttackDesc = new JLabel("Description");
		GridBagConstraints gbc_lblAttackDesc = new GridBagConstraints();
		gbc_lblAttackDesc.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttackDesc.gridx = 7;
		gbc_lblAttackDesc.gridy = 7;
		secondPanel.add(lblAttackDesc, gbc_lblAttackDesc);
		
		txpModifDesc = new JTextPane();
		GridBagConstraints gbc_txpDesc = new GridBagConstraints();
		gbc_txpDesc.gridheight = 2;
		gbc_txpDesc.gridwidth = 4;
		gbc_txpDesc.insets = new Insets(0, 0, 5, 5);
		gbc_txpDesc.fill = GridBagConstraints.BOTH;
		gbc_txpDesc.gridx = 8;
		gbc_txpDesc.gridy = 7;
		secondPanel.add(txpModifDesc, gbc_txpDesc);
		
		JLabel lblHealth = new JLabel("Vie");
		GridBagConstraints gbc_lblHealth = new GridBagConstraints();
		gbc_lblHealth.insets = new Insets(0, 0, 5, 5);
		gbc_lblHealth.gridx = 1;
		gbc_lblHealth.gridy = 8;
		secondPanel.add(lblHealth, gbc_lblHealth);
		
		txbModifHealth = new JTextField();
		GridBagConstraints gbc_txbHealth = new GridBagConstraints();
		gbc_txbHealth.gridwidth = 4;
		gbc_txbHealth.insets = new Insets(0, 0, 5, 5);
		gbc_txbHealth.fill = GridBagConstraints.HORIZONTAL;
		gbc_txbHealth.gridx = 2;
		gbc_txbHealth.gridy = 8;
		secondPanel.add(txbModifHealth, gbc_txbHealth);
		txbModifHealth.setColumns(10);
		
		JLabel lblWickness = new JLabel("Faiblesse");
		GridBagConstraints gbc_lblWickness = new GridBagConstraints();
		gbc_lblWickness.insets = new Insets(0, 0, 5, 5);
		gbc_lblWickness.gridx = 1;
		gbc_lblWickness.gridy = 9;
		secondPanel.add(lblWickness, gbc_lblWickness);
		
		txbModifWickness = new JTextField();
		GridBagConstraints gbc_txbWickness = new GridBagConstraints();
		gbc_txbWickness.gridwidth = 4;
		gbc_txbWickness.insets = new Insets(0, 0, 5, 5);
		gbc_txbWickness.fill = GridBagConstraints.HORIZONTAL;
		gbc_txbWickness.gridx = 2;
		gbc_txbWickness.gridy = 9;
		secondPanel.add(txbModifWickness, gbc_txbWickness);
		txbModifWickness.setColumns(10);
		
		JLabel lblResistance = new JLabel("R\u00E9sistance");
		GridBagConstraints gbc_lblResistance = new GridBagConstraints();
		gbc_lblResistance.insets = new Insets(0, 0, 5, 5);
		gbc_lblResistance.gridx = 1;
		gbc_lblResistance.gridy = 10;
		secondPanel.add(lblResistance, gbc_lblResistance);
		
		txbModifResistance = new JTextField();
		GridBagConstraints gbc_txbResistance = new GridBagConstraints();
		gbc_txbResistance.gridwidth = 4;
		gbc_txbResistance.insets = new Insets(0, 0, 5, 5);
		gbc_txbResistance.fill = GridBagConstraints.HORIZONTAL;
		gbc_txbResistance.gridx = 2;
		gbc_txbResistance.gridy = 10;
		secondPanel.add(txbModifResistance, gbc_txbResistance);
		txbModifResistance.setColumns(10);
		
		JLabel lblAttackCost = new JLabel("Co\u00FBt de \r\nl'attaque");
		GridBagConstraints gbc_lblAttackCost = new GridBagConstraints();
		gbc_lblAttackCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblAttackCost.gridx = 7;
		gbc_lblAttackCost.gridy = 10;
		secondPanel.add(lblAttackCost, gbc_lblAttackCost);
		
		JLabel lblPower = new JLabel("Pouvoir");
		GridBagConstraints gbc_lblPower = new GridBagConstraints();
		gbc_lblPower.insets = new Insets(0, 0, 5, 5);
		gbc_lblPower.gridx = 1;
		gbc_lblPower.gridy = 11;
		secondPanel.add(lblPower, gbc_lblPower);
		
		txpModifPower = new JTextPane();
		GridBagConstraints gbc_txpPower = new GridBagConstraints();
		gbc_txpPower.gridheight = 2;
		gbc_txpPower.gridwidth = 4;
		gbc_txpPower.insets = new Insets(0, 0, 5, 5);
		gbc_txpPower.fill = GridBagConstraints.BOTH;
		gbc_txpPower.gridx = 2;
		gbc_txpPower.gridy = 11;
		secondPanel.add(txpModifPower, gbc_txpPower);
		
		JLabel lblEnergy = new JLabel("Energie");
		GridBagConstraints gbc_lblEnergy = new GridBagConstraints();
		gbc_lblEnergy.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnergy.gridx = 7;
		gbc_lblEnergy.gridy = 11;
		secondPanel.add(lblEnergy, gbc_lblEnergy);
		
		cbxEnergyModif = new JComboBox<Energy>();
		GridBagConstraints gbc_cbxPokemon = new GridBagConstraints();
		gbc_cbxPokemon.gridwidth = 4;
		gbc_cbxPokemon.insets = new Insets(0, 0, 5, 5);
		gbc_cbxPokemon.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxPokemon.gridx = 8;
		gbc_cbxPokemon.gridy = 11;
		secondPanel.add(cbxEnergyModif, gbc_cbxPokemon);
		
		/*JLabel lblEnergyNumber = new JLabel("Nombre");
		GridBagConstraints gbc_lblEnergyNumber = new GridBagConstraints();
		gbc_lblEnergyNumber.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnergyNumber.gridx = 7;
		gbc_lblEnergyNumber.gridy = 12;
		secondPanel.add(lblEnergyNumber, gbc_lblEnergyNumber);
		
		txfNumber = new JTextField();
		GridBagConstraints gbc_txfNumber = new GridBagConstraints();
		gbc_txfNumber.gridwidth = 2;
		gbc_txfNumber.insets = new Insets(0, 0, 5, 5);
		gbc_txfNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txfNumber.gridx = 8;
		gbc_txfNumber.gridy = 12;
		secondPanel.add(txfNumber, gbc_txfNumber);
		txfNumber.setColumns(10);*/
		
		JLabel lblInfo = new JLabel("Information");
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.insets = new Insets(0, 0, 5, 5);
		gbc_lblInfo.gridx = 1;
		gbc_lblInfo.gridy = 13;
		secondPanel.add(lblInfo, gbc_lblInfo);
		
		txpModifInfo = new JTextPane();
		GridBagConstraints gbc_txpInfo = new GridBagConstraints();
		gbc_txpInfo.gridheight = 2;
		gbc_txpInfo.gridwidth = 4;
		gbc_txpInfo.insets = new Insets(0, 0, 5, 5);
		gbc_txpInfo.fill = GridBagConstraints.BOTH;
		gbc_txpInfo.gridx = 2;
		gbc_txpInfo.gridy = 13;
		secondPanel.add(txpModifInfo, gbc_txpInfo);
		
		JLabel lblRetirCost = new JLabel("Co\u00FBt de \r\nretrait");
		GridBagConstraints gbc_lblRetirCost = new GridBagConstraints();
		gbc_lblRetirCost.insets = new Insets(0, 0, 5, 5);
		gbc_lblRetirCost.gridx = 1;
		gbc_lblRetirCost.gridy = 15;
		secondPanel.add(lblRetirCost, gbc_lblRetirCost);
		
		txbModifRetirCost = new JTextField();
		GridBagConstraints gbc_txbRetirCost = new GridBagConstraints();
		gbc_txbRetirCost.gridwidth = 2;
		gbc_txbRetirCost.insets = new Insets(0, 0, 5, 5);
		gbc_txbRetirCost.fill = GridBagConstraints.HORIZONTAL;
		gbc_txbRetirCost.gridx = 2;
		gbc_txbRetirCost.gridy = 15;
		secondPanel.add(txbModifRetirCost, gbc_txbRetirCost);
		txbModifRetirCost.setColumns(10);
		
		JButton butModif = new JButton("Modifier");
		butModif.addActionListener(new EventListener(this));
		GridBagConstraints gbc_butModif = new GridBagConstraints();
		gbc_butModif.insets = new Insets(0, 0, 0, 5);
		gbc_butModif.gridx = 6;
		gbc_butModif.gridy = 16;
		secondPanel.add(butModif, gbc_butModif);		

		return secondPanel;
	}
	
	public Pokemon getCbxPokemonChoice() {
		return (Pokemon) cbxPokemonChoice.getSelectedItem();
	}
	
	public String getModifType() {
		return txfModifType.getText();
	}
	
	public void setModifType(String type) {
		txfModifType.setText(type);
	}
	
	public int getModifLevel() {
		return Integer.parseInt(txfModifLevel.getText());
	}
	
	public void setModifLevel(int lvl) {
		txfModifLevel.setText(Integer.toString(lvl));
	}
	
	public int getModifHealth() {
		return Integer.parseInt(txbModifHealth.getText());
	}
	
	public void setModifHealth(int hp) {
		txbModifHealth.setText(Integer.toString(hp));
	}
	
	public String getModifWickness() {
		return txbModifWickness.getText();
	}
	
	public void setModifWickness(String wick) {
		txbModifWickness.setText(wick);
	}
	
	public String getModifResistance() {
		return txbModifResistance.getText();
	}
	
	public void setModifResistance(String resi) {
		txbModifResistance.setText(resi);
	}
	
	public int getModifRetirement() {
		return Integer.parseInt(txbModifRetirCost.getText());
	}
	
	public void setModifRetirement(int retir) {
		txbModifRetirCost.setText(Integer.toString(retir));
	}
	
	public String getModifPower() {
		return txpModifPower.getText();
	}
	
	public void setModifPower(String power) {
		txpModifPower.setText(power);
	}
	
	public String getModifInfo() {
		return txpModifInfo.getText();
	}
	
	public void setModifInfo(String info) {
		txpModifInfo.setText(info);
	}
	
	public String getModifAttackName() {
		return txfModifAttackName.getText();
	}
	
	public void setModifAttackName(String attckName) {
		txfModifAttackName.setText(attckName);
	}
	
	public String getModifAttackDesc() {
		return txpModifDesc.getText();
	}
	
	public void setModifAttackDesc(String attckDesc) {
		txpModifDesc.setText(attckDesc);
	}
	
	public int getModifAttackDamage() {
		return Integer.parseInt(txfModifDamage.getText());
	}
	
	public void setModifAttackDamage(int dmg) {
		txfModifDamage.setText(Integer.toString(dmg));
	}
	
	public Energy getModifAttackCost() {
		return (Energy) cbxEnergyModif.getSelectedItem();
	}
	
	public void setModifAttackCost(Energy eng) {
		cbxEnergyModif.addItem(eng);
	}
	
	/**
	 * Create Delete card panel
	 * @return JPanel
	 */
	public JPanel deletePanel() {
		JPanel deletePanel = new JPanel();		
		deletePanel.setBackground(new Color(51, 204, 102));
		getContentPane().add(deletePanel, BorderLayout.CENTER);
		GridBagLayout gbl_deletePanel = new GridBagLayout();
		gbl_deletePanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_deletePanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_deletePanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_deletePanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		deletePanel.setLayout(gbl_deletePanel);
		
		JLabel lblTitleDelete = new JLabel("Supprimer une carte");
		lblTitleDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblTitleDelete = new GridBagConstraints();
		gbc_lblTitleDelete.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitleDelete.gridx = 3;
		gbc_lblTitleDelete.gridy = 1;
		deletePanel.add(lblTitleDelete, gbc_lblTitleDelete);
		
		JLabel lblSelectName = new JLabel("S\u00E9lectionner le nom de la carte");
		lblSelectName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblSelectName = new GridBagConstraints();
		gbc_lblSelectName.gridwidth = 2;
		gbc_lblSelectName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSelectName.gridx = 1;
		gbc_lblSelectName.gridy = 4;
		deletePanel.add(lblSelectName, gbc_lblSelectName);
		
		cbxNamePoke = new JComboBox<Card>();
		cbxNamePoke.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_cbxNamePoke = new GridBagConstraints();
		gbc_cbxNamePoke.gridwidth = 2;
		gbc_cbxNamePoke.insets = new Insets(0, 0, 5, 5);
		gbc_cbxNamePoke.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxNamePoke.gridx = 1;
		gbc_cbxNamePoke.gridy = 6;
		deletePanel.add(cbxNamePoke, gbc_cbxNamePoke);
		
		JButton btnDelete = new JButton("Supprimer");
		btnDelete.addActionListener(new EventListener(this));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 0, 5);
		gbc_btnDelete.gridx = 4;
		gbc_btnDelete.gridy = 9;
		deletePanel.add(btnDelete, gbc_btnDelete);
		
		return deletePanel;
	}
	
	public Card getCbxNamePoke() {
		return cbxNamePoke.getItemAt(cbxNamePoke.getSelectedIndex());
	}
}

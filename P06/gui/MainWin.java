package gui;

import javax.swing.*;

public class MainWin extends JFrame
{
	public MainWin()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		
		//menubar
		JMenuBar menubar = new JMenuBar();
		
		//menubar buttons
		JMenu file = new JMenu("File");
		JMenuItem quit = new JMenuItem("Quit");
		JMenu view = new JMenu("View");
		JMenuItem iceCream = new JMenuItem("Ice Cream Flavor");
		JMenuItem mixIn = new JMenuItem("Mix In Flavor");
		JMenuItem scoop = new JMenuItem("Scoop");
		JMenu create = new JMenu("Create");
		JMenuItem newIceCream = new JMenuItem("Ice Cream Flavor");
		JMenuItem newMixIn = new JMenuItem("Mix In Flavor");
		JMenuItem newScoop = new JMenuItem("Scoop");
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		
		//button interactions
		quit.addActionListener(event -> onQuitClick());
		newIceCream.addActionListener(event -> onCreateIceCreamFlavorClick());
		newMixIn.addActionListener(event -> onCreateMixInFlavorClick());
		newScoop.addActionListener(event -> onCreateScoopClick());
		about.addActionListener(event -> onAboutClick());
		
		//adding buttons to menus
		file.add(quit);
		//view.add;
		create.add(newIceCream);
		create.add(newMixIn);
		create.add(newScoop);
		help.add(about);
		
		//adding menus to menubar
		menubar.add(file);
		menubar.add(view);
		menubar.add(create);
		menubar.add(help);
	}
	public void onQuitClick()
	{
		System.exit(0);
	}
	public void onCreateIceCreamFlavorClick()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		
		name = new JButton("Name");
		name.addActionListener(
				event -> {
					String inName = JOptionPane.showInputDialog(this, "Name?");
				});
			constraints.gridy++;
		add(name, constraints);
		
		description = new JButton("Description");
		description.addActionListener(
				event -> {
					String inDesc = JOptionPane.showInputDialog(this, "Description?");
				});
			constraints.gridy++;
		add(description, constraints);
		
		cost = new JButton("Cost");
		cost.addActionListener(
				event -> {
					String inCost = JOptionPane.showInputDialog(this, "Cost?");
				});
			constraints.gridy++;
		add(cost, constraints);
		
		price = new JButton("Price");
		price.addActionListener(
				event -> {
					String inPrice = JOptionPane.showInputDialog(this, "Price?");
				});
			constraints.gridy++;
		add(price, constraints);
		
		setSize(350, 200);
		setVisible(true);
		
		emporium.addIceCreamFlavor(inName);
		emporium.iceCreamFlavor();
	}
	public void onCreateMixInFlavorClick()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		
		name = new JButton("Name");
		name.addActionListener(
				event -> {
					String inName = JOptionPane.showInputDialog(this, "Name?");
				});
			constraints.gridy++;
		add(name, constraints);
		
		description = new JButton("Description");
		description.addActionListener(
				event -> {
					String inDesc = JOptionPane.showInputDialog(this, "Description?");
				});
			constraints.gridy++;
		add(description, constraints);
		
		cost = new JButton("Cost");
		cost.addActionListener(
				event -> {
					String inCost = JOptionPane.showInputDialog(this, "Cost?");
				});
			constraints.gridy++;
		add(cost, constraints);
		
		price = new JButton("Price");
		price.addActionListener(
				event -> {
					String inPrice = JOptionPane.showInputDialog(this, "Price?");
				});
			constraints.gridy++;
		add(price, constraints);
		
		setSize(350, 200);
		setVisible(true);
		
		emporium.addMixInFlavor(inName);
		emporium.mixInFlavors();
	}
	public void onCreateScoopClick()
	{
		String[] iceCreamChoice = emporium.iceCreamFlavors();
		iceCreamChoices = new JComboBox<String>(iceCreamChoice);
		
		String[] mixInChoice = emporium.mixInFlavors();
		mixInChoices = new JComboBox<String>(mixInChoice);
		
		Object[] objects = {
			iceCreamChoice, iceCreamChoices,
			mixInChoice, mixInChoices};
		int button = JOptionPane.showConfirmDialog(
			this,
			objects,
			"New Scoop",
			JOptionPane.OK_CANCEL_OPTION,
			JOptionPane.QUESTION_MESSAGE,
			3);
		if(button == JOptionPane.OK_OPTION)
			JOptionPane.showMessageDialog(
				this,
				"Created!");
		
		Scoop scoop = new Scoop(iceCreamChoices.getSelectedItem());
		scoop.addMixIn(mixInChoices.getSelectedItem());
		emporium.addScoop(scoop);
	}
	public void onAboutClick()
	{
		JDialog about = new JDialog();
		about.setLayout(new FlowLayout());
		about.setTitle("MICE");
	}
	private void view(Screen screen)
	{
	
	}
	
	private Emporium emporium;
	private JLabel display;
}

import javax.swing.JFrame;
import javax.swing.JButton;

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
		view.add;
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
	public onQuitClick()
	{
		System.exit(0);
	}
	public onCreateIceCreamFlavorClick()
	{
		emporium.addIceCreamFlavor();
	}
	public onCreateMixInFlavorClick()
	{
	
	}
	public onCreateScoopClick()
	{
	
	}
	public onAboutClick()
	{
	
	}
	private view(Screen screen)
	{
	
	}
	
	private Emporium emporium;
	private Jlabel display;
}

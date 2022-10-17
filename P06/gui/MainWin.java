package gui;

import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.BoxLayout;
import javax.swing.Box;

import java.awt.BorderLayout;
import java.awt.Font;

import emporium.Emporium;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;

public class MainWin extends JFrame
{
	public MainWin()
	{
		super("Mav Ice Cream Emporium");
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
		iceCream.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
		mixIn.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
        scoop.addActionListener(event -> view(Screen.SCOOPS));
		newIceCream.addActionListener(event -> onCreateIceCreamFlavorClick());
		newMixIn.addActionListener(event -> onCreateMixInFlavorClick());
		newScoop.addActionListener(event -> onCreateScoopClick());
		//newScoop.setEnabled(false);
		about.addActionListener(event -> onAboutClick());
		
		//adding buttons to menus
		file.add(quit);
		view.add(iceCream);
		view.add(mixIn);
		view.add(scoop);
		create.add(newIceCream);
		create.add(newMixIn);
		create.add(newScoop);
		help.add(about);
		
		//adding menus to menubar
		menubar.add(file);
		menubar.add(view);
		menubar.add(create);
		menubar.add(help);
		
		setJMenuBar(menubar);
		
		display = new JLabel();
		display.setFont(new Font("Courier New", Font.BOLD, 20));
		display.setVerticalAlignment(JLabel.TOP);
		add(display, BorderLayout.CENTER);
		
		setVisible(true);
		
		emporium = new Emporium();
	}
	public void onQuitClick()
	{
		System.exit(0);
	}
	public void onCreateIceCreamFlavorClick()
	{
		emporium.addIceCreamFlavor(new IceCreamFlavor(
        	JOptionPane.showInputDialog(this, "Name?", 
                "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
            JOptionPane.showInputDialog(this, "Description?", 
                "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE),
            Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", 
                "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE)),
            Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", 
                "Create Ice Cream Flavor", JOptionPane.QUESTION_MESSAGE))
    	));
    	
    	//newScoop.setEnabled(true);
    	view(Screen.ICE_CREAM_FLAVORS);
	}
	public void onCreateMixInFlavorClick()
	{
		emporium.addMixInFlavor(new MixInFlavor(
			JOptionPane.showInputDialog(this, "Name?", 
                "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE),
            JOptionPane.showInputDialog(this, "Description?", 
                "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE),
            Integer.parseInt(JOptionPane.showInputDialog(this, "Price?", 
                "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE)),
            Integer.parseInt(JOptionPane.showInputDialog(this, "Cost?", 
                "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE))
         ));
         view(Screen.MIX_IN_FLAVORS);
	}
	public void onCreateScoopClick()
	{
		IceCreamFlavor icf = (IceCreamFlavor) JOptionPane.showInputDialog(this, 
            "Ice Cream Flavor?", "New Scoop", JOptionPane.QUESTION_MESSAGE, null, 
            emporium.iceCreamFlavors(), null);
        if(icf != null) {
            Scoop scoop = new Scoop(icf);
            if(emporium.mixInFlavors().length > 0) {
                String prompt = "<html>" + scoop + "<br/>Add a mix in?</html>";
                while(true) {
                    MixInFlavor mif = (MixInFlavor) JOptionPane.showInputDialog(this, prompt, 
                        "Add Mix In", JOptionPane.QUESTION_MESSAGE, null, 
                        emporium.mixInFlavors(), null);
                    if(mif == null) break;
                    MixInAmount mia = (MixInAmount) JOptionPane.showInputDialog(this, prompt, 
                        "Add Mix In", JOptionPane.QUESTION_MESSAGE, null, 
                        MixInAmount.values(), MixInAmount.Normal);
                    scoop.addMixIn(new MixIn(mif, mia));
                    prompt = "<html>" + scoop + "<br/>Add another mix in?</html>";
                }
            }
            emporium.addScoop(scoop);
            view(Screen.SCOOPS);         
        }
	}
	public void onAboutClick()
	{
		JDialog about = new JDialog(this, "Mav Ice Cream Emporium");
		about.setLayout(new BoxLayout(about.getContentPane(), BoxLayout.PAGE_AXIS));
		
		JLabel title = new JLabel("<html>"
          + "<br/><p><font size=+4>MICE</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(title);

        JLabel subTitle = new JLabel("<html>"
          + "<br/><p><font size=+1>Mavs Ice Cream Emporium</font></p>"
          + "</html>", JLabel.CENTER);
        about.add(subTitle);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Version 0.2</p>"
          + "<p>Copyright 2022 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "Logo by Schmidsi, per the Pixabay License"
          + "<p><font size=-2>https://pixabay.com/en/ice-ice-cream-cone-ice-ball-pink-1429596/</font></p>"
          + "<br/></html>", JLabel.CENTER);
        about.add(artists);

        JPanel panel = new JPanel();
        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        panel.add(ok);
        about.add(panel);
        
        about.add(Box.createVerticalStrut(10));
        
        about.pack();
        about.setVisible(true);
	}
	
	private enum Screen {ICE_CREAM_FLAVORS, MIX_IN_FLAVORS, SCOOPS}
	private void view(Screen screen)
	{
		String title = "";
         StringBuilder s = new StringBuilder();
         switch(screen) {
             case ICE_CREAM_FLAVORS: 
                 title = "Ice Cream Flavors";
                 for(var t : emporium.iceCreamFlavors()) s.append(t.toString() + "<br/>");
                 break;
             case MIX_IN_FLAVORS: 
                 title = "Mix In Flavors";
                 for(var t : emporium.mixInFlavors()) s.append(t.toString() + "<br/>");
                 break;
             case SCOOPS: 
                 title = "Scoops";
                 for(var t : emporium.scoops()) s.append(t.toString() + "<br/>");
                 break;
             default:
                 display.setText("PANIC: Invalid Displays type: " + display);
         }
         display.setText("<html><font size=+4>" + title + 
                         "<br/></font><font size=+2>" + s.toString() + 
                         "</font></html>");
	}
	
	private Emporium emporium;
	private JLabel display;
}

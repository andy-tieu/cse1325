package gui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.UIManager;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

import javax.swing.Box;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.FlowLayout;

import java.awt.Font;
import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import emporium.Emporium;

import product.Item;
import product.IceCreamFlavor;
import product.MixInFlavor;
import product.MixInAmount;
import product.MixIn;
import product.Scoop;

public class MainWin extends JFrame
{
	private String NAME = "MICE";
	private String VERSION = "1.0";
	private String FILE_VERSION = "1.0";
	private String MAGIC_COOKIE = "MICE!";
	
	public MainWin()
	{
		super("Mav Ice Cream Emporium");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		filename = new File("untitled.mice");
		
		//menubar
		JMenuBar menubar = new JMenuBar();
		
		//menubar buttons
		JMenu file = new JMenu("File");
		JMenuItem open = new JMenuItem("Open Emporium");
		JMenuItem save = new JMenuItem("Save Emporium");
		JMenuItem saveas = new JMenuItem("Save Emporium As");
		JMenuItem quit = new JMenuItem("Quit");
		JMenu help = new JMenu("Help");
		JMenuItem about = new JMenuItem("About");
		
		//button interactions
		open.addActionListener(event -> onOpenClick());
		save.addActionListener(event -> onSaveClick());
		saveas.addActionListener(event -> onSaveAsClick());
		quit.addActionListener(event -> onQuitClick());
		about.addActionListener(event -> onAboutClick());
		
		//adding buttons to menus
		file.add(open);
		file.add(save);
		file.add(saveas);
		file.add(quit);
		help.add(about);
		
		//adding menus to menubar
		menubar.add(file);
		menubar.add(help);
		
		setJMenuBar(menubar);
		
		//TOOLBAR
		JToolBar toolbar = new JToolBar("MICE Inputs");
		
		JButton openB = new JButton(UIManager.getIcon("FileView.fileIcon"));
			openB.setActionCommand("New Emporium");
			openB.setToolTipText("Create new emporium while ending current one");
			openB.setBorder(null);
			toolbar.add(openB);
			openB.addActionListener(event -> onOpenClick());
		
		JButton save = new JButton(UIManager.getIcon());
		
		toolbar.add(Box.createHorizontalStrut(25));
		
		JButton createICFButton = new JButton(new ImageIcon("ice-cream.png"));
			createICFButton.setActionCommand("Create new ice cream flavor");
			createICFButton.setToolTipText("Create new ice cream flavor");
			toolbar.add(createICFButton);
			createICFButton.addActionListener(event -> onCreateIceCreamFlavorClick());
		
		JButton createMIFButton = new JButton(new ImageIcon("sprinkles.png"));
			createMIFButton.setActionCommand("Create new mixin flavor");
			createMIFButton.setToolTipText("Create new mixin flavor");
			toolbar.add(createMIFButton);
			createMIFButton.addActionListener(event -> onCreateMixInFlavorClick());
			
		JButton createOButton = new JButton(new ImageIcon());
			createOButton.setActionCommand("Create new order");
			createOButton.setToolTipText("Create new order");
			toolbar.add(createOButton);
			createOButton.addActionListener(event -> onCreateOrderClick());
			
		JButton createCButton = new JButton(new ImageIcon());
			createCButton.setActionCommand("Create new container");
			createCButton.setToolTipText("Create new container");
			toolbar.add(createCButton);
			createCButton.addActionListener(event -> onCreateContainerClick());
			
		toolbar.add(Box.createHorizontalStrut(25));
		
		JButton viewICFButton = new JButton(new ImageIcon("ice-cream.png"));
			viewICFButton.setActionCommand("View ice cream flavors");
			viewICFButton.setToolTipText("View ice cream flavors");
			toolbar.add(viewICFButton);
			viewICFButton.addActionListener(event -> view(Screen.ICE_CREAM_FLAVORS));
			
		JButton viewMIFButton = new JButton(new ImageIcon("sprinkles.png"));
			viewMIFButton.setActionCommand("View mixin flavors");
			viewMIFButton.setToolTipText("View mixin flavors");
			toolbar.add(viewMIFButton);
			viewMIFButton.addActionListener(event -> view(Screen.MIX_IN_FLAVORS));
			
		JButton viewOButton = new JButton(new ImageIcon());
			viewOButton.setActionCommand("View orders");
			viewOButton.setToolTipText("View orders");
			toolbar.add(viewOButton);
			viewOButton.addActionListener(event -> view(Screen.ORDERS));
			
		JButton viewCButton = new JButton(new ImageIcon());
			viewCButton.setActionCommand("View containers");
			viewCButton.setToolTipText("View containers");
			toolbar.add(viewCButton);
			viewCButton.addActionListener(event -> view(Screen.CONTAINERS));
			
		toolbar.add(Box.createHorizontalGlue());
		
		getContentPane().add(toolbar, BorderLayout.PAGE_START);
		
		//main display
		display = new JLabel();
		display.setFont(new Font("Courier New", Font.BOLD, 20));
		display.setVerticalAlignment(JLabel.TOP);
		add(display, BorderLayout.CENTER);
		
		setVisible(true);
		
		emporium = new Emporium();
	}
	
	public void onOpenClick()
	{
		final JFileChooser fc = new JFileChooser(filename);
		FileFilter miceFiles = new FileNameExtensionFilter("Mice files", "mice");
		fc.addChoosableFileFilter(miceFiles);
		fc.setFileFilter(miceFiles);
		
		int result = fc.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION)
		{
			filename = fc.getSelectedFile();
			
			try(BufferedReader br = new BufferedReader(new FileReader(filename)))
			{
				String magicCookie = br.readLine();
				if(!magicCookie.equals(MAGIC_COOKIE)) throw new RuntimeException("Not a mice file");
				String fileVersion = br.readLine();
				if(!fileVersion.equals(FILE_VERSION)) throw new RuntimeException("Incompatible mice file format");
				
				emporium = new Emporium(br);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this, "Unable to open" + filename + '\n' + e, "Failed", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void onSaveClick();
	{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
		{
			bw.write(MAGIC_COOKIE + '\n');
			bw.write(FILE_VERSION + '\n');
			emporium.save(bw);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "Unable to open" + filename + '\n' + e, "Failed", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void onSaveAsClick()
	{
		final JFileChooser fc = new JFileChooser(filename);
		FileFilter miceFiles = new FileNameExtensionFilter("Mice files", "mice");
		fc.addChoosableFileFilter(miceFiles);
		fc.setFileFilter(miceFiles);
		
		int result = fc.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION)
		{
			filename = fc.getSelectedFile();
			if(!filename.getAbsolutePath().endsWith(".mice"))
			{
				filename = new File(filename.getAbsolutePath() + ".mice");
			}
			onSaveClick();
		}
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
        }
	}
	
	public void onCreateContainerClick()
	{
		emporium.addContainer(new MixInFlavor(
			JOptionPane.showInputDialog(this, "Name?", 
                "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE),
            JOptionPane.showInputDialog(this, "Description?", 
                "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE),
            Integer.parseInt(JOptionPane.showInputDialog(this, "Max scoops?", 
                "Create Mix In Flavor", JOptionPane.QUESTION_MESSAGE)),
         ));
         view(Screen.CONTAINERS);
	}
	
	public void onCreateServingClick()
	{
		Serving s = (Serving) JOptionPane.showInputDialog(this, 
            "Serving?", "New Serving", JOptionPane.QUESTION_MESSAGE, null, 
            emporium.servings(), null);
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
        }
	}
	
	public void onCreateOrderClick()
	{
		Order o = (Order) JOptionPane.showInputDialog(this, 
            "Order?", "New Order", JOptionPane.QUESTION_MESSAGE, null, 
            emporium.orders(), null);
        if(o != null) {
            Order order = new Order(o);
            if(emporium.orders().length > 0) {
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
        }
        view(Screen.ORDERS);
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
          + "Logo by "
          + "<p><font size=-2>/</font></p>"
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
	
	private enum Screen {ICE_CREAM_FLAVORS, MIX_IN_FLAVORS, CONTAINERS, ORDERS}
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
	private File filename;
}

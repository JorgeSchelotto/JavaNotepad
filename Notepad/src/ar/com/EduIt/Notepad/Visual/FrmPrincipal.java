package ar.com.EduIt.Notepad.Visual;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.EduIt.Notepad.Controler.FileUtil;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();
	
	



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPrincipal frame = new FrmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmPrincipal() {
		setTitle("JavaNotepad");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setFont(new Font("Arial", Font.PLAIN, 16));
		setJMenuBar(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar_1.add(mnNewMenu);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnNewMenu.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("open");
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mnNewMenu.add(mntmSaveAs);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnNewMenu.add(mntmExit);
		
		JMenu mnNewMenu_1 = new JMenu("Edit");
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmCopy = new JMenuItem("Copy");
		mnNewMenu_1.add(mntmCopy);
		
		JMenuItem mntmCut = new JMenuItem("Cut");
		mnNewMenu_1.add(mntmCut);
		
		JMenuItem mntmPaste = new JMenuItem("Paste");
		mnNewMenu_1.add(mntmPaste);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 240);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Arial", Font.PLAIN, 13));
	}
}

package ar.com.EduIt.Notepad.Visual;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.EduIt.Notepad.Controler.CouldNotCreateFileException;
import ar.com.EduIt.Notepad.Controler.FileUtil;

import javax.swing.JSplitPane;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class FrmPrincipal extends JFrame {

	private JPanel contentPane;
	private final JTextArea textArea = new JTextArea();
	private File selected;
	private FileUtil fileUtil;
	
	



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
		fileUtil = new FileUtil();
		selected = null;
		
		
		setTitle("JavaNotepad");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 561, 460);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setFont(new Font("Arial", Font.PLAIN, 16));
		setJMenuBar(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar_1.add(mnNewMenu);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnNewMenu.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("open");
		mntmOpen.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				// Add functionality for open file
				JFileChooser fileChooser = new JFileChooser();
				int opc = fileChooser.showOpenDialog(contentPane);
				if (opc == JFileChooser.APPROVE_OPTION) {
					selected = fileChooser.getSelectedFile();
					try {
						String txt = fileUtil.read(selected);
						textArea.setText(txt);
						
					} catch (FileNotFoundException ex) {
						// Show to user
						showErrorMessagge(ex);
						
					} catch (IOException ex) {
						// Show to user
						showErrorMessage(ex);
					}
					
					
				}
				
			}


		});
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (selected != null) {
					try {
						save();
					} catch (FileNotFoundException ex) {
						// TODO Auto-generated catch block
						showErrorMessagge(ex);
					} catch (IOException ex) {
						// TODO Auto-generated catch block
						showErrorMessage(ex);
					}
					
				} else {
			
					
					saveAs();
				}
				
				
			}




		});
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				saveAs();
				
				
			}
			

		});
		mnNewMenu.add(mntmSaveAs);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
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
		scrollPane.setMinimumSize(new Dimension(32767, 32767));
		scrollPane.setBounds(0, 0, 800, 600);
		
		contentPane.add(scrollPane, BorderLayout.CENTER);
		textArea.setPreferredSize(new Dimension(0, 0));
		textArea.setMinimumSize(new Dimension(9000, 9000));
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Arial", Font.PLAIN, 13));
	}
	
	private void showErrorMessagge(CouldNotCreateFileException ex) {
		JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);
	}
	
	private void showErrorMessagge(FileNotFoundException ex) {
		JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error: ", JOptionPane.ERROR_MESSAGE);
	}

	private void showErrorMessage(IOException ex) {
		JOptionPane.showMessageDialog(contentPane, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	}
	
	
	private void saveAs() {
		JFileChooser fileChooser = new JFileChooser();
		int opc = fileChooser.showSaveDialog(contentPane);
		if (opc == JFileChooser.APPROVE_OPTION) {
			
			try {
				selected = fileChooser.getSelectedFile();
				
				try {
					fileUtil.createFile(selected);
				} catch (CouldNotCreateFileException ex) {
					// TODO Auto-generated catch block
					showErrorMessagge(ex);
				}			
				save();
				
			} catch (FileNotFoundException ex) {
				// Show to user
				showErrorMessagge(ex);
				
			} catch (IOException ex) {
				// Show to user
				showErrorMessage(ex);
			}
		
	}
	}

	private void save() throws IOException, FileNotFoundException {
		String txt = textArea.getText();
		fileUtil.write(txt, selected);
	}
}

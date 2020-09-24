import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class Todo extends JPanel{
	
	//Just a needed addition
	private static final long serialVersionUID = 1L;
	int count = 0;
	
	public Todo() {
		setLayout(new BorderLayout());
		DefaultListModel<String> model = new DefaultListModel<String>();
		JList<String> list = new JList<String>(model);
	    JScrollPane pane = new JScrollPane(list);
	    JPanel buttonPanel = new JPanel();
	    JPanel titlePanel = new JPanel();
	    JLabel title = new JLabel("ToDo List App!");
	    title.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
	    titlePanel.setBackground(Color.BLACK);
	    title.setForeground(Color.WHITE);
	    
	    titlePanel.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	titlePanel.setBackground(Color.WHITE);
	        	title.setForeground(Color.BLACK);
	        }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	titlePanel.setBackground(Color.BLACK);
	        	title.setForeground(Color.WHITE);
	        }
	    });
	    
	    if(model.isEmpty()) {
	    	model.addElement("List is Empty");
	    }
		
	    
	    JButton addButton = new JButton("Add Element");
	    addButton.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
	    addButton.setBackground(Color.BLACK);
	    addButton.setForeground(Color.WHITE);
	    
	    addButton.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	addButton.setBackground(Color.WHITE);
	    	    addButton.setForeground(Color.BLACK);
	        }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	addButton.setBackground(Color.BLACK);
	    	    addButton.setForeground(Color.WHITE);
	        }
	    });
	    
	    JButton removeButton = new JButton("Remove Element");
	    removeButton.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
	    removeButton.setBackground(Color.BLACK);
	    removeButton.setForeground(Color.WHITE);
	    
	    removeButton.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	        	removeButton.setBackground(Color.WHITE);
	        	removeButton.setForeground(Color.BLACK);
	        }
	        public void mouseExited(java.awt.event.MouseEvent evt) {
	        	removeButton.setBackground(Color.BLACK);
	        	removeButton.setForeground(Color.WHITE);
	        }
	    });
	    
	    addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addButton.setVisible(false);
				removeButton.setVisible(false);
				JTextField text = new JTextField(20);
				buttonPanel.add(text);
				buttonPanel.setBackground(Color.BLACK);
				text.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String textValue = text.getText();
						
						if(model.getElementAt(0).equals("List is Empty")) {
							model.remove(0);
							model.add(0, textValue);
						}else {
							model.addElement(textValue);
						}
						
						text.setText("");
						text.setVisible(false);
						buttonPanel.remove(text);
						addButton.setVisible(true);
						removeButton.setVisible(true);
						buttonPanel.setBackground(Color.WHITE);
					}
				});
			}
	    });
	    
	    removeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.remove(list.getSelectedIndex());
				if(model.getSize() == 0) {
					model.addElement("List is Empty");
				}
			}
	    });	  
	    
	    add(titlePanel, BorderLayout.PAGE_START);
	    titlePanel.add(title);
	    add(pane);
	    buttonPanel.add(addButton);
	    buttonPanel.add(removeButton);
	    add(buttonPanel, BorderLayout.PAGE_END);
	}
	public static void main(String[] args) {
		//Creating the JFrame window
		JFrame frame = new JFrame("To-do List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new Todo());
		frame.setResizable(false);
		frame.setSize(310, 400);
		frame.setVisible(true);
	}
}

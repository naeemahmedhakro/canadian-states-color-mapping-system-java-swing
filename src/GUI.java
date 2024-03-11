package canadian_states_color_mapping_system;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI{
	
	int count = 0;
	private JFrame mainFrame, GraphFrame;
	private JPanel mainPanel, panel, panel2;
	private JLabel inputCountLabel;
	private JCheckBox checkBox1,checkBox2,checkBox3,checkBox4;
	private JButton proceed;
	private List<String> colors = new ArrayList<String>();
	
	public GUI(){
		
		//setting components
		mainFrame = new JFrame();
		panel = new JPanel();
		
		// Create checkboxes
        checkBox1 = new JCheckBox("Red");
        checkBox2 = new JCheckBox("Yellow");
        checkBox3 = new JCheckBox("Green");
        checkBox4 = new JCheckBox("Blue");
		
		
		inputCountLabel = new JLabel("color(s) entered: 0");
		checkBox1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBox1.isSelected()){
					count++;
					inputCountLabel.setText("color(s) entered: "+count);
					colors.add(checkBox1.getText());
				}
				else{
					count--;
					inputCountLabel.setText("color(s) entered: "+count);
					colors.remove(checkBox1.getText());
				}
			}
			
		});
		
		checkBox2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBox2.isSelected()){
					count++;
					inputCountLabel.setText("color(s) entered: "+count);
					colors.add(checkBox2.getText());
				}
				else{
					count--;
					inputCountLabel.setText("color(s) entered: "+count);
					colors.remove(checkBox2.getText());
				}
			}
			
		});
		
		checkBox3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBox3.isSelected()){
					count++;
					inputCountLabel.setText("color(s) entered: "+count);
					colors.add(checkBox3.getText());
				}
				else{
					count--;
					inputCountLabel.setText("color(s) entered: "+count);
					colors.remove(checkBox3.getText());
				}
			}
			
		});
		
		checkBox4.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkBox4.isSelected() ){
					count++;
					inputCountLabel.setText("color(s) entered: "+count);
					colors.add(checkBox4.getText());
				}
				else{
					count--;
					inputCountLabel.setText("color(s) entered: "+count);
					colors.remove(checkBox4.getText());
				}
			}
			
		});
		

	    proceed = new JButton("Go for coloring");
	
		panel.setLayout(new GridLayout(0,4));
		panel.setSize(300,200);
		panel.setBorder(BorderFactory.createTitledBorder("Choose Colors"));
	
	
		panel.add(checkBox1);
		panel.add(checkBox2);
		panel.add(checkBox3);
		panel.add(checkBox4);
		panel.add(inputCountLabel);
		
		panel2 = new JPanel(); 
		panel2.setLayout(new GridLayout(0,1));
		panel2.setSize(100,100);
		panel2.add(proceed);
		
		
		mainPanel = new JPanel(); 
	    mainPanel.add(panel);
	    mainPanel.add(panel2);
	    
		proceed.addActionListener(new ActionListener(){
			@Override
            public void actionPerformed(ActionEvent e) {
				if(count>=3){
					BFSGraphCSP graph = new BFSGraphCSP(colors,count);
					
					mainFrame.setVisible(false);
					GraphFrame = new JFrame("CSP Canada Map Coloring Agent");
					GraphFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		            GraphPanel graphPanel = new GraphPanel(graph.visitedQueue);
		            GraphFrame.add(graphPanel);

		            GraphFrame.setSize(800, 600);
		            GraphFrame.setLocationRelativeTo(null);
		            GraphFrame.setVisible(true);
				}
				else{
					JOptionPane.showMessageDialog(mainFrame, "Select Min = 3 and Max = 4 Colors", "Alert", 1);
				}
            }
		});
		
		mainFrame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("CSP Canada Map Coloring Agent");
		mainFrame.setSize(460, 200);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		
	}

	public static void main(String[] args) {
		new GUI();
	}

}

package PartIV;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RollDice extends JFrame {
	private final int rows = 5;
	private final int cols = 5;
	private final int oX = 0;
	private final int oY = 55;
	private final int sideLength = 60;
    
	public class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
		
	}
	
	public RollDice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.LIGHT_GRAY);
		setupPanels();
		setSize(500,700);
		setVisible(true);
    }
    
	public void setupPanels() {
		ActionListener buttonListener = new ButtonListener();
		
        JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 1));
		
        JPanel diePanel = new JPanel();
		diePanel.setLayout(new GridLayout(1, 2));
        ImagePanel imagePanel1 = new ImagePanel("die1.png", true);		
        diePanel.add(imagePanel1);
        ImagePanel imagePanel2 = new ImagePanel("die1.png", true);
		diePanel.add(imagePanel2);
		mainPanel.add(diePanel);
		
		ImagePanel gridPanel = new ImagePanel("", false);
		gridPanel.setLayout(new GridLayout(1, 1));
		gridPanel.setBackground(Color.WHITE);
		mainPanel.add(gridPanel);
		
		JPanel buttonPanel = new JPanel();
		JButton button = new JButton("roll dice");
		button.addActionListener(buttonListener);
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		buttonPanel.add(button);
		mainPanel.add(buttonPanel);
		
		this.add(mainPanel);
	}

    public static void main(String[] args) {
            RollDice rollDice = new RollDice();
    }
}


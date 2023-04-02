package PartIV;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private static final long serialVersionUID = 1L;

	private final String[] DIE_ARRAY = {
			"", "die1.png", "die2.png", "die3.png",
			"die4.png", "die5.png", "die6.png"};		//1-indexing for convenience

    private Image img;
    private boolean hasDie;
	private int die;
	private static int result;

	private final int rows = 5;
	private final int cols = 5;
	private final int oX = 175;
	private final int oY = 50;
	private final int sideLength = 30;
	private static int x = 167;
	private static int y = 73;
	
    public ImagePanel(String img, boolean hasDie) {
            this(new ImageIcon(img).getImage(), hasDie);
    }
    
    public ImagePanel(Image img, boolean hasDie) {
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null) * 10);
            setPreferredSize(size);
            setMinimumSize(size);
    		setMaximumSize(size);
    		setSize(size);
            setLayout(null);
            this.hasDie = hasDie;
    }

    public void paintComponent(Graphics g) {
    	super.paintComponent(g);

    	if(hasDie) {
			g.drawImage(img, 50, 0, null);
			die = (int)(Math.random()*6) + 1;
			img = new ImageIcon(DIE_ARRAY[die]).getImage();
			result += die;
		}
    	else {
    		for(int i = 0; i < rows + 1; i++) {
    			g.setColor(new Color(0, 0 , 255));
    			g.drawLine(oX, oY + (i * sideLength), oX + (cols * sideLength), oY + (i * sideLength));
    		}
    		for(int i = 0; i < cols + 1; i++) {
    			g.drawLine(oX + (i * sideLength), oY, oX + (i * sideLength), oY + (rows * sideLength));
    		}
    		if(result >= 24) {
    			g.setColor(new Color(0, 0 , 0));
    			g.fillOval(187 + (sideLength * (cols - 1)), 63 + (sideLength * (rows - 1)), 5, 5);
    			g.drawString("Finished!", oX + (int)(1.5 * sideLength), oY/2);
    		}
    		else {
    			x = 187 + ((result%cols) * sideLength) % (cols * sideLength);
    			y = 63 + (result/cols) * sideLength;
    			g.setColor(new Color(0, 0 , 0));
    			g.fillOval(x, y, 5, 5);
    			g.drawString("Result: " + result, 215, 215);
    		}
    	}	
    }
}


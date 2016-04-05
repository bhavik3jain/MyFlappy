/*
 *Add:
 *high score box
 *
 */

import java.awt.*;
import java.awt.geom.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;
import java.util.Hashtable;
import java.util.Arrays;
import java.io.*;

public class Game_BSJ extends Vars 
{
	public static void main(String[] args)
	{
		GameDesign gD = new GameDesign();
		bottom = new JPanel();
		top = new JPanel();
		frame = new JFrame();
		frame.setTitle("My Flappy Bird");
		frame.setSize(400, 600);
	//	frame.setResizable(false);
 		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		b1 = new JButton("Start");
 		b2 = new JButton("Pause");
 		b3 = new JButton("ReStart");
 		b4 = new JButton("High Scores");
 		slider = new JSlider();
 		labelTable = new Hashtable();
 		labelTable.put(0, new JLabel("Dawn"));
 		labelTable.put(25, new JLabel("Morning"));
 		labelTable.put(50, new JLabel("Noon"));
 		labelTable.put(75, new JLabel("Dusk"));
 		labelTable.put(100, new JLabel("Night"));
 		slider.setLabelTable(labelTable);
 		slider.setMajorTickSpacing(25);
 		slider.setMinorTickSpacing(5);
 		slider.setPaintTicks(true);
 		slider.setPaintLabels(true);
 		slider.setPaintLabels(true);
 		b1.addActionListener(new ButtonListener1());
 		b2.addActionListener(new ButtonListener2());
 		b3.addActionListener(new ButtonListener3());
 		b4.addActionListener(new ButtonListener4());
 		slider.addChangeListener(new slider1());
 		frame.getContentPane().setLayout(new BorderLayout());
 		bottom.add(b1);
 		bottom.add(b2);
 		bottom.add(b3);
 		bottom.add(b4);
 		top.add(slider);
 		frame.add(bottom, BorderLayout.SOUTH);
 		frame.add(top, BorderLayout.NORTH);
		frame.add(gD);
		frame.setVisible(true);
	}
}

class Vars extends JComponent
{
	public static final int ballChangerClick = -30;
	public static final int ballChangerAuto = 10;
	public static final int rodShift = 10;
	public static final int BARLENGTH = 75;
	public static final int BARCOLORRED = 0;
	public static final int BARCOLORGREEN = 100;
	public static final int BARCOLORBLUE = 0;
	
	public static Graphics2D g2;
	public static Shape oval;
	public static Shape moon;
	public static Shape moonCover;
	public static Rectangle2D background;
	public static Rectangle2D ground;
	public static Rectangle2D rod1T;
	public static Rectangle2D rod1B;
	public static Rectangle2D rod2T;
	public static Rectangle2D rod2B;
	public static Rectangle2D rod3T;
	public static Rectangle2D rod3B;
	public static Rectangle2D rod4T;
	public static Rectangle2D rod4B;
	public static Rectangle2D rod5T;
	public static Rectangle2D rod5B;
	public static Rectangle2D score1;
	public static Rectangle2D score2;
	public static Rectangle2D score3;
	public static Rectangle2D score4;
	public static Rectangle2D score5;
	public static JFrame frame;
	public static Hashtable labelTable;
	public static JSlider slider;
	public static JButton b1;
	public static JButton b2;
	public static JButton b3;
	public static JButton b4;
	public static JPanel bottom;
	public static JPanel top;
	
	
	public static Timer clock; 
	public static int[] arrX;
	public static int[] arrY;
	
	public static final String FILE1 = "scores.txt";
	public static File f1;
	public static PrintWriter output;
	public static Scanner input1 = null;
	public static int[] scores;
	
	private static int high;
	private static int s1;
	private static long start;
	private static int elapsedTime;
	private static boolean tF;
	private static boolean bLoc;
	private static boolean spark;
	private static boolean highScores;
	private static int ballLoc = 200;
	
	private static int bgColorRed = 175;
	private static int bgColorGreen = 238;
	private static int bgColorBlue = 238;
	
	private static int stColR = bgColorRed;
	private static int stColG = bgColorGreen;
	private static int stColB = bgColorBlue;
	
	private static int sparkR = stColR;
	private static int sparkG = stColG;
	private static int sparkB = stColB;
		
	private static int rod1TX = 450; 
	private static int rod1TY = 0; 
	private static int rod1BX = 450;
	private static int rod1BY = 250;
	private static int rod1SX = 450; 
	private static int rod1SY = 150;

	private static int rod2TX = 600; 
	private static int rod2TY = 0; 
	private static int rod2BX = 600;
	private static int rod2BY = 325;
	private static int rod2SX = 600; 
	private static int rod2SY = 225;
	
    private static int rod3TX = 750; 
    private static int rod3TY = 0; 
    private static int rod3BX = 750;
    private static int rod3BY = 250;
    private static int rod3SX = 750; 
    private static int rod3SY = 150;
    
    private static int rod4TX = 900; 
    private static int rod4TY = 0; 
    private static int rod4BX = 900;
    private static int rod4BY = 175;
    private static int rod4SX = 900; 
    private static int rod4SY = 75;

    private static int rod5TX = 1050; 
    private static int rod5TY = 0; 
    private static int rod5BX = 1050;
    private static int rod5BY = 217;
    private static int rod5SX = 1050;
    private static int rod5SY = 117;
    
    public int getHigh()
	{
		return high;
	}
	
	public void setHigh(int num)
	{
		high = num;
	}
    
    public int getScore()
    {
    	return s1;
    }
    
    public void setScore(int num)
    {
    	s1 = num;
    }
    
    public int getElapsedTime()
	{
		return elapsedTime;
	}
	
	public void setElapsedTime(int num)
	{
		elapsedTime = num;
	}
    
	public long getStart()
	{
		return start;
	}
	
	public void setStart(long num)
	{
		start = num;
	}   
   
 	public boolean getHighScores()
 	{
 		return highScores;
 	}
 	
 	public void setHighScores(boolean bool)
 	{
 		highScores = bool;
 	}  
   
   	public boolean getTF()
	{
		return tF;
	}
	
	public void setTF(boolean bool)
	{
		tF = bool;
	}
	
	public boolean getBLoc()
	{
		return bLoc;
	}
	
	public void setBLoc(boolean bool)
	{
		bLoc = bool;
	}
	
	public boolean getSpark()
	{
		return spark;
	}
	
	public void setSpark(boolean bool)
	{
		spark = bool;
	}
    
    public int getBallLoc()
	{
		return ballLoc;
	}
	
	public void setBallLoc(int num)
	{
		ballLoc = num;
	}
    
    public int getBgColorRed()
	{
		return bgColorRed;
	}
	
	public void setBgColorRed(int num)
	{
		bgColorRed = num;
	}
	
	public int getBgColorGreen()
	{
		return bgColorGreen;
	}
	
	public void setBgColorGreen(int num)
	{
		bgColorGreen = num;
	}
	
	public int getBgColorBlue()
	{
		return bgColorBlue;
	}
	
	public void setBgColorBlue(int num)
	{
		bgColorBlue = num;
	}
    
    public int getStColR()
	{
		return stColR;
	}
	
	public void setStColR(int num)
	{
		stColR = num;
	}
	
	public int getStColG()
	{
		return stColG;
	}
	
	public void setStColG(int num)
	{
		stColG = num;
	}
	
	public int getStColB()
	{
		return stColB;
	}
	
	public void setStColB(int num)
	{
		stColB = num;
	}
    
    public int getSparkR()
	{
		return sparkR;
	}
	
	public void setSparkR(int num)
	{
		sparkR = num;
	}
	
	public int getSparkG()
	{
		return sparkG;
	}
	
	public void setSparkG(int num)
	{
		sparkG = num;
	}
	
	public int getSparkB()
	{
		return sparkB;
	}
	
	public void setSparkB(int num)
	{
		sparkB = num;
	}
    
    public int getRod1TX()
    {
    	return rod1TX;
    }
    
    public void setRod1TX(int num)
    {
    	rod1TX = num;
    }
    
    public int getRod1TY()
    {
    	return rod1TY;
    }
    
    public void setRod1TY(int num)
    {
    	rod1TY = num;
    }
    
    public int getRod1BX()
    {
    	return rod1BX;
    }
    
    public void setRod1BX(int num)
    {
    	rod1BX = num;
    }
    
    public int getRod1BY()
    {
    	return rod1BY;
    }
    
    public void setRod1BY(int num)
    {
    	rod1BY = num;
    }
    
    public int getRod1SX()
    {
    	return rod1SX;
    }
    
    public void setRod1SX(int num)
    {
    	rod1SX = num;
    }
    
    public int getRod1SY()
    {
    	return rod1SY;
    }
    
    public void setRod1SY(int num)
    {
    	rod1SY = num;
    }
	
	public int getRod2TX()
    {
    	return rod2TX;
    }
   
    public void setRod2TX(int num)
    {
    	rod2TX = num;
    }
   
    public int getRod2TY()
    {
    	return rod2TY;
    }
  
    public void setRod2TY(int num)
    {
    	rod2TY = num;
    }
  
    public int getRod2BX()
    {
    	return rod2BX;
    }
  
    public void setRod2BX(int num)
    {
    	rod2BX = num;
    }
 
    public int getRod2BY()
    {
    	return rod2BY;
    }
 
    public void setRod2BY(int num)
    {
    	rod2BY = num;
    }

    public int getRod2SX()
    {
    	return rod2SX;
    }
 
    public void setRod2SX(int num)
    {
    	rod2SX = num;
    }
 
    public int getRod2SY()
    {
    	return rod2SY;
    }
  
    public void setRod2SY(int num)
    {
    	rod2SY = num;
    }
  
    public int getRod3TX()
    {
    	return rod3TX;
    }
  
    public void setRod3TX(int num)
    {
    	rod3TX = num;
    }
  
    public int getRod3TY()
    {
    	return rod3TY;
    }
  
    public void setRod3TY(int num)
    {
    	rod3TY = num;
    }
  
    public int getRod3BX()
    {
    	return rod3BX;
    }
 
    public void setRod3BX(int num)
    {
    	rod3BX = num;
    }
 
    public int getRod3BY()
    {
    	return rod3BY;
    }
 
    public void setRod3BY(int num)
    {
    	rod3BY = num;
    }
  
    public int getRod3SX()
    {
    	return rod3SX;
    }
  
    public void setRod3SX(int num)
    {
    	rod3SX = num;
    }
  
    public int getRod3SY()
    {
    	return rod3SY;
    }
  
    public void setRod3SY(int num)
    {
    	rod3SY = num;
    }
  
    public int getRod4TX()
    {
    	return rod4TX;
    }
  
    public void setRod4TX(int num)
    {
    	rod4TX = num;
    }
  
    public int getRod4TY()
    {
    	return rod4TY;
    }
  
    public void setRod4TY(int num)
    {
    	rod4TY = num;
    }
  
    public int getRod4BX()
    {
    	return rod4BX;
    }
  
    public void setRod4BX(int num)
    {
    	rod4BX = num;
    }
  
    public int getRod4BY()
    {
    	return rod4BY;
    }
   
    public void setRod4BY(int num)
    {
    	rod4BY = num;
    }
   
    public int getRod4SX()
    {
    	return rod4SX;
    }
  
    public void setRod4SX(int num)
    {
    	rod4SX = num;
    }
  
    public int getRod4SY()
    {
    	return rod4SY;
    }
  
    public void setRod4SY(int num)
    {
    	rod4SY = num;
    }
  
    public int getRod5TX()
    {
    	return rod5TX;
    }
  
    public void setRod5TX(int num)
    {
    	rod5TX = num;
    }
  
    public int getRod5TY()
    {
    	return rod5TY;
    }
  
    public void setRod5TY(int num)
    {
    	rod5TY = num;
    }
    
    public int getRod5BX()
    {
    	return rod5BX;
    }
    
    public void setRod5BX(int num)
    {
    	rod5BX = num;
    }
    
    public int getRod5BY()
    {
    	return rod5BY;
    }
    
    public void setRod5BY(int num)
    {
    	rod5BY = num;
    }
    
    public int getRod5SX()
    {
    	return rod5SX;
    }
    
    public void setRod5SX(int num)
    {
    	rod5SX = num;
    }
    
    public int getRod5SY()
    {
    	return rod5SY;
    }
    
    public void setRod5SY(int num)
    {
    	rod5SY = num;
    }
}

class ButtonListener1 extends Vars implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		clock.start();
		setStart(System.currentTimeMillis());
	}
}

class ButtonListener2 extends Vars implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		setTF(!getTF());
		if(getTF())
		{
			clock.stop();
		}
		else
		{
			clock.start();
		}
	}
}

class ButtonListener3 extends Vars implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		setBLoc(true);
		clock.start();
	}
}

class ButtonListener4 extends Vars implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		JOptionPane.showMessageDialog(frame, "1. : " + scores[2] + "\n" +
											 "2. : " + scores[1] + "\n" +
											 "3. : " + scores[0], "High Scores!", JOptionPane.PLAIN_MESSAGE);
	}
}

class slider1 extends Vars implements ChangeListener
{
	public void stateChanged(ChangeEvent e)
	{
		JSlider source = (JSlider)e.getSource();
		if(source.getValueIsAdjusting())
		{
			if(source.getValue() >= 0 && source.getValue() < 25)
			{
				setStColR(255);
				setStColG(255);
				setStColB(153);
				setBgColorRed(3);
				setBgColorGreen(13);
				setBgColorBlue(79);
			}
			else if(source.getValue() >= 25 && source.getValue() < 50)
			{
				setStColR(145);
				setStColG(195);
				setStColB(220);
				setBgColorRed(145);
				setBgColorGreen(195);
				setBgColorBlue(220);
			}
			else if(source.getValue() >= 50 && source.getValue() < 75)
			{
				setStColR(175);
				setStColG(238);
				setStColB(238);
				setBgColorRed(175);
				setBgColorGreen(238);
				setBgColorBlue(238);
			}
			else if(source.getValue() >= 75 && source.getValue() <= 99)
			{
				setStColR(255);
				setStColG(255);
				setStColB(102);
				setBgColorRed(70);
				setBgColorGreen(83);
				setBgColorBlue(111);
			}
			else if(source.getValue() == 100)
			{
				setStColR(255);
				setStColG(255);
				setStColB(0);
				setBgColorRed(0);
				setBgColorGreen(0);
				setBgColorBlue(0);
			}
		}
	}
}

class GameDesign extends Vars implements ActionListener, MouseListener, MouseMotionListener
{
	public GameDesign()
	{
		clock = new Timer(85, this);
		setBLoc(false);
		addMouseListener(this);
		addMouseMotionListener(this);
		setTF(false);	
		arrX = new int[50];
		arrY = new int[50];
		scores = new int[3];
		fillArr();
	}
	
	public void fillArr()
	{
		for(int i = 0; i < arrX.length; i++)
		{
			arrX[i] = (int)(Math.random() * 390);
		}
		
		for(int i = 0; i < arrY.length; i++)
		{
			arrY[i] = (int)(Math.random() * 390);
		}
	}
	
	public void makeStar(int x, int y)
	{
		Rectangle2D stX = new Rectangle2D.Double(x, y, 3, 7);
		Rectangle2D stY = new Rectangle2D.Double(x - 2, y + 2, 7, 3);
		g2.setColor(new Color(getStColR(), getStColG(), getStColB()));
		g2.fill(stX);
		g2.fill(stY);
		Rectangle2D sparkle1 = new Rectangle2D.Double(x, y, 3, 5);
		g2.setColor(new Color(getSparkR(), getSparkG(), getSparkB()));
		g2.fill(sparkle1);
	}
	
	public void paintComponent(Graphics g)
	{
		g2 = (Graphics2D) g;
		
		background = new Rectangle2D.Double(0, 0, 400, 500);
		g2.setColor(new Color(getBgColorRed(), getBgColorGreen(), getBgColorBlue()));
		g2.fill(background);
		
		ground = new Rectangle2D.Double(0, 400, 400, 100);
		g2.setColor(new Color(184, 115, 51));
		g2.fill(ground);
		//-------------------------------------------------------------------------------
		score1 = new Rectangle2D.Double(getRod1SX(), getRod1SY(), BARLENGTH, 100);
		g2.setColor(new Color(getBgColorRed(), getBgColorGreen(), getBgColorBlue()));
		g2.fill(score1);
		
		score2 = new Rectangle2D.Double(getRod2SX(), getRod2SY(), BARLENGTH, 100);
		g2.setColor(new Color(getBgColorRed(), getBgColorGreen(), getBgColorBlue()));
		g2.fill(score2);
		
		score3 = new Rectangle2D.Double(getRod3SX(), getRod3SY(), BARLENGTH, 100);
		g2.setColor(new Color(getBgColorRed(), getBgColorGreen(), getBgColorBlue()));
		g2.fill(score3);

		score4 = new Rectangle2D.Double(getRod4SX(), getRod4SY(), BARLENGTH, 100);
		g2.setColor(new Color(getBgColorRed(), getBgColorGreen(), getBgColorBlue()));
		g2.fill(score4);
		
		score5 = new Rectangle2D.Double(getRod5SX(), getRod5SY(), BARLENGTH, 100);
		g2.setColor(new Color(getBgColorRed(), getBgColorGreen(), getBgColorBlue()));
		g2.fill(score5);
		//-------------------------------------------------------------------------------
		moon = new Ellipse2D.Double(325, 0, 100, 100);
		g2.setColor(new Color(getStColR(), getStColG(), getStColB()));
		g2.fill(moon);
		
		moonCover = new Ellipse2D.Double(345, 0, 100, 100);
		g2.setColor(new Color(getBgColorRed(), getBgColorGreen(), getBgColorBlue()));
		g2.fill(moonCover);
		//-------------------------------------------------------------------------------
		makeStar(arrX[0], arrY[0]);
		makeStar(arrX[1], arrY[1]);
		makeStar(arrX[2], arrY[2]);
		makeStar(arrX[3], arrY[3]);
		makeStar(arrX[4], arrY[4]);
		makeStar(arrX[5], arrY[5]);
		makeStar(arrX[6], arrY[6]);
		makeStar(arrX[7], arrY[7]);
		makeStar(arrX[8], arrY[8]);
		makeStar(arrX[9], arrY[9]);
		makeStar(arrX[10], arrY[10]);
		makeStar(arrX[11], arrY[11]);
		makeStar(arrX[12], arrY[12]);
		makeStar(arrX[13], arrY[13]);
		makeStar(arrX[14], arrY[14]);
		makeStar(arrX[15], arrY[15]);
		makeStar(arrX[16], arrY[16]);
		makeStar(arrX[17], arrY[17]);
		makeStar(arrX[18], arrY[18]);
		makeStar(arrX[19], arrY[19]);
		makeStar(arrX[20], arrY[20]);
		makeStar(arrX[21], arrY[21]);
		makeStar(arrX[22], arrY[22]);
		makeStar(arrX[23], arrY[23]);
		makeStar(arrX[24], arrY[24]);
		makeStar(arrX[25], arrY[25]);
		makeStar(arrX[26], arrY[26]);
		makeStar(arrX[27], arrY[27]);
		makeStar(arrX[28], arrY[28]);
		makeStar(arrX[29], arrY[29]);
		makeStar(arrX[30], arrY[30]);
		makeStar(arrX[31], arrY[31]);
		makeStar(arrX[32], arrY[32]);
		makeStar(arrX[33], arrY[33]);
		makeStar(arrX[34], arrY[34]);
		makeStar(arrX[35], arrY[35]);
		makeStar(arrX[36], arrY[36]);
		makeStar(arrX[37], arrY[37]);
		makeStar(arrX[38], arrY[38]);
		makeStar(arrX[39], arrY[39]);
		makeStar(arrX[40], arrY[40]);
		makeStar(arrX[41], arrY[41]);
		makeStar(arrX[42], arrY[42]);
		makeStar(arrX[43], arrY[43]);
		makeStar(arrX[44], arrY[44]);
		makeStar(arrX[45], arrY[45]);
		makeStar(arrX[46], arrY[46]);
		makeStar(arrX[47], arrY[47]);
		makeStar(arrX[48], arrY[48]);
		makeStar(arrX[49], arrY[49]);
		//-------------------------------------------------------------------------------		
		rod1T = new Rectangle2D.Double(getRod1TX(), getRod1TY(), BARLENGTH, 150);
		g2.setColor(new Color(BARCOLORRED, BARCOLORGREEN, BARCOLORBLUE));
		g2.fill(rod1T);
		
		rod1B = new Rectangle2D.Double(getRod1BX(), getRod1BY(), BARLENGTH, 150);
		g2.setColor(new Color(BARCOLORRED, BARCOLORGREEN, BARCOLORBLUE));
		g2.fill(rod1B);
		//-------------------------------------------------------------------------------		
		rod2T = new Rectangle2D.Double(getRod2TX(), getRod2TY(), BARLENGTH, 225);
		g2.setColor(new Color(BARCOLORRED, BARCOLORGREEN, BARCOLORBLUE));
		g2.fill(rod2T);
		
		rod2B = new Rectangle2D.Double(getRod2BX(), getRod2BY(), BARLENGTH, 75);
		g2.setColor(new Color(BARCOLORRED, BARCOLORGREEN, BARCOLORBLUE));
		g2.fill(rod2B);
		//-------------------------------------------------------------------------------
		rod3T = new Rectangle2D.Double(getRod3TX(), getRod3TY(), BARLENGTH, 150);
		g2.setColor(new Color(BARCOLORRED, BARCOLORGREEN, BARCOLORBLUE));
		g2.fill(rod3T);
		
		rod3B = new Rectangle2D.Double(getRod3BX(), getRod3BY(), BARLENGTH, 150);
		g2.setColor(new Color(BARCOLORRED, BARCOLORGREEN, BARCOLORBLUE));
		g2.fill(rod3B);
		//-------------------------------------------------------------------------------
		rod4T = new Rectangle2D.Double(getRod4TX(), getRod4TY(), BARLENGTH, 75);
		g2.setColor(new Color(BARCOLORRED, BARCOLORGREEN, BARCOLORBLUE));
		g2.fill(rod4T);
		
		rod4B = new Rectangle2D.Double(getRod4BX(), getRod4BY(), BARLENGTH, 225);
		g2.setColor(new Color(BARCOLORRED, BARCOLORGREEN, BARCOLORBLUE));
		g2.fill(rod4B);
		//-------------------------------------------------------------------------------
		rod5T = new Rectangle2D.Double(getRod5TX(), getRod5TY(), BARLENGTH, 117);
		g2.setColor(new Color(BARCOLORRED, BARCOLORGREEN, BARCOLORBLUE));
		g2.fill(rod5T);
		
		rod5B = new Rectangle2D.Double(getRod5BX(), getRod5BY(), BARLENGTH, 183);
		g2.setColor(new Color(BARCOLORRED, BARCOLORGREEN, BARCOLORBLUE));
		g2.fill(rod5B);
		//-------------------------------------------------------------------------------		
		oval = new Ellipse2D.Double(40, getBallLoc(), 25, 25);
		g2.setColor(new Color(255, 0, 0));
		g2.fill(oval);
		//-------------------------------------------------------------------------------
		g2.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g2.setColor(Color.RED);
	 	g2.drawString("Score: " + getScore(), 200, 50);
	 	g2.drawString("High: " + getHigh(), 200, 75);
 	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(getBgColorRed() == 0 && getBgColorGreen() == 0 && getBgColorBlue() == 0)
		{
			setSpark(!getSpark());
			
			if(getSpark() == true)
			{
				setSparkR(255);
				setSparkG(255);
				setSparkB(255);
			}
			else
			{
				setSparkR(getStColR());
				setSparkG(getStColG());
				setSparkB(getStColB());
			}
		}
 		if(oval.intersects(rod1T) || oval.intersects(rod1B) || 
 		   oval.intersects(rod2T) || oval.intersects(rod2B) || 
 		   oval.intersects(rod3T) || oval.intersects(rod3B) ||
 		   oval.intersects(rod4T) || oval.intersects(rod4B) ||
 		   oval.intersects(rod5T) || oval.intersects(rod5B))
 		{
 			setBallLoc(370);
 			repaint();
 		}
 		setRod1TX(getRod1TX() - rodShift);
 		setRod1BX(getRod1BX() - rodShift);
 		setRod1SX(getRod1SX() - rodShift);
 		if(getRod1TX() <= -75 && getRod1BX() <= -75 && getRod1SX() <= -75)
 		{
 			setRod1TX(675);
 			setRod1BX(675);
 			setRod1SX(675);
 		}
 		setRod2TX(getRod2TX() - rodShift);
 		setRod2BX(getRod2BX() - rodShift);
 		setRod2SX(getRod2SX() - rodShift);
 		if(getRod2TX() <= -75 && getRod2BX() <= -75 && getRod2SX() <= -75)
 		{
 			setRod2TX(675);
 			setRod2BX(675);
 			setRod2SX(675);
 		}
 		setRod3TX(getRod3TX() - rodShift);
 		setRod3BX(getRod3BX() - rodShift);
 		setRod3SX(getRod3SX() - rodShift);
 		if(getRod3TX() <= -75 && getRod3BX() <= -75 && getRod3SX() <= -75)
 		{
 			setRod3TX(675);
 			setRod3BX(675);
 			setRod3SX(675);
 		}
 		setRod4TX(getRod4TX() - rodShift);
 		setRod4BX(getRod4BX() - rodShift);
 		setRod4SX(getRod4SX() - rodShift);
 		if(getRod4TX() <= -75 && getRod4BX() <= -75 && getRod4SX() <= -75)
 		{
 			setRod4TX(675);
 			setRod4BX(675);
 			setRod4SX(675);
 		}
 		setRod5TX(getRod5TX() - rodShift);
 		setRod5BX(getRod5BX() - rodShift);
 		setRod5SX(getRod5SX() - rodShift);
 		if(getRod5TX() <= -75 && getRod5BX() <= -75 && getRod5SX() <= -75)
 		{
 			setRod5TX(675);
 			setRod5BX(675);
 			setRod5SX(675);
 		}
 		setElapsedTime((int)(System.currentTimeMillis() - getStart()));
 		setBallLoc(getBallLoc() + ballChangerAuto);
 		setScore((int)(Math.sqrt(getElapsedTime())));
 
 		if(getBLoc() == true)
 		{
 			reset();
 		}
 		setBLoc(false);
 		if(getBallLoc() < 380)
 		{
 			repaint();
 		}
 		else
	 	{
	 		repaint();
	 		clock.stop();
	 	}
 	}
	
	public void mouseClicked(MouseEvent e)
 	{
 		if(e.getX() >= 0 && e.getX() <= 400 && e.getY() >= 0 && e.getY() <= 500)
 		{
 			setBallLoc(getBallLoc() + ballChangerClick);
 		}
 	}
 	
 	public void mousePressed(MouseEvent e)
	{
	
	}
 	
 	public void mouseReleased(MouseEvent e)
 	{
 		
 	}
 	
 	public void mouseDragged(MouseEvent e)
 	{
 		
 	}
 	
 	public void mouseEntered(MouseEvent e)
 	{
 		
 	}
 	
 	public void mouseExited(MouseEvent e)
 	{
 		
 	}
 	
 	public void mouseMoved(MouseEvent e)
 	{
 		
 	}
 	
 	public void reset()
 	{
 		clock.stop();
		setBallLoc(200);
		
		setRod1TX(450);
		setRod1BX(450);
		setRod1TY(0);
		setRod1BY(250);
		setRod1SX(450); 
		setRod1SY(150);
		
		setRod2TX(600);
		setRod2BX(600);
		setRod2TY(0); 
		setRod2BY(325);
		setRod2SX(600);
		setRod2SY(225);
		
    	setRod3TX(750); 
    	setRod3BX(750);
    	setRod3TY(0);
    	setRod3BY(250);
    	setRod3SX(750);
    	setRod3SY(150);
    
    	setRod4TX(900);
    	setRod4BX(900);
    	setRod4TY(0);
    	setRod4BY(175);
    	setRod4SX(900);
    	setRod4SY(75);
   	
 	  	setRod5TX(1050);
   		setRod5BX(1050);
    	setRod5TY(0);
    	setRod5BY(217);
    	setRod5SX(1050);
    	setRod5SY(117);
    	
    	clock.stop();
	 	if(getScore() >= scores[0])
	 	{
	 		scores[0] = getScore();
	 		Arrays.sort(scores);
	 		output.println(scores[2]);
	 		output.println(scores[1]);
	 		output.println(scores[0]);
	 		output.close();
	 	}
	 	else
	 	{
	 		output.println(scores[2]);
	 		output.println(scores[1]);
	 		output.println(scores[0]);
	 		output.close();
	 	}
    	
    	setStart(System.currentTimeMillis());
 	}		
}
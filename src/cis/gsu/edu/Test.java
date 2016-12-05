package cis.gsu.edu;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
	
	ImageIcon myImage = new ImageIcon("image/SplashImage.gif");
	
	public Test(){
		setLayout(new GridLayout(1,4,5,5));
		add(new JLabel(myImage));
	}
	
	public static void main(String[] args) {
		Test frame = new Test();
		frame.setTitle("TestImageIcon");
		frame.setSize(200,200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
}


package cis.gsu.edu;

import javax.swing.*;


public class SplashScreen {
	
	
	public static void main(String[] args) {
		
		JWindow window = new JWindow();
		window.getContentPane().add(new JLabel("",new ImageIcon("/Users/Yasuko/Desktop/SplashImage.gif"),SwingConstants.CENTER));
		window.setBounds(450, 300, 320, 240);
		window.setVisible(true);
		
		try{
			Thread.sleep(5000);	
		}catch(InterruptedException e){}
		window.dispose();
	}

}

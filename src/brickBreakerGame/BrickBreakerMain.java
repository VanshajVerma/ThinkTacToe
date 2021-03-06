package brickBreakerGame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import mainMenu.MainMenuController;

import thinktactoeGame.Minigame;
import javax.swing.JTextArea;

public class BrickBreakerMain implements Minigame{
	
	private static JFrame frame;
	
	public static void main(String[] args) {
		
		frame = new JFrame();	
		
		GamePlay gamePlay = new GamePlay();
		frame.setSize(800, 750);

		frame.setTitle("Brick Breaker");		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton menuButton = new JButton("Menu");
		frame.getContentPane().add(menuButton, BorderLayout.SOUTH);
		
		frame.getContentPane().add(gamePlay);
        frame.setVisible(true);
        
        menuButton.setFocusable(false);
        
        menuButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				MainMenuController.displayMenu(3);
				frame.setVisible(false);
				if(GamePlay.play) {
					GamePlay.pauseGame();
				}
				
			}
		});
        
	
	}
	
	public static void returnToGame() {
//		if(!GamePlay.play) {
//			GamePlay.pauseGame();
//		}
//		GamePlay.play = false;
		
		frame.setVisible(true);
		frame.invalidate();
		frame.validate();
	}
	
	public static void exitFrame() {
		frame.dispose();
	}

	@Override
	public void startGame(char player) {
		frame = new JFrame();	
		
		GamePlay gamePlay = new GamePlay();
		frame.setSize(800, 750);

		frame.setTitle("Brick Breaker");		
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton menuButton = new JButton("Menu");
		frame.getContentPane().add(menuButton, BorderLayout.SOUTH);
		
		frame.getContentPane().add(gamePlay);
        frame.setVisible(true);
        
        menuButton.setFocusable(false);
        
        menuButton.addActionListener(new ActionListener()
	    {
			public void actionPerformed(ActionEvent e) {
				MainMenuController.displayMenu(3);
				frame.setVisible(false);
				if(GamePlay.play) {
					GamePlay.pauseGame();
				}
				
			}
		});
//        return true;
	}

}
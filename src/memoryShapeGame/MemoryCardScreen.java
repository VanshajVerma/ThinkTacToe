package memoryShapeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mainMenu.MainMenuController;

public class MemoryCardScreen {
	
	private static MemoryCardScreen instance;
	
	private MemoryCardController controller;
	
	private JTextField moves;
	private JTextField cardsLeft;
	private JLabel playerTurn;
	private JPanel game;
	private static JFrame frame;
	private JButton menuButton;
	
	private MemoryCardScreen(MemoryCardController gc) {
		this.controller = gc;
	}
	
	public static MemoryCardScreen getInstance(MemoryCardController gc) {
		if (instance == null) {
			instance = new MemoryCardScreen(gc);
		}
		return instance;
	}
	
	private void initialScreen() {
		frame = new JFrame("Memory Card - 2D shapes");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setVisible(true);

        JPanel info = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        
        this.playerTurn = new JLabel();
//        JButton startGame = new JButton("Start Game");
//        JButton displayRule = new JButton("Rule");
//        p1.add(startGame);
//        p1.add(displayRule);
        p1.add(playerTurn);
        
        JLabel gameTitle = new JLabel("Memory Card - 2D shapes");
        p2.add(gameTitle);

//        JPanel rulePanel = new JPanel();
//        rulePanel.setLayout(new BoxLayout(rulePanel, BoxLayout.PAGE_AXIS));
//        JLabel l1 = new JLabel("Rules");
//        l1.setFont(new Font(l1.getFont().getName(), Font.PLAIN, 45));
//        JTextArea t1 = new JTextArea();
//        t1.setBackground(l1.getBackground());
//        t1.setEditable(false);
//        t1.setFont(new Font(l1.getFont().getName(), Font.PLAIN, 20));
//        String rules = " - Click on the card to reveal the shape behind it \n" +
//                       " - Two consecutive cards with the same shape will get eliminated \n" +
//                       " - The game ends when all cards get eliminated \n" +
//                       " - The player wins the game with less moves made than the other player";
//
//        t1.setText(rules);
//        rulePanel.add(l1);
//        rulePanel.add(t1);
        
        JLabel displayMoves = new JLabel("Moves:");
        this.moves = new JTextField("0");
        this.moves.setPreferredSize(new Dimension(40, 30));
        p3.add(displayMoves);
        p3.add(moves);
        
        JLabel displayCardsLeft = new JLabel("Cards Left:");
        this.cardsLeft = new JTextField("16");
        this.cardsLeft.setPreferredSize(new Dimension(40, 30));
        p3.add(displayCardsLeft);
        p3.add(cardsLeft);
        
        info.setLayout(new GridLayout(1,3));
        info.add(p1);
        info.add(p2);
        info.add(p3);
        
        this.game = new JPanel();
        this.game.setLayout(new GridLayout(4,4,2,2));
        Card[] cards = this.controller.initCards();
        for (Card card: cards) {
        	this.game.add(card);
        }
        
        menuButton = new JButton("Menu");
        menuButton.setPreferredSize(new Dimension(50, 50));
        menuButton.addActionListener(new ActionListener()
	    {
		    public void actionPerformed(ActionEvent e) {
		    	System.out.println("ressed");
		    	MainMenuController.displayMenu(2);
		    	frame.setVisible(false);
		    }
	    });

        frame.getContentPane().add(BorderLayout.NORTH, info);
        frame.getContentPane().add(BorderLayout.CENTER, this.game);
        frame.getContentPane().add(BorderLayout.SOUTH, menuButton);
        frame.setVisible(true);
	}
	
	public void showScreen(){
		initialScreen();
	}
	
	public void close() {
		frame.setVisible(false);
		frame.dispose();
	}
	
	public void updateCardsLeft(int left) {
		this.cardsLeft.setText(Integer.toString(left));
	}
	
	public void updateMoves(int moves) {
		this.moves.setText(Integer.toString(moves));
	}
	
	public void updateTurn(String player) {
		this.playerTurn.setText(player);
	}

    public static void returnToGame() {
	    frame.setVisible(true);
	    frame.invalidate();
	    frame.validate();
    }
	
}

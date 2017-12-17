package main;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import main.Main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Frame {

	public JFrame frame;
	public GamePanel gamePanel;

	public Frame() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
		frame.pack();
		
		gamePanel = new GamePanel();
		
		//center game inside of the frame
		gamePanel.setBounds(
				(frame.getWidth() - RefStrings.gameWidth) / 2, 
				((frame.getHeight() - RefStrings.gameHeight) / 2) - 50, 
				RefStrings.gameWidth, 
				RefStrings.gameHeight);
		
		frame.getContentPane().add(gamePanel);
		
		gamePanel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent key) {
				
			}
		});
		
		gamePanel.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent mouse){
				gamePanel.requestFocus();
			}
		});
		
		gamePanel.addMouseMotionListener(new MouseMotionListener() {
			public void mouseDragged(MouseEvent e) {}

			public void mouseMoved(MouseEvent e) {}
		});
	}
		
}

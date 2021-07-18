package ru.fadedfog.tombs.view;

import javax.swing.JFrame;

import ru.fadedfog.tombs.controller.UserKeys;

public class GameView extends JFrame {
	
	public GameView(UserKeys userKeys) {
		setSize(100, 100);
		setVisible(true);
		addKeyListener(userKeys);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}

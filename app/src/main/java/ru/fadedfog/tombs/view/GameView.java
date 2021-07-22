package ru.fadedfog.tombs.view;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import ru.fadedfog.tombs.controller.UserKeys;

public class GameView extends JFrame {
	private JLabel label1;
	private JLabel label2;
	
	public GameView(UserKeys userKeys) {
		setSize(400, 300);
		label1 = new JLabel("");
		label2 = new JLabel("");
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(2, 1));
		container.add(label1);
		container.add(label2);
		
		setVisible(true);
		addKeyListener(userKeys);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void setStartMenu() {
		label1.setText("Start Game [Enter]");
		label2.setText("Exit [Backspace]\n");
	}
	
	public void setPauseMenu() {
		label1.setText("Continue [Esc]");
		label2.setText("Exit [Backspace]\n");
	}
	
	public void setLoseMenu() {
		label1.setText("Restart [Enter]");
		label2.setText("Exit [Backspace]\n");
	}

}

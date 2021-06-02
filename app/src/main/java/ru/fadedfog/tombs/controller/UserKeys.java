package ru.fadedfog.tombs.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.game.GameLoop;
import ru.fadedfog.tombs.view.GameView;

public class UserKeys implements KeyListener {
	private GameLoop gameLoop;
	
	public UserKeys(GameLoop gameLoop) {
		this.gameLoop = gameLoop;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int xVelocity = 1;
		int yStartVelocity = 0;
		
		Point oldPoint = gameLoop.getPointUser();
		Character<MoveBehavior> user = gameLoop.getUser();
		Point newPoint;
		System.out.println("##############");
		switch (e.getKeyCode()) {
			case KeyEvent.VK_D:
				if (!gameLoop.isPause()) {
					newPoint = user.move(xVelocity, yStartVelocity, oldPoint);
					System.out.println(newPoint);
					gameLoop.changePositionUser(oldPoint, newPoint);
				}
				break;
			case KeyEvent.VK_A:
				if (!gameLoop.isPause()) {
					newPoint = user.move(-xVelocity, yStartVelocity, oldPoint);
					System.out.println(newPoint);
					gameLoop.changePositionUser(oldPoint, newPoint);
				}
				break;
			case KeyEvent.VK_ESCAPE:
				System.out.println("IP: " + gameLoop.isPause());
				System.out.println("IA: " + gameLoop.isAlive());
				System.out.println("II: " + gameLoop.isInterrupted());
				if (gameLoop.isPause()) {
					gameLoop.proceed();
					System.out.println(gameLoop.isPause());
				} else {
					gameLoop.pause();
					System.out.println(gameLoop.isPause());
				}
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}

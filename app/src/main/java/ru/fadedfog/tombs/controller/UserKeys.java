package ru.fadedfog.tombs.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ru.fadedfog.tombs.asset.character.Character;
import ru.fadedfog.tombs.asset.character.behavior.move.MoveBehavior;
import ru.fadedfog.tombs.asset.character.user.TreasureHunter;
import ru.fadedfog.tombs.asset.geometry.Point;
import ru.fadedfog.tombs.game.GameLoop;


public class UserKeys implements KeyListener {
	private static final Logger LOG = LogManager.getLogger();
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
		
		Point oldPointUser = gameLoop.getRoom().getPointUser();
		ConcurrentHashMap<Point, Character<MoveBehavior>> characters = gameLoop.getRoom().getCharacters();
		TreasureHunter<MoveBehavior> user = (TreasureHunter<MoveBehavior>) characters.get(oldPointUser);
		LOG.info("##############");
		switch (e.getKeyCode()) {
			case KeyEvent.VK_D:
				move(user, xVelocity, yStartVelocity, oldPointUser);
				break;
			case KeyEvent.VK_A:
				move(user, -xVelocity, yStartVelocity, oldPointUser);
				break;
			case KeyEvent.VK_ESCAPE:
				LOG.info("IP: " + gameLoop.isPause());
				LOG.info("IA: " + gameLoop.isAlive());
				LOG.info("II: " + gameLoop.isInterrupted());
				if (gameLoop.isPause()) {
					gameLoop.proceed();
					LOG.info(gameLoop.isPause());
				} else {
					gameLoop.pause();
					LOG.info(gameLoop.isPause());
				}
				break;
		}
	}
	
	private void move(TreasureHunter<MoveBehavior> user, int xVelocity, int yVelocity, Point oldPointUser) {
		if (!gameLoop.isPause()) {
			Point newPoint = user.move(xVelocity, yVelocity, oldPointUser);
			LOG.info(newPoint);
			gameLoop.changePositionUser(user, oldPointUser, newPoint);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}

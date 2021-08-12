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
import ru.fadedfog.tombs.asset.level.map.room.Room;
import ru.fadedfog.tombs.game.GameLoop;
import ru.fadedfog.tombs.game.StateGame;

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
				LOG.info("State of game: " + gameLoop.getStateGame());
				switch (gameLoop.getStateGame()) {
					case PAUSE:
						gameLoop.setStateGame(StateGame.ON);
						break;
					case ON:
						gameLoop.setStateGame(StateGame.PAUSE);
						break;
				}
				LOG.info(gameLoop.getStateGame());
				break;
			case KeyEvent.VK_BACK_SPACE:
				System.exit(0);
				break;
			case KeyEvent.VK_ENTER:
				switch (gameLoop.getStateGame()) {
					case LOSE:
						Room room = gameLoop.getRoom();
						TreasureHunter<MoveBehavior> treasureHunter = (TreasureHunter<MoveBehavior>) room.getCharacters().get(room.getPointUser());
						treasureHunter.setHearts(2);
						gameLoop.setStateGame(StateGame.ON);
						break;
					case MAIN_MENU:
						gameLoop.setStateGame(StateGame.ON);
						break;
				}
				
				break;
		}
	}
	
	private void move(TreasureHunter<MoveBehavior> user, int xVelocity, int yVelocity, Point oldPointUser) {
		if (gameLoop.getStateGame() != StateGame.PAUSE) {
			Point newPoint = user.move(xVelocity, yVelocity, oldPointUser);
			LOG.info(newPoint);
			gameLoop.changePositionUser(user, oldPointUser, newPoint);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}

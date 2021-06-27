package service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.CellRender;
import view.GameView;
public class GameServiceTest {
private static GameService gameService = new GameService();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsAlive() {
	  CellRender[][] cellRenders = new CellRender[100][100];
		GameView gameView = new GameView();
		gameService.isAlive(cellRenders,50,50);
	}

}

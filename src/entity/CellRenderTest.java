package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CellRenderTest {
	private static CellRender cellRender = new CellRender(10,5,0);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCellRender() {
	 cellRender = new CellRender(10,10,1);
	}

	@Test
	public void testGetIsAlive() {
		cellRender.getIsAlive();
	}

	@Test
	public void testSetIsAlive() {
		cellRender.setIsAlive(0);
	}

	@Test
	public void testSetCircleTime() {
		cellRender.setCircleTime(500);
	}

	@Test
	public void testPaintComponent() {
		cellRender.paintComponent();
	}

}

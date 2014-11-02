/*******************************************************************
 * Copyright (c) 2013 Peng Ren
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    feierqi
 *******************************************************************/
package hanto.studentpren.tournament;

import static hanto.util.HantoPieceType.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import hanto.studentpren.common.Coordinate;
import hanto.tournament.*;
import hanto.util.*;

/**
 * This class contains the unit test for DeltaHantoPlayer.
 * 
 * @author Peng Ren
 * @version Feb 26, 2013
 */
public class DeltaHantoPlayerTest {
	HantoGamePlayer player1;
	HantoGamePlayer player2;
	HantoMoveRecord opponentMove1;
	HantoMoveRecord opponentMove2;
	HantoMoveRecord opponentMove3;
	HantoMoveRecord opponentMove4;
	
	@Before
	public void setUp() {
		player1 = new DeltaHantoPlayer(HantoPlayerColor.BLUE, true);
		player2 = new DeltaHantoPlayer(HantoPlayerColor.RED, false);
		opponentMove1 = new HantoMoveRecord(BUTTERFLY, null, new Coordinate(0, 0));
		opponentMove2 = new HantoMoveRecord(SPARROW, null, new Coordinate(0, 1));
		opponentMove3 = new HantoMoveRecord(CRAB, null, new Coordinate(1, 1));
		opponentMove4 = new HantoMoveRecord(CRAB, null, new Coordinate(0, 2));
	}
	
	@Test
	public void playerMoveFirst(){
		player1.makeMove(null);
		player1.makeMove(opponentMove2);
		player1.makeMove(opponentMove3);
		assertNotNull(player1.makeMove(opponentMove4));
	}
	
	@Test
	public void playerAgainstPlayerWithBlueFirst(){
		// create two of your players (say in variable blue and red.
		HantoGameDirector director = HantoGameDirector.getInstance();
		director.initialize(player1, player2);
		// if you want logging turned on include the next line.
		director.setLogLevel(HantoGameDirector.HantoLogLevel.BASIC);
		// if you want to limit the game to n full moves include the next line.
		director.setMoveLimit(15);
		// now play the game
		director.playGame();        // returns a MoveResult that says who wins or if it is a draw
	}
}

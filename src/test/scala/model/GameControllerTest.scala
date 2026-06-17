package cl.uchile.dcc.citric
package model

import model.units.Player


class GameControllerTest extends munit.FunSuite {
  var controller = new GameController

  test("A controller start with a PreGame State"){
    assert(!controller.state.isChapter)
    assert(!controller.state.isCombat)
    assert(!controller.state.isEndGame)
    assert(!controller.state.isLandingPanel)
    assert(!controller.state.isMoving)
    assert(!controller.state.isPlayerTurn)
    assertEquals(controller.state.isPreGame,true)
    assert(!controller.state.isRecover)
  }
  test("A controller should initiate with a empty list of players"){
    assertEquals(controller.players.isEmpty,true)
  }
  test("A controller should add players properly"){
    val name = "Benja"
    val maxHp = 10
    val ATK = 5
    val DEF = 5
    val EVA = 5
    controller.addPlayerCharacter(name,maxHp,ATK, DEF, EVA)
    assertNotEquals(controller.players.isEmpty,true)
    val name2 = "Matias Toro"
    val maxHp2 = 10
    val ATK2 = 5
    val DEF2 = 5
    val EVA2 = 5
    controller.addPlayerCharacter(name2, maxHp2, ATK2, DEF2, EVA2)
    assertEquals(controller.players.size,2)
  }
  test("A controller should have a board to play"){
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    val player2 = new Player("Player 2", 10, 2, 2, 2)
    val player3 = new Player("Player 3", 10, 2, 2, 2)
    val player4 = new Player("Player 4", 10, 2, 2, 2)
    controller.board(player1,player2,player3,player4)
    //Next Panel is HomePanel from player1, so it should have one player (player1)
    assertEquals(controller.tablero.getPlayers.length,1)
    assertEquals(controller.tablero.getNextPanels(0).getPlayers.size,0)
  }
  test("A controller can roll a dice") {
    assert(controller.rollDice() >= 1 && controller.rollDice() <= 6)
  }
}

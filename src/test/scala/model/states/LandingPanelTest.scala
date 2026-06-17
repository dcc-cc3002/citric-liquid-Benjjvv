package cl.uchile.dcc.citric
package model.states

import model.GameController

import model.units.Player

class LandingPanelTest extends munit.FunSuite {
  var controller = new GameController
  var state = new LandingPanel(controller)
  test("A LandingPanel State should have it identification True") {
    assert(!state.isChapter)
    assert(!state.isCombat)
    assert(!state.isEndGame)
    assertEquals(state.isLandingPanel, true)
    assert(!state.isMoving)
    assert(!state.isPlayerTurn)
    assert(!state.isPreGame)
    assert(!state.isRecover)
  }
  test("A LandingPanel State should pass to a Chapter State") {
    assert(controller.state.isPreGame)
    controller.state = new LandingPanel(controller)
    state.handleEvent()
    assert(controller.state.isChapter)
  }
  test("A LandingPanel State should do a apply in the respect panel"){
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    player1.actuallyHP_(player1.actuallyHP-5)
    val player2 = new Player("Player 2", 10, 2, 2, 2)
    val player3 = new Player("Player 3", 10, 2, 2, 2)
    val player4 = new Player("Player 4", 10, 2, 2, 2)
    controller.board(player1, player2, player3, player4)
    assertEquals(controller.tablero.getPlayers.size,1)
    controller.tablero.apply(controller.tablero.getPlayers(0))
    assertEquals(player1.actuallyHP,6)
  }

}

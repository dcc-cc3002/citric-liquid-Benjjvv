package cl.uchile.dcc.citric
package model.states

import model.GameController

import cl.uchile.dcc.citric.model.units.Player

class RecoverTest extends munit.FunSuite {
  var controller = new GameController
  var state = new Recover(controller)
  test("A Recover State should have it identification True") {
    assert(!state.isChapter)
    assert(!state.isCombat)
    assert(!state.isEndGame)
    assert(!state.isLandingPanel)
    assert(!state.isMoving)
    assert(!state.isPlayerTurn)
    assert(!state.isPreGame)
    assertEquals(state.isRecover, true)
  }
  test("A Recover State should move to Chapter State properly") {
    controller.state = new Chapter(controller)
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    controller.state.actual_player = player1
    controller.state.handleEvent()
    //en chapter entra al else y llega a player turn
    assertEquals(controller.state.isPlayerTurn, true)
  }

}

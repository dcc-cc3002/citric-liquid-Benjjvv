package cl.uchile.dcc.citric
package model.states

import model.GameController

import cl.uchile.dcc.citric.model.units.Player

class PlayerTurnTest extends munit.FunSuite {
  var controller = new GameController
  var state = new PlayerTurn(controller)
  test("A PlayerTurn State should have it identification True") {
    assert(!state.isChapter)
    assert(!state.isCombat)
    assert(!state.isEndGame)
    assert(!state.isLandingPanel)
    assert(!state.isMoving)
    assertEquals(state.isPlayerTurn, true)
    assert(!state.isPreGame)
    assert(!state.isRecover)
  }
  test("A PlayerTurn State should pass to a Moving State") {
    assert(controller.state.isPreGame)
    controller.state = new PlayerTurn(controller)
    controller.state.actual_player = new Player("Player 1", 10, 2, 2, 2)
    state.handleEvent()
    assert(controller.state.isMoving)
  }


}

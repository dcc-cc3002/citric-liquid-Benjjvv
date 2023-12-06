package cl.uchile.dcc.citric
package model.states

import model.GameController

class MovingTest extends munit.FunSuite {
  var controller = new GameController
  var state = new Moving(controller)
  test("A Moving State should have it identification True") {
    assert(!state.isChapter)
    assert(!state.isCombat)
    assert(!state.isEndGame)
    assert(!state.isLandingPanel)
    assertEquals(state.isMoving, true)
    assert(!state.isPlayerTurn)
    assert(!state.isPreGame)
    assert(!state.isRecover)
  }
  test("A Moving State should pass to a Combat State") {
    assert(controller.state.isPreGame)
    controller.state = new Moving(controller)
    state.handleEvent()
    assert(controller.state.isCombat)
  }

}

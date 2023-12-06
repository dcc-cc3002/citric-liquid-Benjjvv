package cl.uchile.dcc.citric
package model.states

import model.GameController

class CombatTest extends munit.FunSuite {
  var controller = new GameController
  var state = new Combat(controller)
  test("A Combat State should have it identification True") {
    assert(!state.isChapter)
    assertEquals(state.isCombat, true)
    assert(!state.isEndGame)
    assert(!state.isLandingPanel)
    assert(!state.isMoving)
    assert(!state.isPlayerTurn)
    assert(!state.isPreGame)
    assert(!state.isRecover)
  }
  test("A Combat State should pass to a LandingPanel State") {
    assert(controller.state.isPreGame)
    controller.state = new Combat(controller)
    state.handleEvent()
    assert(controller.state.isLandingPanel)
  }

}

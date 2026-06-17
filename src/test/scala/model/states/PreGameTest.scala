package cl.uchile.dcc.citric
package model.states

import model.GameController

import cl.uchile.dcc.citric.model.units.Player

class PreGameTest extends munit.FunSuite {
  var controller = new GameController
  var state = new PreGame(controller)
  test("A PreGame State should have it identification True") {
    assert(!state.isChapter)
    assert(!state.isCombat)
    assert(!state.isEndGame)
    assert(!state.isLandingPanel)
    assert(!state.isMoving)
    assert(!state.isPlayerTurn)
    assertEquals(state.isPreGame, true)
    assert(!state.isRecover)
  }
  test("A PreGame State should pass to a Chapter State"){
    controller.addPlayerCharacter("Player 1", 10, 2, 2, 2)
    assert(controller.state.isPreGame)
    state.handleEvent()
    assert(controller.state.isChapter)
  }
}

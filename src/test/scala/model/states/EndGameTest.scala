package cl.uchile.dcc.citric
package model.states

import model.GameController

class EndGameTest extends munit.FunSuite {
  var controller = new GameController
  var state = new EndGame(controller)
  test("A EndGame State should have it identification True") {
    assert(!state.isChapter)
    assert(!state.isCombat)
    assertEquals(state.isEndGame, true)
    assert(!state.isLandingPanel)
    assert(!state.isMoving)
    assert(!state.isPlayerTurn)
    assert(!state.isPreGame)
    assert(!state.isRecover)
  }


}

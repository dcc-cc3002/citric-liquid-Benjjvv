package cl.uchile.dcc.citric
package model.states

import model.GameController

import cl.uchile.dcc.citric.model.norma.Norma6
import cl.uchile.dcc.citric.model.units.Player

class ChapterTest extends munit.FunSuite {
  var controller = new GameController
  var state = new Chapter(controller)
  test("A Chapter State should have it identification True"){
    assertEquals(state.isChapter, true)
    assert(!state.isCombat)
    assert(!state.isEndGame)
    assert(!state.isLandingPanel)
    assert(!state.isMoving)
    assert(!state.isPlayerTurn)
    assert(!state.isPreGame)
    assert(!state.isRecover)
  }
  test("A Chapter State should move to Recover State properly") {
    controller.state = new Chapter(controller)
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    player1.actuallyHP_(0)
    controller.state.actual_player=player1
    controller.state.handleEvent()
    assertEquals(controller.state.isRecover,true)
  }
  test("A Chapter State should move to PLayer Turn State properly") {
    controller.state = new Chapter(controller)
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    controller.state.actual_player=player1
    controller.state.handleEvent()
    assertEquals(controller.state.isPlayerTurn, true)
  }
  test("A Chapter State should move to EndGame State properly") {
    controller.state = new Chapter(controller)
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    controller.state.actual_player = player1
    player1.currentNorma_(new Norma6)
    controller.state.handleEvent()
    assertEquals(controller.state.isPlayerTurn, true)
  }
  test("A Chapter should pass to a new chapter if is needed"){
    controller.state = new Chapter(controller)
    controller.state.turns_count=4
    controller.addPlayerCharacter("Player 1", 10, 2, 2, 2)
    controller.state.actual_player=controller.players(0)
    controller.state.handleEvent()
    assertEquals(controller.players(0).chapter, 1)
  }


}

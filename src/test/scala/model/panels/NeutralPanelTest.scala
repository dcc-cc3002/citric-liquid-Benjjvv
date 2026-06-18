package cl.uchile.dcc.citric
package model.panels

import model.units.Player

class NeutralPanelTest extends munit.FunSuite{
  test("Neutral Panel should add and remove characters correctly") {
    val neutralPanel = new NeutralPanel()
    val player1 = new Player("Player 1", 1, 1, 1, 1)
    val player2 = new Player("Player 2", 2, 2, 2, 2)

    neutralPanel.addCharacter(player1)
    neutralPanel.addCharacter(player2)

    assert(neutralPanel.characters.length == 2)
    assert(neutralPanel.characters.contains(player1))
    assert(neutralPanel.characters.contains(player2))

    neutralPanel.removeCharacter(player1)

    assert(neutralPanel.characters.length == 1)
    assert(!neutralPanel.characters.contains(player1))
    assert(neutralPanel.characters.contains(player2))
  }


}

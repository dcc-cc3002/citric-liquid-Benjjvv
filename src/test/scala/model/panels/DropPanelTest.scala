package cl.uchile.dcc.citric
package model.panels

import model.units.Player

class DropPanelTest extends munit.FunSuite{
  test("Drop Panel should add and remove characters correctly") {
    val dropPanel = new DropPanel()
    val player1 = new Player("Player 1", 1, 1, 1, 1)
    val player2 = new Player("Player 2", 2, 2, 2, 2)

    dropPanel.addCharacter(player1)
    dropPanel.addCharacter(player2)

    assert(dropPanel.characters.length == 2)
    assert(dropPanel.characters.contains(player1))
    assert(dropPanel.characters.contains(player2))

    dropPanel.removeCharacter(player1)

    assert(dropPanel.characters.length == 1)
    assert(!dropPanel.characters.contains(player1))
    assert(dropPanel.characters.contains(player2))
  }
  test("Drop Panel should remove stars correctly"){
    val dropPanel = new DropPanel()
    val player = new Player("Player 1", 1, 1, 1, 1)
    player.Stars_(5)
    dropPanel.apply(player)
    assert(player.Stars < 5)
  }

}


package cl.uchile.dcc.citric
package model.panels

import model.units.Player

import scala.collection.mutable.ArrayBuffer

class BonusPanelTest extends munit.FunSuite{
  test("Bonus Panel should add and remove characters correctly") {
    val bonusPanel = new BonusPanel()
    val player1 = new Player("Player 1", 1, 1, 1, 1)
    val player2 = new Player("Player 2", 2, 2, 2, 2)

    bonusPanel.addCharacter(player1)
    bonusPanel.addCharacter(player2)

    assert(bonusPanel.characters.length == 2)
    assert(bonusPanel.characters.contains(player1))
    assert(bonusPanel.characters.contains(player2))

    bonusPanel.removeCharacter(player1)

    assert(bonusPanel.characters.length == 1)
    assert(!bonusPanel.characters.contains(player1))
    assert(bonusPanel.characters.contains(player2))
  }
  test("Bonus Panel should add stars correctly") {
    val bonusPanel = new BonusPanel()
    val player = new Player("Player 1", 1, 1, 1, 1)
    player.Stars_(5)
    bonusPanel.addCharacter(player)
    bonusPanel.apply(bonusPanel.characters)
    assert(player.Stars > 5)
  }
}


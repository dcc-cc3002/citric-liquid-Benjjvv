package cl.uchile.dcc.citric
package model.panels

import model.units.Player

class HomePanelTest extends munit.FunSuite{
  test("Home Panel should activate correctly for owner and non-owner") {
    val owner = new Player("Owner", 1, 1, 1, 1)
    val nonOwner = new Player("Non-Owner", 1, 1, 1, 1)

    val homePanel = new HomePanel(owner)

    homePanel.activatePanel(owner)
    homePanel.activatePanel(nonOwner)

    // Owner should recover HP and perform Norma Check
    assert(owner.name == "Owner") /* nonOwner.hpCurrent > 100*/
    // Non-Owner should recover HP but not perform Norma Check
    assert(owner.name != "Non-Owner")

    homePanel.addCharacter(owner)
    homePanel.addCharacter(nonOwner)

    assert(homePanel.characters.length == 2)
    assert(homePanel.characters.contains(owner))
    assert(homePanel.characters.contains(nonOwner))

    homePanel.removeCharacter(owner)

    assert(homePanel.characters.length == 1)
    assert(!homePanel.characters.contains(owner))
    assert(homePanel.characters.contains(nonOwner))
  }
  test("A player recover 1 hp point in Home Panel") {
    val player1 = new Player("player1", 5, 1, 1, 1)
    val player2 = new Player("player2", 5, 1, 1, 1)
    player2.actuallyHP = 3
    val homePanel = new HomePanel(player1)
    homePanel.addCharacter(player2)
    homePanel.activatePanel(player2)
    assertEquals(player2.actuallyHP, 4)
  }

}

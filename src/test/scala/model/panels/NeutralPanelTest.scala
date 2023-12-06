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
  test("Neutral Panel should add and remove panels correctly"){
    val neutralPanel = new NeutralPanel()
    val player1 = new Player("player1", 5, 1, 1, 1)
    val encounterPanel = new EncounterPanel()
    val homePanel = new HomePanel(player1)
    neutralPanel.addPanel(encounterPanel)
    neutralPanel.addPanel(homePanel)
    assert(neutralPanel.nextPanels.length==2)
    assert(neutralPanel.nextPanels.contains(encounterPanel))
    assert(neutralPanel.nextPanels.contains(homePanel))

    neutralPanel.removePanel(encounterPanel)

    assert(neutralPanel.nextPanels.length == 1)
    assert(!neutralPanel.nextPanels.contains(encounterPanel))
    assert(neutralPanel.nextPanels.contains(homePanel))

  }
  test("Apply should do nothing"){
    val neutralPanel = new NeutralPanel()
    val player1 = new Player("player1", 5, 1, 1, 1)
    neutralPanel.addCharacter(player1)
    neutralPanel.apply(neutralPanel.characters(0))
    assertEquals(player1.maxHP,5)
    assertEquals(player1.ATK,1)
    assertEquals(player1.DEF,1)
    assertEquals(player1.EVA,1)
  }

}

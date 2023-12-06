package cl.uchile.dcc.citric
package model.panels

import model.units.Player

class HomePanelTest extends munit.FunSuite{
  test("Home Panel should activate correctly for owner and non-owner") {
    val owner = new Player("Owner", 1, 1, 1, 1)
    val nonOwner = new Player("Non-Owner", 1, 1, 1, 1)

    val homePanel = new HomePanel(owner)

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
    player2.actuallyHP_(3)
    val homePanel = new HomePanel(player1)
    homePanel.addCharacter(player2)
    homePanel.apply(homePanel.characters(1))
    assertEquals(player2.actuallyHP, 4)
  }
  test("A player can change his Norma") {
    val player1 = new Player("player1", 5, 1, 1, 1)
    player1.Stars_(11)
    val homePanel = new HomePanel(player1)
    homePanel.addCharacter(player1)
    homePanel.apply(homePanel.characters(0))
    assertEquals(player1.currentNorma.getLevel,2)
  }
  test("You can get the owner of a HomePanel"){
    val player1 = new Player("player1", 5, 1, 1, 1)
    val homePanel = new HomePanel(player1)
    assertEquals(homePanel.getowner,player1)
  }
}

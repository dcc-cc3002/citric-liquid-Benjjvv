package cl.uchile.dcc.citric
package model.panels
import model.units.Player
class EncounterPanelTest extends munit.FunSuite{
  test("Encounter Panel should add and remove characters correctly") {
    val encounterPanel = new EncounterPanel()
    val player1 = new Player("Player 1", 1, 1, 1, 1)
    val player2 = new Player("Player 2", 2, 2, 2, 2)

    encounterPanel.addCharacter(player1)
    encounterPanel.addCharacter(player2)

    assert(encounterPanel.characters.length == 2)
    assert(encounterPanel.characters.contains(player1))
    assert(encounterPanel.characters.contains(player2))

    encounterPanel.removeCharacter(player1)

    assert(encounterPanel.characters.length == 1)
    assert(!encounterPanel.characters.contains(player1))
    assert(encounterPanel.characters.contains(player2))

  }
  test("In a Encounter Panel should spawn a enemy") {
    val encounterPanel = new EncounterPanel()
    encounterPanel.getspawnEnemy()
    val enemies: Array[String] = Array("Robo Ball","Seagull","Chicken")
    assert(enemies.contains(encounterPanel.getenemyWU.name))


  }

  test("In a Encounter Panel a battle has to take place"){
  val encounterPanel = new EncounterPanel()
  val player1 = new Player("Player 1", 6, 1, 1, 1)

  encounterPanel.addCharacter(player1)
  encounterPanel.apply(encounterPanel.characters)
  assert(player1.actuallyHP <= player1.maxHP)
  }
}


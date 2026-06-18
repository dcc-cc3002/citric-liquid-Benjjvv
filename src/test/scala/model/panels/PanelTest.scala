package cl.uchile.dcc.citric
package model.panels
import cl.uchile.dcc.citric.model.units.Player

import scala.collection.mutable.ArrayBuffer

import munit._


class PanelTest extends FunSuite {
  test("ola"){

  }
}

/*
  test("Bonus Panel should add stars to the player") {
    val bonusPanel = new BonusPanel()
    val player = PlayerCharacter("Player")

    bonusPanel.addCharacter(player)

    val initialStars = player.stars
    bonusPanel.activatePanel(player)

    // Check if stars are added to the player
    assert(player.stars > initialStars)
  }

 */
/*
  test("Drop Panel should remove stars from the player") {
    val dropPanel = new DropPanel()
    val player = PlayerCharacter("Player")

    dropPanel.addCharacter(player)

    val initialStars = player.stars
    // Assuming a dice roll result of 3
    val mockedDiceRoll = 3
    dropPanel.activatePanel(player, mockedDiceRoll)

    // Check if stars are deducted from the player based on the dice roll
    val expectedStarsDeduction = mockedDiceRoll * player.norma
    assert(player.stars == initialStars - expectedStarsDeduction)
  }
*/



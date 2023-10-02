package cl.uchile.dcc.citric
package model.panels

import model.units.Player

import scala.collection.mutable.ArrayBuffer

/** Drop Panel
 * this panel remove stars from the player
 */
class DropPanel extends Panel {
  val characters: ArrayBuffer[Player] = ArrayBuffer.empty
  var nextPanels: ArrayBuffer[Panel] = ArrayBuffer.empty

  def addCharacter(player: Player): Unit = {
    characters += player
  }

  def removeCharacter(player: Player): Unit = {
    characters -= player
  }

  def activatePanel(player: Player): Unit = {
    val roll = player.numDado
    val starsLost = roll * player.currentNorma
    player.Stars_(player.Stars - starsLost) // resta estrellas al jugador
  }
}
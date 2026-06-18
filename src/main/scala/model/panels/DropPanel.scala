package cl.uchile.dcc.citric
package model.panels

import model.units.Player

import scala.collection.mutable.ArrayBuffer

/** Drop Panel
 * this panel remove stars from the player
 */
class DropPanel extends AbstractPanel {

   override def apply(player: Player): Unit = {
    val roll = player.numDado
    val starsLost = roll * player.currentNorma
    player.Stars_(player.Stars - starsLost) // resta estrellas al jugador
  }
}
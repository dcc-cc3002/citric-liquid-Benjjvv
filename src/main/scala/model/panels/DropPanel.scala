package cl.uchile.dcc.citric
package model.panels

import model.units.Player

import scala.collection.mutable.ArrayBuffer

/** Drop Panel
 * this panel remove stars from the player
 */
class DropPanel extends AbstractPanel {

  /**
   * Apply panel logic to a array of players.
   *
   * For each player in the array, it calculates the number of stars
   * to be deducted based on their dice roll
   * and the current level of their norma. The calculated stars are subtracted from the player's star count.
   *
   * @param players An ArrayBuffer of Player representing the player characters to apply the game logic to.
   */
  override def apply(players: ArrayBuffer[Player]): Unit = {
    for (player <- players) {
      // Get the player's dice roll
      val roll = player.numDado

      // Calculate stars to be deducted based on the dice roll and the current level of the player's norma
      val starsLost = roll * player.currentNorma.getLevel

      // Subtract the calculated stars from the player's star count
      player.Stars_(player.Stars - starsLost)
    }
  }
}
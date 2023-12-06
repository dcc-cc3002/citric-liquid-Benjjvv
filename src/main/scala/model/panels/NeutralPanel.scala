package cl.uchile.dcc.citric
package model.panels

import model.units.Player

import scala.collection.mutable.ArrayBuffer

/**  Neutral Panel
 *
 * this panel doesn't has any effect on the player
 * the turns ends without news
 */
class NeutralPanel extends AbstractPanel with Panel {
  /**
   * Apply panel logic to a array of players.
   *
   * In this case, this panel dont have any effect in the players
   * so it do nothing
   *
   * @param players An ArrayBuffer of Player representing the player characters to apply the game logic to.
   */
  override def apply(player: Player): Unit = null

}

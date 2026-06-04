package cl.uchile.dcc.citric
package model.panels

import model.units.Player

import scala.collection.mutable.ArrayBuffer

/**  Neutral Panel
 *
 * this panel doesn't has any effect on the player
 * the turns ends without news
 */
class NeutralPanel extends Panel{
  val characters: ArrayBuffer[Player] = ArrayBuffer.empty
  var nextPanels: ArrayBuffer[Panel] = ArrayBuffer.empty
  override def addCharacter(player: Player): Unit={
    characters += player
  }
  override def removeCharacter(player: Player): Unit={
    characters -= player
  }
}

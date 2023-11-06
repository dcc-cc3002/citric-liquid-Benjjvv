package cl.uchile.dcc.citric
package model.norma

import model.units.Player

/**
 * A trait representing a game rule or norm.
 *
 * This trait defines the characteristics and behavior of a game rule or norm, including methods for
 * checking if a player complies with the rule, and obtaining the level of the rule.
 *
 */
trait Norma {
  /**
   * The next norm or rule in the sequence.
   *
   * @return The next norm in the game sequence.
   */
  val NextNorma: Norma
  /**
   * Check if a player complies with the norm's requirements.
   *
   * @param player The player to be checked.
   * @return `true` if the player complies with the norm, `false` otherwise.
   */
  def itsOK(player: Player): Boolean
  /**
   * Get the level of the norm.
   *
   * @return The level of the norm as an integer.
   */
  def getLevel: Int
}



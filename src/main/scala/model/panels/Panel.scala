package cl.uchile.dcc.citric
package model.panels
import scala.util.Random

import cl.uchile.dcc.citric.model.units.Player
import scala.collection.mutable.ArrayBuffer
/** Represents a single cell on a board, known as a Panel.
 *
 * Each panel has its own effect, which can be applied to a character.
 * In the context of the board game, a panel represents a tile or space that a character lands on
 * and experiences an effect (e.g., losing stars, fighting an enemy, etc.).
 * Panels can also be connected to other panels, allowing for the formation of complex board
 * structures.
 *
 * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
 * @author [[https://github.com/Benjvv Benjamin Ureta]]
 */
trait Panel {

  /** Array of the characters currently positioned on this panel.
   *
   * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
   * land on the same space.
   */
  protected val characters: ArrayBuffer[Player]

  /** An array of panels that are directly connected to this one.
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  protected var nextPanels: ArrayBuffer[Panel]

  /** Adds a character to the list of characters currently on this panel.
   *
   * This might be invoked when a player moves to this panel or starts their turn on it.
   *
   * @param player The player character to add to this panel.
   */
  protected def addCharacter(player: Player): Unit

  /** Removes a player from the list of players currently on this panel.
   *
   * This might be invoked when a player moves off this panel.
   *
   * @param player The player character to remove from this panel.
   */
  protected def removeCharacter(player: Player): Unit

  /**
   * Add a panel to the collection of next panels.
   *
   * This method adds a specified panel to the collection of next panels.
   *
   * @param panel The panel to be added.
   * @return An ArrayBuffer of Panel containing the updated collection of next panels.
   */
  protected def addPanel(panel: Panel): ArrayBuffer[Panel]

  /**
   * Remove a panel from the collection of next panels.
   *
   * This method removes a specified panel from the collection of next panels.
   *
   * @param panel The panel to be removed.
   * @return An ArrayBuffer of Panel containing the updated collection of next panels.
   */
  protected def removePanel(panel: Panel): ArrayBuffer[Panel]

  /**
   * Applies panel functionality to players
   *
   * @param players An ArrayBuffer of Player representing the players to apply the game logic to.
   */
  def apply(characters: ArrayBuffer[Player]): Unit
  def getPlayers: ArrayBuffer[Player]
}





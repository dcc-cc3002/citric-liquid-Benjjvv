package cl.uchile.dcc.citric
package model.panels
import model.units.Player
import scala.collection.mutable.ArrayBuffer
import model.norma.Norma

/** Home Panel
 * each player have their personal home
 * can be activated
 *
 * if is activated -> player recover one point HP and the panel do a NormaCheck
 */

class HomePanel(private val owner: Player) extends AbstractPanel {
  addCharacter(owner)
  def getowner: Player = owner

  /**
   * Check and advance the player's current norma to the next norma if conditions are met.
   *
   * If both conditions are met, the player's current norma is updated to the next norma,
   * and the process is recursively repeated until no further norma advancements
   * are possible.
   *
   * @param player The player for whom the norma advancement is checked and potentially updated.
   */
  def normacheck(player: Player): Unit = {
    // Check if the player's current norma has a next norma and if the player fulfills the advancement requirements
    if (player.currentNorma.NextNorma != null && player.currentNorma.NextNorma.itsOK(player)) {
      // Update the player's current norma to the next norma
      player.currentNorma_(player.currentNorma.NextNorma)

      // Recursively call normacheck to potentially advance to the next norma again
      normacheck(player)
    }
  }

  /**
   * Apply panel logic to a array of players.
   *
   * For each player in the array, every player recover 1 point of hp and do a normacheck
   *
   * @param players An ArrayBuffer of Player representing the player characters to apply the game logic to.
   */
  override def apply(player:Player): Unit = {

    player.actuallyHP_(player.actuallyHP + 1)
    normacheck(player)

  }
}




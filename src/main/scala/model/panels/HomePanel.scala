package cl.uchile.dcc.citric
package model.panels
import model.units.Player
import scala.collection.mutable.ArrayBuffer
import model.Norma.Norma

/** Home Panel
 * each player have their personal home
 * can be activated
 *
 * if is activated -> player recover one point HP and the panel do a NormaCheck
 */

class HomePanel(owner: Player) extends Panel {
  val characters: ArrayBuffer[Player] = ArrayBuffer.empty //??
  var nextPanels: ArrayBuffer[Panel] = ArrayBuffer.empty  //??

  def addCharacter(player: Player): Unit = {
    characters += player
  }

  def removeCharacter(player: Player): Unit = {
    characters -= player
  }

  /** activatePanel
   *
   *
   * @param player player who fell on the panel
   * if the player is te owner of the panel, he/she can stop in the panel and recover hp
   * if not the panel activates at the moment */
  def activatePanel(player: Player): Unit = {
    /**
     * player recover 1 point of HP
     */
    player.actuallyHP_(player.actuallyHP + 1)
    //if(player._actuallyHP != player.maxHP){
      //player._actuallyHP += 1
    //}
    //normaCheck

  }

}




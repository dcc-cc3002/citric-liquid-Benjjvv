package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.Player

import scala.collection.mutable.ArrayBuffer

/** Encounter Panel
 * in this panel the player fight with a Wild Unit
 */
class EncounterPanel extends Panel {
  val characters: ArrayBuffer[Player] = ArrayBuffer.empty
  var nextPanels: ArrayBuffer[Panel] = ArrayBuffer.empty
  def addCharacter(player: Player): Unit = {
    characters += player
  }
  def removeCharacter(player: Player): Unit = {
    characters -= player
  }

  def combat(player: Player): Unit ={
    //me falto hacer la funcion de combate con un Wild Unit random
  println("el jugador entra en combate con un Wild Unit")}
}
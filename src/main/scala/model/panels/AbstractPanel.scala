package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.Player

import scala.collection.mutable.ArrayBuffer

abstract class AbstractPanel extends Panel {
  val characters: ArrayBuffer[Player] = ArrayBuffer.empty
  var nextPanels: ArrayBuffer[Panel] = ArrayBuffer.empty


  def addCharacter(player: Player): Unit = {
    characters += player
  }

  def removeCharacter(player: Player): Unit = {
    characters -= player
  }

   def addPanel(panel: Panel): ArrayBuffer[Panel] = {
    nextPanels += panel
  }

   def removePanel(panel: Panel): ArrayBuffer[Panel] = {
    nextPanels -= panel
  }
  protected def apply(players: ArrayBuffer[Player]): Unit

}

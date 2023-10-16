package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.Player

import scala.collection.mutable.ArrayBuffer

class AbstractPanel extends Panel {
  val characters: ArrayBuffer[Player] = ArrayBuffer.empty
  var nextPanels: ArrayBuffer[Panel] = ArrayBuffer.empty

   override def addCharacter(player: Player): Unit = {
    characters += player
  }

   override def removeCharacter(player: Player): Unit = {
    characters -= player
  }
  protected def apply(player: Player): Unit = None

}

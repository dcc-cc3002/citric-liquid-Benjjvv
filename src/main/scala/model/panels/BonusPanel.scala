package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.Player

import scala.collection.mutable.ArrayBuffer

 /** Bonus Panel
 * this panel give stars to the player
 */
class BonusPanel extends AbstractPanel {


   override def apply(player: Player): Unit = {
     val roll = player.numDado
     val starsGain = roll * player.currentNorma
     player.Stars_(player.Stars+starsGain )// Sumar estrellas al jugador
   }



}



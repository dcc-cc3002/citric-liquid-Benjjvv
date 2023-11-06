package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.Player

import scala.Console.in
import scala.collection.mutable.ArrayBuffer

 /** Bonus Panel
 * this panel give stars to the player
 */
class BonusPanel extends AbstractPanel {


   /**
    * Apply panel logic to a array of players.
    *
    * For each player in the array,
    * it calculates the stars gained based on their dice roll and the current level
    * of their norma. The calculated stars are added to the player's star count.
    *
    * @param characters An ArrayBuffer of Player representing the player characters to apply the game logic to.
    */
   override def apply(characters: ArrayBuffer[Player]): Unit = {
     for (player <- characters) {
       // Get the player's dice roll
       val roll = player.numDado

       // Calculate stars gained based on the dice roll and the current level of the player's norma
       val starsGain = roll * player.currentNorma.getLevel

       // Add the calculated stars to the player's star count
       player.Stars_(player.Stars + starsGain)
     }
   }

}



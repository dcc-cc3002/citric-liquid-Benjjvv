package cl.uchile.dcc.citric
package model.Norma

import model.units.Player
//var currentStars: Int = 0, var currentWins: Int = 0
/**
 * La clase Norma rastrea el progreso de un jugador en función de las estrellas y las victorias.
 * Permite verificar y actualizar la norma del jugador.
 *
 * @param level El nivel actual del jugador.
 * @param currentStars La cantidad actual de estrellas del jugador.
 * @param currentWins La cantidad actual de victorias del jugador.
 */
class Norma(var level: Int = 1) {

  /**
   * Verifica y actualiza la norma del jugador dependiendo de la cantidad de estrellas/victorias.
   *
   * @param player El jugador cuya norma se va a verificar y actualizar.
   */

  def normaCheck(player: Player): Unit = {
    // Comprobar si el jugador ha alcanzado ciertas condiciones de estrellas o victorias
    if (player.Stars == 10 || player.Wins == 1) {
      player.currentNorma_(2)   // Establecer la norma del jugador en 2
    }
    if (player.Stars == 30 || player.Wins == 3) {
      player.currentNorma_(3)   // Establecer la norma del jugador en 3
    }
    if (player.Stars == 70 || player.Wins == 6) {
      player.currentNorma_(4)   // Establecer la norma del jugador en 4
    }
    if (player.Stars == 120 || player.Wins == 10) {
      player.currentNorma_(5)   // Establecer la norma del jugador en 5
    }
    if (player.Stars == 200 || player.Wins == 14) {
      player.currentNorma_(6)   // Establecer la norma del jugador en 6
    }
  }
}



package cl.uchile.dcc.citric
package model.units.wildunits

import model.units.AbstractUnits

/**
 * Esta es una subclase que representa un jugador del juego.
 *
 * @param name nombre de la unidad
 * @param maxHP stat de vida, vida maxima
 * @param ATK stat de ataque
 * @param DEF stat de defensa
 * @param EVA stat de evasion
 */

class Chicken() extends AbstractUnits("Chicken", 3, -1, -1, 1){

  var actuallyHP = maxHP
  override val KO = isKO()

/**
 * funcion que ve si el jugador esta KO
 */
def isKO(): Boolean = {
  if (actuallyHP == 0) {
    return true
  }
  return false
}

}
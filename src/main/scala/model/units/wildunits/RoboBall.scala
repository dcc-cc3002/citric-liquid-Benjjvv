package cl.uchile.dcc.citric
package model.units.wildunits

import scala.util.Random
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

class RoboBall() extends AbstractUnits("Robo Ball", 3, -1, 1, -1){

  protected var _actuallyHP: Int = maxHP
  override val KO = isKO()

  override def actuallyHP: Int = _actuallyHP

  override def actuallyHP_(newHP: Int): Unit = {
    _actuallyHP = math.max(0, newHP)
  }
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
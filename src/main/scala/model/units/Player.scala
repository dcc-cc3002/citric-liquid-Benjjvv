package cl.uchile.dcc.citric
package model.units

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

class Player(name: String, maxHP: Int, ATK: Int, DEF: Int, EVA: Int) extends AbstractUnits(name, maxHP, ATK, DEF, EVA) {
  /**
   * Los puntos de vida actuales de la unidad.
   */
  var actuallyHP: Int = maxHP
  /**
   * Indica si la unidad está en estado de KO.
   * Por defecto, esta en false.
   */
  override val KO: Boolean = isKO()
  /**
   * chapter que se encuentra el personaje
   * lo iniciamos en 0
   */
  var chapter: Int = 0

  /**
   * norma del player
   * iniciamos en 1
   */
  var currentNorma: Int = 1
  /**
   * numero de estrellas que posee el personaje
   */
  var Stars: Int = (chapter / 5) + 1

  /**
   * numero de victorias del personaje
   */
  var Wins: Int = 0

  /**
   * numero de recovery
   * la iniciamos en 6 y va disminuyendo en cada chapter
   * como iniciamos chapter en 1
   */
  var recoveryVal: Int = 6 - chapter

  /**
   * dado de 6 caras para el juego
   */
  val dado: Random = new Random()

  /**
   * tiramos el dado
   */
  val numDado: Int = dado.nextInt(6) + 1 /* +1 pq genera numero de [0,5[ */


  /**
   * funcion que ve si el jugador esta KO
   */
  def isKO(): Boolean = {
    if (actuallyHP == 0) {
      return true
    }
    return false
  }

  /**
   * funcion que ve si el jugador esta en la fase de recover
   */
  def RecoverFase(): Boolean = {
    if (isKO()) {
      /**
       * si el valor de recovery (6) es menor que el numero del dado sigue
       */
      if (recoveryVal >= numDado) {
        return true
      }
      return false
    }
    return false
  }
}
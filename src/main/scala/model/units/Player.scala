package cl.uchile.dcc.citric
package model.units

import scala.util.Random

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
  protected var _actuallyHP: Int = maxHP

  override def actuallyHP: Int = _actuallyHP


  /**
   * chapter que se encuentra el personaje
   * lo iniciamos en 0
   */
  private var _chapter: Int = 0

  def chapter: Int = _chapter

  def chapter_(newChapter: Int): Unit = {
    _chapter = math.max(0, newChapter)
  }


  /**
   * norma del player
   * iniciamos en 1
   */
  private var _currentNorma: Int = 1

  def currentNorma: Int = _currentNorma

  def currentNorma_(newNorma: Int): Unit = {
    _currentNorma = math.max(0, newNorma)
  }

  /**
   * numero de estrellas que posee el personaje
   */
  private var _Stars: Int = 1

  def Stars: Int = _Stars
  def Stars_(newStars: Int): Unit = {
    _Stars = math.max(0, newStars)
  }

  /**
   * numero de victorias del personaje
   */
  private var _Wins: Int = 0

  def Wins: Int = _Wins

  def Wins_(newWins: Int): Unit = {
    _Wins = math.max(0, newWins)
  }

  /**
   * numero de recovery
   * la iniciamos en 6 y va disminuyendo en cada chapter
   * como iniciamos chapter en 1
   */
  var recoveryVal: Int = 6 - chapter


  /**
   * funcion que ve si el jugador esta en la fase de recover
   */
  def RecoverFase(): Boolean = {
    if (isKO) {
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
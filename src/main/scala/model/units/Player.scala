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
  protected var _actuallyHP: Int = maxHP

  override def actuallyHP: Int = _actuallyHP

  override def actuallyHP_(newHP: Int): Unit = {
    _actuallyHP = math.max(0, newHP)
  }
  /**
   * Indica si la unidad está en estado de KO.
   * Por defecto, esta en false.
   */
   override val KO: Boolean = isKO()
  /**
   * chapter que se encuentra el personaje
   * lo iniciamos en 0
   */
  protected var _chapter: Int = 0

  def chapter: Int = _chapter

  def chapter_(newChapter: Int): Unit = {
    _chapter = math.max(0, newChapter)
  }


  /**
   * norma del player
   * iniciamos en 1
   */
  protected var _currentNorma: Int = 1

  def currentNorma: Int = _currentNorma

  def currentNorma_(newNorma: Int): Unit = {
    _currentNorma = math.max(0, newNorma)
  }

  /**
   * numero de estrellas que posee el personaje
   */
  protected var _Stars: Int = 1

  def Stars: Int = _Stars
  def Stars_(newStars: Int): Unit = {
    _Stars = math.max(0, newStars)
  }

  /**
   * numero de victorias del personaje
   */
  protected var _Wins: Int = 0

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

  /** hacer funcion attack */

  def attack(enemy: Player): Unit = {
    if (!enemy.isKO()) {
      enemy.actuallyHP_(enemy.actuallyHP - 1)
    }
  }
}
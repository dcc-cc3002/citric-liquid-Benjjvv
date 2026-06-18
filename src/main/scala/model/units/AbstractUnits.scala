package cl.uchile.dcc.citric
package model.units

import scala.util.Random

/**
 * Esta es una clase abstracta que representa unidades en el juego.
 *
 * @param name nombre de la unidad
 * @param maxHP stat de vida, vida maxima
 * @param ATK stat de ataque
 * @param DEF stat de defensa
 * @param EVA stat de evasion
 */
abstract class AbstractUnits(  val name: String,
                                val maxHP: Int,
                              val ATK: Int,
                              val DEF: Int,
                              val EVA: Int) {

  /**
   * Los puntos de vida actuales de la unidad.
   */
  protected var _actuallyHP: Int

  //getter actuallyHP
  protected def actuallyHP: Int = _actuallyHP

  //setter actuallyHP
  def actuallyHP_(newHP: Int): Unit = {
    _actuallyHP = math.max(0, newHP)
  }

  /**
   * Indica si la unidad está en estado de KO.
   * Por defecto, esta en false.
   */
  val KO: Boolean = false

  /**
   * funcion que ve si el jugador esta KO
   */
  def isKO: Boolean = {
    if (actuallyHP == 0) {
      true
    } else {
      false
    }
  }

  /**
   * dado de 6 caras para el juego
   */
  val dado: Random = new Random()

  /**
   * tiramos el dado
   */
  val numDado: Int = dado.nextInt(6) + 1 // +1 pq genera numero de [0,5[

  // in this case, I AM ATTACKING
  //en este caso esta funcion esta programada pensando en que uno esta atacando al enemigo
  def attack(enemy: AbstractUnits): Unit = {
    if (!isKO && !enemy.isKO) {
      val damage = ATK + numDado
      enemy.actuallyHP_(enemy.actuallyHP - damage) //le quito vida al enemigo
    }
  }

  // in this case, I AM DEFENDING
  //en este caso esta funcion esta programada pensando en que uno se esta defendiendo del ataque del enemigo
  def defend(enemy: AbstractUnits): Unit = {
    if (!isKO && !enemy.isKO) {
      val damageReceived = math.max(1, enemy.numDado + enemy.ATK - (numDado + DEF))
      actuallyHP_(actuallyHP - damageReceived)
    }
  }

  // in this case, I AM EVADING
  //en este caso esta funcion esta programada pensando en que uno se esta tratando evadir del ataque del enemigo
  def evade(enemy: AbstractUnits): Unit = {
    if (!isKO && !enemy.isKO) {
      if (numDado + EVA < enemy.numDado + enemy.ATK)
        enemy.attack(this) //no evado, el enemigo me ataca
      else None
    }
  }
}



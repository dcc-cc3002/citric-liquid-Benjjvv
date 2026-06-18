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
  protected def actuallyHP: Int = _actuallyHP
  protected def actuallyHP_(newHP: Int): Unit ={
    _actuallyHP = math.max(0,newHP)
  }

  /**
   * Indica si la unidad está en estado de KO.
   * Por defecto, esta en false.
   */
  protected val KO: Boolean = false


}


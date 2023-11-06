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
abstract class AbstractUnits(   private val _name: String,
                                private val _maxHP: Int,
                                private var _ATK: Int,
                                private val _DEF: Int,
                                private val _EVA: Int) extends Units {

  val name = _name
  val maxHP = _maxHP
  var ATK = _ATK
  val DEF = _DEF
  val EVA = _EVA
  /**
   * Los puntos de vida actuales de la unidad.
   */
  protected var _actuallyHP: Int

  //getter actuallyHP
  def actuallyHP: Int = _actuallyHP

  //setter actuallyHP
  def actuallyHP_(newHP: Int): Unit = {
    _actuallyHP = math.max(0, newHP)
  } : Unit

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
   * numero de estrellas que posee el personaje
   */
  protected var _Stars: Int = 1

  def Stars: Int = _Stars

  def Stars_(newStars: Int): Unit = {
    _Stars = math.max(0, newStars)
  }

  /**
   * dado de 6 caras para el juego
   */
  private val dado: Random = new Random()

  /**
   * tiramos el dado
   */
  val numDado: Int = dado.nextInt(6) + 1 // +1 pq genera numero de [0,5[

  var combatMode: String = "DEF"
  /**
   * Attack an enemy unit.
   *
   * This method is used to initiate an attack on an enemy unit, provided that the attacker and the enemy
   * are not knocked out (KO). Th
   *
   * @param enemy The enemy unit to be attacked.
   */
  def attack(enemy: Units): Unit = {
    // Check if neither the attacker nor the enemy is knocked out (KO)
    if (!isKO && !enemy.isKO) {
      // Perform an attack on an enemy unit in "DEF" (defense) mode
      if (enemy.combatMode == "DEF") {
        enemy.defend(this, ATK + numDado)
      }
      // Perform an attack on an enemy unit in "EVA" (evasion) mode
      else if (enemy.combatMode == "EVA") {
        enemy.evade(this, ATK + numDado)
      }
    }
  }

  /**
   * Defend against an enemy's attack.
   *
   * This method allows a unit to defend itself against an enemy's attack.
   * The method calculates the damage received,deducts it from the unit's actual hit points (HP),
   * updates the unit's values, and triggers a
   * counter-attack if the defending unit is still active.
   *
   * @param enemy The attacking enemy unit.
   * @param damage The amount of damage inflicted by the enemy's attack.
   */
  def defend(enemy: Units, damage: Int): Unit = {
    // Check if neither the defending unit nor the enemy unit is knocked out (KO)
    if (!isKO && !enemy.isKO) {
      // Calculate damage received and deduct it from actual hit points (HP)
      actuallyHP_(actuallyHP - math.max(1, damage - (numDado + this.DEF)))
      setValues

      // Check if the defending unit has been knocked out (KO)
      if (this.isKO) {
        // If the defending unit is KO, update the enemy's stats
        enemy.updateStats(this.giveStats._1, this.giveStats._2)
      } else {
        // If the defending unit is still active, initiate a counter-attack
        attack(enemy)
      }
    }
  }

  /**
   * Attempt to evade an enemy's attack.
   *
   * The method calculates the chance of successfully evading the attack based on the unit's evasion stats,
   * and takes appropriate actions based on the outcome,
   * including counter-attacking if the evasion is successful.
   *
   * @param enemy The attacking enemy unit.
   * @param damage The amount of damage inflicted by the enemy's attack.
   */
  def evade(enemy: Units, damage: Int): Unit = {
    // Check if neither the evading unit nor the enemy unit is knocked out (KO)
    if (!isKO && !enemy.isKO) {
      // Calculate the chance of successful evasion
      if ((numDado + EVA) > enemy.numDado + damage) {
        // If evasion is successful, initiate a counter-attack
        attack(enemy)
      } else {
        // If evasion is unsuccessful, deduct damage from actual hit points (HP) and update values
        actuallyHP_(actuallyHP - damage)
        setValues
      }

      // Check if the evading unit has been knocked out (KO)
      if (this.isKO) {
        // If the evading unit is KO, update the enemy's stats
        enemy.updateStats(this.giveStats._1, this.giveStats._2)
      } else {
        // If the evading unit is still active, initiate a counter-attack
        attack(enemy)
      }
    }
  }
}



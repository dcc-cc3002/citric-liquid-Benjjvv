package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.Player
import cl.uchile.dcc.citric.model.units.wildunits.{Chicken, RoboBall, Seagull, WildUnit}

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

/** Encounter Panel
 * in this panel the player fight with a Wild Unit
 */
class EncounterPanel extends AbstractPanel {
    private var enemyWU: WildUnit = null
    def getenemyWU: WildUnit = enemyWU

  /**
   * Spawn a random wild unit.
   *
   * It utilizes a random number generator to select an enemy unit type.
   * The selected enemy unit is then assigned to the `enemyWU` property.
   */
  private def spawnEnemy(): Unit = {
    // Create a new instance of the Random class
    val random = new Random()

    // Generate a random number between 0 and 2
    val randomWU = random.nextInt(3)

    // Based on the random number, assign an enemy unit of the corresponding type to the `enemyWU` property
    if (randomWU == 0) {
      enemyWU = new RoboBall()
    } else if (randomWU == 1) {
      enemyWU = new Chicken()
    } else {
      enemyWU = new Seagull()
    }
  }

  /**
   *
   * This method get the enemy spawned
   */
  def getspawnEnemy(): Unit = spawnEnemy()

  /**
   * Initiate combat between players and a wild unit.
   *
   * For each player in the provided collection, it spawns an enemy unit and then invokes
   * the `attack` method of the enemy unit to attack the player.
   *
   * @param players An ArrayBuffer of Player representing the player characters involved in the combat.
   */
  private def combat(player:Player): Unit = {
      spawnEnemy()

      // Initiate an attack by the spawned enemy unit on the player
      enemyWU.attack(player)

  }

  /**
   * Apply panel logic to a array of players.
   *
   * For each player in the array, put it in a combat with a wild unit
   *
   * @param players An ArrayBuffer of Player representing the player characters to apply the game logic to.
   */
  override def apply(player: Player): Unit = {
    combat(player)
    }

}
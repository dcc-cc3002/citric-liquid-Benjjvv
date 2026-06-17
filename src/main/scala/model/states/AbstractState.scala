package cl.uchile.dcc.citric
package model.states


import model.GameController

import cl.uchile.dcc.citric.model.units.Player


/**
 * An abstract class representing a base state for a game. Extends the GameState trait.
 *
 * @param context The game controller associated with this state.
 */
abstract class AbstractState protected(val context: GameController) extends GameState {

  /**
   * Method that raises an exception indicating an incorrect state. Intended to be overridden by concrete states.
   *
   * @throws Exception indicating an incorrect state.
   */
  def error: Nothing = throw new Exception("Wrong State")

  /**
   * Implementation of the handleEvent method from the GameState trait.
   * Raises an exception indicating an incorrect state. Intended to be overridden by concrete states.
   *
   * @throws Exception indicating an incorrect state.
   */
  def handleEvent(): Unit = error

  /**
   * Indicates whether the current state is a chapter state.
   *
   * @return True if the state is a chapter state, false otherwise.
   */
  override def isChapter: Boolean = false

  /**
   * Indicates whether the current state is a combat state.
   *
   * @return True if the state is a combat state, false otherwise.
   */
  override def isCombat: Boolean = false

  /**
   * Indicates whether the current state is an end game state.
   *
   * @return True if the state is an end game state, false otherwise.
   */
  override def isEndGame: Boolean = false

  /**
   * Indicates whether the current state is a landing panel state.
   *
   * @return True if the state is a landing panel state, false otherwise.
   */
  override def isLandingPanel: Boolean = false

  /**
   * Indicates whether the current state is a moving state.
   *
   * @return True if the state is a moving state, false otherwise.
   */
  override def isMoving: Boolean = false

  /**
   * Indicates whether it's the player's turn in the current state.
   *
   * @return True if it's the player's turn, false otherwise.
   */
  override def isPlayerTurn: Boolean = false

  /**
   * Indicates whether the current state is a pre-game state.
   *
   * @return True if the state is a pre-game state, false otherwise.
   */
  override def isPreGame: Boolean = false

  /**
   * Indicates whether the current state is a recover state.
   *
   * @return True if the state is a recover state, false otherwise.
   */
  override def isRecover: Boolean = false

  /**
   * The actual player who is currently taking their turn.
   * Initially set to null until a player is assigned.
   */
  override var actual_player: Player = null

  /**
   * The count of turns in the game.
   * Initially set to 0.
   */
  var turns_count: Int = 0

}
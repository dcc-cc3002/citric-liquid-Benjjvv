package cl.uchile.dcc.citric
package model.states

import model.GameController

import cl.uchile.dcc.citric.model.units.Player

/**
 * Trait representing a state in a game. Implements the State design pattern.
 *
 * @param context The game controller that holds an internal state.
 */
trait GameState {

  /**
   * The game controller that holds an internal state.
   */
  val context: GameController

  /**
   * Method that handles an event in the game context.
   * The implementation of this method depends on the specific state.
   */
  def handleEvent(): Unit

  /**
   * Indicates whether the current state is a chapter state.
   *
   * @return True if the state is a chapter state, false otherwise.
   */
  def isChapter: Boolean

  /**
   * Indicates whether the current state is a combat state.
   *
   * @return True if the state is a combat state, false otherwise.
   */
  def isCombat: Boolean

  /**
   * Indicates whether the current state is an end game state.
   *
   * @return True if the state is an end game state, false otherwise.
   */
  def isEndGame: Boolean

  /**
   * Indicates whether the current state is a landing panel state.
   *
   * @return True if the state is a landing panel state, false otherwise.
   */
  def isLandingPanel: Boolean

  /**
   * Indicates whether the current state is a moving state.
   *
   * @return True if the state is a moving state, false otherwise.
   */
  def isMoving: Boolean

  /**
   * Indicates whether it's the player's turn in the current state.
   *
   * @return True if it's the player's turn, false otherwise.
   */
  def isPlayerTurn: Boolean

  /**
   * Indicates whether the current state is a pre-game state.
   *
   * @return True if the state is a pre-game state, false otherwise.
   */
  def isPreGame: Boolean

  /**
   * Indicates whether the current state is a recover state.
   *
   * @return True if the state is a recover state, false otherwise.
   */
  def isRecover: Boolean

  var actual_player: Player
  var turns_count: Int
}
package cl.uchile.dcc.citric
package model


import model.states.{GameState, PreGame}
import model.units.{Player, Units}
import model.panels.{BonusPanel, DropPanel, EncounterPanel, HomePanel, NeutralPanel, NullPanel, Panel}

import scala.collection.mutable
import scala.util.Random

/**
 * Class representing the main controller for a game.
 */
class GameController {

  /**
   * The current state of the game.
   */
  var state: GameState = new PreGame(this)

  /**
   * List of players in the game.
   */
  var players: List[Player] = List.empty[Player]

  /**
   * The game board represented by the current panel.
   */
  var tablero: Panel = new NullPanel
  var pasos: Int = 0

  /**
   * A mutable queue representing the turns of game units.
   */
  private var turnsQueue: mutable.Queue[Units] = mutable.Queue.empty[Units]

  /**
   * Method to add a player character to the game.
   *
   * @param name The name of the player character.
   * @param maxHP The maximum health points of the player character.
   * @param ATK The attack stat of the player character.
   * @param DEF The defense stat of the player character.
   * @param EVA The evasion stat of the player character.
   */
  def addPlayerCharacter(name: String, maxHP: Int, ATK: Int, DEF: Int, EVA: Int): Unit = {
    players = new Player(name, maxHP, ATK, DEF, EVA) :: players
  }

  /**
   * Method to roll a six-sided dice.
   *
   * @return A random number between 1 and 6.
   */
  def rollDice(): Int = {
    val dado: Random = new Random()
    dado.nextInt(6) + 1 // +1 because it generates a number in [0,5)
  }

  /**
   * Method to set up the game board with specific panels and player home panels.
   *
   * @param player1 Player 1
   * @param player2 Player 2
   * @param player3 Player 3
   * @param player4 Player 4
   */
  def board(player1: Player, player2: Player, player3: Player, player4: Player): Unit = {
    val h1: Panel = new HomePanel(player1)
    val p1: Panel = new NeutralPanel()
    val p2: Panel = new BonusPanel()
    val h2: Panel = new HomePanel(player2)
    val p3: Panel = new DropPanel()
    val h3: Panel = new HomePanel(player3)
    val p4: Panel = new EncounterPanel()
    val h4: Panel = new HomePanel(player4)

    // Connecting the panels to form a circular board
    h1.addPanel(p1)
    p1.addPanel(p2)
    p2.addPanel(h2)
    h2.addPanel(p3)
    p3.addPanel(h3)
    h3.addPanel(p4)
    p4.addPanel(h4)
    h4.addPanel(h1)

    // Setting the initial position of the game board
    tablero = h1
  }

  /**
   * A method to start a new game with the specified player characters.
   *
   * @param playerCharacters A sequence of tuples representing player characters. Each tuple should contain:
   *                         - name: The name of the player character.
   *                         - maxHP: The maximum health points of the player character.
   *                         - atk: The attack stat of the player character.
   *                         - defend: The defense stat of the player character.
   *                         - eva: The evasion stat of the player character.
   */
  def startGame(playerCharacters: Seq[(String, Int, Int, Int, Int)]): Unit = {
    // Add each player character to the game
    for ((name, maxHP, atk, defend, eva) <- playerCharacters) {
      addPlayerCharacter(name, maxHP, atk, defend, eva)
    }

    // Set up the game board with specific panels and player home panels
    board(players(0), players(1), players(2), players(3))

    // Handle the initial events of the game state
    state.handleEvent()
  }


}

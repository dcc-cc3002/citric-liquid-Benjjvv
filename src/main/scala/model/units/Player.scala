package cl.uchile.dcc.citric
package model.units

import cl.uchile.dcc.citric.model.norma.{Norma, Norma1}
import cl.uchile.dcc.citric.model.states.{PreGame, AbstractState}


/**
 * Esta es una subclase que representa un jugador del juego.
 *
 * @param name nombre de la unidad
 * @param maxHP stat de vida, vida maxima
 * @param ATK stat de ataque
 * @param DEF stat de defensa
 * @param EVA stat de evasion
 */

class Player(name: String, maxHP: Int, ATK: Int, DEF: Int, EVA: Int) extends AbstractUnits(name, maxHP, ATK, DEF, EVA) with PlayerTrait {

  //protected var state: State = new PreGame()

  //def setState(s: State): Unit = {
    //state = s
  //}
  /**
   * Los puntos de vida actuales de la unidad.
   */
  protected var _actuallyHP: Int = maxHP

  override def actuallyHP: Int = _actuallyHP

  var objNorm: String = "STR"

  def setStarObj: Unit = {
    objNorm = "STR"
  }

  def setWinsObj(): Unit = {
    objNorm = "WIN"
  }
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
  protected var _currentNorma: Norma = new Norma1()

  def currentNorma: Norma = _currentNorma

  def currentNorma_(newNorma: Norma): Unit = {
    if (newNorma.itsOK(this)) {
      _currentNorma = newNorma
    }
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
    false
  }

  /**
   * Update unit statistics based on stars and unit type.
   *
   * This method updates the statistics of a game unit, which includes increasing the unit's star count by the
   * specified number of stars and adjusting the unit's wins based on its type. .
   *
   * @param stars An integer representing the number of stars to add to the unit's star count.
   * @param typeUnit A string specifying the type of the unit, which can be "Wild" or "Character."
   */
  def updateStats(stars: Int, typeUnit: String): Unit = {
    // Update the unit's star count by adding the specified stars
    _Stars += stars

    // Check the type of the unit and adjust wins accordingly
    if (typeUnit == "Wild") {
      // Increment wins by 1 for "Wild" type units
      Wins_(Wins + 1)
    } else if (typeUnit == "Player") {
      // Increment wins by 2 for "Character" type units
      Wins_(Wins + 2)
    }
  }
  /**
   * Provide statistics for the unit.
   *
   * @return A tuple containing the unit's statistics, where the first element is the stars divided by 2, and the
   * second element is a string representing the unit type ("Player").
   */
  def giveStats: (Int, String) = {
    // Calculate the number of stars divided by 2, and indicate that the unit is of type "Player"
    (Stars / 2, "Player")
  }

  /**
   * Set values and state for the unit during a game phase.
   *
   * It checks if the unit is knocked out (KO) and, if not, it calls the `RecoverFase` method, which is not
   * defined here, to perform phase-specific actions.
   */
  override def setValues: Unit = {
    // Check if the unit is knocked out (KO)
    isKO

    // Perform phase-specific actions using the `RecoverFase` method (not defined in this context)
    RecoverFase()
  }

}
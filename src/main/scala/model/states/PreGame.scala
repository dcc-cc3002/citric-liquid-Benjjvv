package cl.uchile.dcc.citric
package model.states

import model.GameController

class PreGame(context : GameController) extends AbstractState(context) {
  override def isPreGame: Boolean = true

  /**
   * Implementation of the handleEvent method for the PreGame.
   * Handles events that occur during a game turn.
   */
  override def handleEvent(): Unit = {
    for(player <- context.players){
      context.state = new Chapter(context)
      context.state.actual_player = player
      //context.state.handleEvent()
    }
  }

}

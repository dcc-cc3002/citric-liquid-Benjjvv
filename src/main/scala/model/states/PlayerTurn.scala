package cl.uchile.dcc.citric
package model.states

import model.GameController

class PlayerTurn(context : GameController) extends AbstractState(context) {
  override def isPlayerTurn: Boolean = true

  /**
   * Implementation of the handleEvent method for the PlayerTurn State.
   * Handles events that occur during a game turn.
   */
  override def handleEvent(): Unit = {
    context.state.turns_count+=1
    context.pasos = context.state.actual_player.numDado
    context.state = new Moving(context)
    context.state.actual_player = actual_player
   // context.state.handleEvent()
  }
  //this.handleEvent()

}

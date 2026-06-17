package cl.uchile.dcc.citric
package model.states

import model.GameController

class Recover(context : GameController) extends AbstractState(context) {
  override def isRecover: Boolean = true

  /**
   * Implementation of the handleEvent method for the Recover.
   * Handles events that occur during a game turn.
   */
  override def handleEvent(): Unit = {
    if(!context.state.actual_player.RecoverFase()){
      context.state = new Chapter(context)
    }
  }


}

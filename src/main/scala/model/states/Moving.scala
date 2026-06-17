package cl.uchile.dcc.citric
package model.states

import model.GameController

class Moving(context : GameController) extends AbstractState(context) {
  //context.state.handleEvent()
  override def isMoving: Boolean = true

  /**
   * Implementation of the handleEvent method for the MovingState.
   * Handles events that occur during a game turn.
   */
  override def handleEvent(): Unit = {
    var i=1
    while(i <= context.pasos){
      val nextPanel= context.tablero.getNextPanels(0)
      context.tablero = nextPanel
      i+=1
    }
    context.tablero.addCharacter(context.state.actual_player)
    context.state = new Combat(context)
  }
  //this.handleEvent()

}

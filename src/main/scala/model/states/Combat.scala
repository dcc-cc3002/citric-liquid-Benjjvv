package cl.uchile.dcc.citric
package model.states

import model.GameController

class Combat(context : GameController) extends AbstractState(context) {
  override def isCombat: Boolean = true

  /**
   * Implementation of the handleEvent method for the CombatState.
   * Handles events that occur during a game turn.
   */
  override def handleEvent(): Unit = {
    if(context.tablero.getPlayers.size==2){
      context.tablero.getPlayers(0).attack(context.tablero.getPlayers(1))
    }
    context.state = new LandingPanel(context)
  }
  //this.handleEvent()

}

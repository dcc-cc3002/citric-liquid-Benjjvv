package cl.uchile.dcc.citric
package model.states

import model.GameController

import cl.uchile.dcc.citric.model.norma.Norma6

class Chapter(context : GameController) extends AbstractState(context) {
  override def isChapter: Boolean = true

  /**
   * Implementation of the handleEvent method for the GameTurnState.
   * Handles events that occur during a game turn.
   */
  override def handleEvent(): Unit = {
    if(context.state.turns_count%4==0){
      for(player <- context.players){
        player.chapter_(player.chapter+1)
      }
    }
    if (actual_player.currentNorma.getLevel == 6){
      context.state = new EndGame(context)
      context.state.actual_player = actual_player
      //context.state.handleEvent()
    } else if (actual_player.isKO){
      context.state = new Recover(context)
      context.state.actual_player = actual_player
      //context.state.handleEvent()
    } else {
      context.state = new PlayerTurn(context)
      context.state.actual_player = actual_player
      //context.state.handleEvent()
    }
  }
  //this.handleEvent()

}

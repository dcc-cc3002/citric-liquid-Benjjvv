package cl.uchile.dcc.citric
package model.states

import model.GameController

class EndGame(context : GameController) extends AbstractState(context) {
  override def isEndGame: Boolean = true

  override def handleEvent(): Unit = {

  }

}

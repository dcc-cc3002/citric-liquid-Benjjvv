package cl.uchile.dcc.citric
package model.states

import model.GameController

import model.units.Player

import scala.collection.mutable.ArrayBuffer
  class LandingPanel(context : GameController) extends AbstractState(context) {
    override def isLandingPanel: Boolean = true

    /**
     * Implementation of the handleEvent method for the LandingPanelState.
     * Handles events that occur during a game turn.
     */
    override def handleEvent(): Unit = {
      context.tablero.apply(actual_player)
      context.state = new Chapter(context)
    }
    //this.handleEvent()

 }

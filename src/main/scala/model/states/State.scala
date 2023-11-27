package cl.uchile.dcc.citric
package model.states

import model.units.Player

import cl.uchile.dcc.citric.model.GameController

import scala.collection.mutable.ArrayBuffer

class State protected(val context : GameController){
  def error = throw new Exception("Wrong State")
  def  handleEvent(): Unit = error

  //protected def changeState(players:ArrayBuffer[Player], s: State): Unit = {
    //for (player <- players) {
      //player.setState(s)
    //}
  //}

  def startGame(): Unit = {
    /* ... */
  }

  def rollDice(): Unit = {
    /* ... */
  }

  def doEffect(): Unit = {
    /* ... */
  }

}

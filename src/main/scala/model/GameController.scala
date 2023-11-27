package cl.uchile.dcc.citric
package model


import cl.uchile.dcc.citric.model.states.{PreGame, State}
import cl.uchile.dcc.citric.model.units.wildunits.WildUnit
import cl.uchile.dcc.citric.model.units.{Player, PlayerTrait, Units}

import scala.::
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

class GameController {

    var state: State = new PreGame(this)
    private var playerCharacters = List.empty[PlayerTrait]

  //private var enemyCharacters = List.empty[WildUnit]
    private var turnsQueue = mutable.Queue.empty[Units]

  def addPlayerCharacter(name: String, maxHP: Int, ATK: Int, DEF: Int, EVA: Int): Unit = {
    playerCharacters = new Player(name, maxHP, ATK, DEF, EVA) :: playerCharacters
  }
  //creo que no necesito hacer un add enemy pues este spawnea de forma random en el Encounter Panel
  def startGame(playerCharacters: Seq[(String,Int,Int,Int,Int)]): Unit = {
    for ((name,maxHP,atk,defend,eva)<-playerCharacters){
      addPlayerCharacter(name,maxHP,atk,defend,eva)
    }
    state.startGame()
    /* ... */
  }

  def rollDice(): Unit = {
    /* ... */
  }

  def doEffect(): Unit = {
    /* ... */
  }


}

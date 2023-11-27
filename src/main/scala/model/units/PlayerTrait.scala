package cl.uchile.dcc.citric
package model.units

import model.norma.Norma

import cl.uchile.dcc.citric.model.states.State

trait PlayerTrait extends Units {
   def isKO: Boolean
  //protected def state: State
  protected def _chapter: Int
  protected def Wins: Int
  //protected var recovery: Boolean
  //protected var recoverval: Int
  protected def _currentNorma: Norma
  def objNorm: String

 // def setRecovery(isinrecover: Boolean): Unit

 // def getRecovery: Boolean

 // def getRecoverval: Int

  //def setRecoverval(newRecval: Int): Unit

  //def setVictories(newVicts: Int): Unit

  //def getVictories: Int

  def Stars_(newStars: Int): Unit

  def Stars: Int

  def chapter_(Chapter: Int): Unit

  def chapter: Int

  def currentNorma: Norma

  def currentNorma_(newNorma: Norma): Unit

  //def InRecover(): Unit

  //def setVictObj: Unit

  def setStarObj: Unit
}
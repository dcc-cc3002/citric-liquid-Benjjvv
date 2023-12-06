package cl.uchile.dcc.citric
package model.units

trait Units {

  def name: String
  val maxHP: Int
  var ATK: Int
  val DEF: Int
  val EVA: Int
  val numDado: Int
  var combatMode: String
  def Stars: Int

  def actuallyHP: Int
  def actuallyHP_(int: Int): Unit
  def isKO: Boolean
  def attack(units: Units): Unit
  def defend(units: Units, damage:Int): Unit
  def evade(units: Units,damage:Int): Unit

  def updateStats(stars: Int, typeUnit: String): Unit

  def setValues: Unit


  def giveStats: (Int, String)

}

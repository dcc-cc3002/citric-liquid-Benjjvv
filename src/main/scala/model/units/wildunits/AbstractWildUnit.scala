package cl.uchile.dcc.citric
package model.units.wildunits

import model.units.{AbstractUnits, Units}

abstract class AbstractWildUnit(name: String, maxHP: Int, ATK: Int, DEF: Int, EVA: Int) extends AbstractUnits(name, maxHP, ATK, DEF, EVA) with WildUnit  {

  override def setValues: Unit = {
    isKO
  }

  def updateStats(stars: Int, typeUnit: String): Unit = {
    _Stars += stars
  }

  def giveStats: (Int, String) = {
    (Stars, "Wild")
  }


}

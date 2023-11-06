package cl.uchile.dcc.citric
package model.norma

import model.units.Player

abstract class AbstractNorma(val level: Int , val starsneeded: Int , val winsneeded: Int ) extends Norma {

  def getLevel: Int = {
    level
    }

  def itsOK(player: Player): Boolean = {
    if (player.objNorm == "STR" && player.Stars >= starsneeded) {
      return true
    }
    if (player.objNorm == "WIN" && player.Wins >= winsneeded) {
      true
    } else {
      false
    }
  }


}

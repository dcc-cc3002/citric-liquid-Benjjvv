package cl.uchile.dcc.citric
package model.units.wildunits

import model.units.AbstractUnits
class Seagull() extends AbstractWildUnit("Seagull", 3, 1, -1, -1){

   protected var _actuallyHP: Int = maxHP

   override def actuallyHP: Int = _actuallyHP

   Stars_(2)

}
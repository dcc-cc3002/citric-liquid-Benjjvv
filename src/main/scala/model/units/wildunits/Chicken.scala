package cl.uchile.dcc.citric
package model.units.wildunits




class Chicken() extends AbstractWildUnit("Chicken", 3, -1, -1, 1){

  protected var _actuallyHP: Int = maxHP

  override def actuallyHP: Int = _actuallyHP

  Stars_(3)

}
package cl.uchile.dcc.citric
package model.panels
import model.units.Player


class NullPanel extends AbstractPanel with Panel{
  override def apply(player: Player): Unit = null
}

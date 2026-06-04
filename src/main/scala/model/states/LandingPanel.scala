package cl.uchile.dcc.citric
package model.states

import model.panels.Panel

import cl.uchile.dcc.citric.model.GameController
import cl.uchile.dcc.citric.model.units.Player

  class LandingPanel(context : GameController, panel: Panel) extends State(context) {
    override def handleEvent(): Unit = {
    panel.apply(panel.getPlayers)
    context.state = new Chapter(context)
    }

}

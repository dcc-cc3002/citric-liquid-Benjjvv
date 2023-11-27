package cl.uchile.dcc.citric
package model.norma

class Norma5 extends AbstractNorma(5,120,10) {
  override val NextNorma: Norma = new Norma6
}


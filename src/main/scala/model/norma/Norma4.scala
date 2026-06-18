package cl.uchile.dcc.citric
package model.norma

class Norma4 extends AbstractNorma(4,70,6) {
  override val NextNorma: Norma = new Norma5
}


package cl.uchile.dcc.citric
package model.norma

class Norma2 extends AbstractNorma(2,10,1) {
  override val NextNorma: Norma = new Norma3
}



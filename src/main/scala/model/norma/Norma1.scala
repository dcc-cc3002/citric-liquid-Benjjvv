package cl.uchile.dcc.citric
package model.norma

class Norma1 extends AbstractNorma(1,0,0) {
  override val NextNorma: Norma = new Norma2
}
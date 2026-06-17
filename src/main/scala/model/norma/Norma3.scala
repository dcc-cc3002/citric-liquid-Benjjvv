package cl.uchile.dcc.citric
package model.norma

class Norma3 extends AbstractNorma(3,30,3) {
  override val NextNorma: Norma = new Norma4
}


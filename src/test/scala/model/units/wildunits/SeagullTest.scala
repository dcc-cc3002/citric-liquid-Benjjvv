package cl.uchile.dcc.citric
package model.units.wildunits

import munit._

class SeagullTest extends FunSuite {

  val seagull = new Seagull()

  test("A Seagull should have a name and this name is 'Seagull' ") {
    assertEquals(seagull.name, "Seagull")
    assertNotEquals(seagull.name, "Pepito")
  }


  test("A Seagull should have a maximum HP of 3") {
    assertEquals(seagull.maxHP, 3)
  }

  test("A Seagull should have an ATK of -1") {
    assertEquals(seagull.ATK, 1)
  }

  test("A Seagull should have a DEF of -1") {
    assertEquals(seagull.DEF, -1)
  }

  test("A Seagull should have an EVA of 1") {
    assertEquals(seagull.EVA, -1)
  }

  test("A Seagull should initially have its actual HP equal to max HP") {
    assertEquals(seagull.actuallyHP, seagull.maxHP)
  }

  test("A Seagull should initially not be KO") {
    assertEquals(seagull.isKO, false)
  }

  test("A Seagull should become KO when its actual HP reaches 0") {
    seagull.actuallyHP_(0)
    assertEquals(seagull.isKO, true)
  }

  test("A Seagull should not be KO when its actual HP is greater than 0") {
    seagull.actuallyHP_(2)
    assertEquals(seagull.isKO, false)
  }
}

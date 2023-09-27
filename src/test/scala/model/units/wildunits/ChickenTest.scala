package cl.uchile.dcc.citric
package model.units.wildunits

import munit._

class ChickenTest extends FunSuite {

  val chicken = new Chicken()

  test("A Chicken should have a name and this name is 'Chicken'") {
    assertEquals(chicken.name, "Chicken")
    assertNotEquals(chicken.name, "Pepito")
  }

  test("A Chicken should have a maximum HP of 3") {
    assertEquals(chicken.maxHP, 3)
  }

  test("A Chicken should have an ATK of -1") {
    assertEquals(chicken.ATK, -1)
  }

  test("A Chicken should have a DEF of -1") {
    assertEquals(chicken.DEF, -1)
  }

  test("A Chicken should have an EVA of 1") {
    assertEquals(chicken.EVA, 1)
  }

  test("A Chicken should initially have its actual HP equal to max HP") {
    assertEquals(chicken.actuallyHP, chicken.maxHP)
  }

  test("A Chicken should initially not be KO") {
    assertEquals(chicken.isKO(), false)
  }

  test("A Chicken should become KO when its actual HP reaches 0") {
    chicken.actuallyHP = 0
    assertEquals(chicken.isKO(), true)
  }

  test("A Chicken should not be KO when its actual HP is greater than 0") {
    chicken.actuallyHP = 2
    assertEquals(chicken.isKO(), false)
  }
}

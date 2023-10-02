package cl.uchile.dcc.citric
package model.units.wildunits

import munit._

class RoboBallTest extends FunSuite {

  val roboball = new RoboBall()

  test("A RoboBall should have a name and this name is 'Robo Ball") {
    assertEquals(roboball.name, "Robo Ball")
    assertNotEquals(roboball.name, "Pepito")
  }

  test("A RoboBall should have a maximum HP of 3") {
    assertEquals(roboball.maxHP, 3)
  }

  test("A RoboBall should have an ATK of -1") {
    assertEquals(roboball.ATK, -1)
  }

  test("A RoboBall should have a DEF of -1") {
    assertEquals(roboball.DEF, 1)
  }

  test("A RoboBall should have an EVA of 1") {
    assertEquals(roboball.EVA, -1)
  }

  test("A RoboBall should initially have its actual HP equal to max HP") {
    assertEquals(roboball.actuallyHP, roboball.maxHP)
  }

  test("A RoboBall should initially not be KO") {
    assertEquals(roboball.isKO(), false)
  }

  test("A RoboBall should become KO when its actual HP reaches 0") {
    roboball.actuallyHP_(0)
    assertEquals(roboball.isKO(), true)
  }

  test("A RoboBall should not be KO when its actual HP is greater than 0") {
    roboball.actuallyHP_(2)
    assertEquals(roboball.isKO(), false)
  }
}

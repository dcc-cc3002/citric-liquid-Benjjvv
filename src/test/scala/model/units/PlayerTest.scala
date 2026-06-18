package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class PlayerTest extends munit.FunSuite {
  /**
   * constantes para realizar el test
   */
  private val name = "Benja"
  private val maxHp = 10
  private val ATK = 5
  private val DEF = 5
  private val EVA = 5

  private var player: Player = _

  // This method is executed before each `test(...)` method.
  override def beforeEach(context: BeforeEach): Unit = {
    player = new Player(
      name,
      maxHp,
      ATK,
      DEF,
      EVA,
    )
  }

  test("A player should have correctly set their attributes") {
    assertEquals(player.name, name)
    assertEquals(player.actuallyHP, maxHp)
    assertEquals(player.ATK, ATK)
    assertEquals(player.DEF, DEF)
    assertEquals(player.EVA, EVA)
  }

  test("A player have intial Stars "){
    assertEquals(player.Stars, (player.chapter/5) +1)
  }
  test("A player have start in Norma 1 ") {
    assertEquals(player.currentNorma, 1)
  }
  test("A player have intial Wins=0 ") {
    assertEquals(player.Wins, 0)
  }
  test("A player start with 6 recoveryVal") {
    assertEquals(player.recoveryVal, 6)
  }
  test("A player starts without be KO") {
    assertEquals(player.KO, false)
  }
  test("A player can roll a dice"){
    assert(player.numDado >= 1 && player.numDado <= 6)
  }
  test("A player should become KO when its actual HP reaches 0") {
    player.actuallyHP_(0)
    assertEquals(player.isKO(), true)
  }
  test("A player should be in recoverFase") {
    player.actuallyHP_(0)
    player.recoveryVal = 10
    assertEquals(player.RecoverFase(), true)
  }
  test("A player should not be in recoverFase") {
    player.actuallyHP_(0)
    player.recoveryVal = 0
    assertEquals(player.RecoverFase(), false)
  }


}

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

  test("A player have intial Stars ") {
    assertEquals(player.Stars, (player.chapter / 5) + 1)
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
  test("A player can roll a dice") {
    assert(player.numDado >= 1 && player.numDado <= 6)
  }
  test("A player should become KO when its actual HP reaches 0") {
    player.actuallyHP_(0)
    assertEquals(player.isKO, true)
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
  test("A player can attack other player") {
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    val player2 = new Player("Player 2", 10, 2, 2, 2)
    player1.attack(player2)
    //println(player2.actuallyHP) veo con prints si baja la vida de forma distinta por el dado
    assert(player2.actuallyHP < player2.maxHP)
  }
  test("A player can defend from other player") {
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    val player2 = new Player("Player 2", 10, 2, 2, 2)
    player1.defend(player2)
    //println(player1.actuallyHP) //veo con prints si baja la vida de forma distinta por el dado
    assert(player1.actuallyHP < player1.maxHP)
  }
  test("A player can evade an attack from other player") {
    val player1 = new Player("Player 1", 10, 2, 2, 100)
    val player2 = new Player("Player 2", 10, 1, 2, 2)
    player1.evade(player2)
    //println(player1.actuallyHP) //veo con prints si baja la vida de forma distinta por el dado
    assertEquals(player1.actuallyHP, player1.maxHP)
  }
  test("A player can not evade an attack from other player") {
    val player1 = new Player("Player 1", 10, 2, 2, 1)
    val player2 = new Player("Player 2", 10, 100, 2, 2)
    player1.evade(player2)
    //println(player1.actuallyHP) //veo con prints si baja la vida de forma distinta por el dado
    assertNotEquals(player1.actuallyHP, player1.maxHP)
  }
  test("A KO player can´t attack other player") {
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    val player2 = new Player("Player 2", 10, 2, 2, 2)
    player1.actuallyHP_(0)
    player1.attack(player2)
    assertEquals(player2.actuallyHP, player2.maxHP)
  }
  test("A KO player can´t defend other player") {
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    val player2 = new Player("Player 2", 10, 2, 2, 2)
    player1.actuallyHP_(0)
    player1.defend(player2)
    assertEquals(player1.actuallyHP, 0)
  }
  test("A KO player can´t evade other player") {
    val player1 = new Player("Player 1", 10, 2, 2, 2)
    val player2 = new Player("Player 2", 10, 2, 2, 2)
    player1.actuallyHP_(0)
    player1.evade(player2)
    assertEquals(player2.actuallyHP, player2.maxHP)
  }
}

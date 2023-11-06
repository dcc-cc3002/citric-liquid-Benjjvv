package cl.uchile.dcc.citric
package model.norma

import model.units.Player


class NormaTest extends munit.FunSuite {
  test("Norma should return true if player meets stars requirement") {
    val player = new Player("TestPlayer", maxHP = 10, ATK = 1, DEF = 1, EVA = 1)
    player.Stars_(15)

    // Crear una instancia de Norma con requisitos de estrellas
    val norma = new Norma2
    player.setStarObj

    // Verificar si el jugador cumple con la norma
    val result = norma.itsOK(player)

    // Assert: Debería ser verdadero, ya que el jugador cumple con los requisitos de estrellas
    assert(result)
  }

  test("Norma should return true if player meets victories requirement") {
    // Crear un jugador ficticio con ciertas victorias
    val player = new Player("TestPlayer", maxHP = 10, ATK = 1, DEF = 1, EVA = 1)
    player.Wins_(2)

    // Crear una instancia de Norma con requisitos de victorias
    val norma = new Norma2
    player.setWinsObj

    // Verificar si el jugador cumple con la norma
    val result = norma.itsOK(player)

    // Assert: Debería ser verdadero, ya que el jugador cumple con los requisitos de victorias
    assert(result)
  }

  test("Norma should return false if player doesn't meet requirements") {
    // Crear un jugador ficticio que no cumple con los requisitos
    val player = new Player("TestPlayer", maxHP = 10, ATK = 1, DEF = 1, EVA = 1)
    player.Stars_(5)
    player.Wins_(1)
    // Crear una instancia de Norma con requisitos de estrellas y victorias
    val norma = new Norma3

    // Verificar si el jugador cumple con la norma
    val result = norma.itsOK(player)

    assert(!result)
  }

}

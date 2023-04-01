package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    Player player1 = new Player(1, "Katya", 100);
    Player player2 = new Player(2, "Petya", 20);
    Player player3 = new Player(3, "Kolya", 80);
    Player player4 = new Player(4, "Sasha", 80);

    Game players = new Game();


    @BeforeEach
    public void createData() {
        players.register(player1);
        players.register(player2);
        players.register(player3);
        players.register(player4);
    }


    @Test
    public void whoIsTheWinner1() {
        int expected = 1;
        int actual = players.round("Katya", "Petya");

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void whoIsTheWinner2() {
        int expected = 2;
        int actual = players.round("Petya", "Kolya");

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void whoIsTheWinner0() {
        int expected = 0;
        int actual = players.round("Kolya", "Sasha");

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void unregisteredPlayer1() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Masha", "Sasha");
        });
    }


    @Test
    public void unregisteredPlayer2() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Sasha", "Ira");
        });
    }


    @Test
    public void unregisteredPlayers() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            players.round("Masha", "Ira");
        });
    }
}
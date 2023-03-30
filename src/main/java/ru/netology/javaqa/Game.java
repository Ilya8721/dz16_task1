package ru.netology.javaqa;

import java.util.ArrayList;

public class Game {
    ArrayList<String> registeredPlayers = new ArrayList<>();
    private Player[] players = new Player[0];

    private Player[] addToArray(Player[] current, Player newplayer) {
        Player[] tmp = new Player[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = newplayer;
        return tmp;
    }

    public void add(Player newplayer) {
        players = addToArray(players, newplayer);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public void register(Player player) {
        registeredPlayers.add(player.getName());
    }

    public int round(String playerName1, String playerName2) {
        Player findByName1 = findByName(playerName1);
        Player findByName2 = findByName(playerName2);
        Boolean player1Registered = registeredPlayers.contains(playerName1);
        Boolean player2Registered = registeredPlayers.contains(playerName2);
        int result;

        if (findByName1 == null || findByName2 == null) {
            throw new NotRegisteredException("Unregistered player(s)");
        }

        if (player1Registered && player2Registered) {
            if (findByName1.getStrength() > findByName2.getStrength()) {
                result = 1;
            } else if (findByName1.getStrength() < findByName2.getStrength()) {
                result = 2;
            } else {
                result = 0;
            }
        } else {
            throw new NotRegisteredException("Unregistered player(s)");
        }
        return result;
    }
}

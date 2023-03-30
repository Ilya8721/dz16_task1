package ru.netology.javaqa;

import java.util.HashMap;

public class Game {
    HashMap<String, String> registeredPlayers = new HashMap<>();
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

    public void register(Player player, String status) {
        registeredPlayers.put(player.getName(), status);
    }

    public int round(String playerName1, String playerName2) {
        Player findByName1 = findByName(playerName1);
        Player findByName2 = findByName(playerName2);
        int result;

        if (findByName1 == null || findByName2 == null) {
            throw new NotRegisteredException("Unregistered player(s)");
        }

        if (registeredPlayers.get(playerName1).equals("Registered") && registeredPlayers.get(playerName2).equals("Registered")) {
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

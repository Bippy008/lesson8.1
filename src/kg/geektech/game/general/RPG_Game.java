package kg.geektech.game.general;

import kg.geektech.game.players.*;
import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(1000, 50, "Thanos");
        Warrior warrior = new Warrior(270, 15, "Captain America");
        Medic doc = new Medic(250, 5, 15, "Aibolit");
        Magician magician = new Magician(260, 20,"Harry Potter");
        Berserk berserk = new Berserk(290, 25, "Hulk");
        Medic assistant = new Medic(280, 10, 5, "Hermione");
        Witcher witcher = new Witcher(250, "Geralt");
        Hacker hacker = new Hacker(230, 15, "Blob");
        Thor thor = new Thor(260, 10, "Thor");
        Hero[] heroes = {warrior, doc, magician, berserk, assistant, witcher, hacker, thor};
        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        roundNumber++;
        bossHits(boss, heroes);
        heroesHits(boss, heroes);
        heroesApplySuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
    }


    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println(roundNumber + " ROUND ______________________");
        System.out.println(boss.getName().toUpperCase() + " Boss health: " + boss.getHealth() + " [" +
                boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName().toUpperCase() + " health: " + heroes[i].getHealth() + " [" +
                    heroes[i].getDamage() + "]");
        }
    }

    private static void heroesApplySuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println(boss.getName() + " won!!!");
        }
        return allHeroesDead;
    }

    public static int getRoundNumber() {
        return roundNumber;
    }
}

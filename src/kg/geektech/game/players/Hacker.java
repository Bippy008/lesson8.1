package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Hacker extends Hero{

    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperAbility.TRANSFIGURING_HEALTH, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (RPG_Game.getRoundNumber() % 2 == 0) {
            int healthTaking = 10;
            int number = RPG_Game.random.nextInt(heroes.length) + 1; // выбирает рандомного героя
            if (heroes[number].getHealth() > 0 && heroes[number] != this) { // И отдает ему здоровье если он не мертв и он не hacker
                boss.setHealth(boss.getHealth() - healthTaking);
                heroes[number].setHealth(heroes[number].getHealth() + healthTaking);
                System.out.println(this.getName() + " отобрал 10 здоровья у босса и отдал  " + heroes[number].getName());
            }
        }
    }
}

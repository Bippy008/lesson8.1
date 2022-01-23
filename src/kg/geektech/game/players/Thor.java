package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero{

    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.STUN, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int number = RPG_Game.random.nextInt(10) + 1;
        if (number == 9 || number == 10) { // 20 процентный шанс оглушить босса
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() + boss.getDamage());
                }
            }
            System.out.println(this.getName() + " оглушил босса на этом раунде раунде.");
        }
    }
}

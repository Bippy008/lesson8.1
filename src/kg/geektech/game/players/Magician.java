package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Magician extends Hero{

    public Magician(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int number = RPG_Game.random.nextInt(3) + 1;
        for (int i = 0; i < heroes.length; i++) {
            if(heroes[i].getHealth() > 0 && heroes[i] != this) {
                heroes[i].setDamage(heroes[i].getDamage() + number);
            }
        }
    }
}

package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero{
    private int saveDamage;

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int number = RPG_Game.random.nextInt(6) + 5;
        saveDamage = boss.getDamage()/number;
        if (boss.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - saveDamage);
        }
    }
}

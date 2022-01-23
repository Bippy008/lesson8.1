package kg.geektech.game.players;

public class Witcher extends Hero{
    private boolean isDead = false;

    public Witcher(int health, String name) {
        super(health, 0, SuperAbility.RESURRECT, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <= 0 && heroes[i] != this) {
                heroes[i].setHealth(200); // воскрешает с уровнем здоровья 200
                this.setHealth(0);
                System.out.println(getName() + " воскресил " + heroes[i].getName());
                break;
            }
        }
    }
}

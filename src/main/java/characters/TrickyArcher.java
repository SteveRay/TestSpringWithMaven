package characters;

import annotations.AddToRandom;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

@AddToRandom
public class TrickyArcher extends Character {

    public TrickyArcher() {
        super(9, 2);
    }

    @Override
    public void kick(Character c) {
        System.out.println("Right on the target!");
        final int val = ThreadLocalRandom.current().nextInt(1, super.getPower() + 1);
        System.out.println(this.name + " нанес " + val + " урона " + c.name);
        Map<DamageType, Integer> damage =  new HashMap<>();
        damage.put(DamageType.HP, val);
        c.takeDamage(this, damage);
    }

    @Override
    public void takeDamage(Character from, Map<DamageType, Integer> dmg) {
        if (ThreadLocalRandom.current().nextBoolean()) {
            System.out.println(this.name + ": few...you missed!");
        } else {
            super.takeDamage(from, dmg);
        }
    }
}
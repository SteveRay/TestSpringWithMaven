package characters;


import annotations.AddToRandom;

import java.util.HashMap;
import java.util.Map;

@AddToRandom
public class Orc extends Character {

    public Orc() {
        super.setPower(5);
        super.setHp(8);
    }

    @Override
    public void kick(Character c) {
        Map<DamageType, Integer> damage =  new HashMap<DamageType, Integer>();
        if (c instanceof Eared) {
            System.out.println("Yeess, i will crush your small tiny head, eared elf");
            System.out.println(this.getClass().getSimpleName() + " нанес " + getPower() * 2 + " урона "+ c.getClass().getSimpleName());
            damage.put(DamageType.HP, getPower() * 2);
            c.takeDamage(this, damage);
        } else {
            System.out.println("braAAaghhh!!");
            System.out.println(this.getClass().getSimpleName() + " нанес " + getPower() + " урона "+ c.getClass().getSimpleName());
            damage.put(DamageType.HP, getPower());
            c.takeDamage(this, damage);
        }
    }
}

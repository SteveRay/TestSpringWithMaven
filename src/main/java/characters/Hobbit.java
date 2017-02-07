package characters;

import annotations.AddToRandom;

@AddToRandom
public class Hobbit extends Character {

    public Hobbit() {
        super.setPower(0);
        super.setHp(3);
    }

    public void kick(Character c) {
        toCry();
        System.out.println(this.getClass().getSimpleName() + " нанес 0 урона " + c.getClass().getSimpleName());
    }

    private void toCry() {
        System.out.println(this.getClass().getSimpleName() + ":..mr frooudoouu weep, wee-ep");
    }
}
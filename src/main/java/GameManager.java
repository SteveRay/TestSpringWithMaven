import model.characters.Character;

import java.io.File;

public class GameManager {

    public static void main(String[] args) {
        ClassInstanceFactory factory = new ClassInstanceFactory(new File(System.getProperty("user.dir") + "/target/classes/",
                "model/characters/"));
        Character c1 = factory.buildRandomInstance(Character.class);
        Character c2 = factory.buildRandomInstance(Character.class);
        fight(c1, c2);
    }

    // TODO: static fight method should be replaced with specialized fight simulator
    private static void fight(Character c1, Character c2) {
        System.out.println("Начало боя:");
        logStatus(c1, c2);
        while (c1.isAlive() && c2.isAlive()) {
            // расчет урона
            c1.kick(c2);
            c2.kick(c1);
            // сохраняем изменения
            c1.applyChanges();
            c2.applyChanges();

            logStatus(c1, c2);

            if (c1.getPower() == 0 && c2.getPower() == 0) {
                System.out.println("Воины упорно сражались до самой ночи, но никто так и не смог победить... ничья!");
                break;
            }
        }
    }

    // TODO: replace with specialized logger + wrap into log formatter
    private static void logStatus(Character c1, Character c2) {
        System.out.println("==========================================");
        System.out.println(c1.name + " статус: " + c1.getHp() + " hp, " + c1.getPower() + " pwr.");
        System.out.println(c2.name + " статус: " + c2.getHp() + " hp, " + c2.getPower() + " pwr.");
        System.out.println("------------------------------------------");
    }
}
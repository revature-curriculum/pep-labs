public class SuperHero {
    String ability;
    String superName;
    int health;

    

    public void introduce(){
        System.out.println("Never fear, " + superName + " is here!");
    }


    public int takeDamage(){
        health = health - 10;
        return health;
    }
}

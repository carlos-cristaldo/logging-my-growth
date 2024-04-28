package org.example.model;

public class MonsterModel {

    private final Integer id;
    private final String name;
    private final String hp;
    private final String attack;
    private final String defense;
    private final String speed;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHp() {
        return hp;
    }

    public String getAttack() {
        return attack;
    }

    public String getDefense() {
        return defense;
    }

    public String getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "MonsterModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hp='" + hp + '\'' +
                ", attack='" + attack + '\'' +
                ", defense='" + defense + '\'' +
                ", speed='" + speed + '\'' +
                '}';
    }

    private MonsterModel(MonsterBuilder builder){
        this.id=builder.id;
        this.name=builder.name;
        this.hp=builder.hp;
        this.attack= builder.attack;
        this.defense= builder.defense;
        this.speed= builder.speed;
    }
   public static class MonsterBuilder{

       private final Integer id;
       private final String name;
       private final String hp;
       private final String attack;
       private final String defense;
       private final String speed;

       public MonsterBuilder(Integer id, String name, String hp, String attack, String defense, String speed) {
           this.id = id;
           this.name = name;
           this.hp = hp;
           this.attack = attack;
           this.defense = defense;
           this.speed = speed;
       }

       public MonsterModel build(){
           return new MonsterModel(this);
       }
   }
}

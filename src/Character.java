public abstract class Character implements Fighter {
    private String name;  //имя персонажа
    private int health;  //очки здоровья
    private int gold; //золото
    private int dexterity; //ловкость
    private int xp; //опыт
    private int power; //сила

    //конструктор
    public Character(String name, int health, int gold, int dexterity, int xp, int power) {
        this.name = name;
        this.health = health;
        this.gold = gold;
        this.dexterity = dexterity;
        this.xp = xp;
        this.power = power;
    }

    // Метод ведения боя
    @Override
    public int attack() {
        if (dexterity * 3 > getRandomValue()) {
            if(Math.random()>0.7) {return power*2;} //попытка реализации рандомного удара х2
            else {return power;}
        } else return 0;
    }
// метод рандомайзера для удара
    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    //геттеры
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getGold() {
        return gold;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getXp() {
        return xp;
    }

    public int getPower() {
        return power;
    }
    //сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setPower(int power) {
        this.power = power;
    }


}

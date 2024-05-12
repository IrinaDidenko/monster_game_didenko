

public class Battle {
    public void fight(Player player, Monster monster, Realm.FightCallBack fightCallback) {
        Runnable runnable = () -> {
            int turn = 1;
            boolean isFightIsOver = false;
            while (!isFightIsOver) {
                System.out.println("Ход №" + turn);
                if (turn++ % 2 != 0) //если ход нечетный то бьет монстр
                {
                    isFightIsOver = makeHit(monster, player, fightCallback);
                } else {
                    isFightIsOver = makeHit(player, monster, fightCallback);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        Thread thread=new Thread(runnable);
        thread.start();
    }

    private Boolean makeHit(Character attacker, Character deffender, Realm.FightCallBack fightCallBack){
        int hit = attacker.attack();
        int deffenderHealth = deffender.getHealth() - hit;
        if (hit!=0) {
            System.out.println(String.format("%s нанес удар в %d единиц!", attacker.getName(), hit));
            System.out.println(String.format("У %s осталось %d едмниц здоровья", deffender.getName(), deffenderHealth));
        } else {
            System.out.println(String.format("%s промахнулся", attacker.getName()));
        }
        if(deffenderHealth<=0 && deffender instanceof Player){
            System.out.println("Вы достойно защищались, но пали в бою! Игра окончена!");
            fightCallBack.fightLost();
            return true;
        }
        else if(deffenderHealth<=0){
            System.out.println(String.format("Враг повержен! %s получает %d опыта  и %d золота", attacker.getName(), deffender.getXp(), deffender.getGold()));
            attacker.setGold(attacker.getGold()+deffender.getGold());
            attacker.setXp(attacker.getXp()+deffender.getXp());
            fightCallBack.fightWin();
            return true;
        }
        else {deffender.setHealth(deffenderHealth);
        return false;}
    }
}

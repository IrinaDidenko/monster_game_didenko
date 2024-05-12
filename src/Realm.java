import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Realm {
    private static BufferedReader buff;
    private static Player player = null;
    private static Battle battle = null;

    private static Merchant merchant;

    public static void main(String[] args) {
        buff = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();
        System.out.println("Введите имя персонажа:");
        try {
            gameControl(buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void gameControl(String string) throws IOException {
        if (player == null) {
            player = new Player(string, 100, 20, 20, 0, 0);
            System.out.println(String.format("Приветствую тебя, %s! Желаю тебе удачи на твоем нелегком пути!",
                    player.getName()));
            printNavigation();}
            switch (string) {
                case "1":
                    merchant.sell(Merchant.Goods.POTION, player);
                    break;
                case "2":
                    commitFight();
                    break;
                case "3":
                    System.exit(1);
                    break;
                case "да":
                    gameControl("2");
                    break;
                case "нет": {
                    printNavigation();
                    gameControl(buff.readLine());
                }
            }
            gameControl(buff.readLine());
        }


        public static void printNavigation () {
            System.out.println("Куда отправишься ты, путник?");
            System.out.println("1. К торговцу");
            System.out.println("2. В темный лес");
            System.out.println("3. Выход из игры");
        }

        private static Monster createMonster () {
            if (Math.random() >= 0.5) {
                return new Monster("Гоблин", 50, 10, 10, 100, 20);
            } else {
                return new Monster("Скелет", 25, 20, 20, 100, 10);
            }
        }

        private static void commitFight () {
            battle.fight(player, createMonster(),
                    new FightCallBack() {
                        @Override
                        public void fightWin() {
                            System.out.println(String.format("%s победил! Теперь у вас %d опыта, %d золота. Осталось %d единиц здоровья",
                                    player.getName(), player.getXp(), player.getGold(), player.getHealth()));
                            System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)?");
                            try {
                                gameControl(buff.readLine());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void fightLost() {
                            System.out.println(String.format("%s потерпел поражение.", player.getName()));
                        }
                    }
            );
        }

        interface FightCallBack {
            void fightWin();

            void fightLost();
        }

    }

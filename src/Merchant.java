public class Merchant implements Seller{

    @Override
    public String sell(Merchant.Goods goods, Player player) {
        String sellResult="";
        if(goods==Goods.POTION)
        { if (player.getGold()>=20)  { player.setGold(player.getGold()-20); sellResult=  "potion";}}
        else {sellResult="У вас недостаточно золота для покупки зелья";}
    return sellResult;
    }
    public enum Goods {  //это нужно чтобы можно было добавить товары,
                         // если мне захочется расширить арсенал Мерчанта?
        POTION
    }
}

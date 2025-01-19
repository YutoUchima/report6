package jp.ac.uryukyu.ie.e245756_e245759;

import java.util.List;
import java.util.Scanner;

public class DoubleUp {  
    private Scanner scanner = new Scanner(System.in);

    public int doubleUp(int magnification){
        System.out.println("ダブルアップチャレンジに挑戦しますか？(1:はい/2:いいえ)");
        int input = scanner.nextInt();
        if (input == 1){
            System.out.println("新たに山札を配ります");
            //手札を引くメソッドをHand_0ut_Cardsクラス呼び出す
            HandOutCards handoutcards = new HandOutCards();
            int Draw = 5; //手札を引く回数
            List<Integer> secoundcards = handoutcards.getRandomCards(Draw); //cardsは手札を入れるためのリスト
            System.out.println("手札:" + "[" + secoundcards.get(0) + " ,1枚目 ,2枚目 ,3枚目 ,4枚目]");
            DoubleUp doubleUp = new DoubleUp();
            int cardnumber = doubleUp.chooseCard(secoundcards);
            if (secoundcards.get(0) < secoundcards.get(cardnumber)){
                magnification *= 2;
                System.out.println("チャレンジ成功!!倍率が2倍になった!");
                magnification = doubleUp.doubleUp(magnification);
            } else{
                magnification = 0;
                System.out.println("チャレンジ失敗。。。報酬を失った。");
                return magnification;
            }
        }
        return magnification;
    }

    public int chooseCard(List<Integer> cards){
        int cardnumber = -1; //絶対に使わない数字を入力
        while(true){
            System.out.println("どのカードをめくりますか？(1:1枚目, 2:2枚目, 3:3枚目, 4:4枚目)");
            cardnumber = scanner.nextInt();
            if(cardnumber == 1){
                System.out.println(cards.get(1) + "が出た");
                return 1;
            } else if(cardnumber == 2){
                System.out.println(cards.get(2) + "が出た");
                return 2;
            } else if(cardnumber == 3){
                System.out.println(cards.get(3) + "が出た");
                return 3;
            } else if(cardnumber == 4){
                System.out.println(cards.get(4) + "が出た");
                return 4;
            } else{
                System.out.println("無効なワードです。もう一度カードを指定してください");  
            }
        }
    }
}

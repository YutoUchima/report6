package jp.ac.uryukyu.ie.e245756_e245759;

import java.util.List;
import java.util.Scanner;

/*
 * ダブルアップチャレンジを実装するクラス
 * ダブルアップチャレンジに挑戦するかを聞く
 * 掛け金の倍率計算
 * 手札からどのカードをめくるかを選択する
 */
public class DoubleUp {  
    /*
     * スキャナーでの入力をクラス内で保持する
     */
    private Scanner scanner = new Scanner(System.in);

    /*
     * ダブルアップチャレンジに挑戦するかどうか決め、倍率を計算してくれるメソッド
     *
     * @param magnification 一つ前の動作で揃った役の倍率
     * @return チャレンジ後の倍率
     */
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

    /*
     * ダブルアップチャレンジで手札からどのカードをめくるかを決めるメソッド
     *
     * @param cards 新たに山札から引かれ、与えられた手札
     * @return 選択したカードの位置(1~4)
     */
    public int chooseCard(List<Integer> cards){
        while(true){
            System.out.println("どのカードをめくりますか？(1:1枚目, 2:2枚目, 3:3枚目, 4:4枚目)");
            int cardnumber = scanner.nextInt();
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

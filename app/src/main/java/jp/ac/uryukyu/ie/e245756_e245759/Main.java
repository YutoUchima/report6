package jp.ac.uryukyu.ie.e245756_e245759;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int playerMoney = 1000;  // 初期金額（最初の所持金）
        int goalMoney = 5000;  // ゲームのクリア条件（目標金額）
        //ゲームスタート　目標金額より所持金が少ない間動き続ける
        while (playerMoney < goalMoney) {
            if(playerMoney >0){
                System.out.println("現在の所持金: " + playerMoney + " 円");
                Scanner scanner = new Scanner(System.in);  // Scannerを使って掛け金を入力させる

                // ゲーム開始時の掛け金入力    
                int bet = -1;
                while (bet <= 0 || bet > playerMoney) {
                    System.out.print("掛け金を入力してください: ");
                    bet = scanner.nextInt(); // ユーザーから掛け金を入力してもらう
                    // 所持金以上の掛け金は許可しない
                    if (bet <= 0) {
                        System.out.println("掛け金は正の数で入力してください。");
                    } else if (bet > playerMoney) {
                        System.out.println("掛け金は所持金 " + playerMoney + " 円以下にしてください。");
                    }
                }

                HandOutCards cards = new HandOutCards();  // Deckクラスのインスタンスを生成
                List<Integer> hand = cards.getRandomCards(5);  // 山札から5枚引く

                CheckCards checkCards = new CheckCards();  // PokerHands クラスのインスタンスを作成
                List<Integer> sortedCards = checkCards.sortCards(hand);  // checkCards メソッドで手札を並び替える
                System.out.println("手札: " + sortedCards);                

                ReplaceCards swapCards = new ReplaceCards();  //カード入れ替えのメソッドをSwap_Cardsから呼び出す
                swapCards.replaceCards(cards, sortedCards);

                System.out.println("入れ替え後の手札: " + cards);   //checkCards メソッドで手札を入れ替える

                List<Integer> sortedCards2 = checkCards.sortCards(sortedCards);  // checkCards メソッドで手札を並び替える
                System.out.println("手札: " + sortedCards2);

                String result = checkCards.checkCards(sortedCards);  // 役を判定
                System.out.println("役: " + result);  
                
                Calculation calc = new Calculation();  // Calculation クラスのインスタンスを作成

                int magnification = calc.getReward(result);  // 役に応じた倍率を取得
                // 役に応じて所持金を更新
                if(result.equals("役なし")){
                    playerMoney -= bet;
                }else{
                    playerMoney += bet * magnification;
                }
                System.out.println("掛け金: " + bet + " 円 X " + magnification + " 倍");
            }else{
                break;
            }
        }
        if(playerMoney >= goalMoney){
            System.out.println("所持金: " + playerMoney);
            System.out.println("ゲームクリア！！");
        }else{
            System.out.println("所持金: " + playerMoney);
            System.out.println("ゲームオーバー");
        }
    }
}


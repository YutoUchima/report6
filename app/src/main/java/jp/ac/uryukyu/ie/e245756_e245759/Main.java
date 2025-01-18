package jp.ac.uryukyu.ie.e245756_e245759;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int playerMoney = 1000;  // 初期金額（最初の所持金）
        int goalMoney = 5000;  // ゲームのクリア条件（目標金額）
        //ゲームスタート　目標金額より所持金が少ない間動き続ける
        while (playerMoney < goalMoney) {
            if(playerMoney >0){
                System.out.println("現在の所持金: " + playerMoney + " 円");
                BetMoney betMoney = new BetMoney(); // BetManager のインスタンスを生成
                int bet = betMoney.getBet(playerMoney); // BetManager を使って掛け金を入力

                playerMoney -= bet; //所持金から掛け金を引く

                HandOutCards cards = new HandOutCards();  // HandOutCardsクラスのインスタンスを生成
                List<Integer> hand = cards.getRandomCards(5);  // 山札から5枚引く

                CheckCards checkCards = new CheckCards();  // CheckCards クラスのインスタンスを作成
                List<Integer> sortedCards = checkCards.sortCards(hand);  // checkCards メソッドで手札を並び替える
                System.out.println("手札: " + sortedCards);                

                ReplaceCards replaceCards = new ReplaceCards();  //カード入れ替えのメソッドをReplaceCardsから呼び出す
                replaceCards.replaceCards(cards, sortedCards);
                List<Integer> sortedCards2 = checkCards.sortCards(sortedCards);  // checkCards メソッドで手札を並び替える
                System.out.println("手札: " + sortedCards2);

                String result = checkCards.checkCards(sortedCards2);  // 役を判定
                System.out.println("役: " + result);  
                
                Calculation calc = new Calculation();  // Calculation クラスのインスタンスを作成

                int magnification = calc.getReward(result);  // 役に応じた倍率を取得

                // 役に応じて所持金を更新
                if(result.equals("役なし")){
                    System.out.println("掛け金: " + bet + " 円 X " + magnification + " 倍");
                }else{
                    DoubleUp doubleUp = new DoubleUp();//doubleUpクラスのインスタンスを作成
                    magnification = doubleUp.doubleUp(magnification);
                    playerMoney += bet * magnification;//報酬を所持金に追加する
                    System.out.println("掛け金: " + bet + " 円 X " + magnification + " 倍");
                }
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


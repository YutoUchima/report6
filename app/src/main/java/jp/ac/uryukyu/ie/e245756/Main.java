package jp.ac.uryukyu.ie.e245756;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 初期金額（最初の所持金）
        int playerMoney = 1000;

        // ゲームのクリア条件（目標金額）
        int goalMoney = 5000;

        while (playerMoney < goalMoney) {
            if(playerMoney >0){
                System.out.println("現在の所持金: " + playerMoney + " 円");
                // Scannerを使って掛け金を入力させる
                Scanner scanner = new Scanner(System.in);

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

        
                // Deckクラスのインスタンスを生成
                HandOutCards cards = new HandOutCards();

                // 山札から5枚引く
                List<Integer> hand = cards.getRandomCards(5);


                // PokerHands クラスのインスタンスを作成
                PorkerHands pokerHands = new PorkerHands();

                // checkCards メソッドで手札を並び替える
                List<Integer> sortedCards = pokerHands.sortCards(hand);
                System.out.println("手札: " + sortedCards);

                // 役を判定
                String result = pokerHands.checkCards(sortedCards);
                System.out.println("役: " + result);  


                // Calculation クラスのインスタンスを作成
                Calculation calc = new Calculation();

                // 役に応じた倍率を取得
                int magnification = calc.getReward(result);

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


package jp.ac.uryukyu.ie.e245756_e245759;

import java.util.Scanner;

/*
 * ゲームの掛け金を入力させるクラス
 * Scannerを使ってプレイヤーに入力させる
 */
public class BetMoney {
    /*
     * スキャナーでの入力をクラス内で保持する
     */
    private Scanner scanner; 
    
    /*
     * コンストラクタでscannerを初期化
     */
    public BetMoney() {
        this.scanner = new Scanner(System.in);
    }

    /*
     * 掛け金を入力させるメソッド
     * 掛け金が有効な値なら掛け金を返す
     * 
     * @param playerMoney 掛け金が所持金より大きくならないようにするために値を受け取る
     * @return 入力した掛け金が条件を満たしているとき値を返す
     */
    public int getBet(int playerMoney) {
        int bet = -1;
        while (bet <= 0 || bet > playerMoney) {
            System.out.print("掛け金を入力してください: ");
            bet = scanner.nextInt();

            // 入力値を検証
            if (bet <= 0) {
                System.out.println("掛け金は正の数で入力してください。");
            } else if (bet > playerMoney) {
                System.out.println("掛け金は所持金 " + playerMoney + " 円以下にしてください。");
            }
        }
        return bet;
    }
}



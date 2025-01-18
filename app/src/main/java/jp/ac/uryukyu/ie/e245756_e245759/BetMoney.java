package jp.ac.uryukyu.ie.e245756_e245759;

import java.util.Scanner;

public class BetMoney {
    private final Scanner scanner; // スキャナーをクラス内で保持

    // コンストラクタでScannerを初期化
    public BetMoney() {
        this.scanner = new Scanner(System.in);
    }

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



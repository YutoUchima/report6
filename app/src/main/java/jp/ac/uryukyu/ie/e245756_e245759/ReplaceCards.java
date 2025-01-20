package jp.ac.uryukyu.ie.e245756_e245759;

import java.util.Scanner;
import java.util.List;

/*
 * 手札を入れ替えるクラス
 * HandOutCardsクラスで作成した山札から入れ替えるカードを引く
 */
public class ReplaceCards {
    /*
     * スキャナーでの入力をクラス内で保持する
     */
    private Scanner scanner = new Scanner(System.in);//System.in=キーボードによる標準入力
    
    /*
     * カードを一枚ずつ入れ替えるメソッド
     * 入れ替えるかどうかを左から一枚ずつ聞いていく
     *
     * @param cards　HandOutCardsクラスで作成した山札
     * @param sotedCards　プレイヤーに与えられた手札
     *
     */
    public void replaceCards(HandOutCards cards, List<Integer> sotedCards){
        for (int i = 0; i < sotedCards.size(); i ++){ //リストの要素数以下の時iに+1をしていく
            System.out.println(i+1 + "枚目:" + sotedCards.get(i));
            System.out.println("入れ替えますか？(1:はい/2:いいえ)");
            String input = scanner.nextLine(); //scannerメソッドを使って、入れ替えするかどうか（0か1か）を書き込むためのコード

            if (input.equals("1")){ //"equals"はString型における"=="
                List<Integer> newCard = cards.getRandomCards(1); //newCardは新しく引くカードを入れておくリスト(指定枚数はn=1)
                System.out.println("交換します");
                sotedCards.set(i, newCard.get(0)); //setメソッドで手札を更新する　set(置き換える場所, 置き換えたい値)
            } else{
                System.out.println("交換しません");
            }
        }
    }
}

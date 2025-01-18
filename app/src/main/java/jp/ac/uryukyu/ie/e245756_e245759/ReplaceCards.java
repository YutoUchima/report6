package jp.ac.uryukyu.ie.e245756_e245759;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ReplaceCards {
    //カードを入れ替えるかどうか決める
    public List<Integer> isReplaceCards(List<Integer> sotedCards){
        Scanner scanner = new Scanner(System.in);//System.in=キーボードによる標準入力
        List<Integer> isReplaceCards = new ArrayList<>(); //各番目のカードを交換するかどうかの入力をまとめたリスト

        for (int i = 0; i < sotedCards.size(); i ++){ //リストの要素数以下の時iに+1をしていく
            System.out.println(i+1 + "枚目:" + sotedCards.get(i));
            System.out.println("入れ替えますか？(1:はい/2:いいえ)");
            int input = scanner.nextInt(); //scannerメソッドを使って、入れ替えするかどうか（0か1か）を書き込むためのコード
            isReplaceCards.add(input); //各番目のカードを交換するかどうかの入力をまとめたリストに入力
        }
        return isReplaceCards;
    }
    
    
    //カードを入れ替えるメソッド
    public void replaceCards(HandOutCards cards, List<Integer> sotedCards, List<Integer> isReplaceCards){
        int i = 0; //リストの何番目を指定しているか判定用
        for (var isReplace : isReplaceCards){
            if (isReplace == 1){ 
                List<Integer> newCard = cards.getRandomCards(1); //newCardは新しく引くカードを入れておくリスト(指定枚数はn=1)

                sotedCards.set(i, newCard.get(0)); //setメソッドで手札を更新する　set(置き換える場所, 置き換えたい値)
            }
            i += 1; //リストの何番目かの指定
        }
    }
}



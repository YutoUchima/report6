package jp.ac.uryukyu.ie.e245756_e245759; 

import java.util.ArrayList;
import java.util.List;

public class HandOutCards {
// 山札を作成するコード
    private List<Integer> cards;    

    public HandOutCards(){
        // 1から10までの数字を格納するリスト
        // Listはオブジェクト型だけを扱い、intを直接格納できないためIntegerを使用する
        cards = new ArrayList<>();
        // 数字をリストに追加
        int n = 0;
        while(n < 4){
            for (int i = 1; i <= 13; i++) {
                cards.add(i);
            }
            n += 1;
        }
    }

    public List<Integer> getRandomCards(int drawCard){
        List<Integer> hand = new ArrayList<>();
        for (int i = 0; i < drawCard; i++) {
            int randomIndex = (int) (Math.random() * cards.size()); // ランダムインデックスを取得
            hand.add(cards.get(randomIndex)); // ランダムに選ばれたカードを手札に追加
            cards.remove(randomIndex); // 選ばれたカードを山札から削除
        }
        return hand;
    }
}

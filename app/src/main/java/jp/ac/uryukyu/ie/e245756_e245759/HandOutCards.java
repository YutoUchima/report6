package jp.ac.uryukyu.ie.e245756_e245759; 

import java.util.ArrayList;
import java.util.List;

/*
 * 山札からカードを引くクラス
 * 1~13のカードが４セット入った山札
 * ランダムに引かれ、手札として与えられる
 */
public class HandOutCards {
    /*
     * 山札を入れるためのリスト
     * 1~13の4枚ずつで合計52枚
     */
    private List<Integer> cards;    

    /*
     *1~13までのカードが４セット入った山札を作成するコンストラクタ
     */
    public HandOutCards(){
        cards = new ArrayList<>(); // 1から10までの数字を格納するリスト
        int n = 0; // 数字をリストに追加
        while(n < 4){
            for (int i = 1; i <= 13; i++) {
                cards.add(i);
            }
            n += 1;
        }
    }

    /*
     * 指定された枚数のカードをランダムに引く
     * 引いたカードは山札から削除する
     * 
     * @param drawCard ランダムで引くカードの枚数
     * @return 引いたカードの入ったリストを返す
     */
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

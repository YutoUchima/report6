package jp.ac.uryukyu.ie.e245756_e245759;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * プレイヤーの手札を受け取り、役の判定をするクラス
 * 役の判定がしやすいようにカードを数字の小さい順位並べ変えてから役の判定をする
 */
public class CheckCards {
    /*
     * 手札のカードを小さい順に並び替える
     * プレイヤーが役の判定をしやすくする
     * 
     * @param hand プレイヤーの手札のリストを受け取る
     * @return 小さい順に並び替えた手札のリストを返す
     */
    public List<Integer> sortCards(List<Integer> hand){
        List<Integer> sortCards = new ArrayList<>(hand);
        Collections.sort(sortCards);
        return sortCards;
    }

    /*
     * 手札を受け取り、役があるかどうか判定をする
     * 判定は手札に対する数字の出現回数や連続性をみて判定する
     * 
     * @param sortedCards 交換の動作の後、小さい順に並び替えた手札のリストを受け取る
     * @return 役の名前をString型で返す
     */
    public String checkCards(List<Integer> sortedCards){
        //ロイヤルストレートの役は判別が難しいので作っておく
        List<Integer> RoyalStraight = List.of(1,0,0,0,0,0,0,0,0,1,1,1,1);
        //1~13の出現回数を数えるためのリスト初期値は全て0にする
        List<Integer> counts = new ArrayList<>();
        for(int number = 1; number <= 13; number++){
            counts.add(0);
        }
        //1~13が何回ずつ出てきたか出現回数を数える
        for(int number = 1; number <= 13; number++ ){
            for(int card : sortedCards){
                if(number == card){
                    counts.set(number-1, counts.get(number-1)+1);
                }
            }
        }
        //出現回数を数えたリストに役を判別していく
        if(counts.contains(4)){
            return "フォーカード";
        }else if(counts.contains(3)){
            if(Collections.frequency(counts, 2) == 1){
                return "フルハウス";
            }else{
                return "スリーカード";
            }
        }else if(counts.contains(2)){
            if(Collections.frequency(counts, 2) == 2){
                return "ツーペア";
            }else{
                return "ワンペア";
            }
        }else if(counts.equals(RoyalStraight)){
            return "ロイヤルストレート";
        }else{
            int straight = 0;
            for(int count : counts){
                if(count == 1){
                    straight += 1;
                }else if(straight <5){
                    straight = 0;
                }
            }
            if(straight == 5){
                return "ストレート";
            }else{
                return "役なし";
            }
        }
    }
}

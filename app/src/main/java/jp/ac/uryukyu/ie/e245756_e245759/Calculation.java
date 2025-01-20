package jp.ac.uryukyu.ie.e245756_e245759;
/*
 * 役に応じた倍率を与えるクラス
 * プレイヤーの役を受け取り、役に応じて報酬の倍率を決める
 */
public class Calculation {
    /*
     * 指定された役に応じて、掛け金への倍率を返す
     * 
     * @param result プレイヤーの手札の役（ワンペア、ツーペアなど）
     * @return　役に対応する掛け金への倍率  
     */
    public int getReward(String result){
        //役に応じて賭け金の倍率が上がる
        switch (result) {   
            case "ワンペア":
                return 1;
            case "ツーペア":
                return 2; 
            case "スリーカード":
                return 3;
            case "ストレート":
                return 5;
            case "フルハウス":
                return 10;
            case "フォーカード":
                return 20;  
            case "ロイヤルストレート":
                return 100;  
            default:
                return 0;   
        }
    }
}

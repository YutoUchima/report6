package jp.ac.uryukyu.ie.e245756_e245759;

public class Calculation {
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

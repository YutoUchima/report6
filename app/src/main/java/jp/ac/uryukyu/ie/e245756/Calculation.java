package jp.ac.uryukyu.ie.e245756;

public class Calculation {
    public int getReward(String result){
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

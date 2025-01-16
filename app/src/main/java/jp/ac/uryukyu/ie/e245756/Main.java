package jp.ac.uryukyu.ie.e245756;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        // Deckクラスのインスタンスを生成
        HandOutCards cards = new HandOutCards();

        // 山札から5枚引く
        List<Integer> hand = cards.getRandomCards(5);

        // PokerHands クラスのインスタンスを作成
        PorkerHands pokerHands = new PorkerHands();

        // checkCards メソッドで手札を並び替える
        List<Integer> sortedCards = pokerHands.sortCards(hand);
        System.out.println("手札: " + sortedCards);

        // 役を判定
        String result = pokerHands.checkCards(sortedCards);
        System.out.println("役: " + result);    
    }
}


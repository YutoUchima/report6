package jp.ac.uryukyu.ie.e245756_e245759;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class ReplaceCardsTest {
    @Test
    public void ReplacedCardsTest() {
        HandOutCards cards = new HandOutCards();
        ReplaceCards replaceCards = new ReplaceCards();

        // 最初の手札を生成
        List<Integer> hand = cards.getRandomCards(5);
        System.out.println("交換前の手札: " + hand);

        // 特定のカード（1枚目）を交換
        int originalCard = hand.get(0); // 最初のカードを記録
        List<Integer> isReplaceCards = List.of(1,2,2,2,2); //1は交換、2は交換しない
        replaceCards.replaceCards(cards, hand, isReplaceCards);

        // 交換後のカードを取得
        int replacedCard = hand.get(0); // 1枚目のカードを取得

        // テスト: 最初のカードが交換されていることを確認
        assertNotEquals(originalCard, replacedCard, "最初のカードが交換されていません！");
    }
}



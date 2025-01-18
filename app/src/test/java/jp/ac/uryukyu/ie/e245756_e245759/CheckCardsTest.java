package jp.ac.uryukyu.ie.e245756_e245759;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckCardsTest {
    @Test
    public void straightTest() {
        CheckCards checkCards = new CheckCards();
        List<Integer> hand = List.of(1,2,3,4,5);  //手札を与える
        String result = checkCards.checkCards(hand);

        // テスト: 役が揃ったときにその役が表示されるか確認
        assertEquals("ストレート", result);
    }

    @Test
    public void RoyalStraightTest() {
        CheckCards checkCards = new CheckCards();
        List<Integer> hand = List.of(1,10,11,12,13);  //手札を与える
        String result = checkCards.checkCards(hand);

        // テスト: 役が揃ったときにその役が表示されるか確認
        assertEquals("ロイヤルストレート", result);
    }
}



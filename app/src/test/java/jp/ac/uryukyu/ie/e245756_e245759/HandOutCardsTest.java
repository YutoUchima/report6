package jp.ac.uryukyu.ie.e245756_e245759;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandOutCardsTest {
    @Test
    public void DeckCardsTest(){ //山札に同じカードが5枚以上ないかテスト
        HandOutCards cards = new HandOutCards();
        List<Integer> cardTest = cards.getRandomCards(52);//全ての山札を取り出す
        List<Integer> count = new ArrayList<>();
        for(int number = 1; number <= 13; number++){
            count.add(0);
        }
        for(int card : cardTest){
            count.set(card-1, count.get(card-1)+1); //取り出したカードを数える
        }

        // テスト: 全てのカードの出現回数が4回になっているか確認
        assertEquals(List.of(4,4,4,4,4,4,4,4,4,4,4,4,4), count);
    }
}

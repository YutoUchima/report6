package jp.ac.uryukyu.ie.e245756_e245759;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ReplaceCardsTest {
    @Test
    public void replaceTest() {
        // 入力シミュレーション: プレイヤーが「全て交換しない」を選択する場合
        String simulatedInput = "1\n2\n1\n2\n2\n"; // 各入力を改行で区切る
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        HandOutCards cards = new HandOutCards();

        // 手札を生成
        List<Integer> originalHand = new ArrayList<>(cards.getRandomCards(5)); // 交換前の手札を保存
        List<Integer> hand = new ArrayList<>(originalHand); // 手札をコピー

        ReplaceCards replaceCards = new ReplaceCards();
        replaceCards.replaceCards(cards, hand);

        // テスト: 手札が交換されていることを確認
        assertNotEquals(originalHand, hand, "手札が交換されていません！");
    }
}

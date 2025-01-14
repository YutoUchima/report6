import java.util.ArrayList;
import java.util.List;
public class Hund_0ut_Cards {




// 山札を作成するコード
   public static void main(String[] args) {
       // 1から10までの数字を格納するリスト
       // Listはオブジェクト型だけを扱い、intを直接格納できないためIntegerを使用する
       List<Integer> numbers = new ArrayList<>();


       // 数字をリストに追加
       int n = 0;
       while(n < 4){
            for (int i = 1; i <= 13; i++) {
                numbers.add(i);
            }
            n += 1;
   }
       // リストの内容を出力
       System.out.println("1から13までの数字リスト: " + numbers);
   }
}


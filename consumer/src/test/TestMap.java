import java.util.HashMap;
import java.util.Map;

/**
 * @author dengzhifu
 * @Description TODO
 * @Date 2021/12/20 4:40 PM
 */
public class TestMap {
    private static final Map<Integer, Integer> objectCache = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
//            int random = (int) (Math.random() * 100);
            int finalI = i;
            new Thread(()->{
                objectCache.computeIfAbsent(finalI, v->finalI);
            }).start();
        }
        System.out.println(objectCache);


        for (int i = 0; i < 100; i++) {
            int random = (int) (Math.random() * 100);
            int finalI = i;
            new Thread(()->{
                objectCache.computeIfAbsent(finalI, v->random);
            }).start();
        }

        System.out.println(objectCache);
        Thread.sleep(1000);
        System.out.println(objectCache);
    }
}

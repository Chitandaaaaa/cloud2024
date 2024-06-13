import java.time.ZonedDateTime;

/**
 * @program: cloud2024
 * @description:
 * @author: lixiameng
 * @create: 2024-03-08 23:29
 */
public class ZonedDateTimeDemo {
    public static void main(String[] args)
    {
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
    }
}

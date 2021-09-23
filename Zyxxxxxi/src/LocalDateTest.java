

import java.time.LocalDate;
import java.util.Arrays;

/**
 * @author zyx
 */
public class LocalDateTest {

    public static void main(String[] args) {
        localDateTest("曹可莹\n" +
                "何俊桦\n" +
                "黄泽浩\n" +
                "黄泽雄\n" +
                "鞠竣羿\n" +
                "李芷琪\n" +
                "梁凯光\n" +
                "林耀佳\n" +
                "刘迈琦\n" +
                "刘淑婷\n" +
                "麦森\n" +
                "田欣雨\n" +
                "王广睿\n" +
                "王泽真\n" +
                "吴桁\n" +
                "叶彬\n" +
                "叶子杰\n" +
                "张弘轩\n" +
                "赵宇轩\n" +
                "赵芷彬\n" +
                "周铭坚\n");
    }
    public static void localDateTest(String s) {
        s = s.replace('\n', '|').substring(0, s.length() - 1);
        String base = "何俊桦\n" +
                "黄泽浩\n" +
                "黄泽雄\n" +
                "霍耀东\n" +
                "鞠竣羿\n" +
                "李嘉威\n" +
                "梁筠浩\n" +
                "梁凯光\n" +
                "梁展明\n" +
                "林耀佳\n" +
                "刘迈琦\n" +
                "刘仲禹\n" +
                "麦森\n" +
                "蒙鑫\n" +
                "彭海东\n" +
                "冉旭\n" +
                "施懿泽\n" +
                "田欣雨\n" +
                "王艮林\n" +
                "王广睿\n" +
                "王文鸿\n" +
                "吴桁\n" +
                "冼嘉劲\n" +
                "杨茗\n" +
                "叶彬\n" +
                "叶子杰\n" +
                "袁帅\n" +
                "张创辉\n" +
                "张耿畅\n" +
                "张弘轩\n" +
                "张敏峰\n" +
                "赵宇轩\n" +
                "赵芷彬\n" +
                "周铭坚\n" +
                "曹可莹\n" +
                "李林欣\n" +
                "李芷琪\n" +
                "刘淑婷\n" +
                "邵曼玲\n" +
                "王泽真\n" +
                "伍柳颖\n" +
                "杨晴\n".replace('\n', ' ');
        StringBuilder sb = new StringBuilder();
        Arrays.stream(base.split("\n| |"+s)).forEach(e -> {
            if(!"".equals(e)){
                sb.append(e).append("|");
            }
        });
        System.out.println(sb);
    }
}

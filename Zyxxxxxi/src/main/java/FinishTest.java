

import java.util.Arrays;

/**
 * @author zyx
 */
public class FinishTest {
    static String baseNames = "曾樊升\n" + "欧阳天政\n" + "黄永忠\n" + "陈淑妍\n" + "陈佩妍\n" + "赵宇轩\n" + "凌宇才\n" + "何俊桦\n" + "龙咏欣\n" + "冉旭\n" + "林耀佳\n" + "吕政轩\n" + "许龙辉\n" + "黄泽雄\n" + "邓权威\n" + "谢舒欣\n" + "简锦源\n" + "颜志烨\n" + "林骏贤\n" + "李嘉威\n" + "鞠竣羿\n" + "丘冰玉\n" + "吴炯烽\n" + "李子轩\n" + "刁润龙\n" + "尹亮\n" + "吴桁\n" + "张泽权\n" + "凌秋悦\n" + "邹腾飞\n" + "赵芷彬\n" + "段誉\n" + "黄毅\n" + "黄俊豪\n";

    static String finishNames = "赵宇轩\n" + "段誉\n" + "简锦源\n" + "何俊桦\n" + "丘冰玉\n" + "陈佩妍\n" + "冉旭\n" + "黄俊豪\n" + "吕政轩\n" + "邹腾飞\n" + "欧阳天政\n" + "鞠竣羿\n" + "李嘉威\n" + "谢舒欣\n" + "林骏贤\n" + "凌宇才\n" + "张泽权\n" + "邓权威\n" + "黄毅\n" + "林耀佳\n" + "龙咏欣\n" + "尹亮\n" + "黄泽雄\n" + "赵芷彬\n";
    public static void main(String[] args) {
        finishCheck(finishNames);
    }

    public static void finishCheck(String names) {
        names = names.replace('\n', '|').substring(0, names.length() - 1);
        String base = baseNames.replace('\n', ' ');
        StringBuilder sb = new StringBuilder();
        Arrays.stream(base.split("\n| |"+names)).forEach(e -> {
            if(!"".equals(e)){
                sb.append(e).append("|");
            }
        });
        System.out.println(sb);
    }
}

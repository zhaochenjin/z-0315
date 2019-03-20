package day04;
// 类型转换
public class M3_3 {
    public static void main(String[] args) {
        //把int型转变为String型
        int i = 100;
      //String s=i+"";
        String s = String.valueOf(i);
        System.out.println(s);

        //把String型转变为int型
        String s100 = "100";
        int i100 = Integer.parseInt(s100);
        System.out.println(i100 + 1);

        // 把String型转变为double型
        String s12345 = "123.45";
        double d = Double.parseDouble(s12345);
        System.out.println(s12345);

        // 把String型转换为boolean型
        Boolean.parseBoolean("true");
        System.out.println(true);

        // 把String型转换为boolean型
        String s1="true";
        Boolean b1=Boolean.parseBoolean(s1);
        System.out.println(s1);
    }
}

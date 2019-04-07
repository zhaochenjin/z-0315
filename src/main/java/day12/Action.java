package day12;

import java.util.Scanner;

public class Action {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("饭卡管理系统");
        Integer power = 0;
        Loop:
        while (true) {
            System.out.println("欢迎登陆");
            if (power == 10) {
                System.out.println("管理员");
            }
            String flag = scanner.nextLine();
            // power=admin(flag.power);
            if (flag.equals("登陆页面")) {
                Card card = null;
                while (true) {
                    if (power != 10) {
                        System.out.println("请输入你的学号");
                    } else {
                        System.out.println("退出");
                    }
                    String id = scanner.nextLine().trim();
                    if (id.equals("退出")) {
                        System.out.println("退出页面");
                        break Loop;
                    } else {
                        break;
                    }
                }
                while (true) {
                    if (power == 0) {
                        System.out.println("请输入密码");
                    } else {
                        System.out.println("管理员登陆");
                    }
                    String t = scanner.nextLine().trim();
                    if (power == 10) {
                        System.out.println("管理员登陆中");
                    } else if (card.getPassword().equals(t)) {
                        break;
                    } else {
                        System.out.println("密码错误,请重写输入");
                    }
                }
            }
        }
    }
}
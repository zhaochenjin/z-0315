package day12;

import java.util.Scanner;

public class ActionCard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Meal_Card card = new Meal_Card();
        while (true) {
            System.out.println("请输入学号");
            String id = input.nextLine();
            CardDao cd = new CardDao();
            Meal_Card tempcard = cd.findCard(id);
            if (id.equals("0")) {
                //          card.setId(id);
                break;
            }
        }
        System.out.println("输入姓名");
        card.setName(input.nextLine());
        System.out.println("请输入密码");
        card.setPassword(input.nextLine());


    }

    private static class Meal_Card {
        public void setName(String nextLine) {
        }

        public void setPassword(String nextLine) {
        }
    }

    private static class CardDao {
        public Meal_Card findCard(String id) {
            return null;
        }
    }
}


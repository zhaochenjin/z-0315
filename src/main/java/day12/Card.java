package day12;

public class Card {
private String name;
private String password;
private String class_name;
private int money;
private String balance;

    public Card(String name, String password, String class_name, int money, String balance) {
        this.name = name;
        this.password = password;
        this.class_name = class_name;
        this.money = money;
        this.balance = balance;
    }

    public Card() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
package day08;

import java.util.Scanner;

/*
    create database ...;
    create table ...;
    insert into ...;
    update ...;
    delete ...;
    select ...;
    drop table ...;
    drop database ...;
 */
public class MysqlCommandLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input SQL statement: ");
        String sql = scanner.nextLine();
        // TODO: 2019/3/26
        // .executeUpdate();
        // .executeQuery();   // select
        System.out.println(sql);
    }
}

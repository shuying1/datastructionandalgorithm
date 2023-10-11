package com.iflytek.hsp;


/**
 * @author yings
 * @create 2022-10-01 10:20
 */
public class Single {
    public static void main(String[] args) {
//        Girlfriend gf1 = Girlfriend.getInstance();
//        Girlfriend gf2 = Girlfriend.getInstance();
//        System.out.println(gf1);
//        System.out.println(gf2);
//        System.out.println(gf1==gf2);

        Girlfriend2 gf1 = Girlfriend2.getInstance();
        Girlfriend2 gf2 = Girlfriend2.getInstance();
        System.out.println(gf1);
        System.out.println(gf2);
        System.out.println(gf1 == gf2);
    }
}

/**
 * 饿汉式
 */
class Girlfriend {
    private String name;

    public Girlfriend(String name) {
        this.name = name;
    }

    private static Girlfriend gf = new Girlfriend("小红");


    public static Girlfriend getInstance() {
        return gf;
    }

    @Override
    public String toString() {
        return "Girlfriend{" +
                "name='" + name + '\'' +
                '}';
    }
}

/**
 * 懒汉式
 */
class Girlfriend2 {
    public static int n1 = 999;//当调用静态方法时不立即创建对象
    private static Girlfriend2 gf;
    private String name;

    public static Girlfriend2 getInstance() {
        if (gf == null) {
            gf = new Girlfriend2("小花");
        }
        return gf;
    }

    public Girlfriend2(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "GirlFriend2{" +
                "name='" + name + '\'' +
                '}';
    }
}

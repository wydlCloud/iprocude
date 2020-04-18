package com.wy.jvm.stringtable;

/**
 * @author wy
 * @company
 * @Classname StringLazyLoad
 * @Description 字符串延迟加载 使用到的时候才会进行加载，不会提前加载，可以根据idea的memory框来查看数量
 * @Date 2020/4/19 12:42 上午
 */

public class StringLazyLoad {
    public static void main(String[] args) {
        int x=args.length;
        // 其实就说明了一个道理，如果对象已经存在了的话，就不会再创建对象了，
        // 我的理解是创建之后是放在了StringTable中，每次都从StringTable，取到则不重复存储，取不到则放进去
        // 验证也很简单，看下字节码反编译指令就好了
        System.out.println();
        System.out.println("1"); // 1965
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("0"); // 1974
        System.out.println("1"); // 1975
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9"); // 1975

    }
}

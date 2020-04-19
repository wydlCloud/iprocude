package com.wy.jvm.MemoryStructure.stringtable;
/**
 * @author wy
 * @company
 * @Classname StringTableSimple
 * @Description StringTable的过程分析和情况下的比较判断，深入了解为什么相等和不等
 * @Date 2020/4/19 12:06 上午
 */
//StringTable["a","b","ab"] hashTable结构，不能进行扩容
public class StringTableSimple {
    // 常量池中的信息，都会被加载到运行时常量池中，这个时候 a b ab 都是常量中的符号，还没有变成String字符串对象
    // ldc #2 会把 a 符号变为"a"字符串对象  其实主要是先从StringTable字符表中去找，如果没找到，就放到StringTable，存储结构其实是哈希结构
    // ldc #3 会把 b 符号变为"b"字符串对象
    // ldc #4 会把 ab符号 变为"ab"字符串对象
    public static void main(String[] args) {
        String s1 = "a";// 其实他们创建对象的行为都是懒惰的，只有需要用的时候才开始进行创建
        String s2 = "b";
        String s3 = "ab";
        // new StringBuilder()
        // Method java/lang/StringBuilder."<init>":()V
        // java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
        /**
         *  @Override
         *     public String toString() {
         *         // Create a copy, don't share the array
         *         return new String(value, 0, count);
         *     }
         */
        // 一个存储在StringTable中，一个创建对象在堆中，是不同的字符串对象，地址不同，所以返回false
        // s1 和 s2是变量，所以在运行期间可能会改变的，所以在运行期间才进行通过指令来进行获取和拼接，以保证正确性和安全性，以防止会改变
        String s4 = s1 + s2;
        System.out.println(s3 == s4); // false
        // 反编译查看执行指令就可以明白 javap -v class文件
        // 其实是javac在编译期间进行的优化  结果已经在编译期间确定为ab，因为"a" 和"b" 都是常量，肯定是不会变了，所以在编译期间就直接确定为了"ab"
        String s5 = "a" + "b";
        System.out.println(s3==s5);   //true

    }
}

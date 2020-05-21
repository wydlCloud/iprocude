package com.wy.other.thread.cycliBarrier;

/**
 * @author wy
 * @Classname CyclicBarrierDemo
 * @Description CyclicBarrier是另外一种多线程并发控制实用工具。
 * 和countDownLatch非常类似，它可以实现线程间的计数等待，但它的工鞥
 * 比CountDownLatch要复杂和强大
 * CyclicBarrier可以理解为循环栅栏。栅栏就是一种障碍物，比如，通常在私人宅邸的周围就
 * 可以围上一圈栅栏，阻止闲杂人等入内。这里当然就是用来阻止线程继续执行，要求线程在栅栏处
 * 进行等待。前面的cyclic意为循环，也就是说这个计数器可以反复使用。比如，假设我们将计数器设置为10
 * ，那么凑齐第一批10个线程后，计数器就会归零，然后接着走起下一批10个线程，这就是循环栅栏
 * 内在的含义。
 * @company
 */

public class CyclicBarrierDemo {
}

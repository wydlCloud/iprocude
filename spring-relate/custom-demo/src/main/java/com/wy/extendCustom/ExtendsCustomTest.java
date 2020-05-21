package com.wy.extendCustom;

/**
 * @author wy
 * @company wy(中国)网络科技
 * @Classname ExtendsCustomTest
 * @Description
 * 但是这样的话还是会存在问题，因为这种情况下，比如说，我想在每个方法前和后想做性能监控这样的话，我只能这么去做，见代码，在animal类中已经做了很详细的阐述
 * 后面会通过aop  面向切面编程的思想来解决这个问题
 *
 * 总结一下：
 * 像普通的话，可以通过集成的方式可以解决大部分代码冗余的问题
 * 但是：
 * 像刚才那种性能监控，是继承方式所解决不了的，因为每个方法中都需要进行性能监控，而且此类已经是最底层的父类，再抽取，已经不可能了，即使可以，
 * 也必须得调用方法嵌入到每个方法中去调用，所以说，于事无补
 *
 * 可以通过面向切面编程思想来解决
 * ioc  aop是一种思想，并不是实现，spring 可以作为ioc aop思想的技术实现而已，再此引入ioc 和 aop
 *
 * 在这里稍微说一下ioc把，  ioc  控制反转
 * 控制:  对象控制
 * 反转： 权力反转
 * ioc主要是用于对象的创建和对象的管理等，交给了spring来进行创建和管理
 * 优点：
 * 解耦
 * 可以让我们不关注这些，可以更好的对业务进行开发
 * 缺点:
 * 不能自己去管理对象，把对象的权力移交给了spring
 */

public class ExtendsCustomTest {
}

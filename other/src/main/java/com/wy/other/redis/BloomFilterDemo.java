package com.wy.other.redis;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.apache.commons.io.Charsets;

/**
 * @author wy
 * @company
 * @Classname BloomFilterDemo
 * @Description
 *  误判率的计算
 *  （误判的数量/ 判断的总数量）*100 =误判率
 *  误判率默认是0.03D
 *
 *  误判率越大，则误判的数量越多，当然从空间的纬度来思考，那就是误判率越高，则需要的空间也越小
 *
 *  误判率越小，说明也更加准确，当然需要的空间也更大
 *
 *  在项目场景中使用的时候，要根据具体的业务场景来进行选择，选择一个业务中所容忍的一个度，取平衡点来去处理
 */

public class BloomFilterDemo {
    public static void main(String[] args) {
        int total = 100000;
        BloomFilter<CharSequence> charSequenceBloomFilter = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total);
        // 初始化100000条数据到过滤器中
        for (int i = 0; i < total; i++) {
            charSequenceBloomFilter.put("" + i);
        }
        //判断值是否存在过滤器中
        int count = 0;
        for (int i = 0; i < total + 10000; i++) {
            if (charSequenceBloomFilter.mightContain("" + i)) {
                count++;
            }
        }
        System.out.println("已经匹配数量" + count);
    }
}

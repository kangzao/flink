package com.jep.flink.basic;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/11/6 上午9:50
 */

import com.jep.flink.basic.function.PKFlatMapFunction;
import com.jep.flink.basic.function.PKMapFunction;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.ExecutionEnvironment;

/**
 * 使用Flink进行批处理，并统计wc
 *
 * @author enping.jep
 */
public class BatchWordCountApp {

    public static void main(String[] args) throws Exception {
        // step0: Spark中有上下文，Flink中也有上下文，MR中也有
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();
        // step1: 读取文件内容  ==> 一行一行的字符串而已
        DataSource<String> source = env.readTextFile("data/wc.data");
        // step2: 每一行的内容按照指定的分隔符进行拆分  1:N
        source.flatMap(new PKFlatMapFunction()).map(new PKMapFunction())
                // step4: 按照单词进行分组
                .groupBy(0)
                // ==> 求词频 sum
                .sum(1).print();
    }
}

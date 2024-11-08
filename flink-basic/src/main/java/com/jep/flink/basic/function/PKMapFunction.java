package com.jep.flink.basic.function;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.tuple.Tuple2;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/11/6 上午9:52
 */
public class PKMapFunction implements MapFunction<String, Tuple2<String, Integer>> {

    @Override
    public Tuple2<String, Integer> map(String value) throws Exception {
        return Tuple2.of(value, 1);
    }
}

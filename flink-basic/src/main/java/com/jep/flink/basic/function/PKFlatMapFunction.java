package com.jep.flink.basic.function;


import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.util.Collector;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/11/6 上午9:54
 */
public class PKFlatMapFunction implements FlatMapFunction<String, String> {

    @Override
    public void flatMap(String value, Collector<String> out) throws Exception {
        String[] splits = value.split(",");
        for (String split : splits) {
            out.collect(split.toLowerCase().trim());
        }
    }
}

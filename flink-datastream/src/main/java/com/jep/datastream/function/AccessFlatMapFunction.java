package com.jep.datastream.function;

import com.jep.datastream.bean.Access;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.util.Collector;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/11/9 下午10:08
 */
public class AccessFlatMapFunction extends RichFlatMapFunction<Access, String> {
    @Override
    public void flatMap(Access value, Collector<String> out) throws Exception {
        if ("pk1.com".equals(value.getDomain())) { // 域名为pk1.com
            out.collect(value.getDomain()); // 一个元素 ==> 1
        } else { // 域名为非pk1.com
            out.collect("--domain--" + value.getDomain());
            out.collect("--traffic--" + value.getTraffic());
        }
    }

}

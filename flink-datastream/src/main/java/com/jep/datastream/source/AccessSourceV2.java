package com.jep.datastream.source;

import com.jep.datastream.bean.Access;
import org.apache.flink.streaming.api.functions.source.ParallelSourceFunction;
import org.apache.flink.streaming.api.functions.source.SourceFunction;

import java.util.Random;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/11/9 下午12:20
 */
public class AccessSourceV2 implements ParallelSourceFunction<Access> {

    boolean isRunning = true;

    /**
     * 造数据是自定义数据源的使用方式之一
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void run(SourceFunction.SourceContext<Access> ctx) throws Exception {

        Random random = new Random();
        String[] domains = {"pk1.com", "pk2.com", "pk3.com"};
        while (isRunning) {
            long time = System.currentTimeMillis();
            ctx.collect(new Access(time, domains[random.nextInt(domains.length)], random.nextInt(1000) + 1000));
            Thread.sleep(5000);
        }
    }

    @Override
    public void cancel() {
        isRunning = false;
    }
}

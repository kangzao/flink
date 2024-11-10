package com.jep.datastream.function;

import com.jep.datastream.bean.Access;
import org.apache.flink.api.common.functions.RichMapFunction;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/11/9 下午9:12
 */
public class AccessConvertFunction extends RichMapFunction<String, Access> {
    @Override
    public Access map(String value) throws Exception {
        String[] splits = value.split(",");
        Access access = new Access();
        access.setTime(Long.parseLong(splits[0].trim()));
        access.setDomain(splits[1].trim());
        access.setTraffic(Double.parseDouble(splits[2].trim()));
        return access;
    }
}

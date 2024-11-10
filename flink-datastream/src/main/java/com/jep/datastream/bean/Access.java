package com.jep.datastream.bean;

import lombok.Data;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/11/9 上午11:45
 */
@Data
public class Access {
    private long time;
    private String domain;
    private double traffic;

    public Access(long time, String domain, double traffic) {
        this.time = time;
        this.domain = domain;
        this.traffic = traffic;
    }

    public Access() {

    }
}

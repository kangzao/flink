package com.jep.datastream.source;


import com.jep.datastream.bean.Access;
import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.io.TextInputFormat;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;
import org.apache.flink.util.NumberSequenceIterator;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/11/9 上午11:27
 */
public class FlinkDataSourceApp {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 这个readTextFile方法底层其实调用的就是readFile
//        DataStreamSource<String> source = env.readTextFile("data/wc.txt");
//        // 8
//        System.out.println(source.getParallelism());
//        SingleOutputStreamOperator<String> mapStream = source.map(String::toUpperCase);
//        System.out.println(mapStream.getParallelism());
//        mapStream.print();


//        单并行度
//        DataStreamSource<Access> accessSource = env.addSource(new AccessSource());
//        System.out.println(accessSource.getParallelism());
//        accessSource.print();


//      对于ParallelSourceFunction是可以根据具体情况来设定并行度的
//        DataStreamSource<Access> accessSourceV2 = env.addSource(new AccessSourceV2()).setParallelism(3);
//        System.out.println(accessSourceV2.getParallelism());
//        accessSourceV2.print();


        /**
         * 使用Flink自定义MySQL的数据源，进而读取MySQL里面的数据
         */

        env.addSource(new PKMySQLSource()).print();


        /**
         * 单并行度：fromElements  fromCollection  socketTextStream
         * 多并行度：readTextFile fromParallelCollection generateSequence  readFile
         * 自定义：
         */
        env.execute("作业名字");
    }
}

package main.java;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by yizhao on 7/15/15.
 */
public class SparkExampleMain {
    static final String FILE_PATH = "SparkExample/src/main/resources/abc.txt";


    /**
     * 跑之前要在configuration中设置VM option：-Dorg.xerial.snappy.lib.name=libsnappyjava.jnilib -Dorg.xerial.snappy.tempdir=/tmp
     *
     * **/
    public static void main(String[] args) throws Exception {
        JavaSparkContext ctx = new JavaSparkContext("local", "FuhuSparkProject");
        JavaRDD<String> lines = ctx.textFile(FILE_PATH);
        System.out.println("lines" + lines.count());
        //JavaPairRDD<Text, ByteWritable> lines = ctx.sequenceFile("hdfs://localhost:9000/kafka/logging_consumer/chat/FlumeData.1436566217918", Text.class, ByteWritable.class).cache();

    }
}

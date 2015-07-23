package main.java;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by yizhao on 7/23/15.
 */
public class SparkLoadSequenceFile {
    static final String HDFS_ADDRESS = "SparkLoadSequenceFile/src/main/resources/";

    /**
     * 跑之前要在configuration中设置VM option：-Dorg.xerial.snappy.lib.name=libsnappyjava.jnilib -Dorg.xerial.snappy.tempdir=/tmp
     **/
    public static void main(String[] args) throws Exception {
        System.setProperty("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        System.setProperty("spark.kryo.registrator", "main.java.MyRegistrator");
        JavaSparkContext ctx = new JavaSparkContext("local", "FuhuSparkProject");
        JavaPairRDD<LongWritable, BytesWritable> sequenceFileRDD =
                ctx.sequenceFile(HDFS_ADDRESS, LongWritable.class, BytesWritable.class);

        System.out.println("sequenceFileRDD.count():" + sequenceFileRDD.count());
        System.out.println("sequenceFileRDD.take(1):" + sequenceFileRDD.take(1));
        System.out.println("sequenceFileRDD.take(2):" + sequenceFileRDD.take(2));
        System.out.println("sequenceFileRDD.take(3):" + sequenceFileRDD.take(3));
        System.out.println("sequenceFileRDD.take(4):" + sequenceFileRDD.take(4));
        System.out.println("sequenceFileRDD.take(5):" + sequenceFileRDD.take(5));
    }
}
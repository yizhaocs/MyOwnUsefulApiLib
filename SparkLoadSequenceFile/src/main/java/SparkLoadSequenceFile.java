package main.java;

import com.google.protobuf.ExtensionRegistry;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

/**
 * Created by yizhao on 7/23/15.
 */
public class SparkLoadSequenceFile {
    static final String HDFS_ADDRESS = "SparkLoadSequenceFile/src/main/resources/";

    private static ExtensionRegistry registry;

    /**
     * 跑之前要在configuration中设置VM option：-Dorg.xerial.snappy.lib.name=libsnappyjava.jnilib -Dorg.xerial.snappy.tempdir=/tmp
     **/
    public static void main(String[] args) throws Exception {
        System.setProperty("spark.serializer", "org.apache.spark.serializer.KryoSerializer");
        System.setProperty("spark.kryo.registrator", "main.java.MyRegistrator");
        JavaSparkContext ctx = new JavaSparkContext("local", "FuhuSparkProject");
        JavaPairRDD<LongWritable, BytesWritable> sequenceFileRDD =
                ctx.sequenceFile(HDFS_ADDRESS, LongWritable.class, BytesWritable.class);
        JavaPairRDD<LongWritable, String> result = sequenceFileRDD.mapToPair(new ConvertToNativeTypes());

        System.out.println("result.count():" + result.count());
        System.out.println("result.take(1):" + result.take(1));
        System.out.println("result.take(2):" + result.take(2));
        System.out.println("result.take(3):" + result.take(3));
        System.out.println("result.take(4):" + result.take(4));
        System.out.println("result.take(5):" + result.take(5));
    }

    public static class ConvertToNativeTypes implements PairFunction<Tuple2<LongWritable, BytesWritable>, LongWritable, String> {
        public Tuple2<LongWritable, String> call(Tuple2<LongWritable, BytesWritable> record) {
            return new Tuple2(record._1(), record._2());
        }
    }

}
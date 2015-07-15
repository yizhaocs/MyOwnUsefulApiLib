package main.java;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.List;

/**
 * Created by yizhao on 7/15/15.
 */
public class SparkExampleMain {
    static final String FILE_PATH = "SparkExample/src/main/resources/test.txt";


    /**
     * 跑之前要在configuration中设置VM option：-Dorg.xerial.snappy.lib.name=libsnappyjava.jnilib -Dorg.xerial.snappy.tempdir=/tmp
     **/
    public static void main(String[] args) throws Exception {
        JavaSparkContext ctx = new JavaSparkContext("local", "FuhuSparkProject");
        JavaRDD<String> lines = ctx.textFile(FILE_PATH);

        lines.cache();  //cache，暂时放在缓存中，一般用于哪些可能需要多次使用的RDD，据说这样会减少运行时间

        //collect方法，用于将RDD类型转化为java基本类型，如下
        List<String> line = lines.collect();
        for (String val : line) {
            System.out.println(val);
        }

        System.out.println("lines.top(1):" + lines.top(1)); // lines.top(1):[yi zhao is]
        System.out.println("lines.count():" + lines.count()); // lines.count():9
        System.out.println("lines.countByValue():" + lines.countByValue()); // lines.countByValue():{a=3, yi zhao is=2, hahaha hehe=1, b=2, c=1}

        //下面这些也是RDD的常用函数
        // lines.collect(); List<String>
        // lines.union(); javaRDD<String>
        // lines.top(1); List<String>
        // lines.count(); long
        // lines.countByValue();


        /**
         *  filter test
         *  定义一个返回bool类型的函数，spark运行filter的时候会过滤掉那些返回只为false的数据
         *  String s，中的变量s可以认为就是变量lines（lines可以理解为一系列的String类型数据）的每一条数据
         */
        JavaRDD<String> contaninsE = lines.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) throws Exception {
                return (s.contains("they"));
            }
        });

    }
}

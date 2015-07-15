package main.java;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;

import java.util.Arrays;
import java.util.List;

/**
 * Created by yizhao on 7/15/15.
 */
public class SparkExampleMain {
    static final String FILE_PATH = "SparkExample/src/main/resources/";


    /**
     * 跑之前要在configuration中设置VM option：-Dorg.xerial.snappy.lib.name=libsnappyjava.jnilib -Dorg.xerial.snappy.tempdir=/tmp
     **/
    public static void main(String[] args) throws Exception {
        JavaSparkContext ctx = new JavaSparkContext("local", "FuhuSparkProject");
        JavaRDD<String> lines = ctx.textFile(FILE_PATH);

        lines.cache();  //cache，暂时放在缓存中，一般用于哪些可能需要多次使用的RDD，据说这样会减少运行时间

        System.out.println("--------------next collect方法's result------------------");
        //collect方法，用于将RDD类型转化为java基本类型，如下
        List<String> line = lines.collect();
        for (String val : line) {
            System.out.println(val);
        }

        System.out.println("--------------next 下面这些也是RDD的常用函数's result------------------");
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
        JavaRDD<String> filterRDD = lines.filter(new Function<String, Boolean>() {
            @Override
            public Boolean call(String s) throws Exception {
                /*
                    a
                    b
                    c
                    yi zhao is
                    hahaha hehe
                    a
                    yi zhao is
                    a
                    b
                */
                return s.contains("zhao");
            }
        });
        System.out.println("--------------next filter's result------------------");
        List<String> filterResult = filterRDD.collect();
        for (String val : filterResult) {
            /*
                yi zhao is
                yi zhao is
            */
            System.out.println(val);
        }


        /**
         * sample test
         * sample函数使用很简单，用于对数据进行抽样
         * 参数为：withReplacement: Boolean, fraction: Double, seed: Int
         *
         */
        JavaRDD<String> sampleTestRDD = lines.sample(false, 0.1, 5);
        System.out.println("-------------next sample's result-------------------");
        List<String> sampleTestResult = sampleTestRDD.collect();
        for (String val : sampleTestResult) {
            System.out.println(val);
        }


        /**
         *
         * new FlatMapFunction<String, String>两个string分别代表输入和输出类型
         * Override的call方法需要自己实现一个转换的方法，并返回一个Iterable的结构
         *
         * flatmap属于一类非常常用的spark函数，简单的说作用就是将一条rdd数据使用你定义的函数给分解成多条rdd数据
         * 例如，当前状态下，lines这个rdd类型的变量中，每一条数据都是一行String，我们现在想把他拆分成1个个的词的话，
         * 可以这样写 ：
         */
        JavaRDD<String> flatMapRDD = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterable<String> call(String s) {
                String[] words = s.split(" ");
                return Arrays.asList(words);
            }
        });
        System.out.println("-------------next FlatMap's result-------------------");
        List<String> flatMapResult = flatMapRDD.collect();
        for (String val : flatMapResult) {
            /*
                a
                b
                c
                yi
                zhao
                is
                hahaha
                hehe
                a
                yi
                zhao
                is
                a
                b
            */
            System.out.println(val);
        }


//        /**
//         * map 键值对 ，类似于MR的map方法
//         * pairFunction<T,K,V>: T:输入类型；K,V：输出键值对
//         * 需要重写call方法实现转换
//         */
//        JavaPairRDD<String, Integer> ones = flatMapRDD.map(new PairFunction<String, String, Integer>() {
//            @Override
//            public Tuple2<String, Integer> call(String s) {
//                return new Tuple2<String, Integer>(s, 1);
//            }
//        });
    }
}

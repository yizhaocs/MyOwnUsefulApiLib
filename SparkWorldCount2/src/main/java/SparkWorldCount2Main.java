package main.java;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by yizhao on 7/13/15.
 */
public class SparkWorldCount2Main {
    static final String SPARK_MASTER_ADDRESS = "spark://hadoop01:7077";
    static final String SPARK_HOME = "/home/ARCH/spark";
    static final String APP_LIB_PATH = "lib";
    public static void main(String[] args) throws Exception {
        /************************ 以下代码片段可被所有App共用 ****************************/

        // 设置App访问Spark使用的用户名：ARCH
        System.setProperty("user.name", "ARCH");

        // 设置App访问Hadoop使用的用户名：ARCH
        System.setProperty("HADOOP_USER_NAME", "ARCH");

        // 在将要传递给Executor的环境中设置Executor访问Hadoop使用的用户名：ARCH
        Map<String, String> envs = new HashMap<String, String>();
        envs.put("HADOOP_USER_NAME", "ARCH");

        // 为App的每个Executor配置最多可以使用的内存量：2GB
        System.setProperty("spark.executor.memory", "2g");

        // 为App的所有Executor配置共计最多可以使用的Core数量（最大并行任务数）：20
        System.setProperty("spark.cores.max", "20");

        // 获取要分发到集群各结点的Jar文件
        // 此例策略：若指定路径为文件，则返回该文件；若指定路径为目录，则列举目录下所有文件
        String[] jars = getApplicationLibrary();

        // 获取Spark上下文对象——访问Spark的起点。构造方法各参数的意义分别为：
        // 1 Spark Master结点的地址；2 App的名称；
        // 3 Spark各Worker结点的Spark部署目录，各结点相同；4 待分发到集群各结点的Jar文件；
        // 5 待传递给Executor环境（仅Map中的部分Key有效）
        JavaSparkContext ctx = new JavaSparkContext(SPARK_MASTER_ADDRESS,
                "Spark App 0", SPARK_HOME, jars, envs);


        //也可以使用ctx获取环境变量，例如下面的语句
        System.out.println("spark home:" + ctx.getSparkHome());


        //一次一行，String类型  ,还有hadoopfile，sequenceFile什么的 ，可以直接用sc.textFile("path")
        JavaRDD<String> lines = ctx.textFile(args[1], 1); //java.lang.String path, int minSplits
        lines.cache();  //cache，暂时放在缓存中，一般用于哪些可能需要多次使用的RDD，据说这样会减少运行时间


        //collect方法，用于将RDD类型转化为java基本类型，如下
        List<String> line = lines.collect();
        for (String val : line)
            System.out.println(val);


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
        System.out.println("--------------next filter's result------------------");
        line = contaninsE.collect();
        for (String val : line)
            System.out.println(val);


        /**
         * sample test
         * sample函数使用很简单，用于对数据进行抽样
         * 参数为：withReplacement: Boolean, fraction: Double, seed: Int
         *
         */


        JavaRDD<String> sampletest = lines.sample(false, 0.1, 5);
        System.out.println("-------------next sample-------------------");
        line = sampletest.collect();
        for (String val : line)
            System.out.println(val);


        /**
         *
         * new FlatMapFunction<String, String>两个string分别代表输入和输出类型
         * Override的call方法需要自己实现一个转换的方法，并返回一个Iterable的结构
         *
         * flatmap属于一类非常常用的spark函数，简单的说作用就是将一条rdd数据使用你定义的函数给分解成多条rdd数据
         * 例如，当前状态下，lines这个rdd类型的变量中，每一条数据都是一行String，我们现在想把他拆分成1个个的词的话，
         * 可以这样写 ：
         */


        JavaRDD<String> words = lines.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterable<String> call(String s) {
                String[] words = s.split(" ");
                return Arrays.asList(words);
            }
        });


        /**
         * map 键值对 ，类似于MR的map方法
         * pairFunction<T,K,V>: T:输入类型；K,V：输出键值对
         * 需要重写call方法实现转换
         */
        JavaPairRDD<String, Integer> ones = words.map(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) {
                return new Tuple2<String, Integer>(s, 1);
            }
        });


        //A two-argument function that takes arguments
        // of type T1 and T2 and returns an R.
        /**
         * reduceByKey方法，类似于MR的reduce
         * 要求被操作的数据（即下面实例中的ones）是KV键值对形式，该方法会按照key相同的进行聚合，在两两运算
         */
        JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer i1, Integer i2) { //reduce阶段，key相同的value怎么处理的问题
                return i1 + i2;
            }
        });


        //备注：spark也有reduce方法，输入数据是RDD类型就可以，不需要键值对，
        // reduce方法会对输入进来的所有数据进行两两运算


        /**
         * sort，顾名思义，排序
         */
        JavaPairRDD<String, Integer> sort = counts.sortByKey();
        System.out.println("----------next sort----------------------");


        /**
         * collect方法其实之前已经出现了多次，该方法用于将spark的RDD类型转化为我们熟知的java常见类型
         */
        List<Tuple2<String, Integer>> output = sort.collect();
        for (Tuple2<?, ?> tuple : output) {
            System.out.println(tuple._1() + ": " + tuple._2());
        }


        /**
         * 保存函数，数据输出，spark为结果输出提供了很多接口
         */
        sort.saveAsTextFile("/tmp/spark-tmp/test");


        // sort.saveAsNewAPIHadoopFile();
        // sort.saveAsHadoopFile();
        System.exit(0);
    }

    private static String[] getApplicationLibrary()
            throws IOException {
        List<String> list = new LinkedList<String>();
        File lib = new File(APP_LIB_PATH);
        if (lib.exists()) {
            if (lib.isFile() && lib.getName().endsWith(".jar")) {
                list.add(lib.getCanonicalPath());
            } else {
                for (File file : lib.listFiles()) {
                    if (file.isFile() && file.getName().endsWith(".jar"))
                        list.add(file.getCanonicalPath());
                }
            }
        }
        String[] ret = new String[list.size()];
        int i = 0;
        for (String s : list)
            ret[i++] = s;
        return ret;
    }
}

package main.java;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by yizhao on 4/6/15.
 */
public class SortWords {

    public static class mMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
        private final static IntWritable one = new IntWritable(1);
        private Text word = new Text();

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens()) {
                word.set(tokenizer.nextToken());
                context.write(word, one);
            }
        }
    }

    public static class mReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
        public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
//            int sum = 0;
//            for (IntWritable val : values) {
//                sum += val.get();
//            }
//            for(int i = 0; i <= sum ; i++) {
                context.write(key, new IntWritable(1));
         //   }
        }
    }

    public static void main(String[] args) throws Exception {
        //String hadoopFS = "hdfs://localhost:9000/";
        //String sequenceFileName = "/fuhu/logs/kafka/logging_consumer/temp/test.log";
        Configuration conf = new Configuration();
        //conf.set("fs.defaultFS", hadoopFS);
        //org.apache.hadoop.fs.Path path = new org.apache.hadoop.fs.Path(sequenceFileName);

        Job job = new Job(conf, "Sort Words");

        job.setMapperClass(mMapper.class);
        job.setCombinerClass(mReducer.class);
        job.setReducerClass(mReducer.class);
        //此处的设置是最终输出的key/value，一定要注意！
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        //再次理解此处设置的输入输出格式。。。它表示的是一种对文件划分，索引的方法
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path("/Users/yizhao/Desktop/mergedOutput"));
        FileOutputFormat.setOutputPath(job, new Path("/Users/yizhao/Desktop/output"));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

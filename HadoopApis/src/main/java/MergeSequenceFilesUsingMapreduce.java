package main.java;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

import java.io.IOException;

/**
 * Created by yizhao on 4/6/15.
 */
public class MergeSequenceFilesUsingMapreduce {
    static String hadoopFS = "hdfs://localhost:9000/";
    static String defaultFS = "fs.defaultFS";
    static Configuration conf = new Configuration();
    static String srcPath = "/fuhu/logs/kafka/logging_consumer/temp";
    static String dstPath = "/fuhu/logs/kafka/logging_consumer/mergedOutput";

    static {
        conf.set(defaultFS, hadoopFS);
    }

    public static class mMapper extends Mapper<LongWritable, Text, BytesWritable, BytesWritable> {
        public void map(LongWritable key, BytesWritable value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            context.write(new BytesWritable(value.getBytes()), new BytesWritable());
        }
    }

    public static class mReducer extends Reducer<Text, Text, BytesWritable, BytesWritable> {
        public void reduce(BytesWritable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            context.write(key, new BytesWritable());
        }
    }


    public static void main(String[] args) throws Exception {
        Job job = new Job(conf);
        job.setJobName("MergeTextFiles");

        job.setMapperClass(mMapper.class);
        job.setCombinerClass(mReducer.class);
        job.setReducerClass(mReducer.class);
        //此处的设置是最终输出的key/value，一定要注意！
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(BytesWritable.class);
        //再次理解此处设置的输入输出格式。。。它表示的是一种对文件划分，索引的方法
        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);
        job.setNumReduceTasks(1);
        FileInputFormat.setInputPaths(job, new Path(srcPath));
        FileOutputFormat.setOutputPath(job, new Path(dstPath));
        job.waitForCompletion(true);
    }
}

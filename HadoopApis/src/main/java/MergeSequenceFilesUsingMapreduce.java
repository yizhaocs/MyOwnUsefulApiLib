package main.java;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
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

/**
 * Created by yizhao on 4/6/15.
 */
public class MergeSequenceFilesUsingMapreduce {
    static String hadoopFS = "hdfs://localhost:9000/";
    static String defaultFS = "fs.defaultFS";
    static Configuration conf = new Configuration();
    static String srcPath = "/fuhu/logs/kafka/logging_consumer/temp";
    static String dstPath = "/fuhu/logs/kafka/logging_consumer/mergedOutput/mergedFile.log";

    static {
        conf.set(defaultFS, hadoopFS);
    }

    public static class mMapper extends Mapper<LongWritable, Text, Text, Text> {
        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            context.write(new Text(line), new Text(""));
        }
    }

    public static class mReducer extends Reducer<Text, Text, Text, Text> {
        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
            context.write(key, new Text(""));
        }
    }


    public static void main(String[] args) throws Exception {
        Job job = new Job(conf);
        job.setJobName("MergeTextFiles");
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        job.setMapperClass(mMapper.class);
        job.setCombinerClass(mReducer.class);
        job.setReducerClass(mReducer.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        FileInputFormat.setInputPaths(job, new Path(srcPath));
        FileOutputFormat.setOutputPath(job, new Path(dstPath));
        job.waitForCompletion(true);
    }
}

package main.java;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 * Created by yizhao on 4/6/15.
 */
public class MergeSequenceFilesUsingMapreduce {
    static String hadoopFS = "hdfs://localhost:9000/";
    static String defaultFS = "fs.defaultFS";


//    static {
//        conf.set(defaultFS, hadoopFS);
//    }

//    public static class mMapper extends Mapper<LongWritable, BytesWritable, BytesWritable, Text> {
//        public void map(LongWritable key, BytesWritable value, Context context) throws IOException, InterruptedException {
//            context.write(value, new Text(""));
//        }
//    }
//
//    public static class mReducer extends Reducer<Text, Text, Text, Text> {
//        public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
//            for(Text value: values) {
//                context.write(value,  value);
//            }
//        }
//    }


    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf);
        job.setJobName("MergeTextFiles");

        job.setMapperClass(Mapper.class);
 //       job.setCombinerClass(Reducer.class);
//        job.setReducerClass(mReducer.class);
        //此处的设置是最终输出的key/value，一定要注意！
//        job.setOutputKeyClass(BytesWritable.class);
//        job.setOutputValueClass(BytesWritable.class);
        //再次理解此处设置的输入输出格式。。。它表示的是一种对文件划分，索引的方法
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);
        job.setNumReduceTasks(1);
         String srcPath = "/Users/yizhao/Desktop/mergedOutput";
         String dstPath = "/Users/yizhao/Desktop/output";

        FileInputFormat.setInputPaths(job, new Path(srcPath));
        FileOutputFormat.setOutputPath(job, new Path(dstPath));
        job.waitForCompletion(true);
    }
}

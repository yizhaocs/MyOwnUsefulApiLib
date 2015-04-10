package main.java;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

import java.io.IOException;

/**
 * Created by yizhao on 4/7/15.
 */
public class MergeTextFilesToSequenceFileUsingMapreduce {
    public static class mMapper extends Mapper<Object, Text, NullWritable, Text> {
        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException {
            System.out.println(value.toString());
            context.write(NullWritable.get(), value);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "MergeTextFilesToSequenceFileUsingMapreduce");
        job.setJarByClass(mMapper.class);
        job.setMapperClass(mMapper.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);
        String srcPath = "/Users/yizhao/Desktop/txtfiles";
        String dstPath = "/Users/yizhao/Desktop/output";
        FileInputFormat.setInputPaths(job, new Path(srcPath));
        FileOutputFormat.setOutputPath(job, new Path(dstPath));
        boolean result = job.waitForCompletion(true);
        System.exit(result ? 0 : 1);
    }
}
package main.java;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
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
public class SequenceFileGenerator {
    public static class BinaryFilesToHadoopSequenceFileMapper extends Mapper<Object, Text, Text, BytesWritable> {
        public void map(Object key, Text value, Context context)
                throws IOException, InterruptedException {
            context.write(new Text("a"), new BytesWritable("b".getBytes()));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf,"BinaryFilesToHadoopSequenceFile");
        job.setJarByClass(BinaryFilesToHadoopSequenceFileMapper.class);
        job.setMapperClass(BinaryFilesToHadoopSequenceFileMapper.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(BytesWritable.class);
        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);
        String srcPath = "/Users/yizhao/Desktop/a.png";
        String dstPath = "/Users/yizhao/Desktop/output";
        FileInputFormat.setInputPaths(job, new Path(srcPath));
        FileOutputFormat.setOutputPath(job, new Path(dstPath));
        System.exit(job.waitForCompletion(true)?0:1);
    }
}

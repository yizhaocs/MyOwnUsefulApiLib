package main.java;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.SequenceFileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.SequenceFileOutputFormat;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yizhao on 4/6/15.
 */
public class MergeSequenceFilesUsingMapreduce {
    public static class mMapper extends Mapper<Object, BytesWritable, NullWritable, BytesWritable> {
        public void map(Object key, BytesWritable value, Context context)
                throws IOException, InterruptedException {
            context.write(NullWritable.get(), value);
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();
        Job job = new Job(conf, "MergeSequenceFilesUsingMapreduce");
        job.setJarByClass(mMapper.class);
        job.setMapperClass(mMapper.class);
        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(BytesWritable.class);
        job.setInputFormatClass(SequenceFileInputFormat.class);
        job.setOutputFormatClass(SequenceFileOutputFormat.class);
        String srcPath = "/Users/yizhao/Desktop/txtfiles";
        String dstPath = "/Users/yizhao/Desktop/output";
        FileInputFormat.setInputPaths(job, new Path(srcPath));
        FileOutputFormat.setOutputPath(job, new Path(dstPath));
        System.out.println("Mapreduce starting:" + getCurrentDateTime());
        boolean result = job.waitForCompletion(true);
        if(result){
            System.out.println("Mapreduce finished:" + getCurrentDateTime());
        }
        System.exit(result ? 0 : 1);
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Date date = new Date();
        return dateFormat.format(date).toString();
    }
}

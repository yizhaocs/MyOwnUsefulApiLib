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

public class MergeTextFiles {
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
		Configuration conf = new Configuration();
		Job job = new Job(conf);
		job.setJobName("MergeTextFiles");

		job.setMapperClass(mMapper.class);
		job.setCombinerClass(mReducer.class);
		job.setReducerClass(mReducer.class);
        //此处的设置是最终输出的key/value，一定要注意！
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        //再次理解此处设置的输入输出格式。。。它表示的是一种对文件划分，索引的方法
		job.setInputFormatClass(TextInputFormat.class);
		job.setOutputFormatClass(TextOutputFormat.class);
		FileInputFormat.setInputPaths(job, new Path("/Users/yizhao/Desktop/input"));
		FileOutputFormat.setOutputPath(job, new Path("/Users/yizhao/Desktop/output"));
		job.waitForCompletion(true);
	}
}

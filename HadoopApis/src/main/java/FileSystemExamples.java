package main.java;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * Created by yizhao on 4/10/15.
 */
public class FileSystemExamples {


    public static void main(String[] args) throws Exception{
        String srcPath = "/Users/yizhao/Desktop/txtfiles";
        String dstPath = "/Users/yizhao/Desktop/output/";

        Configuration conf = new Configuration();
        FileSystem hdfs = FileSystem.get(conf);
        hdfs.createNewFile(new Path(srcPath+ "/" + ".running" ));
        hdfs.createNewFile(new Path(srcPath + "/" + ".success" ));
        hdfs.createNewFile(new Path(srcPath + "/" + ".failed"));
    }
}

package main.java;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.conf.Configuration;
import java.io.IOException;

/**
 * Reference: http://stackoverflow.com/questions/25622738/adding-output-files-to-an-existing-output-directory-in-mapreduce
 */
public class MoveFilesWithinHDFS {
    public void moveFiles(Path from, Path to, Configuration conf) throws IOException {
        FileSystem fs = from.getFileSystem(conf); // get file system
        for (FileStatus status : fs.listStatus(from)) { // list all files in 'from' folder
            Path file = status.getPath(); // get path to file in 'from' folder
            Path dst = new Path(to, file.getName()); // create new file name
            fs.rename(file, dst); // move file from 'from' folder to 'to' folder
        }
    }
}

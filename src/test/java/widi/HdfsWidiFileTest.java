package widi;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Before;
import org.junit.Test;

public class HdfsWidiFileTest {

    private FileSystem fs;

    @Before
    public void setUp() {
        try {
            Configuration conf = new Configuration();
            conf.addResource(new Path("./core-site.xml")); // Replace with actual path
            conf.addResource(new Path("./hdfs-site.xml")); // Replace with actual path

            fs = FileSystem.get(conf);
            System.out.println(conf.get("fs.defaultFS"));

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("error " + e.getMessage());
        }

    }

    private void writeFile(FileSystem fileSys, Path name) throws IOException {
        FSDataOutputStream stm = fileSys.create(name);
        stm.close();
    }

    @Test
    public void checkFileWrite() throws Exception {
        writeFile(fs, new Path("/home/widi/widi/file"));
        assertThat(fs.exists(new Path("/home/widi/widi/file")), is(true));
    }

    @Test
    public void checkFileDelete() throws Exception {
//        writeFile(fs, new Path("/home/widi/widi/file"));
        writeFile(fs, new Path("/home/widi/widi/file2"));
        assertThat(fs.exists(new Path("/home/widi/widi/file2")), is(true));
        assertThat(fs.delete(new Path("/home/widi/widi/file2"), true), is(true));
        assertThat(fs.exists(new Path("/home/widi/widi/file2")), is(false));
    }
}

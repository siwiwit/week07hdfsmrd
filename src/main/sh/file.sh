: == url_cat
: == filesystem_cat
: == filesystem_double_cat
: == list_status
: == file_copy_with_progress
: == rm -r /app/user/workspaces/kuliah/2021/GANJIL/BIGDATA/PERTEMUAN/WEEK_07/bigdatamr/week07hdfsmrd/output
export HADOOP_CLASSPATH=target/classes
hdfs dfs -mkdir /user
hdfs dfs -mkdir /user/tom
hdfs dfs -put ./input/quangle.txt hdfs://localhost:9000/user/tom/quangle.txt
: vv url_cat
hadoop hdfs.URLCat hdfs://localhost:9000/user/tom/quangle.txt
: ^^ url_cat
: vv filesystem_cat
hadoop hdfs.FileSystemCat hdfs://localhost:9000/user/tom/quangle.txt
: ^^ filesystem_cat
: vv filesystem_double_cat
hadoop hdfs.FileSystemDoubleCat hdfs://localhost:9000/user/tom/quangle.txt
: ^^ filesystem_double_cat
: vv list_status
hadoop hdfs.ListStatus hdfs://localhost:9000/ hdfs://localhost:9000/user/tom
: ^^ list_status
: vv file_copy_with_progress
hadoop hdfs.FileCopyWithProgress input/docs/1400-8.txt hdfs://localhost:9000/user/tom/1400-8.txt
: ^^ file_copy_with_progress



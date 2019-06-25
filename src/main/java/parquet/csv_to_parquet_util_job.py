import glob
import os
import shutil
import sys

from pyspark.sql import SparkSession

input_dir = sys.argv[1] if len(sys.argv) > 1 else "/media/sf_WinLinShared/input"
output_dir = input_dir + "_output"
separator = sys.argv[2] if len(sys.argv) > 2 else ","
is_header = False if len(sys.argv) > 3 and sys.argv[3].lower() == "false" else True

csv_files = []
for top, dirs, files in os.walk(input_dir):
    for file in files:
        if '.csv' in file:
            csv_files.append(os.path.join(top, file))

if len(csv_files) == 0:
    print("\nExample of usage: my/input/folder ; false")
    print("Default values: input_dir='input' separator=',' is_header='true'")
    sys.exit()

spark = SparkSession.builder.master("local[*]").appName("csv_to_parquet_util_job").getOrCreate()

for file in csv_files:
    file_name = os.path.splitext(file[len(input_dir + os.path.sep):])[0]
    target_folder = os.path.join(output_dir, file_name)

    df = spark.read.csv(file, sep=separator, header=is_header)
    df.write.parquet(target_folder)

    out_parquet = glob.glob(os.path.join(target_folder, "*.parquet"))[0]
    shutil.move(out_parquet, os.path.join(output_dir, file_name) + ".parquet")
    shutil.rmtree(target_folder)

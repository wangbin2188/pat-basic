# 这个脚本的作用就是查找指定目录下的文件，对文件中的内容进行操作，操作完之后保存
# 1.首先查找到当前目录的目标文件
# 2.另存为file.save
# 3.对file.save进行操作，然后追加到file
# 备注：如果操作较多，无法一个命令完成，可以将更新脚本写入file.sed ,通过sed -f file.sed的方式批量操作

dir=$1
cd $dir
find . -name '*.sh' -type f |
	while read file
	do 
		echo $file
		mv $file $file.save
		sed 's/jar/war/g' <$file.save >$file
	done

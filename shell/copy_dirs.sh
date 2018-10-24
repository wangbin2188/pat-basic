# 通过shell脚本复制目录树
old_dir=$1
new_dir=$PWD
find $old_dir -type d -print  |
	sed "s;${old_dir}/;${new_dir}/;" |
		while read newdir
			do 
				mkdir $newdir
			done
		

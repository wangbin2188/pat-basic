# 读取一个文件，并指定分隔符，格式化输出指定列
cat /etc/passwd |while IFS=: read user pass uid gid fullname homedir shell
	do printf "user='%s',fullname='%s'\n" $user $fullname
done



# 还有另外一种写法
while IFS=: read user pass uid gid fullname homedir shell
	do printf "user='%s',fullname='%s'\n" $user $fullname
done  < /etc/passwd 
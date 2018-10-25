# 这是一个简单的并发程序，有如下要求：
# 1.有两个程序a和b,希望他们能并发执行，以节约时间
# 2.a和b都是按照日期顺序执行，但b每日程序的前提条件是当日a的程序已经执行完毕
#解决方案：
# 1.创建一个文件描述符作为pipe，a程序每次执行完就把一个日期发送给pipe,然后继续执行
# 2.b程序每次执行时先从pipe读取a的日期，如果a的日期>=b的日期，则b继续执行，否则阻塞。

[ -e /tmp/fd5 ] || mkfifo /tmp/fd5
exec 5<>/tmp/fd5
rm -rf /tmp/fd5

aFun(){
for((i=0;i<10;i++))
do
	echo 'a'$i
	sleep 1
	echo $i >&5
done
}

bFun(){
for((i=0;i<10;i++))
do
	read -u5 j
	if [ $i -le $j ];then
        	echo 'b'$i
	fi
	sleep 1
done
}
###################################################
aFun &
bFun
exec 5<&-
exec 5>&-

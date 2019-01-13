package thinking_in_java.chapter8;

/**
 * 只有普通方法的调用时多态的，
 * 当sub对象转型为Super引用时，Super.field和Sub.field被分配了不同的存储空间；
 * 这样Sub实际上包含两个field变量
 */
public class FieldAccess {
    public static void main(String[] args) {
        Super sup = new Sub();
        System.out.println("sup.field=" + sup.field + ",sup.getField()=" + sup.getField());
        Sub sub=new Sub();
        System.out.println("sub.field="+sub.field+",sub.getField()="+sub.getField()+",sub.getSuperField()="+sub.getSuperField());
    }
}

class Super {
    public int field=0;

    public int getField() {
        return field;
    }
}

class Sub extends Super {
    public int field=1;

    @Override
    public int getField() {
        return field;
    }

    public int getSuperField() {
        return super.field;
    }
}

package depeng.depeng.java7_lang.datatype.compound.array;

public class DynamicCreateArray {

    private static Object resizeArray (Object oldArray, int newSize) {
        // 取得一个数组对象的length属性, JDK 提供了native方法来取
        int oldSize = java.lang.reflect.Array.getLength(oldArray);

        //不然就只能强制转换，应该有性能方面的问题？
        // 貌似不一定是性能问题，而是你根本无法预知oldArray的数组类型，强制转换的代码没法写！！
        //int[] a = (int[])oldArray;
        //oldSize = a.length;

        //Object[] o = new Object[100];
        //int length = o.length;

        Class elementType = oldArray.getClass().getComponentType(); //返回数组的元素类型的类对象
        System.out.println(oldArray.getClass()); //class [I ,这是一个int数组
        System.out.println(elementType); //int  ，这是int数组的元素类型

        // 这又是一个native方法，可以指定数组的类型和大小来创建数组，普通非native反射是无法做到的
        Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize);
        int preserveLength = Math.min(oldSize,newSize);
        if (preserveLength > 0)
            System.arraycopy (oldArray,0,newArray,0,preserveLength);
        return newArray;
    }

    public static void main (String[] args) {
        int[] a = {1,2,3};
        a = (int[])resizeArray(a,5);
        a[3] = 4;
        a[4] = 5;
        for (int anA : a) {
            System.out.println(anA);
        }
    }
}

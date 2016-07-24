package com.depeng.data_abstruct.inner_class;

public class OutClass {

    private String outName;


    class DefaultInnerClass {
        private String name;

        //ERROR： 非静态内部类不能有静态方法
        //public static void CanNotHave(String[] args) {

        public String out() {
            String outName1 = outName;
            System.out.println(outName);
            return outName1;
        }

    }

    private class PrivateInnerClass {
        private String name;
    }


    public class PublicInnerClass {
        private String name;

        public String out() {
            String outName1 = outName;
            System.out.println(outName);
            return outName1;
        }

    }


    public static class PublicStaticInnerClass {
        private String name;

        // static内部类能有静态方法
        public static void CanNotHave(String[] args) {

        }

    }


    public final static class FinalStaticInnerClass {
        private String name;

        public FinalStaticInnerClass(String name) {
            this.name = name;
        }

        public String say() {
            return name;
        }
    }

}

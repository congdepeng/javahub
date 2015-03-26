package depeng.design_pattern.builder;

public class App {
    public static void main(String[] args) {
        DataHolder.Builder builder = new DataHolder.Builder();
        DataHolder dataHolder = builder.withData("Data here").withNum(100).build();

        String data = dataHolder.getData();
        int num = dataHolder.getNum();
        System.out.println(data);
        System.out.println(num);
    }
}

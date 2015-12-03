package depeng.concurrent;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

public class App {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        ArrayList<String> in = Lists.newArrayList();
        in.add("http://www.zhihu.com/");
        in.add("http://getbootstrap.com/");
        in.add("http://coolshell.cn/articles/4990.html");

        ArrayList<Future<String>> out = Lists.newArrayList();
        for (final String s : in) {
            Future<String> submit = executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    if (s.equals("http://www.zhihu.com/")) {
                        throw new Exception();
                    }
                    System.out.println(new Date().getTime() + ":" + Thread.currentThread().getName() + "---> " + s);
                    return s;
                }
            });
            out.add(submit);
        }


        for (Future<String> stringFuture : out) {
            try {
                String s = stringFuture.get();
                System.out.println(Thread.currentThread().getName() + "---> " + s);
            } catch (Exception e) {
                System.err.println(Thread.currentThread().getName() + "--> fail a case.");
            }
        }


        executorService.shutdown();
    }

}

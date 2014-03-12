package depeng.lang.thread;

import java.util.Map;

public class MethodStack {

    private void methodRun() {
        System.out.println();
        Map<Thread,StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        int loop1=0;
        for (Thread thread : allStackTraces.keySet()) {
            loop1++;
            System.out.println(loop1+"***************");
            System.out.println(thread);
            StackTraceElement[] stackTrace = thread.getStackTrace();
            int loop11=0;
            for (StackTraceElement stackTraceElement : stackTrace) {
                loop11++;
                System.out.println(loop11+" ====>"+stackTraceElement);
                System.out.println("          -- class name -->"+stackTraceElement.getClassName());
                System.out.println("          -- file name -->"+stackTraceElement.getFileName());
                System.out.println("          -- line number -->"+stackTraceElement.getLineNumber());
                System.out.println("          -- method name -->"+stackTraceElement.getMethodName());
            }
        }


        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int loop2=0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            loop2++;
            System.out.println(loop2+" ====>"+stackTraceElement);
            System.out.println("          -- class name -->"+stackTraceElement.getClassName());
            System.out.println("          -- file name -->"+stackTraceElement.getFileName());
            System.out.println("          -- line number -->"+stackTraceElement.getLineNumber());
            System.out.println("          -- method name -->"+stackTraceElement.getMethodName());
        }

        String methodName = stackTrace[1].getMethodName();
        System.out.println("current method name = "+methodName);

    }


    public static void main(String[] args) {
        MethodStack methodStack = new MethodStack();
        methodStack.methodRun();
    }

}

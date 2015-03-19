package depeng.exception;

import java.util.Arrays;

public class NewExceptionWithMethod extends RuntimeException {

    private String name;

    public static NewExceptionWithMethod withName(String name) {
        NewExceptionWithMethod newExceptionWithMethod = new NewExceptionWithMethod();
        newExceptionWithMethod.printStackTrace();

        StackTraceElement[] stackTrace = newExceptionWithMethod.getStackTrace();
        StackTraceElement[] stackTraceElements = Arrays.copyOfRange(stackTrace, 1, stackTrace.length);
        newExceptionWithMethod.setStackTrace(stackTraceElements);
        return newExceptionWithMethod.setName(name);
    }
    
    public String getName() {
        return name;
    }

    public NewExceptionWithMethod setName(String name) {
        this.name = name;
        return this;
    }
}

package depeng.jdk_api.thread;

public class GetCallerInfo {


    /**
     * replace GetCallerInfo.class to a new class
     * getCallerInfo() return a info about from where the GetCallerInfo.method be invoked
     *
     * @return
     */
    private static String getCallerInfo() {
        int index = 0;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            index++;
            String stackName = stackTraceElement.getClassName();
            if (!stackName.equals(Thread.class.getCanonicalName())
                    && !stackName.equals(GetCallerInfo.class.getCanonicalName())) {
                break;
            }
        }
        return getCallerClassName(index) + "#" + getCallerMethodName(index) + "(" + getCallerFileName(index) + ":" + getCallerLineNumber(index) + ")";
    }


    private static String getCallerClassName(int index) {
        return Thread.currentThread().getStackTrace()[index].getClassName();
    }

    private static String getCallerFileName(int index) {
        return Thread.currentThread().getStackTrace()[index].getFileName();
    }

    private static String getCallerMethodName(int index) {
        return Thread.currentThread().getStackTrace()[index].getMethodName();
    }

    private static int getCallerLineNumber(int index) {
        return Thread.currentThread().getStackTrace()[index].getLineNumber();
    }
}

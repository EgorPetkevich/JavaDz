package hw2;

public class Task4 {
    public record CallingInfo(String className, String methodName) {}

    public static class CallingInfoExtractor {
        public static CallingInfo callingInfo() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

            if (stackTrace.length >= 3) {
                String className = stackTrace[2].getClassName();
                String methodName = stackTrace[2].getMethodName();
                return new CallingInfo(className, methodName);
            } else {
                return null;
            }
        }

        public static void main(String[] args) {
            CallingInfo info = callingInfo();
            if (info != null) {
                System.out.println("Calling class: " + info.className());
                System.out.println("Calling method: " + info.methodName());
            } else {
                System.out.println("Calling info not available.");
            }
        }
    }
}

package thread_safe.npe;

public class Main {
    private static Object o = null;

    public static void main(String[] args) {
        synchronized (o) {

        }
    }
}

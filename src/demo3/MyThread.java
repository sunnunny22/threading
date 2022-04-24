package demo3;

import javax.rmi.CORBA.Util;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class MyThread extends Thread {
    MyThread() throws InterruptedException {
        while(true){

            TimeUnit.SECONDS.sleep(1);
            System.out.println("你好");
        }

    }
    @Override
    public void run() {
        System.out.println(Add.add(1,2));
    }
}

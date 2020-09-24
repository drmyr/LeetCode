package concurrency;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.concurrent.*;

/*
    Should print `foobar` over and over. Output must start with `foo` and end with `bar`
*/

@FieldDefaults(level = AccessLevel.PRIVATE)
public class FooBarPrinter {
    int n;
    final BlockingQueue<String> syncQueue = new SynchronousQueue<>();
    final CountDownLatch cdl = new CountDownLatch(1);

    public void foo(final Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            syncQueue.take();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            cdl.countDown();
            syncQueue.put("flag");
        }
    }

    public void bar(final Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            syncQueue.put("flag");
            // printBar.run() outputs "bar". Do not change or remove this line.
            cdl.await();
        	printBar.run();
            syncQueue.take();

        }
    }
}
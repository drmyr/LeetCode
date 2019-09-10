import java.util.concurrent.*;

/*
    Should print `foobar` over and over. Output must start with `foo` and end with `bar`
*/

class FooBarPrinter {
    private int n;
    BlockingQueue<String> syncQueue = new SynchronousQueue<>();
    CountDownLatch cdl = new CountDownLatch(1);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            syncQueue.take();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            cdl.countDown();
            syncQueue.put("flag");
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            syncQueue.put("flag");
            // printBar.run() outputs "bar". Do not change or remove this line.
            cdl.await();
        	printBar.run();
            syncQueue.take();

        }
    }
}
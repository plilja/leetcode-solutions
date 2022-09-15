class Foo {
    private AtomicBoolean firstFired = new AtomicBoolean(false);
    private AtomicBoolean secondFired = new AtomicBoolean(false);

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (firstFired) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFired.set(true);
            firstFired.notify();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (firstFired) {
            while (!firstFired.get()) {
                firstFired.wait();
            }
        }
        synchronized (secondFired) {
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFired.set(true);
            secondFired.notify();
        }
        
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (secondFired) {
            while (!secondFired.get()) {
                secondFired.wait();
            }
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

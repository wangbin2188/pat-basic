package thinking_in_java.chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Created by wangbin10 on 2019/1/11.
 */
public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("innerThread1");
        new InnerThread2("innerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}

class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    public InnerThread1(String name) {
        inner = new Inner(name);
    }

    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupt");
            }
        }

        @Override
        public String toString() {
            return getName() + ":" + countDown;
        }
    }
}

class InnerThread2 {
    private int countDown = 5;
    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(100);
                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupt");
                }
            }

            @Override
            public String toString() {
                return getName() + ":" + countDown;
            }
        };
        t.start();
    }
}

class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable {
        Thread t;

        public Inner(String name) {
            this.t = new Thread(this,name);
            t.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupt");
            }
        }

        @Override
        public String toString() {
            return Thread.currentThread().getName() + ":" + countDown;
        }
    }
}


class InnerRunnable2 {
    private int countDown = 5;
    private Thread t;

    public InnerRunnable2(String name) {
        t=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(100);
                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupt");
                }
            }
        },name);
        t.start();
    }
}

class ThreadMethod {
    private int countDown=5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (t == null) {
            t = new Thread(name){
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println(this);
                            if (--countDown == 0) {
                                return;
                            }
                            sleep(10);
                        }
                    } catch (InterruptedException e) {
                        System.out.println("sleep interrupt");
                    }
                }
            };
            t.start();
        }
    }
}
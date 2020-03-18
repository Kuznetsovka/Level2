package lesson5;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] a1 = new float[HALF];
    static float[] a2 = new float[HALF];

    public static void main(String[] args) {
        System.out.println("Start");
        method1();
        method2();
    }

    public static void method1() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++)
            arr[i] = 1;
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void method2() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < SIZE; i++)
            arr[i] = 1;
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, HALF, a2, 0, HALF);
        MyThread mt1 = new MyThread(a1);
        MyThread mt2 = new MyThread(a2);
        mt1.start();
        mt2.start();
        try {
            mt1.join();
            mt2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, HALF);
        System.arraycopy(a2, 0, arr, HALF, HALF);
        System.out.println(System.currentTimeMillis() - a);
    }

    public static synchronized void calculate(float[] myArr) {
        for (int i = 0; i < myArr.length; i++)
            myArr[i] = (float) (myArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
    }

    static class MyThread extends Thread {
        float[] myArr;

        public MyThread(float[] myArr) {
            super();
            this.myArr = myArr;
        }

        @Override
        public void run() {
            if (!isInterrupted()) {
                try {
                    calculate(myArr);
                    sleep(1);
                } catch (InterruptedException e) {
                    this.interrupted();
                }
            }
        }

    }
}
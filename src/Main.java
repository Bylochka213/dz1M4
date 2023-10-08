public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("Counter: " + counter.getValue());
    }
}
//Результат может быть разным каждый раз из-за проблемы с одновременным доступом к общему ресурсу count из нескольких потоков. В вашем коде, два потока thread и thread1 одновременно выполняют инкрементацию count.
//
//Когда несколько потоков одновременно выполняют операции чтения и записи на общий ресурс без синхронизации, может возникать состояние гонки (race condition). Это может приводить к непредсказуемому результату, такому как неправильные значения count или даже аварийное завершение программы.
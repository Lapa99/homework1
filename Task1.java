public class Dz4 {
    public static class Main {
        private static Object lock = new Object();
        private static volatile char lastLetter = 'C';

        public static void main(String[] args) {
            LetterPrinter threadA = new LetterPrinter('C', 'A');
            LetterPrinter threadB = new LetterPrinter('A', 'B');
            LetterPrinter threadC = new LetterPrinter('B', 'C');

            threadA.start();
            threadB.start();
            threadC.start();
        }

        private static class LetterPrinter extends Thread {
            private char before;
            private char after;

            public LetterPrinter(char before, char after) {
                this.before = before;
                this.after = after;
            }

            @Override
            public void run() {
                try {
                    for (int i = 0; i < 5; i++) {
                        synchronized (lock) {
                            while (lastLetter != before) {
                                lock.wait();
                            }
                            System.out.print(after);
                            lastLetter = after;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

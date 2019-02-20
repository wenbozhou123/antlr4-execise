package myConcurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class Piped {

    public static void main(String[] args) throws IOException {
        PipedWriter writer = new PipedWriter();
        PipedReader reader = new PipedReader();

        //将输出流和输入流进行连接，否则在使用时会抛出IOException
        writer.connect(reader);
        Thread printThread = new Thread(new Print(reader), "PrintThread");
        printThread.start();

        int receive = 0;
        int temp = System.in.read();
        try {
            while ((receive = System.in.read()) != -1) {
                writer.write(receive);
            }
        } finally {
            writer.close();
        }
    }

    static class Print implements Runnable {
        private PipedReader reader;

        public Print(PipedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            int receive = 0;
            try {
                while ((receive = reader.read()) != -1) {
                    System.out.print((char) receive);
                }
            } catch (IOException e) {

            }

        }
    }
}

package myConcurrent.simpleWebServer;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SimpleHttpServer {

    //处理HttpRequest线程池
    /*static ThreadPool<HttpRequest> threadPool = new Defa*/

    static class HttpRequestHandler implements Runnable{
        private Socket socket;
        public HttpRequestHandler(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            try {

            }catch (Exception e){

            }finally {

            }
        }
    }
}

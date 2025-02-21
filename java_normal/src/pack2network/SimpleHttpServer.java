package pack2network;
    // http란 인터넷에서 정보를 주고받기 위한 프로토콜로 웹의 기반 기술.
    // 웹 브라우저와 웹 서버 간에 메시지를 주고받는 방식을 정의함

    // 웹 서버는 웹 브라우저에서 요청(HTTP 요청)은 HTML 문서나 이미지 파일 등을 전송해주는 서비스 프로그램
    // 웹 서버는 인터넷에 연결되어 있어, 웹에 연결된 다른 기기들이 웹 서버의 데이터를 주고받을 수 있도록 함.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

// 간단한 HttpServer 프로그램을 작성 : 서버 소켓을 생성하고 클라이언트 연결을 기다리다가 연결이 되면
    // 스레드를 생성하여 클라이언트 요청을 처리하는 서버(서버 socket vs 클라이언트 socket 통신), naver 웹 서버 등의 기본 기술임
    public class SimpleHttpServer {
        private ServerSocket serverSocket;
        private final int PORT;

    public SimpleHttpServer(int port) {
        this.PORT = port;
    }

    public void gogo() throws Exception {
        serverSocket = new ServerSocket(PORT);
        System.out.println("웹 서버 서비스 중 포트 번호는 " + PORT);

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Received request from " + clientSocket.getRemoteSocketAddress());
                ClientHandlerClass handlerClass = new ClientHandlerClass(clientSocket);
                new Thread(handlerClass).start(); // runnable은 handlerClass가 갖고 있다.
            } catch (Exception e) {
                System.out.println("error connection : " + e);
                break;
            }
        }
    }
    private static class ClientHandlerClass implements Runnable { // 통신은 여기에서
        private Socket clientSocket;

        public ClientHandlerClass(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // 입출력 객체 생성
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

                // 요청 처리
                String requestLine = in.readLine();
                System.out.println("request : " + requestLine);

                // Http Response (html 문서 전송)
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type:text/html;charset=UTF-8");
                out.println("");
                out.println("<html><body><h1>안녕 ㅎㅅㅎ</h1>");
                out.println("<a href='https://www.kbs.co.kr'>kbs 방송국</a>");
                out.println("</body></html>");
                out.close();
                in.close();
                clientSocket.close();

            } catch (Exception e) {
                System.out.println("error ClientHandlerClass : " + e);
            }
        }
    }

    public static void main(String[] args) {
        int port = 8080;
        try {
            SimpleHttpServer httpServer = new SimpleHttpServer(port);
            httpServer.gogo();
        } catch (Exception e) {
            System.out.println("error starting server : " + e);
        }
    }
}

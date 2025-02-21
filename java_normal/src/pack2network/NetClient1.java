package pack2network;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class NetClient1 {
	public static void main(String[] args) {
		// 일회용 echo server에 접속 후메세지 전송용
		try {
			// 서버 socket과 통신하기 socket 객체 생성 후 접속(서버의 serverSocket.accept()를 만남)
			Socket socket = new Socket("192.168.0.28", 8888);

			PrintWriter writer = new PrintWriter(
					new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true); //true는 처리 끝나면 비우라는 소리
			
			writer.println("안녕 난 시마자키 하루카라고 해"); // 서버로 자료 전송
			writer.close();
			
			socket.close();
		} catch (Exception e) {
			System.out.println("client err : " + e);
		}
	}
}

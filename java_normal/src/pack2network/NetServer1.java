package pack2network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/*
소켓(Socket)은 네트워크 통신에서 두 컴퓨터 간에 데이터를 주고받기 위한 통신 엔드포인트입니다. 간단히 말해, 소켓은 네트워크 상에서 데이터를 송수신할 수 있는 통로 역할을 합니다.
IP 주소와 포트 번호를 통해 네트워크 상에서 특정 컴퓨터와 프로그램을 식별합니다.
TCP나 UDP와 같은 프로토콜을 이용해 연결을 설정하고, 데이터를 주고받을 수 있습니다.
서버는 특정 포트에서 대기하고, 클라이언트는 그 포트에 접속하여 데이터를 전송합니다.
소켓을 사용하면 네트워크를 통한 양방향 통신이 가능합니다!
*/
//서버와 클라이언트
//소켓 통신에서는 서버와 클라이언트가 존재하며, 서버는 데이터를 제공하는 쪽을 말하며 클라이언트는 데이터를 요청하여 제공받는 쪽을 말한다.
public class NetServer1 {
	public static void main(String[] args) {
		// 단순 에코 서버
		ServerSocket serverSocket = null; // 서버소켓 생성
		
		// 내 컴퓨터가 사용 중인 port number 확인
		/*
		for (int i = 0; i < 65536; i++) {
			try {
				serverSocket = new ServerSocket(i);
				serverSocket.close();
			} catch (Exception e) {
				System.out.println(i + "번 포트번호는 사용 중");
			}
		}
		System.out.println("확인 완료");
		*/
		Socket socket = null; //클라이언트와 송수신을 위함
		try {
			serverSocket = new ServerSocket(8888); // ip와 port number를 binding한 후 listening
			System.out.println("서버 서비스 시작 ...");
			socket = serverSocket.accept(); // ServerSocket이 클라이언트 요청을 대기하다가 접속하면 클라이언트와 통신하기 위한 Socket 객체 생성 
			
			// 현재 웹 서버는 실험용으로 클라이언트 메세지를 받아 출력하고 종료하는 일회용 서비스
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			String data = reader.readLine();
			System.out.println("수신된 자료 : " + data);
			
			reader.close();
			socket.close();
			serverSocket.close();
		} catch (Exception e) {
			System.out.println("server err : " + e);
		}
		
	}
}

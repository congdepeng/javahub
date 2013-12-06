package depeng.thrift.demo.impl.simple.client;

import depeng.thrift.demo.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by depeng on 12/6/13.
 */
public class HelloClient {
	public static final String server_ip = "localhost";
	public static final int port = 8090;
	public static final int timeout = 30000;

	public void startClient(String userName) {

		TTransport transport = new TSocket(server_ip, port, timeout);
		TProtocol protocol = new TBinaryProtocol(transport);

		HelloService.Client client = new HelloService.Client(protocol);
		try {
			transport.open();
		} catch (TTransportException e) {
			e.printStackTrace();
		}

		String s = null;
		try {
			s = client.sayHello(userName);
		} catch (TException e) {
			e.printStackTrace();
		} finally {
			transport.close();
		}

		System.out.println(s);



	}


	public static void main(String[] args) {
		HelloClient helloClient = new HelloClient();
		helloClient.startClient("fuck thrift");
	}


}

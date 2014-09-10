package depeng.thrift.demo.impl.simple.server;

import depeng.thrift.demo.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by depeng on 12/6/13.
 */
public class HelloServer {
	public static final int Server_port = 8090;

	public void startServer() throws TTransportException {
		System.out.println("Server start ...");

//		http://www.micmiu.com/soa/rpc/thrift-sample/
/*
		实现服务处理接口impl
				创建TProcessor
		创建TServerTransport
				创建TProtocol
		创建TServer
				启动Server*/

		//Server args
		TServer.Args args = new TServer.Args(new TServerSocket(Server_port));  // 1. Transport (Server port)
		args.protocolFactory(new TBinaryProtocol.Factory());  // 3. Protocol
		args.processor(new HelloService.Processor<HelloService.Iface>(new HelloService.Iface() {
			@Override
			public String sayHello(String username) throws TException {
				return "dddddddddd";
			}
		})); // 2. Processor


		TServer server = new TSimpleServer(args);
		server.serve();

	}


	public static void main(String[] args) throws TTransportException {
		HelloServer helloServerDemo = new HelloServer();
		helloServerDemo.startServer();
	}

}

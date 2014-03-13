package depeng.thrift.demo.impl.blockIO;

import depeng.thrift.demo.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class Server {

	public static void main(String[] args) {

		HelloService.Processor<HelloService.Iface> processor = new HelloService.Processor<HelloService.Iface>(new HelloService.Iface() {
			@Override
			public String sayHello(String username) throws TException {
				return "This is block IO server " + username;
			}
		});


		try {
			TThreadPoolServer.Args a = new TThreadPoolServer.Args(new TServerSocket(8090));
			a.processor(processor);
			a.protocolFactory(new TBinaryProtocol.Factory());

			TThreadPoolServer tThreadPoolServer = new TThreadPoolServer(a);
			tThreadPoolServer.serve();


		} catch (TTransportException e) {
			e.printStackTrace();
		}


	}
}

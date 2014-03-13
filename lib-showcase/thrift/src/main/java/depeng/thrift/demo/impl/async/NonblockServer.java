package depeng.thrift.demo.impl.async;

import depeng.thrift.demo.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by depeng on 12/6/13.
 */
public class NonblockServer {



	public static void main(String[] argsxx) throws TTransportException {


		HelloService.Processor<HelloService.Iface> processor = new HelloService.Processor<HelloService.Iface>(new HelloService.Iface() {
			@Override
			public String sayHello(String username) throws TException {
				return "This is block IO server " + username;
			}
		});


		TNonblockingServer.Args args = new TNonblockingServer.Args(new TNonblockingServerSocket(8090));
		args.processor(processor);
		args.transportFactory(new TFramedTransport.Factory());
		args.protocolFactory(new TCompactProtocol.Factory());

		TNonblockingServer tNonblockingServer = new TNonblockingServer(args);
		tNonblockingServer.serve();


	}


}

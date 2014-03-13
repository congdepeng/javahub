package depeng.thrift.demo.client;

import depeng.thrift.demo.HelloService;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.async.TAsyncClientManager;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.transport.TNonblockingSocket;
import sun.launcher.resources.launcher_zh_TW;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by depeng on 12/6/13.
 */
public class AsyncClient {

	public static void main(String[] args) throws IOException, TException, InterruptedException {
		TAsyncClientManager clientManager = new TAsyncClientManager();

		TNonblockingSocket transport = new TNonblockingSocket("localhost", 8090, 30000);

		TProtocolFactory tprotocol = new TCompactProtocol.Factory();

		HelloService.AsyncClient client = new HelloService.AsyncClient(tprotocol, clientManager, transport);

		System.out.println("client start");

		CountDownLatch countDownLatch = new CountDownLatch(1);
		AsynCallback asynCallback = new AsynCallback(countDownLatch);
		client.sayHello("call me ", asynCallback);
		boolean wait = countDownLatch.await(30, TimeUnit.SECONDS);

		System.out.println("wait..."+wait);


	}

	private static class AsynCallback implements AsyncMethodCallback<HelloService.AsyncClient.sayHello_call>{
		CountDownLatch countDownLatch;

		public AsynCallback(CountDownLatch countDownLatch) {
			   this.countDownLatch = countDownLatch;
		}

		@Override
		public void onComplete(HelloService.AsyncClient.sayHello_call sayHello_call) {
			System.out.println("On complete");

			String x = null;
			try {
				x = sayHello_call.getResult();
			} catch (TException e) {
				e.printStackTrace();
			}
			System.out.println(x);
		}

		@Override
		public void onError(Exception e) {
			System.out.println("on Error");
		}
	}
}

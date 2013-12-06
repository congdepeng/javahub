package depeng.thrift.demo.impl.simple.server;

import depeng.thrift.demo.HelloService;
import org.apache.thrift.TException;

/**
 * Created by depeng on 12/6/13.
 */
public class HelloWorldImpl implements HelloService.Iface {
	@Override
	public String sayHello(String username) throws TException {
		return "Hi "+username + ", welcome to use thrift";
	}
}

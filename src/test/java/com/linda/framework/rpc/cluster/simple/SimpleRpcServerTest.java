package com.linda.framework.rpc.cluster.simple;

import com.linda.framework.rpc.cluster.HelloRpcService;
import com.linda.framework.rpc.cluster.HelloRpcServiceImpl;
import com.linda.framework.rpc.cluster.HelloRpcTestService;
import com.linda.framework.rpc.cluster.HelloRpcTestServiceImpl;
import com.linda.framework.rpc.cluster.LoginRpcService;
import com.linda.framework.rpc.cluster.LoginRpcServiceImpl;
import com.linda.framework.rpc.server.SimpleRpcServer;

public class SimpleRpcServerTest {
	
	public static void main(String[] args) {
		
		SimpleRpcServer rpcServer = new SimpleRpcServer();
		rpcServer.setHost("127.0.0.1");
		rpcServer.setPort(4321);
		
		rpcServer.register(HelloRpcService.class, new HelloRpcServiceImpl());
		rpcServer.register(LoginRpcService.class, new LoginRpcServiceImpl());
		rpcServer.register(HelloRpcTestService.class, new HelloRpcTestServiceImpl());
		rpcServer.startService();
		System.out.println("--------started----------");
		
	}

}

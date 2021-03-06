package com.linda.framework.rpc.cluster.simple;

import java.util.List;

import com.linda.framework.rpc.RpcService;
import com.linda.framework.rpc.cluster.JSONUtils;
import com.linda.framework.rpc.cluster.RpcHostAndPort;
import com.linda.framework.rpc.cluster.admin.SimpleRpcAdminService;

public class SimpleAdminTest {
	
	public static void main(String[] args) {
		SimpleRpcAdminService adminService = new SimpleRpcAdminService();
		
		adminService.setHost("127.0.0.1");
		adminService.setPort(4321);
		
		adminService.startService();
		
		List<RpcHostAndPort> rpcServers = adminService.getRpcServers();
		
		System.out.println(JSONUtils.toJSON(rpcServers));
		
		for(RpcHostAndPort server:rpcServers){
			List<RpcService> services = adminService.getRpcServices(server);
			System.out.println(JSONUtils.toJSON(server.getHost()+":"+server.getPort()+"     "+services));
		}
		
	}

}

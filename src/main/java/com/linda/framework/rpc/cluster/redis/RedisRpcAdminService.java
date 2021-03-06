package com.linda.framework.rpc.cluster.redis;

import java.util.List;
import java.util.Set;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import com.linda.framework.rpc.RpcService;
import com.linda.framework.rpc.Service;
import com.linda.framework.rpc.cluster.RpcHostAndPort;
import com.linda.framework.rpc.cluster.admin.RpcAdminService;
import com.linda.framework.rpc.net.AbstractRpcConnector;

public class RedisRpcAdminService implements RpcAdminService, Service {

	private RedisRpcClient redisRpcClient = new RedisRpcClient();

	public Class<? extends AbstractRpcConnector> getConnectorClass() {
		return redisRpcClient.getConnectorClass();
	}

	public void setConnectorClass(Class<? extends AbstractRpcConnector> connectorClass) {
		redisRpcClient.setConnectorClass(connectorClass);
	}

	public String getRedisHost() {
		return redisRpcClient.getRedisHost();
	}

	public void setRedisHost(String host) {
		redisRpcClient.setRedisHost(host);
	}

	public int getRedisPort() {
		return redisRpcClient.getRedisPort();
	}

	public void setRedisPort(int port) {
		redisRpcClient.setRedisPort(port);
	}

	public Set<String> getRedisSentinels() {
		return redisRpcClient.getRedisSentinels();
	}

	public void setRedisSentinels(Set<String> sentinels) {
		redisRpcClient.setRedisSentinels(sentinels);
	}

	public String getRedisMasterName() {
		return redisRpcClient.getRedisMasterName();
	}

	public void setRedisMasterName(String masterName) {
		redisRpcClient.setRedisMasterName(masterName);
	}

	public GenericObjectPoolConfig getRedisPoolConfig() {
		return redisRpcClient.getRedisPoolConfig();
	}

	public void setRedisPoolConfig(GenericObjectPoolConfig poolConfig) {
		redisRpcClient.setRedisPoolConfig(poolConfig);
	}

	private RedisRpcClientExecutor getRedisExecutor() {
		return (RedisRpcClientExecutor) redisRpcClient.getRemoteExecutor();
	}

	@Override
	public List<RpcHostAndPort> getRpcServers() {
		return getRedisExecutor().getHostAndPorts();
	}

	@Override
	public List<RpcService> getRpcServices(RpcHostAndPort rpcServer) {
		return getRedisExecutor().getServerService(rpcServer);
	}

	@Override
	public void startService() {
		redisRpcClient.startService();
	}

	@Override
	public void stopService() {
		redisRpcClient.startService();
	}
}

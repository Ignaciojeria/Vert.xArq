package com.example.DemoVertx.server;

import org.springframework.stereotype.Component;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Future;

@Component
public class ServerLauncher extends AbstractVerticle {

	@Override
    public void start(Future<Void> done){
        int WORKER_POOL_SIZE = 100;

        DeploymentOptions opts = new DeploymentOptions().setWorkerPoolSize(WORKER_POOL_SIZE);
        String verticle = ServerVerticle.class.getName();
        vertx.deployVerticle(verticle, opts, res -> {
            if(res.failed()){
                System.out.println("Failed to deploy verticle");
                done.fail(res.cause());
            }
            else {
                System.out.println("Successfully deployed verticle");
                done.complete();
            }
        });
    }
}

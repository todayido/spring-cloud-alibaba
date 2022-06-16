package com.cloud.momo.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalance{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getIntIncrement() {
        int curr;
        int next;
        do {
            curr = this.atomicInteger.get();
            next = curr >= Integer.MAX_VALUE ? 0 : curr + 1;
            System.out.println("**********第" + next + "次访问***********");
        } while (!this.atomicInteger.compareAndSet(curr, next));
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getIntIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}

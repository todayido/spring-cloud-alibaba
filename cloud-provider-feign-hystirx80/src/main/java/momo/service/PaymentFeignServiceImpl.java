package momo.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceImpl implements PaymentFeignService{
    @Override
    public String paymentOK(Integer id) {
        System.out.println("PaymentFeignServiceImpl-paymentOK");
        return "error";
    }

    @Override
    public String paymentTimOut(Integer id) {
        System.out.println("PaymentFeignServiceImpl-paymentTimOut");
        return "timeout";
    }
}

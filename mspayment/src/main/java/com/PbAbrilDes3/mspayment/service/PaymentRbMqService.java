package com.PbAbrilDes3.mspayment.service;

import com.PbAbrilDes3.mspayment.entity.Payment;
import com.PbAbrilDes3.mspayment.repository.PaymentRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PaymentRbMqService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Transactional
    public Payment createPayment(Payment payment) {
        payment.setId(UUID.randomUUID());
        Payment savedPayment = paymentRepository.save(payment);

        rabbitTemplate.convertAndSend("paymentQueue", savedPayment);

        return savedPayment;
    }
}

package com.PbAbrilDes3.mscalculate.consumer;

import com.PbAbrilDes3.mscalculate.dto.CalculateRequest;
import com.PbAbrilDes3.mscalculate.dto.CalculateResponse;
import com.PbAbrilDes3.mscalculate.service.PointsCalculationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {

    @Autowired
    private PointsCalculationService pointsCalculationService;

    @RabbitListener(queues = "paymentQueue")
    public void handlePaymentMessage(Payment payment) {
        // Criar uma solicitação de cálculo
        CalculateRequest calculateRequest = new CalculateRequest();
        calculateRequest.setCategoryId(payment.getCategoryId());
        calculateRequest.setValue(payment.getTotal());

        // Calcular os pontos
        CalculateResponse response = pointsCalculationService.calculatePoints(calculateRequest);

        // Atualizar pontos do cliente com base no cálculo (deve ser implementado)
        // Exemplo: customerService.updateCustomerPoints(payment.getCustomerId(), response.getTotal());
    }
}

package com.example.shop_api.domain.status;

public enum ProductStatus {
    ORDER_CONFIRMING,   // 주문 확인중 (결제 완료 직후)
    PAYMENT_PENDING,    // 결제 대기중
    PAYMENT_COMPLETED,  // 결제 완료

    PREPARING,          // 상품 준비중
    READY_TO_SHIP,      // 발송 대기중
    SHIPPING,           // 배송중
    DELIVERED,          // 배송 완료

    CANCELLED,          // 주문 취소
    REFUND_REQUESTED,   // 환불 요청
    REFUNDED            // 환불 완료
}

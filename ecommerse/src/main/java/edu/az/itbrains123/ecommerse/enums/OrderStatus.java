package edu.az.itbrains123.ecommerse.enums;

public enum OrderStatus {
    PENDING,      // Order has been placed but not yet processed
    PROCESSING,   // Order is currently being processed
    SHIPPED,      // Order has been shipped but not yet delivered
    DELIVERED,    // Order has been delivered to the customer
    CANCELLED,    // Order has been cancelled
    RETURNED      // Order has been returned by the customer
}

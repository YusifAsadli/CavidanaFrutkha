package edu.az.itbrains123.ecommerse.repositories;

import edu.az.itbrains123.ecommerse.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon findByName(String name);
}

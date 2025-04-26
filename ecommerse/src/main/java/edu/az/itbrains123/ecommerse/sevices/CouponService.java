package edu.az.itbrains123.ecommerse.sevices;

import edu.az.itbrains123.ecommerse.dtos.coupon.CouponDto;
import edu.az.itbrains123.ecommerse.models.Coupon;

public interface CouponService {
    CouponDto getCoupon(String coupon);
}

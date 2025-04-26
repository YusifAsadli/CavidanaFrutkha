package edu.az.itbrains123.ecommerse.sevices.impls;

import edu.az.itbrains123.ecommerse.dtos.coupon.CouponDto;
import edu.az.itbrains123.ecommerse.models.Coupon;
import edu.az.itbrains123.ecommerse.repositories.CouponRepository;
import edu.az.itbrains123.ecommerse.sevices.CouponService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl implements CouponService {
    private final CouponRepository couponRepository;
    private final ModelMapper modelMapper;

    public CouponServiceImpl(CouponRepository couponRepository, ModelMapper modelMapper) {
        this.couponRepository = couponRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CouponDto getCoupon(String coupon) {
        try {
            Coupon findCoupon = couponRepository.findByName(coupon);
            CouponDto couponDto = modelMapper.map(findCoupon,CouponDto.class);
            return couponDto;
        }catch (Exception e){
            return  null;
        }
    }
}

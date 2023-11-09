package com.btc.swimpyo.backend.controller.room.user;

import com.btc.swimpyo.backend.dto.reservation.ReservationDto;
import com.btc.swimpyo.backend.dto.room.user.UserReviewDto;
import com.btc.swimpyo.backend.service.Reservation.user.UserReservationService;
import com.btc.swimpyo.backend.service.room.user.UserReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Log4j2
@RestController
@RequestMapping("/api/user/review")
@RequiredArgsConstructor
public class UserReviewController {

    private final UserReviewService userReviewService;

    // 등록
    @PostMapping(value = "/registReview", consumes = "multipart/form-data")
    public void registReview(@RequestPart(value = "userReviewDto", required = false) UserReviewDto userReviewDto,
                             @RequestPart(value = "userReservationDto", required = false) ReservationDto reservationDto,
                             @RequestPart(value = "reviewImages", required = false)MultipartFile[] reviewImages) {
        log.info("[UserReviewController] registReview()");

        log.info("reservationDto: " + reservationDto);
        userReviewDto.setU_r_no(reservationDto.getU_r_no());

        try {
            // reviewImages 차례대로 data를 뽑음
            for (MultipartFile file : reviewImages) {
                InputStream inputStream = file.getInputStream();

                log.info("inputstream:" + inputStream);

            }
        } catch (IOException e) {
            log.error("MultipartFile에서 InputStream을 가져오는 중 에러 발생", e);

        }

        // S3에 이미지 업로드하고 url 얻어옴
        String imageUrl = userReviewService.registReview(userReviewDto, reviewImages);

    }

//    public Object registReview(@RequestBody Map<String, Object> msgMap, UserReviewDto userReviewDto){
//        log.info("registReview");
//
//        int result = -1;
//        result  = userReviewService.registReview(msgMap, userReviewDto);
//        if(result > 0){
//            return "userRegReviewSuccess";
//        } else {
//            return "userRegReviewFail";
//        }
//    }

    // 리스트 조회


    // 상세페이지 조회
    @PostMapping("/getReview")
    public Object getReview(@RequestBody Map<String, Object>  msgMap, UserReviewDto userReviewDto){
        log.info("getReview");


        return null;
    }

}

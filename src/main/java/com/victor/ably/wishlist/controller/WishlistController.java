package com.victor.ably.wishlist.controller;


import com.victor.ably.constants.CommonErrorCode;
import com.victor.ably.util.ApiException;
import com.victor.ably.wishlist.dto.request.WishProductRequestDTO;
import com.victor.ably.wishlist.dto.request.WishlistRequestDTO;
import com.victor.ably.wishlist.dto.response.WishProductResponseDTO;
import com.victor.ably.wishlist.dto.response.WishlistResponseDTO;
import com.victor.ably.wishlist.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/wish")
public class WishlistController {

    private final WishlistService wishlistService;

    //상품찜하기
    @PostMapping(value = "/product")
    public ResponseEntity<?> addWishProduct(@Validated @RequestBody WishProductRequestDTO requestDTO) {
        WishProductResponseDTO responseDTO = new WishProductResponseDTO();
        try {
            wishlistService.addWishProduct(requestDTO, responseDTO);
        } catch (Exception exception) {
            throw new ApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //찜내역삭제
    @DeleteMapping(value = "/product")
    public ResponseEntity<?> deleteWishProduct(@Validated @RequestBody WishProductRequestDTO requestDTO) {
        WishProductResponseDTO responseDTO = new WishProductResponseDTO();
        try {
            wishlistService.deleteWishProduct(requestDTO, responseDTO);
        } catch (Exception exception) {
            throw new ApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //내 찜 서랍의 찜 목록 조회
    @GetMapping(value = "/{wishlistSequence}/product")
    public ResponseEntity<?> getWishProductList(
            @RequestParam @Min(1) int currentPageIndex,
            @RequestParam @Min(0) int pagingWindowSize,
            @PathVariable("wishlistSequence") @NotNull(message = "wishlistSequence는 필수값 입니다.") long wishlistSequence) {
        WishProductResponseDTO responseDTO = new WishProductResponseDTO();
        try {
            wishlistService.getWishProductList(wishlistSequence, currentPageIndex, pagingWindowSize, responseDTO);
        } catch (Exception exception) {
            throw new ApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //내 찜 서랍 생성
    @PostMapping(value = "/list")
    public ResponseEntity<?> addWishList(@Validated @RequestBody WishlistRequestDTO requestDTO) {
        WishlistResponseDTO responseDTO = new WishlistResponseDTO();
        try {
            wishlistService.addWishList(requestDTO, responseDTO);
        } catch (Exception exception) {
            throw new ApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //내 찜 서랍 삭제
    @DeleteMapping(value = "/list")
    public ResponseEntity<?> deleteWishList(@Validated @RequestBody WishlistRequestDTO requestDTO) {
        WishlistResponseDTO responseDTO = new WishlistResponseDTO();
        try {
            wishlistService.deleteWishList(requestDTO, responseDTO);
        } catch (Exception exception) {
            throw new ApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    //내 찜 서랍 목록 조회
    @GetMapping(value = "/list")
    public ResponseEntity<?> getWishList(@RequestParam @Min(1) int currentPageIndex, @RequestParam @Min(0) int pagingWindowSize) {
        WishlistResponseDTO responseDTO = new WishlistResponseDTO();
        try {
            wishlistService.getWishList(currentPageIndex, pagingWindowSize, responseDTO);
        } catch (Exception exception) {
            throw new ApiException(CommonErrorCode.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

package com.victor.ably.wishlist.service;

import com.victor.ably.member.service.MemberService;
import com.victor.ably.util.PagingInfo;
import com.victor.ably.util.PagingUtil;
import com.victor.ably.wishlist.dao.WishlistDao;
import com.victor.ably.wishlist.dto.request.WishProductRequestDTO;
import com.victor.ably.wishlist.dto.request.WishlistRequestDTO;
import com.victor.ably.wishlist.dto.response.WishProductResponseDTO;
import com.victor.ably.wishlist.dto.response.WishlistResponseDTO;
import com.victor.ably.wishlist.mapper.WishProductMapper;
import com.victor.ably.wishlist.mapper.WishlistMapper;
import com.victor.ably.wishlist.vo.WishListConditionVO;
import com.victor.ably.wishlist.vo.WishListParamVO;
import com.victor.ably.wishlist.vo.WishProductConditionVO;
import com.victor.ably.wishlist.vo.WishProductParamVO;
import com.victor.ably.wishlist.vo.WishProductResultVO;
import com.victor.ably.wishlist.vo.WishlistResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final MemberService memberService;
    private final WishlistDao wishlistDao;

    public void addWishProduct(WishProductRequestDTO requestDTO, WishProductResponseDTO responseDTO) {
        boolean isSuccess = false;

        String memberEmail = memberService.getSessionMemberEmail();
        //생성된 찜목록이 있는지 확인
        if(wishlistDao.selectMyWishlistCount( WishProductConditionVO.of(memberEmail ,"")) > 0 ) {
            //기등록된 상품인지 확인
            if (wishlistDao.checkDuplicateWishProduct(WishProductConditionVO.of(memberEmail, requestDTO.getProductCode())) == 0) {
                //찜등록
                if(wishlistDao.insertWishProduct(WishProductParamVO.ofInsert(memberEmail,  requestDTO.getProductCode(),
                        requestDTO.getProductName(), requestDTO.getProductImgPath(), requestDTO.getPrice(), requestDTO.getWishlistSequence())) > 0){
                    responseDTO.setResultMessage("찜 상품 등록 성공.");
                    isSuccess = true;
                }else{
                    responseDTO.setResultMessage("찜 상품 등록 실패.");
                }
            }else {
                responseDTO.setResultMessage("다른 찜목록에 해당상품이 있습니다.");
            }
        }else {
            responseDTO.setResultMessage("생성된 찜록록이 없습니다.");
        }
        responseDTO.setResultCode(isSuccess == true ? 1 : 0);
    }

    public void deleteWishProduct(WishProductRequestDTO requestDTO, WishProductResponseDTO responseDTO) {
        boolean isSuccess = wishlistDao.deleteWishProduct(requestDTO.getProductCode()) > 0;
        responseDTO.setResultCode(isSuccess ? 1 : 0);
        responseDTO.setResultMessage(isSuccess ? "삭제에 성공했습니다." : "삭제에 실패했습니다");
    }

    public void getWishProductList(long wishlistSequence, int currentPageIndex, int pagingWindowSize, WishProductResponseDTO responseDTO) {
        String memberEmail = memberService.getSessionMemberEmail();
        WishProductConditionVO conditionVO = WishProductConditionVO.ofList(memberEmail, wishlistSequence);

        int wishProductCount = wishlistDao.getWishProductCount(conditionVO);
        if (wishProductCount > 0) {
            PagingInfo pagingInfo = new PagingInfo(pagingWindowSize, 0, currentPageIndex, 0, 0, 0);
            responseDTO.setPagingInfo(PagingUtil.makePagingInfo(pagingInfo, wishProductCount));
            List<WishProductResultVO> resultVOList = wishlistDao.getWishProductList(WishProductConditionVO.setPaging(conditionVO, responseDTO.getPagingInfo()));
            if (!ObjectUtils.isEmpty(resultVOList))
                responseDTO.setWishProductDTO(WishProductMapper.INSTANCE.toWishProductDTO(resultVOList));
        }
    }

    public void addWishList(WishlistRequestDTO requestDTO, WishlistResponseDTO responseDTO) {
        boolean isSuccess = false;

        String memberEmail = memberService.getSessionMemberEmail();
        //동일한 이름으로 생성된 찜목록이 있는지 확인
        if (wishlistDao.checkDuplicateWishList(WishListConditionVO.of(memberEmail, StringUtils.trimAllWhitespace(requestDTO.getWishlistName()))) == 0) {
            //찜등록
            if(wishlistDao.insertWishList(WishListParamVO.of(memberEmail, requestDTO.getListImagePath(), StringUtils.trimAllWhitespace(requestDTO.getWishlistName()))) > 0){
                responseDTO.setResultMessage("찜 목록 등록 성공.");
                isSuccess = true;
            }else{
                responseDTO.setResultMessage("찜 목록 등록 실패.");
            }
        }else {
            responseDTO.setResultMessage("같은 이름으로 생성된 찜목록이 있습니다.");
        }
        responseDTO.setResultCode(isSuccess == true ? 1 : 0);
    }

    public void deleteWishList(WishlistRequestDTO requestDTO, WishlistResponseDTO responseDTO) {
        //찜목록내 상품삭제
        int productDeleteCount = wishlistDao.deleteWishProductBySequence(requestDTO.getWishlistSequence());
        //찜목록 삭제
        int listDeleteCount = wishlistDao.deleteWishList(requestDTO.getWishlistSequence());

        boolean isSuccess = productDeleteCount + listDeleteCount >= 2;
        responseDTO.setResultCode(isSuccess ? 1 : 0);
        responseDTO.setResultMessage(isSuccess ? "삭제에 성공했습니다." : "삭제에 실패했습니다");
    }

    public void getWishList(int currentPageIndex, int pagingWindowSize, WishlistResponseDTO responseDTO) {
        String memberEmail = memberService.getSessionMemberEmail();
        WishListConditionVO conditionVO = WishListConditionVO.ofList(memberEmail);

        int wishListCount = wishlistDao.getWishListCount(conditionVO);
        if (wishListCount > 0) {
            PagingInfo pagingInfo = new PagingInfo(pagingWindowSize, 0, currentPageIndex, 0, 0, 0);
            responseDTO.setPagingInfo(PagingUtil.makePagingInfo(pagingInfo, wishListCount));
            List<WishlistResultVO> resultVOList = wishlistDao.getWishList(WishListConditionVO.setPaging(conditionVO, responseDTO.getPagingInfo()));
            if (!ObjectUtils.isEmpty(resultVOList))
                responseDTO.setWishListDTO(WishlistMapper.INSTANCE.toWishListDTO(resultVOList));
        }
    }
}

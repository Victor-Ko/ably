package com.victor.ably.wishlist.dao;


import com.victor.ably.wishlist.vo.WishListConditionVO;
import com.victor.ably.wishlist.vo.WishListParamVO;
import com.victor.ably.wishlist.vo.WishProductConditionVO;
import com.victor.ably.wishlist.vo.WishProductParamVO;
import com.victor.ably.wishlist.vo.WishProductResultVO;
import com.victor.ably.wishlist.vo.WishlistResultVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WishlistDao {

    int selectMyWishlistCount(WishProductConditionVO conditionVO);

    int checkDuplicateWishProduct(WishProductConditionVO conditionVO);

    int insertWishProduct(WishProductParamVO paramVO);

    int deleteWishProduct(String productCode);

    int getWishProductCount(WishProductConditionVO conditionVO);

    List<WishProductResultVO> getWishProductList(WishProductConditionVO conditionVO);

    int checkDuplicateWishList(WishListConditionVO conditionVO);

    int insertWishList(WishListParamVO paramVO);
    int deleteWishProductBySequence(long wishlistSequence);

    int deleteWishList(long wishlistSequence);

    int getWishListCount(WishListConditionVO conditionVO);

    List<WishlistResultVO> getWishList(WishListConditionVO conditionVO);
}

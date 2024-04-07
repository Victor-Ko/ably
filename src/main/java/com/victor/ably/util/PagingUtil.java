package com.victor.ably.util;

public class PagingUtil {
    public static PagingInfo makePagingInfo(PagingInfo pagingInfo, int rowsTotalCount) {
        int currentPageIndex = pagingInfo.getCurrentPageIndex();
        int pagingWindowSize = pagingInfo.getPagingWindowSize();

        if(pagingInfo != null && pagingInfo.getPagingWindowSize() > 0 && rowsTotalCount > 0) {
            int itemStartIndex = (currentPageIndex - 1) * pagingWindowSize + 1;
            int itemEndIndex = Math.min(rowsTotalCount, currentPageIndex * pagingWindowSize);
            int lastPage = rowsTotalCount / pagingWindowSize + 1;
            if (lastPage > 1 && rowsTotalCount % pagingWindowSize == 0) {
                --lastPage;
            }
            return PagingInfo.builder().currentPageIndex(currentPageIndex).rowsTotalCount(rowsTotalCount).pagingWindowSize(pagingWindowSize).pageTotalCount(lastPage).itemStartIndex(itemStartIndex).itemEndIndex(itemEndIndex).build();
        }
        return pagingInfo;
    }
}

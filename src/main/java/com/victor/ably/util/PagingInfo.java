package com.victor.ably.util;

public class PagingInfo {

    private int pagingWindowSize;
    private int rowsTotalCount;
    private int currentPageIndex;
    private int pageTotalCount;
    private int itemStartIndex;
    private int itemEndIndex;

    public PagingInfo(final int pagingWindowSize, final int rowsTotalCount, final int currentPageIndex, final int pageTotalCount, final int itemStartIndex, final int itemEndIndex) {
        this.pagingWindowSize = pagingWindowSize;
        this.rowsTotalCount = rowsTotalCount;
        this.currentPageIndex = currentPageIndex;
        this.pageTotalCount = pageTotalCount;
        this.itemStartIndex = itemStartIndex;
        this.itemEndIndex = itemEndIndex;
    }

    public static PagingInfoBuilder builder() {
        return new PagingInfoBuilder();
    }

    public int getPagingWindowSize() {
        return this.pagingWindowSize;
    }

    public int getRowsTotalCount() {
        return this.rowsTotalCount;
    }

    public int getCurrentPageIndex() {
        return this.currentPageIndex;
    }

    public int getPageTotalCount() {
        return this.pageTotalCount;
    }

    public int getItemStartIndex() {
        return this.itemStartIndex;
    }

    public int getItemEndIndex() {
        return this.itemEndIndex;
    }

    public void setPagingWindowSize(final int pagingWindowSize) {
        this.pagingWindowSize = pagingWindowSize;
    }

    public void setRowsTotalCount(final int rowsTotalCount) {
        this.rowsTotalCount = rowsTotalCount;
    }

    public void setCurrentPageIndex(final int currentPageIndex) {
        this.currentPageIndex = currentPageIndex;
    }

    public void setPageTotalCount(final int pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public void setItemStartIndex(final int itemStartIndex) {
        this.itemStartIndex = itemStartIndex;
    }

    public void setItemEndIndex(final int itemEndIndex) {
        this.itemEndIndex = itemEndIndex;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PagingInfo)) {
            return false;
        } else {
            PagingInfo other = (PagingInfo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getPagingWindowSize() != other.getPagingWindowSize()) {
                return false;
            } else if (this.getRowsTotalCount() != other.getRowsTotalCount()) {
                return false;
            } else if (this.getCurrentPageIndex() != other.getCurrentPageIndex()) {
                return false;
            } else if (this.getPageTotalCount() != other.getPageTotalCount()) {
                return false;
            } else if (this.getItemStartIndex() != other.getItemStartIndex()) {
                return false;
            } else {
                return this.getItemEndIndex() == other.getItemEndIndex();
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PagingInfo;
    }

    public String toString() {
        int var10000 = this.getPagingWindowSize();
        return "PagingInfo(pagingWindowSize=" + var10000 + ", rowsTotalCount=" + this.getRowsTotalCount() + ", currentPageIndex=" + this.getCurrentPageIndex() + ", pageTotalCount=" + this.getPageTotalCount() + ", itemStartIndex=" + this.getItemStartIndex() + ", itemEndIndex=" + this.getItemEndIndex() + ")";
    }

    public static class PagingInfoBuilder {
        private int pagingWindowSize;
        private int rowsTotalCount;
        private int currentPageIndex;
        private int pageTotalCount;
        private int itemStartIndex;
        private int itemEndIndex;

        PagingInfoBuilder() {
        }

        public PagingInfoBuilder pagingWindowSize(final int pagingWindowSize) {
            this.pagingWindowSize = pagingWindowSize;
            return this;
        }

        public PagingInfoBuilder rowsTotalCount(final int rowsTotalCount) {
            this.rowsTotalCount = rowsTotalCount;
            return this;
        }

        public PagingInfoBuilder currentPageIndex(final int currentPageIndex) {
            this.currentPageIndex = currentPageIndex;
            return this;
        }

        public PagingInfoBuilder pageTotalCount(final int pageTotalCount) {
            this.pageTotalCount = pageTotalCount;
            return this;
        }

        public PagingInfoBuilder itemStartIndex(final int itemStartIndex) {
            this.itemStartIndex = itemStartIndex;
            return this;
        }

        public PagingInfoBuilder itemEndIndex(final int itemEndIndex) {
            this.itemEndIndex = itemEndIndex;
            return this;
        }

        public PagingInfo build() {
            return new PagingInfo(this.pagingWindowSize, this.rowsTotalCount, this.currentPageIndex, this.pageTotalCount, this.itemStartIndex, this.itemEndIndex);
        }

        public String toString() {
            return "PagingInfo.PagingInfoBuilder(pagingWindowSize=" + this.pagingWindowSize + ", rowsTotalCount=" + this.rowsTotalCount + ", currentPageIndex=" + this.currentPageIndex + ", pageTotalCount=" + this.pageTotalCount + ", itemStartIndex=" + this.itemStartIndex + ", itemEndIndex=" + this.itemEndIndex + ")";
        }
    }
}

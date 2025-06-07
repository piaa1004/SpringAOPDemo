package com.ysy.aspectjsupport.declaringadvice.model;

public interface UsageTracked {
    void incrementUseCount();
    int getUseCount();
}

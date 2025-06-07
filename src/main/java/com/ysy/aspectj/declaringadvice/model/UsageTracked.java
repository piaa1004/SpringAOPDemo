package com.ysy.aspectj.declaringadvice.model;

public interface UsageTracked {
    void incrementUseCount();
    int getUseCount();
}

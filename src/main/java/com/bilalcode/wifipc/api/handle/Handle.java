package com.bilalcode.wifipc.api.handle;

public abstract class Handle {
    private final long ptr;

    public Handle(long ptr) {
        this.ptr = ptr;
    }

    public long getPtr() {
        return ptr;
    }
}

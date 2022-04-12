package memory.service;

import static common.Configuration.DEFAULT_MEM_SIZE;

public class MemoryConfiguration {

    private long getOperationMemorySize = DEFAULT_MEM_SIZE;

    long getGetOperationMemorySize() {
        return getOperationMemorySize;
    }

    void setGetOperationMemorySize(long getOperationMemorySize) {
        this.getOperationMemorySize = getOperationMemorySize;
    }

}

package memory.service;

public class MemoryConfiguration {

    private long getOperationMemorySize = 50;

    long getGetOperationMemorySize() {
        return getOperationMemorySize;
    }

    void setGetOperationMemorySize(long getOperationMemorySize) {
        this.getOperationMemorySize = getOperationMemorySize;
    }

}

package main.java.RolloverStrategyMethods;

/**
 * Reference: /fuhu-hadoop/src/main/java/com/fuhu/commons/hadoop/RolloverStrategy.java
 */
public interface RolloverStrategy
{
    public String getRolloverStrategyName();

    public void reset();

    public boolean checkRollover(long size);

}
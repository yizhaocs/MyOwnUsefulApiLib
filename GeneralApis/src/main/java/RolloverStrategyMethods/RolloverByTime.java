package main.java.RolloverStrategyMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reference: /fuhu-hadoop/src/main/java/com/fuhu/commons/hadoop/RolloverByTime.java
 */
public class RolloverByTime implements RolloverStrategy
{
    private static final Logger logger = LoggerFactory.getLogger(RolloverByTime.class);

    private final long rolloverIntervalTime;

    private final long initialDelayTime;

    private long nextRolloverTime;

    public RolloverByTime(long rolloverIntervalTime, long initialDelayTime)
    {
        super();
        this.initialDelayTime = initialDelayTime;
        this.rolloverIntervalTime = rolloverIntervalTime;
        this.nextRolloverTime = initialDelayTime + System.currentTimeMillis() + rolloverIntervalTime;
    }

    public long getRolloverIntervalTime()
    {
        return rolloverIntervalTime;
    }

    public long getInitialDelayTime()
    {
        return initialDelayTime;
    }

    @Override
    public String getRolloverStrategyName() {
        return "RolloverByTime";
    }

    @Override
    public void reset()
    {
        // TODO Auto-generated method stub
        nextRolloverTime = System.currentTimeMillis() + rolloverIntervalTime;
        if (logger.isDebugEnabled()) {
            logger.debug("nextRolloverTime at reset() ===> " + nextRolloverTime);
        }
    }

    @Override
    public boolean checkRollover(long size)
    {
        System.out.println("System.currentTimeMillis():" + System.currentTimeMillis());
        System.out.println("nextRolloverTime:" + nextRolloverTime);
        long interval = System.currentTimeMillis() - nextRolloverTime;
        System.out.println("System.currentTimeMillis() - nextRolloverTime:" + interval);
        System.out.println("System.currentTimeMillis() >= nextRolloverTime:" + (System.currentTimeMillis() >= nextRolloverTime));
        // TODO Auto-generated method stub
        if (System.currentTimeMillis() >= nextRolloverTime) {
            if (logger.isDebugEnabled()) {
                logger.debug("checkRollover() at RolloverByTime return true.");
            }
            System.out.println("true");
            return true;
        }
        System.out.println("false");
        return false;
    }

}
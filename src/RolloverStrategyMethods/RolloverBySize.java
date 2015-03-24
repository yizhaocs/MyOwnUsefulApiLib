package RolloverStrategyMethods;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Reference: /fuhu-hadoop/src/main/java/com/fuhu/commons/hadoop/RolloverBySize.java
 */
public class RolloverBySize implements RolloverStrategy
{
    private static final Logger logger = LoggerFactory.getLogger(RolloverBySize.class);

    private final long fileSizeUnit;

    private final long maxFileSize;

    public RolloverBySize(long maxFileSize, String unit)
    {
        super();
        this.maxFileSize = maxFileSize;
        if(unit.equals("k") || unit.equals("K")) {
            this.fileSizeUnit = 1024;
        } else if (unit.equals("g") || unit.equals("G")) {
            this.fileSizeUnit = 1024 * 1024 * 1024;
        } else { // default - M
            this.fileSizeUnit = 1024 * 1024;
        }

    }

    public long getFileSizeUnit()
    {
        return fileSizeUnit;
    }

    public long getMaxFileSize()
    {
        return maxFileSize;
    }

    @Override
    public String getRolloverStrategyName() {
        return "RolloverBySize";
    }

    @Override
    public void reset()
    {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean checkRollover(long size)
    {
        // TODO Auto-generated method stub
        if(size >= maxFileSize * fileSizeUnit) {
            if (logger.isDebugEnabled()) {
                logger.debug("checkRollover() at RolloverBySize return true.");
                logger.debug("size checkRollover() at RolloverBySize => " + size);
            }

            return true;
        }

        return false;
    }

}
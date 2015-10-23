package main.java.pipeline;

/**
 *
 * The <code>Payload</code> interface represents a context that holds data
 * and process information across all stages in a pipeline execution.
 *
 * @see     Stage
 * @see     Pipeline
 * @version 1.0
 * @author Nathan Wang
 * @author eriche
 */
public interface Payload {

    /** reset the payload for reuse */
    void reset();

    void activate(boolean active);
}


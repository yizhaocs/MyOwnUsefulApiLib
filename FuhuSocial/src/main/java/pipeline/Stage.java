package main.java.pipeline;

/**
 *
 * This <code>Stage</code> interface represents one of many Steps in a
 * <code>Pipeline</code> execution.
 *
 * @see Pipeline
 *
 * @author Nathan Wang
 * @author Eric He
 *
 * @param <P> : the payload type which pass through all Stages in a Pipeline
 */
public interface Stage<P extends Payload> {
    /**
     *
     * @param payload <code>Payload</code> object that this Stage is working on
     * @throws PipelineException
     */
    void execute(P payload) throws PipelineException;
}

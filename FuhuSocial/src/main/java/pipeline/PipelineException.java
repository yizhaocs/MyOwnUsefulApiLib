package main.java.pipeline;


/**
 * The <code>PipelineException</code> class presents exception thrown
 * from a pipeline execution, when a synchronous <code>Stage</code> throw
 * an exception, the pipeline which executes the stage will catch and wrape
 * with this <code>PipelineException</code>, to get Stage exception, use
 * <p><blockquote><pre>
 * this.getCause,
 * </pre></blockquote>
 *
 * @author Nathan Wang
 * @author Eric He
 *
 */
public class PipelineException extends Exception {

    private static final long serialVersionUID = 1L;

    private int errcode;

    public PipelineException(String msg, int errcode) {
        super(msg);
        this.errcode = errcode;
    }

    public PipelineException(String msg, int errcode, Throwable cause) {
        super(msg, cause);
        this.errcode = errcode;
    }

    public int getErrcode() {
        return errcode;
    }
}

package main.java.pipeline;

/**
 * The <code>Pipeline</code> interface represents a process across multiple
 * <code>Stage</code>s.
 * <P>
 * a <code>Pipeline</code> is type associated with a <code>Payload</code>
 * and contains a list of synchronous <code>Stage</code> and a list of
 * asynchronous <code>Stage</code>,
 * a <code>Stage</code> is executed by a <code>Pipeline</code> by passing
 * a <code>Payload</code> object.
 * <P>
 * a default Pipeline implementation is provided as <link>PipelineImpl</link>
 * typical usage in a Spring application is as followings:
 * <P>
 * (note: One Pipeline for each Payload type exists in a server environment).
 * <p><blockquote><pre>
 * step1:
 *   create an payload class which holds context of the process
 *   for example:
 *
 *     public class Payload1 extends AbstractPayload
 *
 * step2:
 *   splits a process into <code>Stage<code>s base on function/feature,
 *   for example:
 *
 *   {@code
 *     public class Mod1Stage1 extends AbstractStage<Payload1> implements Stage<Payload1>
 *   }
 *
 *   note: error handling in a <code>Stage</code>, if error should cause synchronous stages
 *     to abort, throw exception, otherwise catch and deal the error locally.
 *     error information such as an exception should be put into payload for asynchronous
 *     stage to be aware.
 *
 * step3:
 *   define each stage as a singleton spring bean.
 *   for example in spring-config.xml:

 *   {@code
 *     <bean id="mod1Stage1" class="com.fuhu.osg.pipeline.sample.module1.Mod1Stage1" />
 *   }
 *
 * step4:
 *   define a Pipeline bean for the payload type by using default pipeline impl,
 *   for example in spring-config.xml:
 *
 *   {@code
 *     <bean id="payload1Pipeline" parent="PipelineImpl" scope="singleton" autowire-candidate="true">
 *        <constructor-arg value="mod1Pipeline" /> <!-- pipeline name -->
 *        <constructor-arg value="com.fuhu.osg.pipeline.sample.module1.Payload1" /> <!-- payload class -->
 *        <constructor-arg>
 *  	    <list>  <!-- beans for synchronous stages -->
 *  	      <ref bean="mod1Stage1" />
 *  	      <ref bean="mod1Stage11" />
 *  	    </list>
 *        </constructor-arg>
 *        <constructor-arg>
 *  	    <list>  <!-- beans for asynchronous stages -->
 *  	      <ref bean="mod1Stage2" />
 *  	    </list>
 *        </constructor-arg>
 *        <constructor-arg>
 *          <ref bean="asyncExecutor" /> <!-- bean for the ThreadPoolExecutor (same for all pipeline) -->
 *        </constructor-arg>
 *    </bean>
 *   }
 *
 * step5:
 *   in the business service class, inject this Pipeline bean,
 *   for example:
 *
 *      &#064Autowired
 *      &#064Qualifier("payload1Pipeline")
 *      private Pipeline<Payload1>     pipeline;
 *
 * step6:
 *   use the pipeline to process
 *   for example:
 *
 *   {@code
 *           Payload1 payload = pipeline.createPayload();
 *          //init payload here
 *          try {
 *              pipeline.executeSynchronous(payload);
 *          } catch (PipelineException e){
 *          	Throwable stageException = e.getCause(); //stageException is a Stage exception thrown from a Stage.
 *          	if(null != stageException){
 *          		//TODO process stage exception.
 *          	}
 *          } finally {
 *              pipeline.continueAsynchronous(payload);
 *          }
 *          logger.info("Mod1.handleRequest finished");
 *    }
 * </pre></blockquote>
 *
 * @author  Nathan Wang
 * @author  Eric He
 * @version 1.0
 * @see     Payload
 * @see     Stage
 * @see     com.fuhu.osg.pipeline.impl.PipelineImpl
 *
 * @param <P> : payload type
 */
public interface Pipeline<P extends Payload> {
    /*
     * The Name of this Pipeline.
     */
    String getName();

    /**
     *
     * @return A proper reusable payload object for the Pipeline execution.
     * @throws PipelineException
     */
    P createPayload() throws PipelineException;

    /**
     * Execute the Synchronous <code>Stage</code>s, by the order of their position in
     * synchronous Stage list,
     * (Note: the stages are executed in the same thread as the caller)
     * @param payload the <code>Payload</code> object
     * @throws PipelineException
     */
    void executeSynchronous(P payload) throws PipelineException;


    /**
     * Execute the Asynchronous <code>Stage</code>s, by the order of their position in
     * asynchronous Stage list,
     * (Note: the stages are executed in a new thread, not the caller's)
     * @param payload the <code>Payload</code> object
     * @throws PipelineException
     */
    void continueAsynchronous(P payload) throws PipelineException;

    /**
     * Gets the number of active payload objects in the payload ObjectPool.
     * @return number of active payload objects in the payload ObjectPool.
     */
    int getNumOfActivePayloads();

}
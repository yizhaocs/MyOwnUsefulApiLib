package main.java

import org.apache.spark.serializer.KryoRegistrator

/**
 * Created by yizhao on 7/15/15.
 */
class MyRegistrator extends KryoRegistrator {

  import com.esotericsoftware.kryo.Kryo

  override def registerClasses(kryo:Kryo) {
    import org.apache.hadoop.io.{BytesWritable, LongWritable}
    kryo.register(classOf[LongWritable])
    kryo.register(classOf[BytesWritable])
  }
}
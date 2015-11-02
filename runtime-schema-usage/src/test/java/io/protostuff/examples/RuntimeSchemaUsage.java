package io.protostuff.examples;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;

/**
 * @author Kostiantyn Shchepanovskyi
 */
public class RuntimeSchemaUsage {

    private final LinkedBuffer BUFFER = LinkedBuffer.allocate();;
    private final Schema<Foo> SCHEMA = RuntimeSchema.getSchema(Foo.class);;

    @Test
    public void serializeAndDeserialize() throws Exception {
        Foo foo = createFooInstance();
        byte[] bytes = serialize(foo);
        Foo x = deserialize(bytes);
        Assert.assertEquals(foo, x);
    }

    private byte[] serialize(Foo foo) throws java.io.IOException {
        ByteArrayOutputStream temp = new ByteArrayOutputStream();
        ProtobufIOUtil.writeTo(temp, foo, SCHEMA, BUFFER);
        return temp.toByteArray();
    }

    private Foo deserialize(byte[] bytes) {
        Foo tmp = SCHEMA.newMessage();
        ProtobufIOUtil.mergeFrom(bytes, tmp, SCHEMA);
        return tmp;
    }

    private Foo createFooInstance() {
        Foo foo;
        foo = new Foo();
        foo.setBar(Bar.newBuilder()
                .id(42)
                .name("Bar")
                .build());
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(42, "Forty Two");
        foo.setMap(map);
        return foo;
    }


}

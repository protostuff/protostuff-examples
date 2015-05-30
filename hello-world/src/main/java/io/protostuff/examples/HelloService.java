package io.protostuff.examples;

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Sample {@code HelloService} implementation.
 *
 * @author Kostiantyn Shchepanovskyi
 */
public class HelloService {


    public static final Schema<HelloRequest> SEARCH_REQUEST_SCHEMA = HelloRequest.getSchema();
    public static final Schema<HelloResponse> SEARCH_RESPONSE_SCHEMA = HelloResponse.getSchema();

    /**
     * Sample "hello" rpc method handler.
     *
     * @param requestData {@code HelloRequest} binary array encoded using Protocol Buffers
     * @return {@code HelloResponse} binary array encoded using Protocol Buffers
     */
    public byte[] hello(byte[] requestData) throws IOException {
        HelloRequest request = deserialize(requestData);
        HelloResponse response = hello(request);
        return serialize(response);
    }

    private byte[] serialize(HelloResponse response) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        LinkedBuffer buffer = LinkedBuffer.allocate();
        ProtobufIOUtil.writeTo(outputStream, response, SEARCH_RESPONSE_SCHEMA, buffer);
        return outputStream.toByteArray();
    }

    private HelloRequest deserialize(byte[] requestData) {
        HelloRequest request = SEARCH_REQUEST_SCHEMA.newMessage();
        ProtobufIOUtil.mergeFrom(requestData, request, SEARCH_REQUEST_SCHEMA);
        return request;
    }

    /**
     * Service method implementation.
     */
    private HelloResponse hello(HelloRequest request) {
        HelloResponse response = new HelloResponse();
        String name = request.getName();
        response.setGreeting("Hello, " + name);
        return response;
    }

}

package io.protostuff.examples;

import com.google.common.util.concurrent.ListenableFuture;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Tests for {@code DummySearchService}
 *
 * @author Kostiantyn Shchepanovskyi
 */
public class DummySearchServiceTest {

    private final DummySearchService service = new DummySearchService();

    @Test
    public void testBasicSearch() throws Exception {
        ListenableFuture<SearchResponse> result = service.basicSearch(new BasicSearchRequest());
        Assert.assertEquals(Arrays.asList("result 1", "result 2"), result.get().getResultList());
    }

    @Test
    public void testExtendedSearch() throws Exception {
        ListenableFuture<SearchResponse> result = service.extendedSearch(new ExtendedSearchRequest());
        Assert.assertEquals(Arrays.asList("result 1", "result 2", "result 3"), result.get().getResultList());
    }

}
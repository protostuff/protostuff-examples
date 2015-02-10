package io.protostuff.example.search

import com.google.common.util.concurrent.ListenableFuture
import org.junit.Assert
import org.junit.Test

/**
 * Test dummy service implementation for generated interface
 *
 * @author Konstantin Shchepanovskyi
 */
class DummySearchServiceTest {

    private final DummySearchService service = new DummySearchService();

    @Test
    public void testBasicSearch() {
        ListenableFuture<SearchResponse> result = service.basicSearch(new BasicSearchRequest());
        Assert.assertEquals(Arrays.asList("result 1", "result 2"), result);
    }

    @Test
    public void testExtendedSearch() {
        ListenableFuture<SearchResponse> result = service.extendedSearch(new ExtendedSearchRequest());
        Assert.assertEquals(Arrays.asList("result 1", "result 2", "result 3"), result);
    }
}

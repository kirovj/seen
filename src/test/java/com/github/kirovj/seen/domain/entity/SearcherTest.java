package com.github.kirovj.seen.domain.entity;

import com.github.kirovj.seen.domain.enums.Type;
import org.junit.Assert;
import org.junit.Test;

public class SearcherTest {

    @Test
    public void testSearcher() {
        var s = new Searcher("a", Type.Movie, true, false, 2022, "CN", "jack");
        Assert.assertEquals(2022, s.year());
    }
}
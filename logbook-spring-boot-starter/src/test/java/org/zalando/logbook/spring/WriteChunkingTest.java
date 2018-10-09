package org.zalando.logbook.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.zalando.logbook.ChunkingHttpLogWriter;
import org.zalando.logbook.HttpLogWriter;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@LogbookTest(properties = "logbook.write.chunk-size = 100")
class WriteChunkingTest {

    @Autowired
    private HttpLogWriter writer;

    @Test
    void shouldUseChunkingWriter() throws IOException {
        assertThat(writer, is(instanceOf(ChunkingHttpLogWriter.class)));
    }

}

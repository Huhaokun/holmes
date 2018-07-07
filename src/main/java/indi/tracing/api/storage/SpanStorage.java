package indi.tracing.api.storage;

import indi.tracing.api.domain.Span;

import java.util.List;

interface SpanStorage {
    /**
     * @param span upload a span to storage
     * */
    void put(Span span);

    /**get a trace by traceId
     * @param traceId String
     * @return List<Span>
     * */
    List<Span>  getTrace(String traceId);
}

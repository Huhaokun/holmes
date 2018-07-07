package indi.tracing.api.storage;

import indi.tracing.api.domain.Span;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.springframework.stereotype.Component;


import java.util.*;
import java.util.stream.Collectors;

@Component
public class MemSpanStorage implements SpanStorage {
    private final MultiValuedMap<String, Span> traces = new ArrayListValuedHashMap<>();

    @Override
    public synchronized void put(Span span) {
        traces.put(span.getTraceId(), span);
    }

    @Override
    public synchronized List<Span> getTrace(String traceId) {
        return traces.get(traceId).parallelStream().collect(Collectors.toList());
    }
}

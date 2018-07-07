package indi.tracing.api.controllers;

import indi.tracing.api.domain.Span;
import indi.tracing.api.storage.StorageComponent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TraceController {
    private StorageComponent storage;
    public TraceController(StorageComponent storageComponent) {
        storage = storageComponent;
    }

    @GetMapping("/v1/trace/{traceId}")
    public List<Span> get(@PathVariable String traceId) {
        return storage.getTrace(traceId);
    }
}

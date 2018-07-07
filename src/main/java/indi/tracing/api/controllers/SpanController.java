package indi.tracing.api.controllers;

import indi.tracing.api.domain.Span;
import indi.tracing.api.storage.StorageComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/span")
public class SpanController {
    private StorageComponent storage;
    SpanController(StorageComponent storageComponent) {
        storage = storageComponent;
    }

    @PostMapping
    public void uploadSpan(List<Span> spans) {
        // upload the span to storage service
        // TODO refine this impl
        for (Span s: spans) {
            storage.put(s);
        }
    }

}

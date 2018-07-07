package indi.tracing.api.domain;

import java.util.List;

/**
 description:
 A span is a single-host view of an operation. A trace is a series of spans
 (often RPC calls) which nest to form a latency tree. Spans are in the same
 trace when they share the same trace ID. The parent_id field establishes the
 position of one span in the tree.

 The root span is where parent_id is Absent and usually has the longest
 duration in the trace. However, nested asynchronous work can materialize as
 child spans whose duration exceed the root span.

 Spans usually represent remote activity such as RPC calls, or messaging
 producers and consumers. However, they can also represent in-process
 activity in any position of the trace. For example, a root span could
 represent a server receiving an initial client request. A root span could
 also represent a scheduled job that has no remote context.

 traceId*	string
 maxLength: 32
 minLength: 16
 pattern: [a-z0-9]{16,32}
 Randomly generated, unique identifier for a trace, set on all spans within it.

 Encoded as 16 or 32 lowercase hex characters corresponding to 64 or 128 bits.
 For example, a 128bit trace ID looks like 4e441824ec2b6a44ffdc9bb9a6453df3

 name	string
 The logical operation this span represents in lowercase (e.g. rpc method).
 Leave absent if unknown.

 As these are lookup labels, take care to ensure names are low cardinality.
 For example, do not embed variables into the name.

 parentId	string
 pattern: [a-z0-9]{16}
 maxLength: 16
 minLength: 16
 The parent span ID or absent if this the root span in a trace.

 id*	string
 pattern: [a-z0-9]{16}
 maxLength: 16
 minLength: 16
 Unique 64bit identifier for this operation within the trace.

 Encoded as 16 lowercase hex characters. For example ffdc9bb9a6453df3

 kind	string
 When present, kind clarifies timestamp, duration and remoteEndpoint. When
 absent, the span is local or incomplete. Unlike client and server, there
 is no direct critical path latency relationship between producer and
 consumer spans.

 CLIENT
 timestamp is the moment a request was sent to the server. (in v1 “cs”)
 duration is the delay until a response or an error was received. (in v1 “cr”-“cs”)
 remoteEndpoint is the server. (in v1 “sa”)
 SERVER
 timestamp is the moment a client request was received. (in v1 “sr”)
 duration is the delay until a response was sent or an error. (in v1 “ss”-“sr”)
 remote_endpoint is the client. (in v1 “ca”)
 PRODUCER
 timestamp is the moment a message was sent to a destination. (in v1 “ms”)
 duration is the delay sending the message, such as batching.
 remoteEndpoint is the broker.
 CONSUMER
 timestamp is the moment a message was received from an origin. (in v1 “mr”)
 duration is the delay consuming the message, such as from backlog.
 remoteEndpoint - Represents the broker. Leave serviceName absent if unknown.
 Enum:
 Array [ 4 ]
 timestamp	integer($int64)
 Epoch microseconds of the start of this span, possibly absent if
 incomplete.

 For example, 1502787600000000 corresponds to 2017-08-15 09:00 UTC

 This value should be set directly by instrumentation, using the most
 precise value possible. For example, gettimeofday or multiplying epoch
 millis by 1000.

 There are three known edge-cases where this could be reported absent.

 A span was allocated but never started (ex not yet received a timestamp)
 The span’s start event was lost
 Data about a completed span (ex tags) were sent after the fact
 duration	integer($int64)
 minimum: 1
 Duration in microseconds of the critical path, if known. Durations of less
 than one are rounded up. Duration of children can be longer than their
 parents due to asynchronous operations.

 For example 150 milliseconds is 150000 microseconds.

 debug	boolean
 True is a request to store this span even if it overrides sampling policy.

 This is true when the X-B3-Flags header has a value of 1.

 shared	boolean
 True if we are contributing to a span started by another tracer (ex on a different host).

 localEndpoint	Endpoint

 remoteEndpoint	Endpoint
 Depending on context, this could be a listen port or the client-side of a
 socket. Absent if unknown


 annotations	Annotation

 uniqueItems:true
 description:Associates events that explain latency with the time they happened.

 tags	list of String
 * */

public class Span {
    private String traceId;

    private String name;

    private String parentId;

    private String id;

    private String kind;

    private Integer timestamp;

    private Integer duration;

    private Boolean debug;

    private Boolean shared;

    private Endpoint localEndpoint;

    private Endpoint remoteEndpoint;

    private List<Annotation> annotations;

    private List<String> tags;

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getDebug() {
        return debug;
    }

    public void setDebug(Boolean debug) {
        this.debug = debug;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public Endpoint getLocalEndpoint() {
        return localEndpoint;
    }

    public void setLocalEndpoint(Endpoint localEndpoint) {
        this.localEndpoint = localEndpoint;
    }

    public Endpoint getRemoteEndpoint() {
        return remoteEndpoint;
    }

    public void setRemoteEndpoint(Endpoint remoteEndpoint) {
        this.remoteEndpoint = remoteEndpoint;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}

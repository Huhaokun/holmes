package indi.tracing.api.domain;

/**
 *
 * The network context of a node in the service graph
 *
 * @param serviceName	string
 * Lower-case label of this node in the service graph, such as "favstar". Leave
 * absent if unknown.
 *
 * This is a primary label for trace lookup and aggregation, so it should be
 * intuitive and consistent. Many use a name from service discovery.
 *
 * @param ipv4	string($ipv4)
 * The text representation of the primary IPv4 address associated with this
 * connection. Ex. 192.168.99.100 Absent if unknown.
 *
 * @param pv6	string($ipv6)
 * The text representation of the primary IPv6 address associated with a
 * connection. Ex. 2001:db8::c001 Absent if unknown.
 *
 * Prefer using the ipv4 field for mapped addresses.
 *
 * @param port	integer
 * Depending on context, this could be a listen port or the client-side of a
 * socket. Absent if unknown
 */
public class Endpoint {
    private String serviceName;
    private String ipv4;
    private String ipv6;
    private Integer port;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }

    public String getIpv6() {
        return ipv6;
    }

    public void setIpv6(String ipv6) {
        this.ipv6 = ipv6;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}

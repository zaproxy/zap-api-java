# OWASP ZAP Java API

The Java implementation to access the [OWASP ZAP API](https://github.com/zaproxy/zaproxy/wiki/ApiDetails). For more information
about OWASP ZAP consult the (main) [OWASP ZAP project](https://github.com/zaproxy/zaproxy/).

This project produces two libraries:
 * `zap-clientapi`, the library that contains the Java implementation to access the OWASP ZAP API;
 * `zap-clientapi-ant`, the library that contains [Ant](https://ant.apache.org/) tasks that wrap functionality
 provided by `zap-clientapi`. This library depends on `zap-clientapi` and Ant, both should be available at runtime.

## How to Obtain

The latest released versions can be downloaded from the [Releases page](https://github.com/zaproxy/zap-api-java/releases).

Or, if using a dependency management tool, for example [Maven](https://maven.apache.org/), the `zap-clientapi` library
can be obtained from [Maven Central](http://search.maven.org/) with following coordinates:

 * GroupId: `org.zaproxy`
 * ArtifactId: `zap-clientapi`
 * Version: `1.0.0`

Previous releases are also available, more details can be found in [Maven Central](http://search.maven.org/#search|ga|1|org.zaproxy).

## Getting Help

For help using OWASP ZAP API refer to:
  * [Examples](subprojects/zap-clientapi/src/examples/java/org/zaproxy/clientapi/examples) - collection of examples using the library;
  * [OWASP ZAP User Group](https://groups.google.com/group/zaproxy-users) - for asking questions;
  * IRC: irc.mozilla.org #websectools (eg [using Mibbit](http://chat.mibbit.com/?server=irc.mozilla.org%3A%2B6697&channel=%23websectools)) - chat with core ZAP developers (European office hours usually best)
  
## Issues

To report issues related to OWASP ZAP API, bugs and enhancements requests, use the [issue tracker of the main OWASP ZAP project](https://github.com/zaproxy/zaproxy/issues).

# OWASP ZAP Java API

[![Version](https://maven-badges.herokuapp.com/maven-central/org.zaproxy/zap-clientapi/badge.svg)](https://maven-badges.herokuapp.com/maven-central/org.zaproxy/zap-clientapi/)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Known Vulnerabilities](https://snyk.io/test/github/zaproxy/zap-api-java/badge.svg)](https://snyk.io/test/github/zaproxy/zap-api-java)

The Java implementation to access the [OWASP ZAP API](https://www.zaproxy.org/docs/api/). For more information
about OWASP ZAP consult the (main) [OWASP ZAP project](https://github.com/zaproxy/zaproxy/).

This project produces two libraries:
 * `zap-clientapi`, the library that contains the Java implementation to access the OWASP ZAP API;
 * `zap-clientapi-ant`, the library that contains [Ant](https://ant.apache.org/) tasks that wrap functionality
 provided by `zap-clientapi`. This library depends on `zap-clientapi` and Ant, both should be available at runtime.

## How to Obtain

The latest released versions can be downloaded from the [Releases page](https://github.com/zaproxy/zap-api-java/releases).

Or, if using a dependency management tool, for example [Maven](https://maven.apache.org/) or [Gradle](https://gradle.org/), the `zap-clientapi` library
can be obtained from [Maven Central](https://search.maven.org/) with following coordinates:

 * GroupId: `org.zaproxy`
 * ArtifactId: `zap-clientapi`
 * Version: `1.9.0`

Previous releases are also available, more details can be found in [Maven Central](https://search.maven.org/search?q=g:org.zaproxy%20AND%20a:zap-clientapi&core=gav).

## Getting Help

For help using OWASP ZAP API refer to:
  * [Examples](subprojects/zap-clientapi/src/examples/java/org/zaproxy/clientapi/examples) - collection of examples using the library;
  * [API Documentation](https://www.zaproxy.org/docs/api/)
  * [OWASP ZAP User Group](https://groups.google.com/group/zaproxy-users) - for asking questions
  
## Issues

To report issues related to OWASP ZAP API, bugs and enhancements requests, use the [issue tracker of the main OWASP ZAP project](https://github.com/zaproxy/zaproxy/issues).

## Building

This project uses Gradle to build its libraries, for example, running:

    ./gradlew build

in the main directory of the project will build all the libraries. The libraries will be located in the `build/libs` directory
of each subproject.

### Installing

To install the artifacts to the local Maven repository you can run the following:

    ./gradlew install

The installed artifacts (`zap-clientapi`) are then available for other (local) projects to use.

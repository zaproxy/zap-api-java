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
 * Version: `1.2.0`

Previous releases are also available, more details can be found in [Maven Central](http://search.maven.org/#search|ga|1|org.zaproxy).

## Getting Help

For help using OWASP ZAP API refer to:
  * [Examples](subprojects/zap-clientapi/src/examples/java/org/zaproxy/clientapi/examples) - collection of examples using the library;
  * [OWASP ZAP User Group](https://groups.google.com/group/zaproxy-users) - for asking questions;
  * IRC: irc.mozilla.org #websectools (eg [using Mibbit](http://chat.mibbit.com/?server=irc.mozilla.org%3A%2B6697&channel=%23websectools)) - chat with core ZAP developers (European office hours usually best)
  
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

## Releasing

In the following sections it will be explained the steps necessary to release a new version of the libraries. In all steps the
version to be released is referred to as `<version-to-release>`, which should be replaced with appropriate version number
(e.g. 2.1.0).

### Release Branching

The project follows the [git-flow branching model](http://nvie.com/posts/a-successful-git-branching-model/). To release a new version it needs to be created a new release branch, update the version, and tag:
  1. Create a release branch:
     `git checkout -b release-<version-to-release> develop`;
  2. Update version in:
     1. `build.gradle` file (e.g. remove `-SNAPSHOT`);
     2. source code (e.g. `@since` and `@deprecated` JavaDoc tags);
     3. `README.md` file (in `How to Obtain` section);
  3. Review that everything is correct and commit the changes:
     `git commit -S -m "Bump version number to <version-to-release>"`
  4. Checkout `master` and merge the release branch:
     1. `git checkout master`
     2. `git merge -S --no-ff release-<version-to-release> -m "Merge branch 'release-<version-to-release>' into master"`
  5. Tag the new version:
     `git tag -s v<version-to-release> -m "Version <version-to-release>"`

Reintegrate the changes into `develop` branch:
  1. Checkout develop branch:
     `git checkout develop`
  2. Merge the `release-<version-to-release>` branch:
     `git merge -S --no-ff release-<version-to-release> -m "Merge branch 'release-<version-to-release>' into develop"`
     1. Resolve possible conflicts;
         1. The version can be bumped to the next developing version (e.g. increase the minor version and add `-SNAPSHOT`);
         2. Continue with the merge (if the version was bumped mention it in the commit message);
  3. Bump to the next developing version now (e.g. increase the minor version and add `-SNAPSHOT`), if not done during the merge:
     `git commit -S -m "Bump version number to <developing-version>-SNAPSHOT"`

Delete the release branch:

    git branch -d release-<version-to-release>

Push the branches (`develop` and `master`) and tag:

    git push upstream develop master v<version-to-release>

(Assuming `upstream` is the zaproxy repo.)

### Build for Release

Checkout the tagged version:

    git checkout v<version-to-release>

Create the the artifacts/libraries necessary for the release:

    ./gradlew clean build uberJar

### Release to Maven Central

To upload the built artifacts to OSSRH you can run the following:

    ./gradlew uploadArchives

Once uploaded continue with the release process in OSSRH:
http://central.sonatype.org/pages/releasing-the-deployment.html

NOTE: The following properties must be defined (e.g. in file `GRADLE_HOME/gradle.properties` ) to successfully sign and
upload the artifacts:
 - `signing.keyId` - the ID of the GPG key, used to sign the artifacts;
 - `ossrhUsername` - the OSSRH username;
 - `ossrhPassword` - the OSSRH password for above username.

Also, the user must have permissions to upload to GroupId `org.zaproxy`.

### GitHub Release

Release in GitHub:
 1. Draft a [new release](https://github.com/zaproxy/zap-api-java/releases/new):
    - Tag: `v<version-to-release>`
    - Title: `Version <version-to-release>`
    - Description: (Add a summary of the changes done in the new version and mention the artifacts/libraries available.)
 2. Upload the libraries:
     - `zap-api-<version-to-release>.jar`
     - `zap-clientapi-<version-to-release>.jar`
     - `zap-clientapi-ant-<version-to-release>.jar`
 3. Publish release.

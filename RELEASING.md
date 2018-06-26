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

Create the artifacts/libraries necessary for the release:

    ./gradlew clean build

### Release to Maven Central

To upload the built artifacts to OSSRH you can run the following:

    ./gradlew publish

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

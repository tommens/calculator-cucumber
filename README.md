[![](https://img.shields.io/github/v/release/tommens/calculator-cucumber?label=Latest%20Release)](https://github.com/tommens/calculator-cucumber/releases/latest)
[![SWH](https://archive.softwareheritage.org/badge/origin/https://github.com/tommens/calculator-cucumber/)](https://archive.softwareheritage.org/browse/origin/?origin_url=https://github.com/tommens/calculator-cucumber)

Code quality:
![Maven Build](https://github.com/tommens/calculator-cucumber/actions/workflows/maven.yml/badge.svg)
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/6856a0f94d25446ca346cbc15a701d43)](https://www.codacy.com/gh/tommens/calculator-cucumber/dashboard?utm_source=github.com&utm_medium=referral&utm_content=tommens/calculator-cucumber&utm_campaign=Badge_Grade)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=tommens_calculator-cucumber&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=tommens_calculator-cucumber)

Test coverage: ![Coverage](.github/badges/jacoco.svg)
![Branches](.github/badges/branches.svg)

Security analysis:
![CodeQL](https://github.com/tommens/calculator-cucumber/actions/workflows/codeql.yml/badge.svg)
[![OpenSSF Scorecard](https://api.securityscorecards.dev/projects/github.com/tommens/calculator-cucumber/badge)](https://securityscorecards.dev/viewer/?uri=github.com/tommens/calculator-cucumber)

# Calculating arithmetic expressions

## About

This repository contains Java code for computing arithmetic expressions. It is
deliberately incomplete as it serves to be the basis of all kinds of extensions,
such as a more sophisticated Calculator application. The code was written to be
used for educational purposes at the University of Mons, Belgium in the context
of the software evolution course.

### Unit testing and BDD

- All tests can be found in the src\test directory. They serve as executable
  documentation of the source code.
- The source code is accompanied by a set of JUnit 5 unit tests. These tests can
  be written and run in the usual way. If you are not familiar with unit testing
  or JUnit 5, please refer to https://junit.org/junit5/.
- The source code is accompanied by a set of Cucumber BDD scenarios, also
  running in Junit. If you are not familiar with Cucumber and BDD, please refer
  to https://cucumber.io/docs/cucumber/. The BDD scenarios are specified as
  .feature files in the src\test\resources directory. Some classes defined in
  src\test take care of converting these scenarios to executable JUnit tests.

### Prerequisites

- You will need to have a running version of Java 21 on your machine in order to
  be able to compile and execute this code, although it is also backward
  compatible with earlier versions of Java.
- You will need to have a running version of Maven, since this project is
  accompanied by a pom.xml file so that it can be installed, compiled, tested
  and run using Maven.

### Development Environments

There are several ways to set up your development environment. You can use
DevContainer, Nix, or set up your environment manually.

#### Using DevContainer (Container based)

[DevContainer](https://containers.dev/) is a feature available for
[VSCode](https://code.visualstudio.com/) and
[Jetbrains](https://www.jetbrains.com/) IDEs that allows you to develop
seamlessly in a containerised environment. This approach will setup your
development environment using containers.

1. Ensure you have Docker installed on your machine. It might work with Podman
   too, but it is not tested yet.
2. Install the DevContainer extension
   1. For VSCode:
      [Dev Containers extension](https://marketplace.visualstudio.com/items?itemName=ms-vscode-remote.remote-containers)
      ([documentation](https://code.visualstudio.com/docs/devcontainers/containers))
   2. For Jetbrains: nothing to do, it is supported by default
      ([documentation](https://www.jetbrains.com/help/idea/connect-to-devcontainer.html))
3. Open the project in your IDE, and you should see a notification to reopen the
   project in a container, click on it.
4. Once the project is reopened in the container, you need to wait a bit for the
   container to build and start, and then you can start developing, all the
   tools and dependencies are already installed in the container.

#### Using Nix

This approach will setup a development environment using the
[Nix](https://nixos.org) package manager. Unlike DevContainer, no
containerisation is used, and the development environment will be installed on
your local machine, in total isolation from your current system packages.

1. Install Nix package manager: `curl -L https://nixos.org/nix/install | sh`
2. Go to the project root folder
3. Run `nix develop` to enter the development environment
4. Once you are done, you can exit the environment by running `exit`

### Installation and testing instructions

- Upon first use of the code in this repository, you will need to run "mvn clean
  install" to ensure that all required project dependencies (e.g. for Java,
  JUnit, Cucumber, and Maven) will be downloaded and installed locally.
- Assuming you have a sufficiently recent version of Maven installed (the
  required versions are specified as properties in the POM file), you can
  compile the source code using "mvn compile"
- Once the code is compiled, you can execute the main class of the Java code
  using "mvn exec:java"
- The tests and BDD scenarios are executable with Maven using "mvn test"
- Note that the tests are also executed when you do a "mvn install". It is
  possible to skip those tests by providing an extra parameter. For details of
  more advanced uses of Maven, please refer to its official documentation
  https://maven.apache.org/guides/.

### Test coverage and JavaDoc reporting

- In addition to testing the code, "mvn test" will also generate a test coverage
  report (in HTML format) using JaCoCo. This test coverage is generated in
  target/site/jacoco.
- When packaging the code using "mvn package" the JavaDoc code documentation
  will be generated and stored in target/site/apidocs.

## Built With

- [Maven](https://maven.apache.org/) - an open source build automation and
  dependency management tool
- [JUnit5](https://junit.org/junit5/) - a unit testing framework for Java
- [Cucumber](https://cucumber.io/docs/cucumber/) - a tool for Behaviour-Driven
  Development
- [JaCoCo](https://www.jacoco.org) - a code coverage library for Java
- [JavaDoc](https://docs.oracle.com/en/java/javase/17/javadoc/javadoc.html) - a
  code documentation tool for Java

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available,
see the
[tags on this repository](https://github.com/tommens/calculator-cucumber/tags).

## Contributors

- Tom Mens
- Gauvain Devillez @GauvainD
- Damien Legay @DamienLegay

## Licence

[This code is available under the GNU General Public License v3.0](https://choosealicense.com/licenses/gpl-3.0/)
(GPLv3)

## Acknowledgments

- Software Engineering Lab, Faculty of Sciences, University of Mons, Belgium.

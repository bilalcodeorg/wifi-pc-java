# Build Instructions

This project requires the native binary to be built **before** compiling the Java code with Maven.

## Prerequisites

- [Git](https://git-scm.com/downloads)
- [Docker](https://docs.docker.com/get-docker/)
- [Java JDK](https://adoptium.net/) (version required by the project)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Step 1: Pull the Repository

Pull the repository along with all of its submodules:

```bash
git pull --recurse-submodules
```

> Make sure this completes successfully so that all submodules are present before moving on.

## Step 2: Compile the Native Binary

Run the following command from the project root. It builds the native binary inside Docker and exports the output to the current directory:

```bash
docker build --output type=local,dest=. .
```

> Make sure this step completes successfully and the native binary is generated before moving on.

## Step 3: Compile the Java Code with Maven

Once the native binary is in place, build the Java project:

```bash
mvn clean package
```

## Summary

```bash
# 1. Pull the repo with submodules
git pull --recurse-submodules

# 2. Build the native binary
docker build --output type=local,dest=. .

# 3. Build the Java project
mvn clean package
```
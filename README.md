# Build Instructions

This project requires the native binary to be built **before** compiling the Java code with Maven.

## Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [Java JDK](https://adoptium.net/) (version required by the project)
- [Apache Maven](https://maven.apache.org/download.cgi)

## Step 1: Compile the Native Binary

Run the following command from the project root. It builds the native binary inside Docker and exports the output to the current directory:

```bash
docker build --output type=local,dest=. .
```

> Make sure this step completes successfully and the native binary is generated before moving on.

## Step 2: Compile the Java Code with Maven

Once the native binary is in place, build the Java project:

```bash
mvn clean package
```

## Summary

```bash
# 1. Build the native binary
docker build --output type=local,dest=. .

# 2. Build the Java project
mvn clean package
```
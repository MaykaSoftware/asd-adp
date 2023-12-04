FROM adoptopenjdk/openjdk11:alpine

RUN apk --no-cache add curl

# Install Kotlin
RUN curl -s https://get.sdkman.io | bash
RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install kotlin"

WORKDIR /workspace

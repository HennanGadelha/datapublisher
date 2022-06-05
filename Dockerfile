FROM gcr.io/distroless/java:11

COPY /build/libs /app
WORKDIR /app

CMD ["api-dados.jar"]
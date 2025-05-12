build:
    gradle shadowJar

generate-antlr:
    gradle generateGrammarSource

transpile pk:
    @java -jar build/libs/pocket-1.0.jar {{ pk }}

run pk:
    @java -jar build/libs/pocket-1.0.jar {{ pk }} --no-emit

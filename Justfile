transpile pk:
    @echo "Transpiling {{ pk }}:\n\033[34m"
    @cat src/main/resources/{{ pk }}
    @echo " \033[0m\n"
    @gradle run --quiet | sed $'s/^/\033[32m/'   # prefix each line with green
    @echo "\033[0m"  # reset color

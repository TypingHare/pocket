package pocket.utility

object FileUtility {
    /**
     * Removes the extension from a filepath.
     */
    fun removeExtension(filepath: String): String {
        val lastSlash = filepath.lastIndexOfAny(charArrayOf('/', '\\'))
        val lastDot = filepath.lastIndexOf('.')

        return if (lastDot > lastSlash)
            filepath.substring(0, lastDot) else filepath
    }
}
package pocket.utility

import kotlin.math.max

object FileUtility {
    /**
     * Removes the extension from a filepath.
     */
    fun removeExtension(filepath: String): String {
        val lastSeparatorIndex =
            max(filepath.lastIndexOf('/'), filepath.lastIndexOf('\\'))
        val lastDotIndex = filepath.lastIndexOf('.')

        if (lastDotIndex > lastSeparatorIndex) {
            return filepath.substring(0, lastDotIndex)
        }

        return filepath
    }
}
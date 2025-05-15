package pocket.ast

import java.nio.file.Path

class MissingSourceFIleException(filepath: Path) :
    RuntimeException("Source file <$filepath> not found")

class TargetFileNotFound(currentFileAbsolutePath: Path, targetPath: String) :
    RuntimeException("Target path <$targetPath> not found in $currentFileAbsolutePath")

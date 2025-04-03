package matt.calculateaim.util;

import java.io.File;
import java.util.List;
import java.util.UUID;

public class FileUtil {
    public String getEnclosingDirectoryAndFileName(String fullPath) {
        File file = new File(fullPath);
        String fileName = file.getName();
        File parent = file.getParentFile();
        if (parent == null) {
            throw new RuntimeException("failed to find enclosing directory for file: " + fullPath);
        }
        return parent.getName() + File.separator + fileName;
    }

    public String generateRandomFileName(
        String extensionWithoutDot,
        boolean returnFullPath
    ) {
        String fileName = UUID.randomUUID().toString() + "." + extensionWithoutDot;
        if (!returnFullPath) {
            return fileName;
        }
        else {
            File file = new File(fileName);
            String fullPath = file.getAbsolutePath();
            return fullPath;
        }
    }
}

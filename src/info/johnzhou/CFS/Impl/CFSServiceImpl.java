package info.johnzhou.CFS.Impl;

import info.johnzhou.CFS.CFSService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lingjue Zhou
 * @Date 2019/11/20
 */
public class CFSServiceImpl implements CFSService {
    List<File> targetPath;

    @Override
    public List<File> getFolderInfo(File target) {
        return Arrays.asList(target.listFiles());
    }

    @Override
    public int copyFile(File sourceFile, File target, int depth) throws IOException {
        targetPath = new ArrayList<>();
        search(target, 0, depth);
        if (sourceFile.isDirectory()) {

        }
        if (sourceFile.isFile()) {
            for (File f : targetPath)
                Files.copy(sourceFile.toPath(), new File(f + "\\" + sourceFile.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        return targetPath.size();
    }


    private void search(File path, int count, int depth) {
        if (count == depth) {
            targetPath.add(path);
            return;
        }
        for (File f : path.listFiles()) {
            if (f.isDirectory())
                search(f, count + 1, depth);
        }
    }
}

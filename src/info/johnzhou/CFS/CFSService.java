package info.johnzhou.CFS;

import info.johnzhou.DO.FolderDO;

import java.io.File;
import java.util.List;

/**
 * @Author Lingjue Zhou
 * @Date 2019/11/20
 */
public interface CFSService {

    /**
     * Get directory information
     *
     * @return
     */
    List<FolderDO> getFolderInfo(File target);

    /**
     * Get total number of folders in the specific depth
     *
     * @param target
     * @param depth
     * @return
     */
    int getFolderNumber(File target, int depth);

    /**
     * Copy the sourceFile in to the target path with specific depth of the folder
     *
     * @param sourceFile
     * @param target
     * @param depth
     * @return
     */
    int copyFile(File sourceFile, File target, int depth);
}

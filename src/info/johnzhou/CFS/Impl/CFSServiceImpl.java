package info.johnzhou.CFS.Impl;

import info.johnzhou.CFS.CFSService;
import info.johnzhou.DO.FolderDO;

import java.io.File;
import java.util.List;

/**
 * @Author Lingjue Zhou
 * @Date 2019/11/20
 */
public class CFSServiceImpl implements CFSService {
    @Override
    public List<FolderDO> getFolderInfo(File target) {
        return null;
    }

    @Override
    public int getFolderNumber(File target, int depth) {
        return 0;
    }

    @Override
    public int copyFile(File sourceFile, File target, int depth) {
        return 0;
    }
}

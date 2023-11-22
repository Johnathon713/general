package org.john.hadoop.service.impl;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
//import org.apache.hadoop.fs.FileSystem;
//import org.apache.hadoop.fs.Path;
import org.john.hadoop.service.HadoopService;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Johna
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class HadoopServiceImpl implements HadoopService {
//    private final FileSystem fileSystem;
    @Override
    public boolean makeDir(String path) {
//        try {
//            boolean success = fileSystem.mkdirs(new Path(path));
//            log.info("success: " + success);
//            return success;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        return true;
    }
}

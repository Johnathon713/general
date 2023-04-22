package org.john.hadoop.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.john.hadoop.service.HadoopService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Johna
 */
@RestController
@Api(tags = "Hadoop")
@RequiredArgsConstructor
@RequestMapping("api/hadoop")
public class HadoopController {
    private final HadoopService hadoopService;

    @GetMapping("mkdir")
    @ApiOperation("创建目录")
    public boolean makeDir(@RequestParam String path) {
        return hadoopService.makeDir(path);
    }
}

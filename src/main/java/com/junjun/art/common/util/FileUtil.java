package com.junjun.art.common.util;

import com.junjun.art.pojo.SysFile;
import com.junjun.art.service.SysFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author junjun
 * @since 2019/5/17 10:33:52
 **/
@Slf4j
public class FileUtil {

    @Autowired
    private SysFileService sysFileService;

    /**
     * 单文件上传
     */
    public static Map<String, String> upload(MultipartFile file) throws Exception {

        if (file.isEmpty()) {
            throw new Exception("文件为空");
        }
        System.out.print(file.getOriginalFilename());
        // D:\\IDEA\\code\\art\\src\\main\\resources\\static\\upload\\ 都行
        file.transferTo(new File("D:/IDEA/code/art/src/main/resources/static/upload//" + file.getOriginalFilename()));
        Map<String, String> map = new HashMap<>(16);
        map.put("contentType", file.getContentType());
        map.put("fileName", file.getOriginalFilename());
        map.put("fileSize", file.getSize() + "");
        //saveFile(map);
        return map;
    }


    /**
     * 下载文件
     */
    public static Object download(HttpServletResponse response, String filePath) throws Exception {

        if (filePath != null) {
            // 设置文件路径
            File file = new File(filePath);
            System.out.println(file.exists());
            log.info("文件路径是否存在", file.exists());
            if (file.exists()) {
                // 设置强制下载不打开
                response.setContentType("application/force-download");
                // 设置文件名
                response.addHeader("Content-Dispostion", "attachment;fileName=" + URLEncoder.encode(file.getName(), "UTF-8"));
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    return "下载成功";
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        throw new Exception("下载失败");
    }

    /**
     * util类不能涉及业务，要删掉 TODO
     */
    public boolean saveFile(Map<String, String> map) {

        // 新增文件信息
        SysFile sysFile = new SysFile();
        sysFile.setFileName(map.get("fileName"));
        sysFile.setFileSize(map.get("fileSize"));
        sysFile.setUrl("D:/IDEA/code/art/src/main/resources/static/upload//" + map.get("fileName"));
        // 设置人、时间 TODO

        return sysFileService.saveOrUpdate(sysFile);
    }

}

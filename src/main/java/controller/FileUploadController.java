package controller;


import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import jdbc.UserJDBCTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class FileUploadController {

    private final String UPLOAD_DIRECTORY = "C:/uploads";

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFileHandler(
//            @RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {


        if (!file.isEmpty()) {
            UserJDBCTemplate userJDBCTemplate = new UserJDBCTemplate();
            try {
                byte[] bytes = file.getBytes();
                File serverFile = new File(UPLOAD_DIRECTORY + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                userJDBCTemplate.setImgURL(serverFile.getAbsolutePath(), 1);
                return "You successfully uploaded file=" + file.getOriginalFilename();
            } catch (Exception e) {
                return "You failed to upload " + file.getOriginalFilename() + " => " + e;
            }
        } else {
            return "You failed to upload " + file.getOriginalFilename()
                    + " because the file was empty.";
        }
    }
}

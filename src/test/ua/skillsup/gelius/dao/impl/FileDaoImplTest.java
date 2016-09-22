package ua.skillsup.gelius.dao.impl;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.multipart.MultipartFile;
import ua.skillsup.gelius.dao.FileDao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FileDaoImplTest {

    private String directoryPath = "dir";

    private FileDao fileDao = new FileDaoImpl();

    @After
    public void tearDown() throws Exception {
        File directory = new File(directoryPath);
        FileUtils.deleteDirectory(directory);
    }

    @Test
    public void createDirectory() throws Exception {
        fileDao.createDirectory(directoryPath);

        File directory = new File(directoryPath);

        assertEquals("Is directory exists?", directory.exists(), true);
        FileUtils.deleteDirectory(directory);
    }

    @Test
    public void deleteDirectory() throws Exception {
        File directory = new File(directoryPath);
        boolean isCreated = directory.mkdirs();

        assertEquals("Is directory exists?", isCreated, true);

        fileDao.deleteDirectory(directoryPath);

        assertEquals("Directory have already deleted", directory.exists(), false);
    }

    @Test
    public void findAllFilePathsWithoutSubdirectories() throws Exception {
        String [] extensions = new String[]{"pdf"};
        File file1 = new File(directoryPath + File.separator + "somefile1.pdf");
        File file2 = new File(directoryPath + File.separator + "somefile2.pdf");
        File directory = new File(directoryPath);

        directory.mkdirs();
        file1.createNewFile();
        file2.createNewFile();

        final List<String> filePaths = fileDao.findFilePaths(directoryPath, extensions, false);

        assertEquals("Find all file paths withour subdirectories", filePaths.size(), 2);
    }


    @Test
    public void findAllFilePathsWithSubdirectoriesAndAnyExtensions() throws Exception {
        String [] extensions = new String[]{"pdf", "png"};
        File file1 = new File(directoryPath + File.separator + "test" + File.separator + "somefile1.pdf");
        File file2 = new File(directoryPath + File.separator + "test" + File.separator + "somefile2.png");
        File file3 = new File(directoryPath + File.separator + "somefile3.pdf");

        file1.getParentFile().mkdirs();
        file3.getParentFile().mkdirs();
        file1.createNewFile();
        file2.createNewFile();
        file3.createNewFile();

        final List<String> filePaths = fileDao.findFilePaths(directoryPath, extensions, true);

        assertEquals("Find all file paths with subdirectories", filePaths.size(), 3);
    }

    @Test
    public void saveFiles() throws Exception {
        File directory = new File(directoryPath);
        directory.mkdirs();

        MultipartFile multipartFile = new TestMockMultipartFile();

        File convertFile = new File(multipartFile.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convertFile);
        fos.write(multipartFile.getBytes());
        fos.close();
        convertFile.deleteOnExit();

        List<MultipartFile> list = new ArrayList<>();
        list.add(multipartFile);

        fileDao.saveOrUpdateFiles(directoryPath, list, null);

        assertEquals("Is saved file exists", new File(directoryPath + File.separator + multipartFile.getOriginalFilename()).exists(), true);
    }


    private class TestMockMultipartFile implements MultipartFile {

        @Override
        public String getName() {
            return "test";
        }

        @Override
        public String getOriginalFilename() {
            return "test.pdf";
        }

        @Override
        public String getContentType() {
            return null;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public long getSize() {
            return 0;
        }

        @Override
        public byte[] getBytes() throws IOException {
            return new byte[0];
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return null;
        }

        @Override
        public void transferTo(File dest) throws IOException, IllegalStateException {

        }

}
}
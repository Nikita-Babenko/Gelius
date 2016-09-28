package ua.skillsup.gelius.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.skillsup.gelius.dao.FileDao;
import ua.skillsup.gelius.service.FileService;

import java.util.HashMap;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceImplTest {

    @Mock
    private FileDao fileDao;

    private String directoryPath = "dir";

    @InjectMocks
    private FileService fileService = new FileServiceImpl();

    @Test
    public void findFilePathsInDirectoryWithoutSubdirectories() throws Exception {
        String[] extensions = new String[]{"pdf", "jpeg"};

        when(fileDao.findFilePaths(directoryPath, extensions, false)).thenReturn(new HashMap<>());

        fileService.findFilePaths(directoryPath, extensions, false);

        verify(fileDao, times(1)).findFilePaths(directoryPath, extensions, false);
    }

    @Test
    public void deleteDirectoryWithPath() throws Exception {
        when(fileDao.deleteDirectory(directoryPath)).thenReturn(true);

        fileService.deleteDirectory(directoryPath);

        verify(fileDao, times(1)).deleteDirectory(directoryPath);
    }
}
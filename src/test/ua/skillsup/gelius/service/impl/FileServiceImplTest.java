package ua.skillsup.gelius.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.skillsup.gelius.dao.FileDao;
import ua.skillsup.gelius.service.FileService;

import java.util.ArrayList;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceImplTest {

    @Mock
    private FileDao fileDao;

    @InjectMocks
    private FileService fileService = new FileServiceImpl();

    @Test
    public void findFilePaths() throws Exception {
        String dirName = anyString();
        when(fileDao.findFilePaths(dirName)).thenReturn(new ArrayList<>());

        fileService.findFilePaths(dirName);

        verify(fileDao, times(1)).findFilePaths(dirName);
    }

    @Test
    public void deleteDirectory() throws Exception {
        String dirName = anyString();
        when(fileDao.deleteDirectory(dirName)).thenReturn(anyBoolean());

        fileService.deleteDirectory(dirName);

        verify(fileDao, times(1)).deleteDirectory(dirName);
    }
}
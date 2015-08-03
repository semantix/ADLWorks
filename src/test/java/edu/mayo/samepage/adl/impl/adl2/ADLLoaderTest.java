package edu.mayo.samepage.adl.impl.adl2;

import org.junit.Test;
import org.lexemantix.utils.file.LMFileUtils;

import java.io.File;
import java.net.URL;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by dks02 on 7/28/15.
 */
public class ADLLoaderTest
{
    @Test
    public void testLoadFromFile() throws Exception
    {
        File startDir = new File(System.getProperty("user.dir"));
        List<File> adlsFiles = LMFileUtils.getAllFiles(startDir.getCanonicalPath(), ".\\.adls");
        
        for (File file : adlsFiles)
            assertNotNull(ADLLoader.loadFromFile(file));
    }

    @Test
    public void testLoadFromURL() throws Exception
    {
        assertNotNull(ADLLoader.loadFromURL(
                new URL("https://raw.githubusercontent.com/opencimi/archetypes/master/miniCIMI/CIMI-CORE-PARTY.party.v1.0.0.adls")));
    }
}
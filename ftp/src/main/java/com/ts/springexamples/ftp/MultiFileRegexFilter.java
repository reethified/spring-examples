package com.ts.springexamples.ftp;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.file.filters.AbstractDirectoryAwareFileListFilter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *<P> The multi file regex filter allows to filter multiple files from sft</P>
 *
 *
 */
@Component
public class MultiFileRegexFilter extends AbstractDirectoryAwareFileListFilter<ChannelSftp.LsEntry>{

    private final List<Pattern> filePattersn;

    @Autowired
    public MultiFileRegexFilter(@Autowired List<String> filesRegexPatterns){
        filePattersn = new ArrayList<>();

        filesRegexPatterns.stream().map(file->Pattern.compile(file)).forEach(pattern->filePattersn.add(pattern));
    }
    protected boolean isDirectory(ChannelSftp.LsEntry object) {
        return false;
    }


    public boolean accept(ChannelSftp.LsEntry object) {
        String fName = getFilename(object);
        /**
         * match with each pattern and return true if found match
         */
        return filePattersn.stream().filter(pattern -> pattern.matcher(fName).matches()).count()>0;
    }

    public String getFilename(ChannelSftp.LsEntry object){
      return   object!=null ? object.getFilename():null;
    }
}

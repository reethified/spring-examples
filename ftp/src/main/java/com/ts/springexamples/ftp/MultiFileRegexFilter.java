package com.ts.springexamples.ftp;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.integration.file.filters.AbstractDirectoryAwareFileListFilter;

/**
 *<P> The multi file regex filter allows to filter multiple files from sft</P>
 */
public class MultiFileRegexFilter extends AbstractDirectoryAwareFileListFilter<ChannelSftp.LsEntry>{
    protected boolean isDirectory(ChannelSftp.LsEntry object) {
        return false;
    }

    public boolean accept(ChannelSftp.LsEntry object) {
        return false;
    }
}

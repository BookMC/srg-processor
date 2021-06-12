package org.bookmc.srg;

import org.bookmc.srg.output.SrgOutput;
import org.bookmc.srg.output.SrgOutputDirty;
import org.bookmc.srg.processor.RawMappingProcessor;
import org.bookmc.srg.processor.cl.CLProcessor;
import org.bookmc.srg.processor.fd.FDProcessor;
import org.bookmc.srg.processor.md.MDProcessor;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SrgProcessor {
    private final String srgFile;

    private final List<RawMappingProcessor> processors = Arrays.asList(new FDProcessor(), new MDProcessor(), new CLProcessor());

    public SrgProcessor(File srgFile) {
        this(readFile(srgFile));
    }

    public SrgProcessor(String string) {
        this.srgFile = string;
    }

    public SrgOutput process() {
        String[] lines = srgFile.split("\n");
        SrgOutputDirty dirty = new SrgOutputDirty();

        for (String line : lines) {
            for (RawMappingProcessor processor : processors) {
                if (processor.detect(line.trim())) {
                    processor.process(dirty, line.trim());
                    break;
                }
            }
        }

        return new SrgOutput(dirty.getMethods(), dirty.getClasses(), dirty.getFields());
    }

    private static String readFile(File file) {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String lineRead;

            while ((lineRead = reader.readLine()) != null) {
                builder.append(lineRead);
                builder.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }
}

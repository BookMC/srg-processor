package org.bookmc.srg;

import org.bookmc.srg.output.SrgOutput;
import org.bookmc.srg.output.SrgOutputDirty;
import org.bookmc.srg.processor.RawMappingProcessor;
import org.bookmc.srg.processor.CLProcessor;
import org.bookmc.srg.processor.FDProcessor;
import org.bookmc.srg.processor.MDProcessor;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
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
        if (srgFile == null) {
            return new SrgOutput(new HashMap<>(), new HashMap<>(), new HashMap<>());
        }

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

        return new SrgOutput(dirty.getMethods(), dirty.getFields(), dirty.getClasses());
    }

    private static String readFile(File file) {
        if (file == null) return null;

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String lineRead;

            while ((lineRead = reader.readLine()) != null) {
                builder.append(lineRead);
                builder.append("\n");
            }
        } catch (IOException e) {
            return null;
        }

        return builder.toString();
    }
}
